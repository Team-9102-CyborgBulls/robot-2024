package frc.robot.commands; // Déclaration du package où se trouve la classe DriveForwardGyroCmd

import edu.wpi.first.wpilibj2.command.Command; // Import des classes nécessaires
import frc.robot.subsystems.DriveSubsystem;

public class DriveForwardGyroCmd extends Command { // Déclaration de la classe DriveForwardGyroCmd qui étend la classe Command

    DriveSubsystem driveSubsystem; // Déclaration d'une variable driveSubsystem de type DriveSubsystem

    public DriveForwardGyroCmd(DriveSubsystem drivesubsystem) { // Constructeur de la classe DriveForwardGyroCmd
        this.driveSubsystem = drivesubsystem; // Initialisation de la variable driveSubsystem avec la valeur passée en paramètre
        addRequirements(driveSubsystem); // Ajout de la dépendance du sous-système driveSubsystem
    }
}