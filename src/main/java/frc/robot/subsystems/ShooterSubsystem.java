package frc.robot.subsystems; // Déclaration du package où se trouve la classe ShooterSubsystem

import com.revrobotics.CANSparkMax; // Import des classes nécessaires

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase { // Déclaration de la classe ShooterSubsystem qui étend la classe SubsystemBase

    CANSparkMax m_launchWheel; // Déclaration d'une variable m_launchWheel de type CANSparkMax pour la roue de lancement
    CANSparkMax m_feedWheel; // Déclaration d'une variable m_feedWheel de type CANSparkMax pour la roue d'alimentation

    public ShooterSubsystem() { // Constructeur de la classe ShooterSubsystem
        m_launchWheel = new CANSparkMax(Constants.ShooterConstants.m_launchWheelID, com.revrobotics.CANSparkLowLevel.MotorType.kBrushed); // Initialisation de la roue de lancement avec l'ID et le type de moteur spécifiés dans Constants
        m_feedWheel = new CANSparkMax(Constants.ShooterConstants.m_feedWheelID, com.revrobotics.CANSparkLowLevel.MotorType.kBrushed); // Initialisation de la roue d'alimentation avec l'ID et le type de moteur spécifiés dans Constants
        
        m_launchWheel.setSmartCurrentLimit(Constants.ShooterConstants.kLauncherCurrentLimit); // Configuration de la limite de courant pour la roue de lancement
        m_feedWheel.setSmartCurrentLimit(Constants.ShooterConstants.kFeedCurrentLimit); // Configuration de la limite de courant pour la roue d'alimentation
        
        m_launchWheel.setInverted(true); // Inversion du sens de rotation de la roue de lancement
        m_feedWheel.setInverted(true); // Inversion du sens de rotation de la roue d'alimentation
    }

    public Command getIntakeCommand() {
    // The startEnd helper method takes a method to call when the command is initialized and one to
    // call when it ends
    return this.startEnd(
        // When the command is initialized, set the wheels to the intake speed values
        () -> {
          setFeedWheel(Constants.ShooterConstants.kSourceIntakeSpeed);
          setLaunchWheel(Constants.ShooterConstants.kSourceIntakeSpeed);
        },
        // When the command stops, stop the wheels
        () -> {
          stop();
        });
  }

    // Méthode d'accès pour définir la vitesse (techniquement le pourcentage de sortie) de la roue de lancement
    public void setLaunchWheel(double speed) {
        m_launchWheel.set(speed);
    }

    // Méthode d'accès pour définir la vitesse (techniquement le pourcentage de sortie) de la roue d'alimentation
    public void setFeedWheel(double speed) {
        m_feedWheel.set(speed);
    }

    // Méthode auxiliaire pour arrêter les deux roues. Vous pourriez éviter d'avoir une méthode comme celle-ci et appeler les méthodes d'accès individuelles avec speed = 0 à la place
    public void stop() {
        m_launchWheel.set(0);
        m_feedWheel.set(0);
    }
  }