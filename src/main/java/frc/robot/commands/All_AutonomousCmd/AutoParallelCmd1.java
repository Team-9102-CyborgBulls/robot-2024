package frc.robot.commands.All_AutonomousCmd;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.All_IntakeCmd.IntakeCmdAuto;
import frc.robot.commands.All_ShooterCmd.LaunchNoteAuto;
import frc.robot.subsystems.IntakeSubsystem;

public class AutoParallelCmd1 extends ParallelCommandGroup {

    public AutoParallelCmd1() {

        addCommands(new IntakeCmdAuto(RobotContainer.intakeSubsystem));
        addCommands(new LaunchNoteAuto(RobotContainer.shooterSubsytem));
    }
}
