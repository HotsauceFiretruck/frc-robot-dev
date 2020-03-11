package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;

import frc.robot.controls.OI;

public class ShooterSystem
{
    //initiates motor controlls
    private static final SpeedController spin1 = new PWMVictorSPX(4);
    private static final SpeedController spin2 =  new PWMVictorSPX(5);
    private static boolean activateMotor = false;

    public static void update()
    {
        //actives shooter when trigger pulled
        if(OI.SHOOT_BUTTON.isPressed()) {
            activateMotor = !activateMotor;
            System.out.println("Update Shooter System");
            if (activateMotor) {
                System.out.println("Activate Motor");
                spin1.set(.5);
                spin2.set(-.75);
            } else {
                System.out.println("DeActivate Motor");
                spin1.stopMotor();
                spin2.stopMotor();
            }
        }
    }
}