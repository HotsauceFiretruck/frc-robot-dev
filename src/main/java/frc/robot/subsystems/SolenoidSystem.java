package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.controls.OI;

public class SolenoidSystem 
{
    private static DoubleSolenoid SOLENOID = new DoubleSolenoid(0, 1);

    public static void forward() 
    {
        SOLENOID.set(DoubleSolenoid.Value.kForward);
        System.out.println(SOLENOID.get());
    }
    public static void reverse() 
    {
        SOLENOID.set(DoubleSolenoid.Value.kReverse);
        System.out.println(SOLENOID.get());
    }

    public static void update() {
        if (OI.PNEU_BACKWARD_BUTTON.isPressed()) {
            reverse();
            System.out.println("pressed reverse");
        }
        if (OI.PNEU_FORWARD_BUTTON.isPressed()) {
            forward();
            System.out.println("pressed forward");
        }
    }
}
