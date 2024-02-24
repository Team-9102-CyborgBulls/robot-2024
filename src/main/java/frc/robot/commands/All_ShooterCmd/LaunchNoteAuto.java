package frc.robot.commands.All_ShooterCmd;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterSubsystem;

public class LaunchNoteAuto extends Command {

    ShooterSubsystem m_launcher;

    public LaunchNoteAuto(ShooterSubsystem launcher) {

    this.m_launcher = launcher;
    addRequirements(m_launcher);
  }

  
  @Override
  public void initialize() {
 
    m_launcher.setLaunchWheel(Constants.ShooterConstants.kLauncherSpeed);
    m_launcher.setFeedWheel(Constants.ShooterConstants.kLaunchFeederSpeed);
    RobotContainer.m_timer.reset();
    RobotContainer.m_timer.start();
  }

  @Override
  public void execute() {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Always return false so the command never ends on it's own. In this project we use the
    // scheduler to end the command when the button is released.
    if(RobotContainer.m_timer.get() >= 0.3){
      return true;
  }
  else{
    return false;
  }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stop the wheels when the command ends.
    m_launcher.stop();
  }
}
