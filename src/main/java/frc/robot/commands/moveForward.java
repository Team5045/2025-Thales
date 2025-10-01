package frc.robot.commands;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CommandSwerveDrivetrain;

public class moveForward extends Command {
    CommandSwerveDrivetrain drivetrain;
    public moveForward(CommandSwerveDrivetrain drivetrain){
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void execute(){
        drivetrain.driveRobotRelative(new ChassisSpeeds(-0.5, 0, 0));
    }

    @Override
    public void end(boolean interrupted){
        drivetrain.driveRobotRelative(new ChassisSpeeds(0, 0, 0));
    }
}
