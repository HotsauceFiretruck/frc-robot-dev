package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.controls.OI;
import frc.robot.util.Debug;

//A drive system.
//To do what? Drive the robot, of course!

public class Shooter
{
    private static final SpeedController spin1 = new PWMVictorSPX(6);
    private static final SpeedController spin2 =  new PWMVictorSPX(7);
    
    public static void update()
    {
        //System.out.println("KKJKKJ");
        if(OI.shootButton.isHold()) {
          //  System.out.println("HHEHEUHU");
            spin1.set(.5);
            spin2.set(-.75);
        }  else {
            spin1.stopMotor();
            spin2.stopMotor();
        }
    }
}