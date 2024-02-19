package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase {
    
    CANSparkMax m_elevatorMotor;
    RelativeEncoder m_encoder;

    public ElevatorSubsystem(){

        m_elevatorMotor = new CANSparkMax(Constants.ElevatorConstants.kElevatorMotorID,com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
        m_encoder = m_elevatorMotor.getEncoder();
    }

    public void setElevatorSpeed(double speed){
        m_elevatorMotor.set(speed);
    }

    public void stop(){
        m_elevatorMotor.set(0);
    }
}
