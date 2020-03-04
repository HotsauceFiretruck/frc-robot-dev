package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.controls.OI;

//A drive system.
//To do what? Drive the robot, of course!

public class DriveSystem
{
    /*  
    Remember, the PWNVictorSPX is the actual motor. 
    PWMVictorSPX takes in the port number of the motor.
    DifferentialDrive is a class that makes running the two motors together easier.
    If you want to know more, maybe consider reading the frc wpilib documentation to know more.
    */
    private static final DifferentialDrive wheelsMotor1 = new DifferentialDrive(new PWMVictorSPX(2), new PWMVictorSPX(0));
    private static final DifferentialDrive wheelsMotor2 = new DifferentialDrive(new PWMVictorSPX(3), new PWMVictorSPX(1)); 
    private static double leftSpeed = 0;
    private static double rightSpeed = 0;
    private static final double SPEED_MULTIPLIER = 1;
    
    //Pretty obvious what this function does. Run this in the Robot.java teleopPeriodic() function to run the robot.
    public static void update()
    {
        System.out.println("Driving! ");
        moveWheels(-OI.LEFT_STICK.getY() * SPEED_MULTIPLIER, -OI.RIGHT_STICK.getY() * SPEED_MULTIPLIER);
    }

    public static void moveWheels(double leftSpeed, double rightSpeed)
    {
        double _rightSpeed = -rightSpeed; //Set it to negative to match the motor set up.
        wheelsMotor2.tankDrive(leftSpeed, _rightSpeed);
        wheelsMotor1.tankDrive(leftSpeed, _rightSpeed);
    }

    public static void stopWheels()
    {
        wheelsMotor2.stopMotor();
        wheelsMotor1.stopMotor();
    }
}