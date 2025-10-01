package frc.robot.commands;

import com.ctre.phoenix6.swerve.SwerveRequest;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Camera;

import frc.robot.LimelightHelpers;
import frc.robot.LimelightConstants;
import frc.robot.subsystems.CommandSwerveDrivetrain;

public class alignReefRight extends Command {
    CommandSwerveDrivetrain drivetrain;
    public alignReefRight(CommandSwerveDrivetrain drivetrain){
        this.drivetrain = drivetrain;
        addRequirements(this.drivetrain);
    }

    @Override
    public void initialize(){
        //System.out.println("Aligning!");
    }
    
    @Override
    public void execute(){
        //System.out.println("Executing!");
        Camera.updateCurrentPose();
        // Pose3d botPose = Camera.getCurrentPose();
        
        if(Camera.checkIfTag()){
            //System.out.println("Got tag!");
            this.drivetrain.driveRobotRelative(new ChassisSpeeds(Camera.getXOutput(false), Camera.getYOutput(false), Camera.getRotOutput()));
        } else {
            this.drivetrain.driveRobotRelative(new ChassisSpeeds(0, 0, 0));
        }
    }

    @Override
    public void end(boolean interrupted){
        if(Camera.checkAligned() && Camera.checkIfTag()){
            System.out.println("Aligned!");
        } else {
            System.out.println("Not aligned!");
        }
        
        this.drivetrain.driveRobotRelative(new ChassisSpeeds(0, 0, 0));
    }
    
    @Override
    public boolean isFinished(){
        // System.out.println(Camera.checkAligned());
        return Camera.checkAligned();
    }
    
        
}
