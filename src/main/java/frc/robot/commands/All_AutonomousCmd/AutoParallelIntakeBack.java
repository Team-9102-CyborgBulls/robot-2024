// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.All_AutonomousCmd;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.RobotContainer;
import frc.robot.commands.All_AngleCmd.AngleDownBasCmd;
import frc.robot.commands.All_AngleCmd.AngleUpIntakeCmd;
import frc.robot.commands.All_DriveCmd.DriveForDistanceCmd;
import frc.robot.commands.All_IntakeCmd.IntakeCmdRamassage;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoParallelIntakeBack extends ParallelCommandGroup {
  /** Creates a new AutoParallelCmd3. */
  public AutoParallelIntakeBack(double distance) {

    addCommands(new AngleUpIntakeCmd(RobotContainer.angleSubsystem));
    addCommands(new IntakeCmdRamassage(RobotContainer.intakeSubsystem));
    addCommands(new DriveForDistanceCmd(distance));
  }
}
