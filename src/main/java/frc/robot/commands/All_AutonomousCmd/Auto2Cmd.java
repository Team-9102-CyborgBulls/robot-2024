package frc.robot.commands.All_AutonomousCmd;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.All_DriveCmd.DriveBackward2sCmd;
import frc.robot.commands.All_DriveCmd.DriveForward2sCmd;
<<<<<<< HEAD
import frc.robot.commands.All_IntakeCmd.IntakeCmdAuto;
=======
import frc.robot.commands.All_IntakeCmd.IntakeAutoCmd;
>>>>>>> 94036b86cd03d3b5626c29a19e60095fe18782b4
import frc.robot.commands.All_ShooterCmd.LaunchNoteAuto;
import frc.robot.commands.All_ShooterCmd.PrepareLaunchAuto;

public class Auto2Cmd extends SequentialCommandGroup {

    public Auto2Cmd(){
<<<<<<< HEAD
    
        addCommands(new PrepareLaunchAuto(RobotContainer.shooterSubsytem));
        addCommands(new LaunchNoteAuto(RobotContainer.shooterSubsytem));
        addCommands(new DriveBackward2sCmd(RobotContainer.driveSubsystem));
        addCommands(new IntakeCmdAuto(RobotContainer.intakeSubsystem));
=======

        addCommands(new PrepareLaunchAuto(RobotContainer.shooterSubsytem));
        addCommands(new LaunchNoteAuto(RobotContainer.shooterSubsytem));
        addCommands(new DriveBackward2sCmd(RobotContainer.driveSubsystem));
        addCommands(new IntakeAutoCmd(RobotContainer.intakeSubsystem));
>>>>>>> 94036b86cd03d3b5626c29a19e60095fe18782b4
        addCommands(new DriveForward2sCmd(RobotContainer.driveSubsystem));
        addCommands(new PrepareLaunchAuto(RobotContainer.shooterSubsytem));
        addCommands(new LaunchNoteAuto(RobotContainer.shooterSubsytem));
    }
<<<<<<< HEAD
    
}
=======

}
>>>>>>> 94036b86cd03d3b5626c29a19e60095fe18782b4
