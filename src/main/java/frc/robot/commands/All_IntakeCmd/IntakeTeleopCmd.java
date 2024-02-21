package frc.robot.commands.All_IntakeCmd; // Déclaration du package où se trouve la classe IntakeTeleopCmd

import edu.wpi.first.wpilibj2.command.Command; // Import des classes nécessaires
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeTeleopCmd extends Command { // Déclaration de la classe IntakeTeleopCmd qui étend la classe Command

    IntakeSubsystem m_intake; // Déclaration d'une variable m_intake de type IntakeSubsystem

    public IntakeTeleopCmd(IntakeSubsystem intake) { // Constructeur de la classe IntakeTeleopCmd
        this.m_intake = intake; // Initialisation de la variable m_intake avec la valeur passée en paramètre
        addRequirements(m_intake); // Ajout de la dépendance du sous-système intake
    }

    @Override
    public void initialize() { // Méthode d'initialisation
        m_intake.setIntakeMotor(0.0); // Arrêt du moteur d'intake (valeur de vitesse = 0.0)
    }

    @Override
    public void execute() { // Méthode execute qui sera appelée périodiquement
        m_intake.setIntakeMotor(0.75); // Activation du moteur d'intake à 75% de sa vitesse
    }

    @Override
    public boolean isFinished() { // Méthode qui indique si la commande est terminée
        return false; // La commande ne se termine jamais automatiquement
    }

    @Override
    public void end(boolean interrupted) { // Méthode appelée une fois que la commande se termine ou est interrompue
        m_intake.stop(); // Arrêt du moteur d'intake
    }
}