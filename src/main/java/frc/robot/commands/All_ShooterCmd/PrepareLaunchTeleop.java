<<<<<<< HEAD
package frc.robot.commands.All_ShooterCmd;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterSubsystem;

public class PrepareLaunchTeleop extends Command {
   
  ShooterSubsystem m_launcher;

  public PrepareLaunchTeleop(ShooterSubsystem launcher) {

    this.m_launcher = launcher;
    addRequirements(m_launcher);
  }

 
  @Override
  public void initialize() {
    m_launcher.setLaunchWheel(Constants.ShooterConstants.kLauncherSpeed);
  }

 
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Do nothing when the command ends. The launch wheel needs to keep spinning in order to launch
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Always return false so the command never ends on it's own. In this project we use a timeout
    // decorator on the command to end it.
    return false;
  }
}

=======
package frc.robot.commands.All_ShooterCmd; // Déclaration du package où se trouve la classe PrepareLaunchTeleop

import edu.wpi.first.wpilibj2.command.Command; // Import des classes nécessaires
import frc.robot.Constants;
import frc.robot.subsystems.ShooterSubsystem;

public class PrepareLaunchTeleop extends Command { // Déclaration de la classe PrepareLaunchTeleop qui étend la classe Command

    ShooterSubsystem m_launcher; // Déclaration d'une variable m_launcher de type ShooterSubsystem

    public PrepareLaunchTeleop(ShooterSubsystem launcher) { // Constructeur de la classe PrepareLaunchTeleop
        this.m_launcher = launcher; // Initialisation de la variable m_launcher avec la valeur passée en paramètre
        addRequirements(m_launcher); // Ajout de la dépendance du sous-système launcher
    }

    @Override
    public void initialize() { // Méthode d'initialisation
        m_launcher.setLaunchWheel(Constants.ShooterConstants.kLauncherSpeed); // Réglage de la vitesse de rotation du lanceur
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
        return false;
    }
}
>>>>>>> 94036b86cd03d3b5626c29a19e60095fe18782b4
