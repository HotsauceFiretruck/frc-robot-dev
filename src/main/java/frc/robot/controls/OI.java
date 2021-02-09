package frc.robot.controls;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.ControlModule;

//OI class: A control system class
//OI class checks control inputs such as joysticks and buttons and update the variables accordingly.
//You will find this class being used essentially everywhere (unless it is not).

public class OI {

    //Joystick takes in the port number? <-- Not very sure, ask the builders or even the instructors to know more.
    public static final Joystick FARLEFT_STICK = new Joystick(0);
    public static final Joystick LEFT_STICK = new Joystick(1);
    public static final Joystick RIGHT_STICK = new Joystick(2);

    public static final Button BLUE_BUTTON = new Button(FARLEFT_STICK, 1);
    public static final Button RED_BUTTON = new Button(FARLEFT_STICK, 2);
    public static final Button YELLOW_BUTTON = new Button(FARLEFT_STICK, 3);
    public static final Button BOTTOM_RIGHT = new Trigger(FARLEFT_STICK, 3);
    //Controls what the pneumatic control buttons control...
    // public static final Button NEXT_BUTTON = new Button(FARLEFT_STICK, 5);
    // public static final Trigger PREVIOUS_BUTTON = new Trigger(FARLEFT_STICK, 2);
    public static final Button PNEU_FORWARD_BUTTON = new Button(RIGHT_STICK, 1);
    public static final Button PNEU_BACKWARD_BUTTON = new Button(LEFT_STICK, 1);
  
    public static final Button INTAKE_BUTTON = new Button(RIGHT_STICK, 2);
    public static final Button SHOOT_BUTTON = new Button(LEFT_STICK, 2);
    public static final Button BALL_BUTTON = new Button(FARLEFT_STICK, 14);

    //Since index starts at 0, using the codes above as index needs to subtract 1.
    private static Button[] buttons = new Button[]
    {
        BLUE_BUTTON,
        RED_BUTTON,
        YELLOW_BUTTON,
        BOTTOM_RIGHT,
        // NEXT_BUTTON,
        // PREVIOUS_BUTTON,
        PNEU_FORWARD_BUTTON,
        PNEU_BACKWARD_BUTTON,
        SHOOT_BUTTON,
        INTAKE_BUTTON,
        BALL_BUTTON
    };

    //Getting the inputs of the joystick and update the variables
    public static void update()
    {
        // if (NEXT_BUTTON.isPressed)
        // {
        //     ControlModule.changeMode(false);
        // }
        // else if (PREVIOUS_BUTTON.isPressed)
        // {
        //     ControlModule.changeMode(true);
        // }
        //System.out.println(COLOR_STICK.getTrigger());
        for (int i = 0; i < buttons.length; i++) 
        {
            buttons[i].setStates();
        }
    }
}