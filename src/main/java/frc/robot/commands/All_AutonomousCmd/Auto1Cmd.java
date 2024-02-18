package frc.robot.commands.All_AutonomousCmd;



import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.TurnToAngle90Cmd;
import frc.robot.subsystems.DriveSubsystem;

public class Auto1Cmd extends SequentialCommandGroup{
    
    public Auto1Cmd(){

        addCommands(new TurnToAngle90Cmd(RobotContainer.driveSubsystem));
    }
}
