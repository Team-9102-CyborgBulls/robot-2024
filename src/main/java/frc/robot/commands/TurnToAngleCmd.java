package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class TurnToAngleCmd extends Command{
    
    DriveSubsystem driveSubsystem;
    double error;
    double targetAngle;
    double degreesToTurn;

    public TurnToAngleCmd(DriveSubsystem drivesubsystem, double degreesToTurn){

        this.driveSubsystem = drivesubsystem;
        this.degreesToTurn = degreesToTurn;
        
        addRequirements(driveSubsystem);

    }

    @Override
    public void initialize() {
       DriveSubsystem.gyro.reset();

       this.targetAngle = degreesToTurn +  DriveSubsystem.gyro.getAngle();
    }
  
    @Override
    public void execute() {
    
    double kP = 0.019;

    double currentPosition = DriveSubsystem.gyro.getAngle();
        // Find the heading error; setpoint is 90
    error = targetAngle - currentPosition;
    double speed = kP * error;

    // Turns the robot to face the desired direction
    
        driveSubsystem.drive(speed,-speed);

        
    System.out.println(currentPosition);
    System.out.println(error);

    }

    @Override
    public void end(boolean interrupted){
       
        //DriveSubsystem.m_drive.tankDrive(0, 0);

    }
    
  
    @Override
    public boolean isFinished() {
    
    if(Math.abs(error) <= 30){    
      return true;
    }
    else{
        return false;
        
    }
    }

}