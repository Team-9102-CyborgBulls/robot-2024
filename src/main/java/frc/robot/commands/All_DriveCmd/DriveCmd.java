package frc.robot.commands.All_DriveCmd; // Déclaration du package où se trouve la classe DriveCmd

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; // Import des classes nécessaires
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCmd extends Command{ // Déclaration de la classe DriveCmd qui étend la classe Command

    final DriveSubsystem driveSubsystem; // Déclaration d'une variable driveSubsystem de type DriveSubsystem

    public DriveCmd(DriveSubsystem drivesubsystem){ // Constructeur de la classe DriveCmd
        this.driveSubsystem = drivesubsystem; // Initialisation de la variable driveSubsystem avec la valeur passée en paramètre
        addRequirements(driveSubsystem); // Ajout de la dépendance du sous-système driveSubsystem
    }

    @Override
    public void initialize() {} // Méthode d'initialisation vide

    @Override
    public void execute() { // Méthode execute qui sera appelée périodiquement
        SmartDashboard.putNumber("speed changer value", driveSubsystem.speed_changer); // Affichage de la valeur de speed_changer sur le SmartDashboard
        SmartDashboard.putNumber("direction value", driveSubsystem.direction); // Affichage de la valeur de direction sur le SmartDashboard
        
        double forwardSpeed = RobotContainer.manette.getLeftY(); // Récupération de la vitesse de déplacement vers l'avant
        double turnSpeed =  RobotContainer.manette.getRightX(); // Récupération de la vitesse de rotation
        
        driveSubsystem.arcadeDrive(-forwardSpeed, -turnSpeed); // Appel de la méthode arcadeDrive du sous-système driveSubsystem avec les vitesses calculées
        
        if( forwardSpeed == 0 && turnSpeed == 0){ // Vérification si les vitesses sont nulles
            driveSubsystem.arcadeDrive(0, 0); // Arrêt du mouvement si les vitesses sont nulles
        }
    }
}