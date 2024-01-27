package frc.robot.commands.All_DriveCmd;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class SpeedChangerCmd extends Command {
    
    final DriveSubsystem driveSubsystem;

    public SpeedChangerCmd(DriveSubsystem drivesubsystem){

        this.driveSubsystem = drivesubsystem;
       
        
        
    
        addRequirements(driveSubsystem);

    }

    @Override
  public void execute() {}

}