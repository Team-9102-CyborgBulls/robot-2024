<<<<<<< HEAD
package frc.robot.commands.All_ShooterCmd;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterSubsystem;

<<<<<<<< HEAD:src/main/java/frc/robot/commands/All_ShooterCmd/LaunchNoteTeleop.java
public class LaunchNoteTeleop extends Command {
  
    ShooterSubsystem m_launcher;

    public LaunchNoteTeleop(ShooterSubsystem launcher) {
    
========
public class LaunchNoteAuto extends Command {

    ShooterSubsystem m_launcher;

    public LaunchNoteAuto(ShooterSubsystem launcher) {

>>>>>>>> 94036b86cd03d3b5626c29a19e60095fe18782b4:src/main/java/frc/robot/commands/All_ShooterCmd/LaunchNoteAuto.java
    this.m_launcher = launcher;
    addRequirements(m_launcher);
  }


  @Override
  public void initialize() {

    m_launcher.setLaunchWheel(Constants.ShooterConstants.kLauncherSpeed);
    m_launcher.setFeedWheel(Constants.ShooterConstants.kLaunchFeederSpeed);
    RobotContainer.m_timer.reset();
    RobotContainer.m_timer.start();
  }

  @Override
  public void execute() {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Always return false so the command never ends on it's own. In this project we use the
    // scheduler to end the command when the button is released.
    if(RobotContainer.m_timer.get() >= 3){
      return true;
  }
  else{
    return false;
  }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stop the wheels when the command ends.
    m_launcher.stop();
  }
=======
package frc.robot.commands.All_ShooterCmd; // Déclaration du package où se trouve la classe LaunchNoteTeleop

import edu.wpi.first.wpilibj2.command.Command; // Import des classes nécessaires
import frc.robot.Constants;
import frc.robot.subsystems.ShooterSubsystem;

public class LaunchNoteTeleop extends Command { // Déclaration de la classe LaunchNoteTeleop qui étend la classe Command

    ShooterSubsystem m_launcher; // Déclaration d'une variable m_launcher de type ShooterSubsystem

    public LaunchNoteTeleop(ShooterSubsystem launcher) { // Constructeur de la classe LaunchNoteTeleop
        this.m_launcher = launcher; // Initialisation de la variable m_launcher avec la valeur passée en paramètre
        addRequirements(m_launcher); // Ajout de la dépendance du sous-système launcher
    }

    @Override
    public void initialize() { // Méthode d'initialisation
        m_launcher.setLaunchWheel(Constants.ShooterConstants.kLauncherSpeed); // Réglage de la vitesse de rotation du lanceur
        m_launcher.setFeedWheel(Constants.ShooterConstants.kLaunchFeederSpeed); // Réglage de la vitesse de rotation du distributeur de balles
    }

    @Override
    public void execute() {} // Méthode execute vide

    @Override
    public boolean isFinished() { // Méthode qui indique si la commande est terminée
        // Toujours renvoyer false pour que la commande ne se termine jamais d'elle-même. Dans ce projet, nous utilisons le planificateur pour terminer la commande lorsque le bouton est relâché.
        return false;
    }

    @Override
    public void end(boolean interrupted) { // Méthode appelée une fois que la commande se termine ou est interrompue
        // Arrêter les roues lorsque la commande se termine
        m_launcher.stop(); // Appel de la méthode stop du sous-système launcher pour arrêter les roues
    }
>>>>>>> 94036b86cd03d3b5626c29a19e60095fe18782b4
}