// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private final RobotContainer m_robotContainer;

  public Robot() {
    m_robotContainer = new RobotContainer();
    /*
     Thread vision_thread = new Thread(
             () -> {
               // Get the UsbCamera from CameraServer
               UsbCamera camera = CameraServer.startAutomaticCapture();
               // Set the resolution
               camera.setResolution(640, 480);
               // Get a CvSink. This will capture Mats from the camera
               CvSink cvSink = CameraServer.getVideo();
               // Setup a CvSource. This will send images back to the Dashboard
               CvSource outputStream = CameraServer.putVideo("Rectangle", 640, 480);
     
               // Mats are very memory expensive. Lets reuse this Mat.
               Mat mat = new Mat();
     
               // This cannot be 'true'. The program will never exit if it is. This
               // lets the robot stop this thread when restarting robot code or
               // deploying.
               while (!Thread.interrupted()) {
                 // Tell the CvSink to grab a frame from the camera and put it
                 // in the source mat.  If there is an error notify the output.
                 if (cvSink.grabFrame(mat) == 0) {
                   // Send the output the error.
                   outputStream.notifyError(cvSink.getError());
                   // skip the rest of the current iteration
                   continue;
                 }
                 // Put a rectangle on the image
                 Imgproc.rectangle(
                     mat, new Point(100, 100), new Point(400, 400), new Scalar(255, 255, 255), 5);
          // Give the output stream a new image to display
          outputStream.putFrame(mat);
        }
    });
    vision_thread.setDaemon(true);
    vision_thread.start();
    */
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run(); 
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {}

  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}

  @Override
  public void simulationPeriodic() {}
}
