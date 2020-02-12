package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import frc.robot.controls.OI;
import frc.robot.subsystems.ColorDetectionSystem.Colors;

/*
        Idle: motor not doing anything, trying to get a color button input
        PrepOnStandby: reseting variables, motor on standby
        SpinThreeTimes: motor starts to spin the color wheel 3 times
        SpinToSelectedColor: motor starts to spin to selected color from color button input.
    */
enum MotorStatus
{
    Idle,
    PrepOnStandby,
    SpinThreeTimes,
    SpinToSelectedColor
}

/*
    A color motor system to turn that color motor.

    It is used in Robot.java and probably nowhere else.
*/
public class ColorMotorSystem
{
    private final SpeedController COLOR_MOTOR = new PWMVictorSPX(4);
    private final ColorDetectionSystem COLOR_DETECTION = new ColorDetectionSystem();
    private final int COLOR_AMOUNT = 8;

    private int colorsPassed;
    private Colors colorSelection;
    private Colors currentColor;
    private Colors prevColor;

    private MotorStatus status;

    public ColorMotorSystem()
    {
        colorsPassed = 0;
        status = MotorStatus.Idle;
        colorSelection = Colors.Unknown;
        currentColor = Colors.Unknown;
        prevColor = Colors.Unknown;
    }

    //Getting 'color' button presses every updates only when motor is idle.
    //If a 'color' button is pressed, set colorSelection variable to the color selected.
    //Use in update() function down below. 
    private boolean scanColorButton()
    {
        if (status == MotorStatus.Idle)
        {
            if (OI.BLUE_BUTTON.isPressed()) colorSelection = Colors.Blue;
            else if (OI.RED_BUTTON.isPressed()) colorSelection = Colors.Red;
            else if (OI.YELLOW_BUTTON.isPressed()) colorSelection = Colors.Yellow;
            else if (OI.GREEN_BUTTON.isPressed()) colorSelection = Colors.Green;
            if (!colorSelection.equals(Colors.Unknown)) 
            {   
            //    System.out.println("COLOR HAVE BEEN SELECTED: " + colorSelection);
            //    System.out.println("BEGIN PREPING FOR MOTOR SPIN...");
                return true;
            }
        }
        return false;
    }

    //Set motor speed to 1.0 (max) until it has spin the color wheel (control panel) 3.5 times.
    //Use in update() function down below.
    private void spinThreeTimes()
    {
        //System.out.println(currentColor);
        //System.out.println("Number of Color Passed - " + colorsPassed); //Debugging
        currentColor = COLOR_DETECTION.runDetection();
        COLOR_MOTOR.set(1.0);

        //If the sensor sees anything other than RGBY ignore it
        if (!currentColor.equals(Colors.Unknown))
        {
            //If the previously detected color is not the same as the current
            if (!prevColor.equals(currentColor))
            {
                colorsPassed++;
                prevColor = currentColor;
            }
            //If it has spun 3.5 times (passing 28 colors), stop it
            if (colorsPassed >= COLOR_AMOUNT * 3.5)
            {
                COLOR_MOTOR.stopMotor();
                System.out.println("SPIN_3_TIMES ACTION ENDED!");
                status = MotorStatus.SpinToSelectedColor;
            }
        }
    }

    /*
        Set motor speed to 1.0 (max) until it has spin the color wheel (control panel) to the 
        selected color (colorSelection).

        Used in update() function down below.
    */
    private void spinToColorSeleted()
    {
        COLOR_MOTOR.set(1.0);
        if (COLOR_DETECTION.isColorMatch(colorSelection))
        {
            COLOR_MOTOR.stopMotor();
            colorSelection = Colors.Unknown;
            status = MotorStatus.Idle;
        }
    }

    // update function, updates color motor status every cycle/tick/loop of teleopPeriodic() function in Robot.java
    public void update()
    {
        //System.out.println("------------- New Color Motor System Loop ---------------");
        if(scanColorButton()) status = MotorStatus.PrepOnStandby;
        if(status == MotorStatus.PrepOnStandby)
        {
            colorsPassed = 0;  
            currentColor = COLOR_DETECTION.runDetection();
            prevColor = COLOR_DETECTION.runDetection();
            status = MotorStatus.SpinThreeTimes;
          //  System.out.println("SPIN_3_TIMES ACTION INITIATED!");
        }
        if (status == MotorStatus.SpinThreeTimes) spinThreeTimes();
        if (status == MotorStatus.SpinToSelectedColor) spinToColorSeleted();
    }
}