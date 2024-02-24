// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.All_ElevatorCmd;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorDownManualCmd extends Command {
   ElevatorSubsystem m_elevator;
   RobotContainer m_robotContainer;

  public ElevatorDownManualCmd( ElevatorSubsystem elevator) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_elevator = elevator;
    addRequirements(m_elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_elevator.setElevatorSpeed(0.0); //0.027
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_elevator.setElevatorSpeed(-0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_elevator.setElevatorSpeed(-0.1); //0.027
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_robotContainer.elevatorSubsystem.getElevatorValue() <= -30){ // -28.5
      return true;
    } else{
      return false;
    }
  }
}
