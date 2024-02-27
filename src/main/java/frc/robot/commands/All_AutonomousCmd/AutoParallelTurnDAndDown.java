// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.All_AutonomousCmd;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.TurnToAngleCmd;
import frc.robot.commands.All_AngleCmd.AngleDownChariotCmd;
import frc.robot.commands.All_ElevatorCmd.ElevatorDownManualCmd;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoParallelTurnDAndDown extends ParallelCommandGroup {
  /** Creates a new AutoParallelTurnAndDown. */
  public AutoParallelTurnDAndDown() {
    
    addCommands(new TurnToAngleCmd(RobotContainer.driveSubsystem, -52));
    addCommands(new AngleDownChariotCmd(RobotContainer.angleSubsystem));
    addCommands(new ElevatorDownManualCmd(RobotContainer.elevatorSubsystem));
  }
}
