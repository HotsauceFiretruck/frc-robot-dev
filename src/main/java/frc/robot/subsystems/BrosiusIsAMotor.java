package frc.robot.subsystems;


import frc.robot.controls.OI;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class BrosiusIsAMotor {
  private CANSparkMax broMo;
  private CANSparkMax broMo2;

  public BrosiusIsAMotor() {
    broMo = new CANSparkMax(2, MotorType.kBrushless);
    broMo2 = new CANSparkMax(3, MotorType.kBrushless);

  }
  
  public void update() {
    //activates intake when pressed
    if (OI.INTAKE_BUTTON.isPressed()) {
      broMo.set(-0.5);
      broMo2.set(1);
    }
    //stop if button is released
    else{
      broMo.set(0);
      broMo2.set(0);
    }

    
  }
}