package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;

import frc.robot.controls.OI;

public class ConveyorSystem
{
    //initiates motor controls
    // private static final SpeedController spin1 = new PWMVictorSPX(5);
    private static final SpeedController motor = new PWMVictorSPX(6);

    public static void update()
    {
        //actives shooter when trigger pulled
        if(OI.BALL_BUTTON.isHold()) {
            // turn on conveyor motor
            motor.set(1);
            System.out.println("Pushed conveyor button");
        } else if(OI.BALLREVERSE_BUTTON.isHold()) {
            motor.set(-1);
        }  else {
            // dont turn on motor
            motor.set(0);
        }
    }
}