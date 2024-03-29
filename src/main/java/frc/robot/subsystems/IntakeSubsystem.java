package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

    CANSparkMax m_intakeMotor;
    
    
    public IntakeSubsystem(){
        
     m_intakeMotor = new CANSparkMax(Constants.IntakeConstants.m_intakeMotorID, com.revrobotics.CANSparkLowLevel.MotorType.kBrushed);
     m_intakeMotor.enableVoltageCompensation(8);
     m_intakeMotor.setInverted(true);
    }

    public void setIntakeMotor(double speed){
        m_intakeMotor.set(speed);
    }

    public void stop(){
        m_intakeMotor.set(0);
    }
}  
