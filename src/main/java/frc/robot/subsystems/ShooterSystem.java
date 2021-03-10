package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;

import frc.robot.controls.OI;

public class ShooterSystem
{
    //initiates motor controls
    private static final SpeedController spin1 = new PWMVictorSPX(5); //bottom wheels
    private static final SpeedController spin2 =  new PWMVictorSPX(4); //top wheels

    public static void update()
    {
        //actives shooter when trigger pulled
        if(OI.SHOOT_BUTTON.isHold() & OI.FARLEFT_STICK.getThrottle()>0) { // If the button to turn on the shooter is held and the 
            spin2.set((OI.FARLEFT_STICK.getThrottle())); //.435 good at ~5 feet
            spin1.set(-(OI.FARLEFT_STICK.getThrottle())); //.435
            System.out.println("Shoot Button Pressed");
        }  else {
            System.out.println(-(OI.FARLEFT_STICK.getThrottle()));
            spin1.stopMotor();
            spin2.stopMotor();
        }
    }
}