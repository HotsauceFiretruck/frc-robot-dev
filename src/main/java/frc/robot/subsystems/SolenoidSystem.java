package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import frc.robot.util.Debug;
import frc.robot.controls.OI;


public class SolenoidSystem 
{
    private static final DoubleSolenoid SOLENOID1 = new DoubleSolenoid(0, 1);
    private static final DoubleSolenoid SOLENOID2 = new DoubleSolenoid(2, 3);
    private static boolean shiftSolenoid = false;

    // Send the solenoid forward
    public static void forward() 
    {
        // Set solenoid value
        SOLENOID1.set(DoubleSolenoid.Value.kForward);
        SOLENOID2.set(DoubleSolenoid.Value.kForward);
    }

    // Send the solenoid in reverse
    public static void reverse() 
    {
        // Set solenoid value
        Debug.printOnce("Reversed!");
        SOLENOID1.set(DoubleSolenoid.Value.kReverse);
        SOLENOID2.set(DoubleSolenoid.Value.kReverse);
    }

    private static boolean scanSolenoidButton() 
    {
        //in and out for intake system
        if (OI.PNEU_CONTROL_BUTTON.isPressed()) {
            shiftSolenoid = !shiftSolenoid;
            if(shiftSolenoid) {
                reverse();
            } else {
                forward();
            }
        }
        //low high gear for shifting drive system
        if (OI.PNEU_CONTROL_BUTTON2.isPressed()) {
            shiftSolenoid = !shiftSolenoid;
            if(shiftSolenoid) {
                reverse();
            } else {
                forward();
            }
        }
        return false;
    }

    public static void update() {
        scanSolenoidButton();
    }
}
