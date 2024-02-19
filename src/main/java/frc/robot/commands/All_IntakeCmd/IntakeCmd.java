package frc.robot.commands.All_IntakeCmd;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCmd extends Command {
    
    IntakeSubsystem m_intake;

    public IntakeCmd(IntakeSubsystem intake){

        m_intake = intake;

        addRequirements(m_intake);
    }

    @Override
  public void initialize() {

    m_intake.setIntakeMotor(0.0);

  }

  @Override
  public void execute() {

    m_intake.setIntakeMotor(0.75);
  }

  @Override
  public boolean isFinished() {

    return false;
  }

  @Override
  public void end(boolean interrupted){
    m_intake.stop();
}
}
