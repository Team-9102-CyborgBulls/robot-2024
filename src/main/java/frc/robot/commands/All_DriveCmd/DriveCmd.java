package frc.robot.commands.All_DriveCmd;

import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
//import java.util.function.DoubleSupplier;

public class DriveCmd extends Command{
    
     final DriveSubsystem driveSubsystem;
  
    
   
  
    
    public DriveCmd(DriveSubsystem drivesubsystem){

        this.driveSubsystem = drivesubsystem;
       
        
        
    
        addRequirements(driveSubsystem);

    }
    
    @Override
  public void initialize() {

    DriveSubsystem.m_drive.feed();
  }

 
  @Override
  public void execute() {
    
    

    double forwardSpeed = RobotContainer.manette.getLeftY() ;
    double turnSpeed =  RobotContainer.manette.getRightX();
    driveSubsystem.arcadeDrive(forwardSpeed, turnSpeed);

    if( forwardSpeed == 0 && turnSpeed == 0){
      
      DriveSubsystem.m_drive.arcadeDrive(0, 0);
     
    }
    else{
      
      DriveSubsystem.m_drive.arcadeDrive(-forwardSpeed, -turnSpeed);
  }
  
 

    
  }

  @Override
  public void end(boolean interrupted) {}

 
  @Override
  public boolean isFinished() {
    return false;
  }
}


