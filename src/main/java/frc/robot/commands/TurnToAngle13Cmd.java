package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class TurnToAngle13Cmd extends Command{
    
    DriveSubsystem driveSubsystem;
    double error;
    public TurnToAngle13Cmd(DriveSubsystem drivesubsystem){

        this.driveSubsystem = drivesubsystem;
        
       
        addRequirements(driveSubsystem);

    }

    @Override
    public void initialize() {
       RobotContainer.gyro.reset();
    }
  
    @Override
    public void execute() {
    
    double kP = 0.09;
    double currentPosition = RobotContainer.gyro.getAngle();
        // Find the heading error; setpoint is 90
    error = 13 - currentPosition;
    double rightSpeed = kP * error;
    double leftSpeed = -kP * error;
    // Turns the robot to face the desired direction
    
        if(rightSpeed >= 0.5 || leftSpeed>=0.5){
        DriveSubsystem.m_drive.tankDrive(-0.5, 0.5);
        }else{
            DriveSubsystem.m_drive.tankDrive(leftSpeed,rightSpeed);

        }
    System.out.println(currentPosition);

    }

    @Override
    public void end(boolean interrupted){
       
        DriveSubsystem.m_drive.tankDrive(0, 0);

    }
    
  
    @Override
    public boolean isFinished() {
    
    if(Math.abs(error) <= 5){    
      return true;
    }
    else{
        return false;
        
    }
    }

}