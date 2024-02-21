// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.All_DriveCmd;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class WaitCmd extends Command {
  /** Creates a new WaitCmd. */
  DriveSubsystem driveSubsystem;
  public WaitCmd(DriveSubsystem drivesubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveSubsystem = drivesubsystem;
       
        addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_timer.reset();   
    RobotContainer.m_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   driveSubsystem.setDriveMotors(0, 0);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
     driveSubsystem.setDriveMotors(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return RobotContainer.m_timer.get() >= 2;
  }
}