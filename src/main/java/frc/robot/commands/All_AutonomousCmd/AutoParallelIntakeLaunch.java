package frc.robot.commands.All_AutonomousCmd;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.All_IntakeCmd.IntakeCmdRamassage;
import frc.robot.commands.All_IntakeCmd.IntakeCmdShoot;
import frc.robot.commands.All_ShooterCmd.LaunchNoteAuto;
import frc.robot.subsystems.IntakeSubsystem;

public class AutoParallelIntakeLaunch extends ParallelCommandGroup {

    public AutoParallelIntakeLaunch() {

        addCommands(new IntakeCmdShoot(RobotContainer.intakeSubsystem));
        addCommands(new LaunchNoteAuto(RobotContainer.shooterSubsytem));
    }
}
