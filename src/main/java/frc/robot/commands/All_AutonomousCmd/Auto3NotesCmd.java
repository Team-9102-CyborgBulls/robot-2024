package frc.robot.commands.All_AutonomousCmd;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.TurnToAngleCmd;
import frc.robot.commands.All_AngleCmd.AngleUpManualCmd;
import frc.robot.commands.All_DriveCmd.DriveBackward2sCmd;
import frc.robot.commands.All_DriveCmd.DriveForDistanceCmd;
import frc.robot.commands.All_DriveCmd.DriveForward2sCmd;
import frc.robot.commands.All_IntakeCmd.IntakeCmdAuto;
import frc.robot.commands.All_ShooterCmd.LaunchNoteAuto;
import frc.robot.commands.All_ShooterCmd.PrepareLaunchAuto;
import frc.robot.subsystems.DriveSubsystem;

public class Auto3NotesCmd extends SequentialCommandGroup {

    public Auto3NotesCmd(){
        addCommands(new PrepareLaunchAuto(RobotContainer.shooterSubsytem));
        //addCommands(new LaunchNoteAuto(RobotContainer.shooterSubsytem));
        addCommands(new AutoParallelCmd1()); // IntakeCmd and LaunchNote

        //changer drive2sec et fordistance en fonction de ce qu'on veux faire: 

        //addCommands(new DriveBackward2sCmd(RobotContainer.driveSubsystem));
        addCommands(new DriveForDistanceCmd(-0.3));

        addCommands(new AngleUpManualCmd(RobotContainer.angleSubsystem));
        
        addCommands(new IntakeCmdAuto(RobotContainer.intakeSubsystem));

        //addCommands(new DriveForward2sCmd(RobotContainer.driveSubsystem));
        addCommands(new AutoParallelCmd2()); // AngleDown and DriveForDistance
        
        addCommands(new PrepareLaunchAuto(RobotContainer.shooterSubsytem));
        //addCommands(new LaunchNoteAuto(RobotContainer.shooterSubsytem));
        addCommands(new AutoParallelCmd1());

        addCommands(new DriveForDistanceCmd(-0.3));

        addCommands(new TurnToAngleCmd(RobotContainer.driveSubsystem,90));

        addCommands(new AutoParallelCmd3());

        addCommands(new IntakeCmdAuto(RobotContainer.intakeSubsystem));

        addCommands(new TurnToAngleCmd(RobotContainer.driveSubsystem,1)); // Faut encore déterminer l'angle

        addCommands(new AutoParallelCmd2());

        addCommands(new PrepareLaunchAuto(RobotContainer.shooterSubsytem));
        
        addCommands(new AutoParallelCmd1());


    }
    
}
//you shall not pass