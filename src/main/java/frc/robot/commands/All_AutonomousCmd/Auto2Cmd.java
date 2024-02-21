package frc.robot.commands.All_AutonomousCmd;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.All_DriveCmd.DriveBackward2sCmd;
import frc.robot.commands.All_DriveCmd.DriveForward2sCmd;
import frc.robot.commands.All_IntakeCmd.IntakeAutoCmd;
import frc.robot.commands.All_ShooterCmd.LaunchNoteAuto;
import frc.robot.commands.All_ShooterCmd.PrepareLaunchAuto;

public class Auto2Cmd extends SequentialCommandGroup {

    public Auto2Cmd(){

        addCommands(new PrepareLaunchAuto(RobotContainer.shooterSubsytem));
        addCommands(new LaunchNoteAuto(RobotContainer.shooterSubsytem));
        addCommands(new DriveBackward2sCmd(RobotContainer.driveSubsystem));
        addCommands(new IntakeAutoCmd(RobotContainer.intakeSubsystem));
        addCommands(new DriveForward2sCmd(RobotContainer.driveSubsystem));
        addCommands(new PrepareLaunchAuto(RobotContainer.shooterSubsytem));
        addCommands(new LaunchNoteAuto(RobotContainer.shooterSubsytem));
    }

}