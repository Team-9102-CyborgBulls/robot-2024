package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;



import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase{
 
  CANSparkMax m_launchWheel;
  CANSparkMax m_feedWheel;

  /** Creates a new Launcher. */
  public ShooterSubsystem() {
    m_launchWheel = new CANSparkMax(Constants.ShooterConstants.m_launchWheelID, com.revrobotics.CANSparkLowLevel.MotorType.kBrushed);
    m_feedWheel = new CANSparkMax(Constants.ShooterConstants.m_feedWheelID, com.revrobotics.CANSparkLowLevel.MotorType.kBrushed);

    m_launchWheel.setSmartCurrentLimit(Constants.ShooterConstants.kLauncherCurrentLimit);
    m_feedWheel.setSmartCurrentLimit(Constants.ShooterConstants.kFeedCurrentLimit);
  }

  /**
   * This method is an example of the 'subsystem factory' style of command creation. A method inside
   * the subsytem is created to return an instance of a command. This works for commands that
   * operate on only that subsystem, a similar approach can be done in RobotContainer for commands
   * that need to span subsystems. The Subsystem class has helper methods, such as the startEnd
   * method used here, to create these commands.
   */
  // An accessor method to set the speed (technically the output percentage) of the launch wheel
  public void setLaunchWheel(double speed) {
    m_launchWheel.set(speed);
  }

  // An accessor method to set the speed (technically the output percentage) of the feed wheel
  public void setFeedWheel(double speed) {
    m_feedWheel.set(speed);
  }

  // A helper method to stop both wheels. You could skip having a method like this and call the
  // individual accessors with speed = 0 instead
  public void stop() {
    m_launchWheel.set(0);
    m_feedWheel.set(0);
  }
}

