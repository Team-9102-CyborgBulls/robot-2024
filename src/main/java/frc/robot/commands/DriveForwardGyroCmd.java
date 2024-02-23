package frc.robot.commands; // Déclaration du package où se trouve la classe DriveForwardGyroCmd

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command; // Import des classes nécessaires
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

public class DriveForwardGyroCmd extends Command { // Déclaration de la classe DriveForwardGyroCmd qui étend la classe Command

    DriveSubsystem driveSubsystem; // Déclaration d'une variable driveSubsystem de type DriveSubsystem

    Timer timer = new Timer();

	double duration; // how long we want to drive
    double startAngle; // our starting gyroscope heading
    double driveRate; // how fast we want to drive

    public DriveForwardGyroCmd(DriveSubsystem drivesubsystem, double time) { // Constructeur de la classe DriveForwardGyroCmd
        this.driveSubsystem = drivesubsystem; // Initialisation de la variable driveSubsystem avec la valeur passée en paramètre
        this.duration = time;
        addRequirements(driveSubsystem); // Ajout de la dépendance du sous-système driveSubsystem
    }
    	//Starts the timer and gets the starting angle
	public void initialize() {
	  timer.reset();
  	  timer.start();
      driveSubsystem.resetGyro();
      this.startAngle = driveSubsystem.getAngle(); // Get our initial gyroscope heading; this will be the 'goal' of our PID loop
	}

	// Called every time the scheduler runs while the command is scheduled.
    public void execute() {
      double error = startAngle - driveSubsystem.getAngle(); // Correction needed for robot angle (our starting angle, since we would like to drive straight)
      SmartDashboard.putNumber("erreur",error);
      double turn = error * 0.015;
      SmartDashboard.putNumber("turn",turn);
      driveSubsystem.setDriveMotors(0.2,-turn); // write percent values to motors
	}
	
	// returns true when the command ends
	public boolean isFinished() {
		return timer.get() >= duration;
	}

	// Called once the command ends or is interrupted.	
	public void end(boolean interrupted) {
		timer.reset();
	}
}
