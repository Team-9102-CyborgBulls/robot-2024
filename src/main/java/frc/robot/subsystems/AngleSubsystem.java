package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AngleSubsystem extends SubsystemBase {
  
    CANSparkMax m_angleMotor;

    public AngleSubsystem(){
        
     m_angleMotor = new CANSparkMax(Constants.AngleElevatorConstants.m_angleMotorID, com.revrobotics.CANSparkLowLevel.MotorType.kBrushed);
     m_angleMotor.setInverted(false);
     m_angleMotor.enableVoltageCompensation(8);
    
    }

    public void setAngleMotor(double speed){

        m_angleMotor.set(speed);
    }

    public void stop(){
        m_angleMotor.set(0);
    }
}  


