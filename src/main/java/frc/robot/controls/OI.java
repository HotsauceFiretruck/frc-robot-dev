package frc.robot.controls;

import edu.wpi.first.wpilibj.Joystick;

//OI class: A control system class
//OI class checks control inputs such as joysticks and buttons and update the variables accordingly.
//You will find this class being used essentially everywhere (unless it is not).

public class OI {

    // Declaring Joysticks
    public static final Joystick FARLEFT_STICK = new Joystick(0);
    public static final Joystick LEFT_STICK = new Joystick(1);
    public static final Joystick RIGHT_STICK = new Joystick(2);
    

    public static final Button SHOOT_BUTTON = new Button(FARLEFT_STICK, 1);
    public static final Button INTAKE_BUTTON = new Button(FARLEFT_STICK, 2);

    public static final Button PNEU_FORWARD_BUTTON = new Button(FARLEFT_STICK, 3);
    public static final Button PNEU_BACKWARD_BUTTON = new Button(FARLEFT_STICK, 4);

    // Declaring Layers of Buttons for the Joystick positioned to the far left of the driver station
    public static final Button INTAKE_REVERSE = new Button(FARLEFT_STICK, 5);
    public static final Button TOPLEFT_MIDDLE = new Button(FARLEFT_STICK, 6);
    public static final Button TOPLEFT_RIGHT = new Button(FARLEFT_STICK, 7);

    public static final Button BOTLEFT_RIGHT = new Button(FARLEFT_STICK, 8);
    public static final Button BOTLEFT_MIDDLE = new Button(FARLEFT_STICK, 9);
    public static final Button BOTLEFT_LEFT = new Button(FARLEFT_STICK, 10);

    public static final Button BALLREVERSE = new Button(FARLEFT_STICK, 11);
    public static final Button TOPRIGHT_MIDDLE = new Button(FARLEFT_STICK, 12);
    public static final Button BALLREVERSE_BUTTON = new Button(FARLEFT_STICK, 13);
    
    public static final Button BALL_BUTTON = new Button(FARLEFT_STICK, 14);
    public static final Button BOTRIGHT_MIDDLE = new Button(FARLEFT_STICK, 15);
    public static final Button BALLPUSH = new Button(FARLEFT_STICK, 16);

    //Since index starts at 0, using the codes above as index needs to subtract 1.
    private static Button[] buttons = new Button[]
    {
        TOPLEFT_MIDDLE,
        TOPLEFT_RIGHT,
        BOTLEFT_LEFT,
        BOTLEFT_MIDDLE,
        BOTLEFT_RIGHT,
        TOPRIGHT_MIDDLE,
        BOTRIGHT_MIDDLE,
        PNEU_FORWARD_BUTTON,
        PNEU_BACKWARD_BUTTON,
        SHOOT_BUTTON,
        INTAKE_BUTTON,
        INTAKE_REVERSE,
        BALL_BUTTON,
        BALLREVERSE_BUTTON,
        BALLPUSH,
        BALLREVERSE
    };

    //Getting the inputs of the joystick and update the variables
    public static void update()
    {
        for (int i = 0; i < buttons.length; i++) {
                buttons[i].setStates();
        }
    }
}