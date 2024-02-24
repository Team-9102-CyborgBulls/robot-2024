package frc.robot.commands.All_IntakeCmd;

import edu.wpi.first.hal.simulation.RoboRioDataJNI;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCmdAuto extends Command {
    
    IntakeSubsystem m_intake;

    public IntakeCmdAuto(IntakeSubsystem intake){

      this.m_intake = intake;
      addRequirements(m_intake);
    }

    @Override
  public void initialize() {
    
    RobotContainer.m_timer.reset();
    RobotContainer.m_timer.start();

  }

  @Override
  public void execute() {
    m_intake.setIntakeMotor(1);
  }

  @Override
  public boolean isFinished() {
    if(RobotContainer.m_timer.get() >= 1.3){ //a définir
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
