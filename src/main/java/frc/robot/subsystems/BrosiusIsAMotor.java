package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import frc.robot.util.Debug;
import frc.robot.controls.OI;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class BrosiusIsAMotor {
  private CANSparkMax broMo;
  private CANSparkMax broMo2;
  private boolean activateMotor;

  public BrosiusIsAMotor() {
    activateMotor = false;
    broMo = new CANSparkMax(2, MotorType.kBrushless);
    broMo2 = new CANSparkMax(3, MotorType.kBrushless);

  }
  
  public void update() {
    //activates intake when pressed
    if (OI.INTAKE_BUTTON.isPressed()) {
      activateMotor = !activateMotor;
    }

    if (activateMotor) {
      broMo2.set(1);
    }

  }
}