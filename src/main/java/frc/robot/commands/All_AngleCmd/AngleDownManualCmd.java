package frc.robot.commands.All_AngleCmd;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.AngleSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;

public class AngleDownManualCmd extends Command{
    AngleSubsystem m_angle;
    public AngleDownManualCmd(AngleSubsystem angle){
        m_angle = angle;
        addRequirements(m_angle);
    }
    
    @Override
  public void initialize() {
    RobotContainer.m_timer.reset();
    RobotContainer.m_timer.start();

  }

  @Override
  public void execute() {

    m_angle.setAngleMotor(-1);
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
