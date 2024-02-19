package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class TurnToAngleCmd extends Command{
    
    DriveSubsystem driveSubsystem;
    double error;
    double m_setpoint;
    public TurnToAngleCmd(DriveSubsystem drivesubsystem, double setpoint){

        this.driveSubsystem = drivesubsystem;
        this.m_setpoint = setpoint;
        
       
        addRequirements(driveSubsystem);

    }

    @Override
    public void initialize() {
       DriveSubsystem.gyro.reset();
    }
  
    @Override
    public void execute() {
    
    double kP = 0.09;
    double currentPosition = DriveSubsystem.gyro.getAngle();
        // Find the heading error; setpoint is 90
    error = 90 - currentPosition;
    double rightSpeed = kP * error;
    double leftSpeed = -kP * error;
    // Turns the robot to face the desired direction
    
        if(rightSpeed >= 0.53 || leftSpeed>=0.53){
        DriveSubsystem.m_drive.tankDrive(-0.53, 0.53);
        }else{
            DriveSubsystem.m_drive.tankDrive(-leftSpeed,-rightSpeed);

        }
    System.out.println(currentPosition);

    }

    @Override
    public void end(boolean interrupted){
       
        DriveSubsystem.m_drive.tankDrive(0, 0);

    }
    
  
    @Override
    public boolean isFinished() {
    
    if(Math.abs(error) <= 10){    
      return true;
    }
    else{
        return false;
        
    }
    }

}