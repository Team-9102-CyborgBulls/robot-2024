package frc.robot.commands.All_AngleCmd;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.AngleSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;

public class AngleUpManualCmd extends Command{
    AngleSubsystem m_angle;
    public AngleUpManualCmd(AngleSubsystem anglesubsystem){
        m_angle = anglesubsystem;
        addRequirements(m_angle);
    }
    
    @Override
  public void initialize() {
  }

  @Override
  public void execute() {

    m_angle.setAngleMotor(1);
  }
  @Override
  public void end(boolean interrupted){

    m_angle.stop();
  }
  

  @Override
  public boolean isFinished() {

    return false;
  }
}
