package frc.robot;

import java.util.Arrays;
import java.util.List;

public class LimelightConstants {
    public final static String name = "";

    // Units in meters & degrees
    public final static double cameraPoseForward = 0.01;
    public final static double cameraPoseSide = -0.05;
    public final static double cameraPoseUp = 0.38;
    public final static double cameraPoseRoll = 0.0;
    public final static double cameraPosePitch = -5.0;
    public final static double cameraPoseYaw = 2.5;
    
    public final static double tag_rot = 0.0;
    // TODO: Tune these
    public final static double tag_Z_left = -0.45;//-0.75
    public final static double tag_X_left = -0.11;//-0.2
    public final static double tag_Z_right = -0.45;
    public final static double tag_X_right = 0.27; // tune later

    public final static double maxTrackingDistance = 3; // meters
    // TODO: Tune max forward speed
    public final static double maxForwardSpeed = 1;
    public final static double maxForwardAcceleration = 0.18;
    public final static double maxSideSpeed = 0.7;
    public final static double maxSideAcceleration = 0.18;

    // TODO: See if we can eliminate ki

    public final static double forwards_kp = 0.7; // 1
    public final static double forwards_ki = 0.1;
    public final static double forwards_kd = 0;

    public final static double side_kp = 0.7; // 0.8
    public final static double side_ki = 0.1; // 0.1
    public final static double side_kd = 0;

    public final static double rot_kp = 0.1;
    public final static double rot_ki = 0;
    public final static double rot_kd = 0;

    public final static double driveFF_ks = 0;
    public final static double driveFF_kv = 0;
    public final static double driveFF_ka = 0;

    public final static double x_thres = 0.08;
    public final static double y_thres = 0.03;
    public final static double rot_thres = 1.5;

    public static final List<Double> reef_ids = Arrays.asList(
      (double)6, 
      (double)7, 
      (double)8, 
      (double)9, 
      (double)10, 
      (double)11, 
      (double)17, 
      (double)18, 
      (double)19, 
      (double)20, 
      (double)21, 
      (double)22
    );
}
