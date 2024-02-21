package frc.robot.commands.All_DriveCmd;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.RobotContainer;

public class DriveForward2sCmd extends Command{
    
    DriveSubsystem driveSubsystem;

    public DriveForward2sCmd(DriveSubsystem drivesubsystem){

      this.driveSubsystem = drivesubsystem;
      addRequirements(driveSubsystem);

    }
    @Override
    public void initialize() {
  
      RobotContainer.m_timer.reset();   
      RobotContainer.m_timer.start(); 
  
      driveSubsystem.setDriveMotors(0.0,0.0);
    }
  
   
    @Override
    public void execute() {
    
      System.out.println(RobotContainer.m_timer.get());
  
      double speed = -0.5;
     
      driveSubsystem.arcadeDrive(speed,0);
    }
  
    @Override
    public void end(boolean interrupted) {
      driveSubsystem.setDriveMotors(0, 0);
  
    }
  
   
    @Override
    public boolean isFinished() {
      return  RobotContainer.m_timer.get() >= 1.95;
    }
  }
  
  
  

