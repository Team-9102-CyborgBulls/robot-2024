package frc.robot.commands.All_ShooterCmd;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterSubsystem;

public class PrepareLaunchTeleop extends Command {
   
  ShooterSubsystem m_launcher;

  public PrepareLaunchTeleop(ShooterSubsystem launcher) {

    this.m_launcher = launcher;
    addRequirements(m_launcher);
  }

 
  @Override
  public void initialize() {
    m_launcher.setLaunchWheel(Constants.ShooterConstants.kLauncherSpeed);
  }

 
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Do nothing when the command ends. The launch wheel needs to keep spinning in order to launch
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Always return false so the command never ends on it's own. In this project we use a timeout
    // decorator on the command to end it.
    return false;
  }
}

