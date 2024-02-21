package frc.robot.commands.All_ShooterCmd;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterSubsystem;

<<<<<<< HEAD
public class LaunchNoteAuto extends Command {
  
    ShooterSubsystem m_launcher;

    public LaunchNoteAuto(ShooterSubsystem launcher) {
    
=======
<<<<<<<< HEAD:src/main/java/frc/robot/commands/All_ShooterCmd/LaunchNoteTeleop.java
public class LaunchNoteTeleop extends Command {
  
    ShooterSubsystem m_launcher;

    public LaunchNoteTeleop(ShooterSubsystem launcher) {
    
========
public class LaunchNoteAuto extends Command {

    ShooterSubsystem m_launcher;

    public LaunchNoteAuto(ShooterSubsystem launcher) {

>>>>>>>> 94036b86cd03d3b5626c29a19e60095fe18782b4:src/main/java/frc/robot/commands/All_ShooterCmd/LaunchNoteAuto.java
>>>>>>> 94036b86cd03d3b5626c29a19e60095fe18782b4
    this.m_launcher = launcher;
    addRequirements(m_launcher);
  }

<<<<<<< HEAD
  
  @Override
  public void initialize() {
 
=======

  @Override
  public void initialize() {

>>>>>>> 94036b86cd03d3b5626c29a19e60095fe18782b4
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
    if(RobotContainer.m_timer.get() >= 3){
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
<<<<<<< HEAD
}
=======
}
>>>>>>> 94036b86cd03d3b5626c29a19e60095fe18782b4
