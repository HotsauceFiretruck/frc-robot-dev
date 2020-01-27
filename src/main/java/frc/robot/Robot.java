/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.ColorMotorSystem;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.SolenoidSystem;

/*
  The Robot Class.
  This is technically your true 'Main' class.
  Every classes that you program must go in here for it to run.
*/
public class Robot extends TimedRobot 
{
  SolenoidSystem solenoidSystem;
  DriveSystem driveSystem;

  @Override
  public void robotInit() 
  {
    driveSystem = new DriveSystem();
  }

  //An automatic update method, provided by WPILIB
  //Runs every cycle/loop/tick
  @Override
  public void teleopPeriodic() 
  {
    driveSystem.update();
  }
}
