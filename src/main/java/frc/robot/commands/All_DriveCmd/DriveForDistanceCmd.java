package frc.robot.commands.All_DriveCmd;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

// This command drives a specified number of meters
public class DriveForDistanceCmd extends Command {

  DriveSubsystem m_DriveSubsystem;
  double initialDistance;
  double distance;
  double percentPower;

  /** Creates a new DriveForDistanceCommand. */
  public DriveForDistanceCmd(double distance, double percentPower) {
    m_DriveSubsystem = RobotContainer.driveSubsystem;
    this.distance = distance;
    this.percentPower = percentPower;
    addRequirements(m_DriveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    initialDistance = m_DriveSubsystem.getDistance();
    System.out.println("INITIAL DISTANCE: " + initialDistance);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_DriveSubsystem.setDriveMotors(percentPower, percentPower);
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
    return m_DriveSubsystem.getDistance() >= initialDistance + distance; // End the command when we have reached our goal
  }
}