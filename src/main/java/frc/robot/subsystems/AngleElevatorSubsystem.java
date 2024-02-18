package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AngleElevatorSubsystem extends SubsystemBase {
  
    CANSparkMax m_angleMotor;

    public AngleElevatorSubsystem(){
        
     m_angleMotor = new CANSparkMax(Constants.IntakeConstants.m_intakeMotorID, com.revrobotics.CANSparkLowLevel.MotorType.kBrushed);
    
    }

    public void setIntakeMotor(double speed){

        m_angleMotor.set(speed);
    }

    public void stop(){
        m_angleMotor.set(0);
    }
}  


