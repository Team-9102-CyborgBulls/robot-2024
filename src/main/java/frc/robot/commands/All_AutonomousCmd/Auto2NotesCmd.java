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
import frc.robot.commands.All_IntakeCmd.IntakeCmdAuto;
import frc.robot.commands.All_ShooterCmd.PrepareLaunchAuto;
import frc.robot.subsystems.DriveSubsystem;

public class Auto2NotesCmd extends SequentialCommandGroup{
    
    public Auto2NotesCmd(){
         
        addCommands(new AngleUpShootCmd(RobotContainer.angleSubsystem));
        addCommands(new PrepareLaunchAuto(RobotContainer.shooterSubsytem));
        //addCommands(new LaunchNoteAuto(RobotContainer.shooterSubsytem));
        addCommands(new AutoParallelIntakeLaunch()); // IntakeCmd and LaunchNote

        addCommands(new AngleDownChariotCmd(RobotContainer.angleSubsystem));
       
        addCommands(new ElevatorDownManualCmd(RobotContainer.elevatorSubsystem));

        
       

        addCommands(new AutoParallelIntakeBack(-1));
        
        addCommands(new DriveForDistanceCmd(1));                  //position Intake en face du shoot

     
        addCommands(new AngleDownChariotCmd(RobotContainer.angleSubsystem)); // position passe bumper

        addCommands(new ElevatorUpManualCmd(RobotContainer.elevatorSubsystem)); // remonte chariot

        addCommands(new AngleUpShootCmd(RobotContainer.angleSubsystem)); // position shoot
        
        addCommands(new PrepareLaunchAuto(RobotContainer.shooterSubsytem)); // shoot
        
        addCommands(new AutoParallelIntakeLaunch());                        // shoot
    }
}
