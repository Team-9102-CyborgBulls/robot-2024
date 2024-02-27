package frc.robot.commands.All_AutonomousCmd;



import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.TurnToAngleCmd;
import frc.robot.commands.All_AngleCmd.AngleDownBasCmd;
import frc.robot.commands.All_AngleCmd.AngleDownChariotCmd;
import frc.robot.commands.All_AngleCmd.AngleUpIntakeCmd;
import frc.robot.commands.All_AngleCmd.AngleUpShootCmd;
import frc.robot.commands.All_DriveCmd.DriveForDistanceCmd;
import frc.robot.commands.All_ElevatorCmd.ElevatorDownManualCmd;
import frc.robot.commands.All_ElevatorCmd.ElevatorUpManualCmd;
import frc.robot.commands.All_IntakeCmd.IntakeCmdRamassage;
import frc.robot.commands.All_ShooterCmd.PrepareLaunchAuto;
import frc.robot.subsystems.DriveSubsystem;

public class Auto2NotesDCmd extends SequentialCommandGroup{
    
    public Auto2NotesDCmd(){
         
        addCommands(new AngleUpShootCmd(RobotContainer.angleSubsystem));
        addCommands(new PrepareLaunchAuto(RobotContainer.shooterSubsytem));
        //addCommands(new LaunchNoteAuto(RobotContainer.shooterSubsytem));
        addCommands(new AutoParallelIntakeLaunch()); // IntakeCmd and LaunchNote

        //changer drive2sec et fordistance en fonction de ce qu'on veux faire:
        
        addCommands(new DriveForDistanceCmd(-0.40));

        addCommands(new AutoParallelTurnDAndDown());

        //addCommands(new TurnToAngleCmd(RobotContainer.driveSubsystem, 42.6)); // a définir

        //addCommands(new AngleDownChariotCmd(RobotContainer.angleSubsystem));

        //addCommands(new ElevatorDownManualCmd(RobotContainer.elevatorSubsystem));
        
        addCommands(new AutoParallelIntakeBack(-1.5));

       addCommands(new DriveForDistanceCmd(1.6));

        addCommands(new TurnToAngleCmd(RobotContainer.driveSubsystem, 44));

        addCommands(new DriveForDistanceCmd(0.50));
        
        //addCommands(new AngleDownChariotCmd(RobotContainer.angleSubsystem));
        //addCommands(new ElevatorUpManualCmd(RobotContainer.elevatorSubsystem));
        addCommands(new AutoParalleAngleDownElevatorUp());
        addCommands(new AngleUpShootCmd(RobotContainer.angleSubsystem));

        //addCommands(new AutoParalleAngleUpElevatorDown());

        addCommands(new PrepareLaunchAuto(RobotContainer.shooterSubsytem));
        //addCommands(new LaunchNoteAuto(RobotContainer.shooterSubsytem));
        addCommands(new AutoParallelIntakeLaunch());
    }
}
