// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.All_AutonomousCmd;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.All_AngleCmd.AngleDownBasCmd;
import frc.robot.commands.All_DriveCmd.DriveForDistanceCmd;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoParallelDownDrive extends ParallelCommandGroup {
  /** Creates a new AutoParallelCmd2. */
  public AutoParallelDownDrive() {
    
    addCommands(new AngleDownBasCmd(RobotContainer.angleSubsystem));
    addCommands(new DriveForDistanceCmd(1.2));

  }
}
