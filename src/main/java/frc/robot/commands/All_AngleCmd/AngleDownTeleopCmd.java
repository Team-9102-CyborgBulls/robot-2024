package frc.robot.commands.All_AngleCmd; // Déclaration du package où se trouve la classe AngleDownManualCmd

import edu.wpi.first.wpilibj2.command.Command; // Import des classes nécessaires
import frc.robot.RobotContainer;
import frc.robot.subsystems.AngleSubsystem;

public class AngleDownTeleopCmd extends Command { // Déclaration de la classe AngleDownManualCmd qui étend la classe Command

    AngleSubsystem m_angle; // Déclaration d'une variable m_angle de type AngleSubsystem
    RobotContainer m_robotContainer;
    double targetHeight;
    double error; 
    
    public AngleDownTeleopCmd(AngleSubsystem angle) { // Constructeur de la classe AngleDownManualCmd
        this.m_angle = angle; // Initialisation de la variable m_angle avec la valeur passée en paramètre
        
        addRequirements(m_angle); // Ajout de la dépendance du sous-système angle
    }

    @Override
    public void initialize() { // Méthode d'initialisation
        RobotContainer.m_timer.reset(); // Réinitialisation du timer
        RobotContainer.m_timer.start(); // Démarrage du timer
    }

    @Override
    public void execute() { // Méthode execute qui sera appelée périodiquement
        m_angle.setAngleMotor(1); // Appel de la méthode setAngleMotor du sous-système angle avec une valeur de 1
    }

    @Override
    public void end(boolean interrupted) { // Méthode appelée une fois que la commande se termine ou est interrompue
        m_angle.stop(); // Appel de la méthode stop du sous-système angle
    }

    @Override
    public boolean isFinished() { // Méthode qui indique si la commande est terminée
        if(m_robotContainer.Potentio.getValue() <= 1500){

            m_robotContainer.angleLimit = true;
            return true;
    
        }else if(m_robotContainer.Potentio.getValue() <= 4060 && m_robotContainer.Potentio.getValue() >= 4058){
            m_robotContainer.angleShoot = true; 
            return true;

        }else if(m_robotContainer.Potentio.getValue() <= 3285 && m_robotContainer.Potentio.getValue() >= 3245){
            m_robotContainer.angleBumper = true; 
            return true;
        }else{
            m_robotContainer.angleBumper = false; 
            m_robotContainer.angleShoot = false; 
            m_robotContainer.angleLimit = false;
            m_robotContainer.angleIntake = false;
            return false; 
        } // La commande ne se termine jamais automatiquement
    }
}