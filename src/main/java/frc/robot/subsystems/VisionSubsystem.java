package frc.robot.subsystems;

import org.photonvision.PhotonCamera;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase {
      // Constants such as camera and target height stored. Change per robot and goal!
    public static final double CAMERA_HEIGHT_METERS = 0.95;
    public static final double TARGET_HEIGHT_METERS = 1.45;

    // Angle between horizontal and the camera.
    public static final double CAMERA_PITCH_RADIANS = Units.degreesToRadians(10);

    // How far from the target we want to be
    public static final double GOAL_RANGE_METERS = 2.72;

    // Change this to match the name of your camera
    public PhotonCamera camera = new PhotonCamera("photonvision");

    // PID constants should be tuned per robot
    final static double P_GAIN = 1;
    final static double D_GAIN = 0.1;
    public static PIDController controller = new PIDController(P_GAIN, 0, D_GAIN);

    


public VisionSubsystem() {}    

@Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }






}
