package frc.robot.commands.All_DriveCmd;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class ReverseCmd extends Command {
    final DriveSubsystem driveSubsystem;



    public ReverseCmd(DriveSubsystem drivesubsystem){
        this.driveSubsystem = drivesubsystem;


        addRequirements(driveSubsystem);
    }
    
    @Override
  public void initialize(){}

  @Override
  public void execute(){
  
  }
}
