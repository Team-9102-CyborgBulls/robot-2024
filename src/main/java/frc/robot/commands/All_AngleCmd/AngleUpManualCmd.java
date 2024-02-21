package frc.robot.commands.All_AngleCmd; // Déclaration du package où se trouve la classe AngleUpManualCmd

import edu.wpi.first.wpilibj2.command.Command; // Import des classes nécessaires
import frc.robot.RobotContainer;
import frc.robot.subsystems.AngleSubsystem;

public class AngleUpManualCmd extends Command { // Déclaration de la classe AngleUpManualCmd qui étend la classe Command

    AngleSubsystem m_angle; // Déclaration d'une variable m_angle de type AngleSubsystem
    double targetHeight;
    double error; 
    double heightToGo;
    RobotContainer m_robotContainer;

    public AngleUpManualCmd(AngleSubsystem anglesubsystem, double heightToGo) { // Constructeur de la classe AngleUpManualCmd
        this.m_angle = anglesubsystem;// Initialisation de la variable m_angle avec la valeur passée en paramètre
        this.heightToGo = heightToGo
        addRequirements(m_angle); // Ajout de la dépendance du sous-système anglesubsystem
    }

    @Override
    public void initialize() {

        m_robotContainer.analog.getValue();
        this.targetHeight = heightToGo + m_robotContainer.analog.getValue();
    } // Méthode d'initialisation 

    @Override
    public void execute() { // Méthode execute qui sera appelée périodiquement

        double kP;
        double currentHeight = m_robotContainer.analog.getValue();
        error = targetHeight - currentHeight;
        double speed = kP*error;
        m_angle.setAngleMotor(speed); // Appel de la méthode setAngleMotor du sous-système angle avec une valeur de -1 pour monter
    }

    @Override
    public void end(boolean interrupted) { // Méthode appelée une fois que la commande se termine ou est interrompue
        m_angle.stop(); // Appel de la méthode stop du sous-système angle pour arrêter le mouvement
    }

    @Override
    public boolean isFinished() { // Méthode qui indique si la commande est terminée
        if(Math.abs(error) <= 30){    
      return true;
    }
    else{
        return false;
        
    }// La commande ne se termine jamais automatiquement
    }
}