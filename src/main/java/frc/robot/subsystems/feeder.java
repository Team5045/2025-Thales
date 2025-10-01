package frc.robot.subsystems;
import edu.wpi.first.wpilibj.*;
import com.ctre.phoenix6.hardware.TalonFX;

/*
 * This file is to be deprecated once elevator version of bot is complete
 */
public class feeder {
    private TalonFX motorD;
    public feeder(TalonFX motor1){
        this.motorD = motor1;
    }
    public void dispense(){ motorD.set(-0.18); }
    public void gimmemorpowa(){ motorD.set(-0.3); } // prev -0.18
    public void soft() { motorD.set(-0.08); }
    public void reverse(){ motorD.set(0.12); }
    // MOH POWA
    public void hold(){ motorD.set(0.05); }
    // Above: Idle function to prevent problems
    public void stop(){ motorD.set(0.0); }
}
