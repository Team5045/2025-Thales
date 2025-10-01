package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.elevator_PS;

public class autoL2up extends Command {
    private elevator_PS m_elevator;
    private Timer timer;

    public autoL2up(elevator_PS L){
        this.m_elevator = L;
        this.timer = new Timer();
    }

    @Override
    public void initialize(){
        timer.reset();
        timer.start();
    }

    @Override
    @SuppressWarnings("removal")
    public void execute(){
        m_elevator.setGoal(-8); 
        m_elevator.enable();
    }

    @Override
    public void end(boolean interrupted){
        timer.stop();
    }
    @Override
    public boolean isFinished(){
        return timer.hasElapsed(2.5);
    }
}
