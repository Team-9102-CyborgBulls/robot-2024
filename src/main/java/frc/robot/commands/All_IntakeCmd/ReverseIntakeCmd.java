// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.All_IntakeCmd;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;

public class ReverseIntakeCmd extends Command {

    IntakeSubsystem m_intake;

    public ReverseIntakeCmd(IntakeSubsystem intake){

      this.m_intake = intake;
      addRequirements(m_intake);
    }

    @Override
  public void initialize() {
    m_intake.setIntakeMotor(0.0);
    RobotContainer.m_timer.reset();
    RobotContainer.m_timer.start();

  }

  @Override
  public void execute() {
    m_intake.setIntakeMotor(-0.75);
  }

  @Override
  public boolean isFinished() {
    if(RobotContainer.m_timer.get() >= 3){
      return true;
  }
  else{
    return false;
  }
  }

  @Override
  public void end(boolean interrupted){
    m_intake.stop();
  }
}
