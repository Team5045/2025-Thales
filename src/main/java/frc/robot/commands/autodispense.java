package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.feeder;

public class autodispense extends Command{
    private final feeder dispenser;
    private final Timer timer;

    // Constructor
    public autodispense(feeder d){
        this.dispenser = d;
        this.timer = new Timer();
    }

    // starting code at start of call per use case
    @Override
    public void initialize(){
        timer.reset();
        timer.start();
    }

    // actual command
    @Override
    public void execute(){
        dispenser.gimmemorpowa();
    }

    // in case of an interuption if interrupted boolean changed will halt action
    @Override
    public void end(boolean interrupted){
        dispenser.stop();
    }

    // Expected completion time of 1 second, ends command
    @Override
    public boolean isFinished(){
        return timer.hasElapsed(1);
    }
}

