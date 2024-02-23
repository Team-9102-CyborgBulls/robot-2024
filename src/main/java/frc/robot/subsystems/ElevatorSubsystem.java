package frc.robot.subsystems; // Déclaration du package où se trouve la classe ElevatorSubsystem
import com.revrobotics.CANSparkMax; // Import des classes nécessaires
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase { // Déclaration de la classe ElevatorSubsystem qui étend la classe SubsystemBase

    CANSparkMax m_elevatorMotor; // Déclaration d'une variable m_elevatorMotor de type CANSparkMax pour le moteur de l'ascenseur
    //RelativeEncoder m_encoder; // Déclaration d'une variable m_encoder de type RelativeEncoder pour l'encodeur
    public DutyCycleEncoder ElevatorEncoder = new DutyCycleEncoder(1); //Rev Through Bore Encoder

    public ElevatorSubsystem() { // Constructeur de la classe ElevatorSubsystem
        m_elevatorMotor = new CANSparkMax(Constants.ElevatorConstants.kElevatorMotorID, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless); // Initialisation du moteur de l'ascenseur avec l'ID et le type de moteur spécifiés dans Constants
        //m_encoder = m_elevatorMotor.getEncoder(); // Initialisation de l'encodeur à partir du moteur de l'ascenseur
        ElevatorEncoder.setDistancePerRotation(Constants.AngleElevatorConstants.kEncoderdistancePerRotation);
        m_elevatorMotor.enableVoltageCompensation(8); // Activation de la compensation de tension pour le moteur de l'ascenseur
        m_elevatorMotor.setIdleMode(IdleMode.kCoast); // Configuration du mode de repos du moteur de l'ascenseur en mode frein
    }

    public void setElevatorSpeed(double speed) { // Méthode pour définir la vitesse de l'ascenseur
        m_elevatorMotor.set(speed); // Réglage de la vitesse du moteur de l'ascenseur
    }

    public void stop() { // Méthode pour arrêter le moteur de l'ascenseur
        m_elevatorMotor.set(0); // Arrêt du moteur de l'ascenseur en mettant sa vitesse à 0
    }
}