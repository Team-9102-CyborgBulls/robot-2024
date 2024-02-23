package frc.robot.commands.All_AutonomousCmd;



import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.TurnToAngleCmd;
import frc.robot.commands.All_AngleCmd.AngleUpManualCmd;
import frc.robot.commands.All_DriveCmd.DriveForDistanceCmd;
import frc.robot.commands.All_IntakeCmd.IntakeCmdAuto;
import frc.robot.commands.All_ShooterCmd.PrepareLaunchAuto;
import frc.robot.subsystems.DriveSubsystem;

public class Auto2NotesCmd extends SequentialCommandGroup{
    
    public Auto2NotesCmd(){
         
        addCommands(new AngleUpManualCmd(RobotContainer.angleSubsystem));
        addCommands(new PrepareLaunchAuto(RobotContainer.shooterSubsytem));
        //addCommands(new LaunchNoteAuto(RobotContainer.shooterSubsytem));
        addCommands(new AutoParallelCmd1()); // IntakeCmd and LaunchNote

        //changer drive2sec et fordistance en fonction de ce qu'on veux faire: 
        addCommands(new AngleUpManualCmd(RobotContainer.angleSubsystem));
     
        //addCommands(new DriveBackward2sCmd(RobotContainer.driveSubsystem));
        addCommands(new DriveForDistanceCmd(-1.4));

        addCommands(new IntakeCmdAuto(RobotContainer.intakeSubsystem));

        //addCommands(new DriveForward2sCmd(RobotContainer.driveSubsystem));
        addCommands(new AutoParallelCmd2()); // AngleDown and DriveForDistance
        
        addCommands(new PrepareLaunchAuto(RobotContainer.shooterSubsytem));
        //addCommands(new LaunchNoteAuto(RobotContainer.shooterSubsytem));
        addCommands(new AutoParallelCmd1());
    }
}
