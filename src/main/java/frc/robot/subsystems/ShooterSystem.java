package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;

import frc.robot.controls.OI;

public class ShooterSystem
{
    //initiates motor controls
    private static final SpeedController spin1 = new PWMVictorSPX(5);
    private static final SpeedController spin2 =  new PWMVictorSPX(4);

    public static void update()
    {
        //actives shooter when trigger pulled
        if(OI.SHOOT_BUTTON.isHold()) {
            spin2.set(.415);
            spin1.set(-.415);
            System.out.println("Shoot Button Pressed");
        }  else {
            spin1.stopMotor();
            spin2.stopMotor();
        }
    }
}