package frc.robot;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;

public class Camera {
    private static Pose3d currentPose;

    private static ProfiledPIDController xPID = new ProfiledPIDController(LimelightConstants.forwards_kp, LimelightConstants.forwards_ki, LimelightConstants.forwards_kd, new TrapezoidProfile.Constraints(LimelightConstants.maxForwardSpeed, LimelightConstants.maxForwardAcceleration));
    private static ProfiledPIDController yPID = new ProfiledPIDController(LimelightConstants.side_kp, LimelightConstants.side_ki, LimelightConstants.side_kd, new TrapezoidProfile.Constraints(LimelightConstants.maxSideSpeed, LimelightConstants.maxSideAcceleration));
    private static PIDController rotPID = new PIDController(LimelightConstants.rot_kp, LimelightConstants.rot_ki, LimelightConstants.rot_kd);
    private static SimpleMotorFeedforward driveFF = new SimpleMotorFeedforward(LimelightConstants.driveFF_ks, LimelightConstants.driveFF_kv, LimelightConstants.driveFF_ka);

    public static void init(){
        LimelightHelpers.setCameraPose_RobotSpace(LimelightConstants.name, LimelightConstants.cameraPoseForward, LimelightConstants.cameraPoseSide, LimelightConstants.cameraPoseUp, LimelightConstants.cameraPoseRoll, LimelightConstants.cameraPosePitch, LimelightConstants.cameraPoseYaw);
        xPID.setTolerance(LimelightConstants.x_thres);
        yPID.setTolerance(LimelightConstants.y_thres);
        yPID.setIZone(0.5);
        xPID.setIZone(0.7);
        updateCurrentPose();
    }
    public static boolean checkIfTag(){
        return LimelightHelpers.getTV(LimelightConstants.name) && LimelightConstants.reef_ids.contains(LimelightHelpers.getFiducialID(LimelightConstants.name))
            && Math.abs(currentPose.getZ()) < LimelightConstants.maxTrackingDistance;
    }
    public static void updateCurrentPose(){
        currentPose = LimelightHelpers.getBotPose3d_TargetSpace(LimelightConstants.name);
    }
    public static Pose3d getCurrentPose(){
        return currentPose;
    }

    public static double getXOutput(boolean left){
        /*
        if(xPID.atGoal()){
            return 0.0;
        }
            */
        return -xPID.calculate(getXDiff(left));
    }
    public static double getYOutput(boolean left){
        /*
        if(yPID.atGoal()){
            return 0.0;
        }
            */
        return yPID.calculate(getYDiff(left));
    }
    public static double getRotOutput(){
        double output = -rotPID.calculate(getRotDiff());
        //System.out.println(output);
        return output;
    }

    public static double getXDiff(boolean left){
        double tag_Z;
        if(left) {
            tag_Z = LimelightConstants.tag_Z_left;
        } else {
            tag_Z = LimelightConstants.tag_Z_right;
        }
        return currentPose.getZ() - tag_Z;
    }
    public static double getYDiff(boolean left){
        double tag_X;
        if(left) {
            tag_X = LimelightConstants.tag_X_left;
        } else {
            tag_X = LimelightConstants.tag_X_right;
        }
        return currentPose.getX() - tag_X;
    }
    public static double getRotDiff(){
        double diff = Units.radiansToDegrees(currentPose.getRotation().getQuaternion().getY()) - LimelightConstants.tag_rot;
        //System.out.println(diff);
        return diff;
    }

    public static boolean checkAligned(){
        return xPID.atGoal() &&
            yPID.atGoal() &&
            Math.abs(getRotDiff()) < LimelightConstants.rot_thres;
    }
}   
