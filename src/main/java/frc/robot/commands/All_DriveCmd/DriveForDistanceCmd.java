package frc.robot.commands.All_DriveCmd;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

// This command drives a specified number of meters
public class DriveForDistanceCmd extends Command {

  DriveSubsystem m_DriveSubsystem;
  double initialDistance;
  double targetDistance;
  double distance;
  double percentPower;
  double kP;
  double error;
  double startAngle; // our starting gyroscope heading

  /** Creates a new DriveForDistanceCommand. */
  public DriveForDistanceCmd(double distance) {
    m_DriveSubsystem = RobotContainer.driveSubsystem;
    this.distance = distance;
    addRequirements(m_DriveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    m_DriveSubsystem.resetPosition();
    initialDistance = m_DriveSubsystem.getDistance();
    m_DriveSubsystem.resetGyro();
    this.startAngle = m_DriveSubsystem.getAngle();
    System.out.println("INITIAL DISTANCE: " + initialDistance);
    this.targetDistance = initialDistance + distance;
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double kP = 0.5;
    double currentPosition = -m_DriveSubsystem.getDistance();
    error = targetDistance - currentPosition;
    double speed =  kP * error;
    System.out.println(speed);
    double error_turn = startAngle - m_DriveSubsystem.getAngle(); // Correction needed for robot angle (our starting angle, since we would like to drive straight)
    SmartDashboard.putNumber("erreur",error_turn);
    System.out.println(error_turn);
    double turn = error_turn * 0.015;
    SmartDashboard.putNumber("turn",turn);
    System.out.println(turn);

    if(speed >= 0.2){
      speed = 0.2;
    }
    else if (speed <= -0.2){
      speed = -0.2;
    }
    else if(speed >= 0){
      turn = -turn;
    }
    else if (speed <0){
      turn = turn;
    }
    else if (turn >= 0.2){
      turn = 0.2;
    }
    else if(turn <= -0.2){
      turn = -0.2;
    }
    
    m_DriveSubsystem.setDriveMotors(speed,turn);
    

    //m_DriveSubsystem.setDriveMotors(speed, 0);
    // Print statements for debugging
    System.out.println("GOAL DISTANCE: " + (distance + initialDistance));
    System.out.println("CURRENT DISTANCE: " + m_DriveSubsystem.getDistance());
    System.out.println("POWER: " + percentPower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_DriveSubsystem.stop(); // Stop the drivetrain motors
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(error >= 0 && error <= 0.2){
      return true; // End the command when we have reached our goal
    }else if(error <= 0 && error >= -0.2){
      return true; // End the command when we have reached our goal
    }else{
      return false;
    }
  }
}
