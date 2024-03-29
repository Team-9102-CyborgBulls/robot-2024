package frc.robot.commands.All_AngleCmd; // Déclaration du package où se trouve la classe AngleUpManualCmd

import edu.wpi.first.wpilibj2.command.Command; // Import des classes nécessaires
import frc.robot.RobotContainer;
import frc.robot.subsystems.AngleSubsystem;

public class AngleUpShootCmd extends Command { // Déclaration de la classe AngleUpManualCmd qui étend la classe Command

    AngleSubsystem m_angle; // Déclaration d'une variable m_angle de type AngleSubsystem
    double targetHeight;
    double error; 
    double heightToGo;
    double kP = 0.00048;
    RobotContainer m_robotContainer;

    public AngleUpShootCmd(AngleSubsystem anglesubsystem) { // Constructeur de la classe AngleUpManualCmd
        this.m_angle = anglesubsystem;// Initialisation de la variable m_angle avec la valeur passée en paramètre
       
        addRequirements(m_angle); // Ajout de la dépendance du sous-système anglesubsystem
    }

    @Override
    public void initialize() {

        m_robotContainer.Potentio.getValue();
       
    } // Méthode d'initialisation 

    @Override
    public void execute() { // Méthode execute qui sera appelée périodiquement

        m_angle.setAngleMotor(-1); // Appel de la méthode setAngleMotor du sous-système angle avec une valeur de -1 pour monter
    }

    @Override
    public void end(boolean interrupted) { // Méthode appelée une fois que la commande se termine ou est interrompue
        m_angle.stop(); // Appel de la méthode stop du sous-système angle pour arrêter le mouvement
    }

    @Override
    public boolean isFinished() { // Méthode qui indique si la commande est terminée
        if(m_robotContainer.Potentio.getValue() >=4055){    
      return true;
    }
    else{
        return false;
        
    }
    }
}