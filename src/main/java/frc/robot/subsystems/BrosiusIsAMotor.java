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

  public BrosiusIsAMotor() {
    broMo = new CANSparkMax(0, MotorType.kBrushless);
  }
  
  public void update() {
      broMo.set(.5);
  }
}