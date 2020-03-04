package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.controls.OI;

public class ShooterSystem
{
    private static final SpeedController spin1 = new PWMVictorSPX(0);
    private static final SpeedController spin2 =  new PWMVictorSPX(4);

    public static void update()
    {
        if(OI.SHOOT_BUTTON.isHold()) {
            spin1.set(.5);
            spin2.set(-.75);
        }  else {
            spin1.stopMotor();
            spin2.stopMotor();
        }
    }
}