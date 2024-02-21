package frc.robot.commands.All_ShooterCmd; // Déclaration du package où se trouve la classe PrepareLaunchAuto

import edu.wpi.first.wpilibj2.command.Command; // Import des classes nécessaires
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterSubsystem;

public class PrepareLaunchAuto extends Command { // Déclaration de la classe PrepareLaunchAuto qui étend la classe Command

    ShooterSubsystem m_launcher; // Déclaration d'une variable m_launcher de type ShooterSubsystem

    public PrepareLaunchAuto(ShooterSubsystem launcher) { // Constructeur de la classe PrepareLaunchAuto
        this.m_launcher = launcher; // Initialisation de la variable m_launcher avec la valeur passée en paramètre
        addRequirements(m_launcher); // Ajout de la dépendance du sous-système launcher
    }

    @Override
    public void initialize() { // Méthode d'initialisation
        m_launcher.setLaunchWheel(Constants.ShooterConstants.kLauncherSpeed); // Réglage de la vitesse de rotation du lanceur
        RobotContainer.m_timer.reset(); // Réinitialisation du timer
        RobotContainer.m_timer.start(); // Démarrage du timer
    }

    @Override
    public void execute() {} // Méthode execute vide

    @Override
    public void end(boolean interrupted) { // Méthode appelée une fois que la commande se termine ou est interrompue
        // Ne rien faire lorsque la commande se termine. La roue de lancement doit continuer à tourner pour lancer
    }

    @Override
    public boolean isFinished() { // Méthode qui indique si la commande est terminée
        // Toujours renvoyer false pour que la commande ne se termine jamais par elle-même. Dans ce projet, nous utilisons un délai d'attente pour terminer la commande.
        if(RobotContainer.m_timer.get() >= 1){
            return true;
        } else {
            return false;
        }
    }
}