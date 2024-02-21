package frc.robot.commands.All_IntakeCmd;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;

<<<<<<<< HEAD:src/main/java/frc/robot/commands/All_IntakeCmd/IntakeCmdTeleop.java
public class IntakeCmdTeleop extends Command {
    
    IntakeSubsystem m_intake;

    public IntakeCmdTeleop(IntakeSubsystem intake){
========
public class IntakeAutoCmd extends Command {

    IntakeSubsystem m_intake;

    public IntakeAutoCmd(IntakeSubsystem intake){
>>>>>>>> 94036b86cd03d3b5626c29a19e60095fe18782b4:src/main/java/frc/robot/commands/All_IntakeCmd/IntakeAutoCmd.java

      this.m_intake = intake;
      addRequirements(m_intake);
    }

    @Override
  public void initialize() {
    m_intake.setIntakeMotor(0.0);
    RobotContainer.m_timer.reset();
    RobotContainer.m_timer.start();

  }

  @Override
  public void execute() {
    m_intake.setIntakeMotor(0.75);
  }

  @Override
  public boolean isFinished() {
    if(RobotContainer.m_timer.get() >= 3){
      return true;
  }
  else{
    return false;
  }
  }

  @Override
  public void end(boolean interrupted){
    m_intake.stop();
  }
}