package frc.robot.commands.All_DriveCmd;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCmd extends Command{
    
     final DriveSubsystem driveSubsystem;
     
     public DriveCmd(DriveSubsystem drivesubsystem){

      this.driveSubsystem = drivesubsystem;
      addRequirements(driveSubsystem);
    }
    
    @Override
  public void initialize() {}

  @Override
  public void execute() {
    SmartDashboard.putNumber("speed changer value", driveSubsystem.speed_changer);
    SmartDashboard.putNumber("direction value", driveSubsystem.direction);
    
    double forwardSpeed = RobotContainer.manette.getRightX() ;
    double turnSpeed =  RobotContainer.manette.getLeftY();
    driveSubsystem.arcadeDrive(-forwardSpeed, -turnSpeed);

    if( forwardSpeed == 0 && turnSpeed == 0){
      driveSubsystem.arcadeDrive(0, 0);
    }
  }

  @Override
  public void end(boolean interrupted) {}

 
  @Override
  public boolean isFinished() {
    return false;
  }
}


