package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase{
 
  CANSparkMax m_launchWheel;
  CANSparkMax m_feedWheel;

  
  public ShooterSubsystem() {
    m_launchWheel = new CANSparkMax(Constants.ShooterConstants.m_launchWheelID, com.revrobotics.CANSparkLowLevel.MotorType.kBrushed);
    m_feedWheel = new CANSparkMax(Constants.ShooterConstants.m_feedWheelID, com.revrobotics.CANSparkLowLevel.MotorType.kBrushed);

    m_launchWheel.setSmartCurrentLimit(Constants.ShooterConstants.kLauncherCurrentLimit);
    m_feedWheel.setSmartCurrentLimit(Constants.ShooterConstants.kFeedCurrentLimit);
    m_launchWheel.setInverted(true);
    m_feedWheel.setInverted(true);
  }

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

