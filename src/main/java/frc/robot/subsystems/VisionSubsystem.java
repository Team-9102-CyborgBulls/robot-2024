package frc.robot.subsystems; // Déclaration du package où se trouve la classe VisionSubsystem

import org.photonvision.PhotonCamera; // Import des classes nécessaires
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase { // Déclaration de la classe VisionSubsystem qui étend la classe SubsystemBase

    // Constantes telles que la hauteur de la caméra et de la cible stockées. À changer selon le robot et l'objectif !
    public static final double CAMERA_HEIGHT_METERS = Units.inchesToMeters(24);
    public static final double TARGET_HEIGHT_METERS = Units.feetToMeters(5);
    
    // Angle entre l'horizontal et la caméra.
    public static final double CAMERA_PITCH_RADIANS = Units.degreesToRadians(0);
    
    // Distance souhaitée par rapport à la cible
    public static final double GOAL_RANGE_METERS = Units.feetToMeters(3);
    
    // Changer ceci pour correspondre au nom de votre caméra
    PhotonCamera camera = new PhotonCamera("photonvision");
    
    // Les constantes PID doivent être ajustées par robot
    final static double P_GAIN = 0.1;
    final static double D_GAIN = 0.0;
    public static PIDController controller = new PIDController(P_GAIN, 0, D_GAIN);

    public VisionSubsystem() {} // Constructeur de la classe VisionSubsystem

    @Override
    public void periodic() {} // Cette méthode sera appelée une fois par exécution du planificateur

}