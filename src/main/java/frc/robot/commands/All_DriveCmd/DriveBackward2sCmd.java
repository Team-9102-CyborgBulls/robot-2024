package frc.robot.commands.All_DriveCmd;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class DriveBackward2sCmd extends Command{
    
    DriveSubsystem driveSubsystem;
  
    public DriveBackward2sCmd(DriveSubsystem drivesubsystem){

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

    double speed = 0.8;
    driveSubsystem.setDriveMotors(speed,0);
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


