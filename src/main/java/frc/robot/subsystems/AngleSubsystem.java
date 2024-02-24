package frc.robot.subsystems; // Déclaration du package où se trouve la classe AngleSubsystem

import com.revrobotics.CANSparkMax; // Import des classes nécessaires
import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AngleSubsystem extends SubsystemBase { // Déclaration de la classe AngleSubsystem qui étend la classe SubsystemBase

    CANSparkMax m_angleMotor; // Déclaration d'une variable m_angleMotor de type CANSparkMax pour le moteur d'angle

    public AngleSubsystem() { // Constructeur de la classe AngleSubsystem
        m_angleMotor = new CANSparkMax(Constants.AngleElevatorConstants.m_angleMotorID, com.revrobotics.CANSparkLowLevel.MotorType.kBrushed); // Initialisation du moteur d'angle avec l'ID et le type de moteur spécifiés dans Constants
        m_angleMotor.setInverted(true); // Configuration de la direction du moteur d'angle
        m_angleMotor.enableVoltageCompensation(9); // Activation de la compensation de tension pour le moteur d'angle
        m_angleMotor.setIdleMode(IdleMode.kBrake);
    }

    public void setAngleMotor(double speed) { // Méthode pour définir la vitesse du moteur d'angle
        m_angleMotor.set(speed); // Réglage de la vitesse du moteur d'angle
    }

    public void stop() { // Méthode pour arrêter le moteur d'angle
        m_angleMotor.set(0); // Arrêt du moteur d'angle en mettant sa vitesse à 0
    }
}