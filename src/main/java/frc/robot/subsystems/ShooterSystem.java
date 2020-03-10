package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;

import frc.robot.controls.OI;

public class ShooterSystem
{
    //initiates motor controlls
    private static final SpeedController spin1 = new PWMVictorSPX(5);
    //private static final SpeedController spin2 =  new PWMVictorSPX(4);

    public static void update()
    {
        System.out.println(":(");
        //actives shooter when trigger pulled
        if(OI.SHOOT_BUTTON.isHold()) {
            spin1.set(.5);
            //spin2.set(-.75);
        }  else {
            spin1.stopMotor();
            //spin2.stopMotor();
        }
    }
}