<<<<<<< HEAD
package frc.robot.commands.All_ShooterCmd;

import edu.wpi.first.wpilibj2.command.Command;
=======
package frc.robot.commands.All_ShooterCmd; // Déclaration du package où se trouve la classe PrepareLaunchAuto

import edu.wpi.first.wpilibj2.command.Command; // Import des classes nécessaires
>>>>>>> 94036b86cd03d3b5626c29a19e60095fe18782b4
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterSubsystem;

<<<<<<< HEAD
public class PrepareLaunchAuto extends Command {
   
  ShooterSubsystem m_launcher;

  public PrepareLaunchAuto(ShooterSubsystem launcher) {

    this.m_launcher = launcher;
    addRequirements(m_launcher);
  }

 
  @Override
  public void initialize() {
    m_launcher.setLaunchWheel(Constants.ShooterConstants.kLauncherSpeed);
    RobotContainer.m_timer.reset();
    RobotContainer.m_timer.start();
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
    if(RobotContainer.m_timer.get() >= 1){
        return true;
    }
    else{
      return false;
    }
  }
}

=======
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
>>>>>>> 94036b86cd03d3b5626c29a19e60095fe18782b4
