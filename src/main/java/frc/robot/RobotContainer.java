package frc.robot;

import frc.robot.commands.All_DriveCmd.DriveBackward2sCmd;
import frc.robot.commands.TurnToAngleCmd;
import frc.robot.commands.All_AngleCmd.AngleDownManualCmd;
import frc.robot.commands.All_AngleCmd.AngleUpManualCmd;
import frc.robot.commands.All_AutonomousCmd.Auto1Cmd;
import frc.robot.commands.All_DriveCmd.DriveCmd;
import frc.robot.commands.All_DriveCmd.DriveForward2sCmd;
import frc.robot.commands.All_ElevatorCmd.ElevatorDownManualCmd;
import frc.robot.commands.All_ElevatorCmd.ElevatorUpManualCmd;
import frc.robot.commands.All_IntakeCmd.IntakeTeleopCmd;
import frc.robot.commands.All_ShooterCmd.LaunchNoteTeleop;
import frc.robot.commands.All_ShooterCmd.PrepareLaunchTeleop;
import frc.robot.subsystems.AngleSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.VisionSubsystem;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.VisionSubsystem;
import org.photonvision.PhotonCamera;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
    // Les sous-systèmes et les commandes du robot sont définis ici...
    public final static DriveSubsystem driveSubsystem = new DriveSubsystem();
    public final static VisionSubsystem visionSubsystem = new VisionSubsystem();
    public final static ShooterSubsystem shooterSubsytem = new ShooterSubsystem();
    public static final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    public static final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
    public static final AngleSubsystem angleSubsystem = new AngleSubsystem();

    private final DriveCmd driveCmd = new DriveCmd(driveSubsystem);
    private final DriveBackward2sCmd backward = new DriveBackward2sCmd(driveSubsystem);
    private final DriveForward2sCmd forward = new DriveForward2sCmd(driveSubsystem);
    private final TurnToAngleCmd turnToAngle13Cmd = new TurnToAngleCmd(driveSubsystem, 13);
    private final TurnToAngleCmd turnToAngle90Cmd = new TurnToAngleCmd(driveSubsystem, 90);
    private final PrepareLaunchTeleop prepareLaunch = new PrepareLaunchTeleop(shooterSubsytem);
    private final LaunchNoteTeleop launchNote = new LaunchNoteTeleop(shooterSubsytem);
    private final IntakeTeleopCmd intakeCmd = new IntakeTeleopCmd(intakeSubsystem);
    private final AngleUpManualCmd angleUpManualCmd = new AngleUpManualCmd(angleSubsystem);
    private final AngleDownManualCmd angleDownManualCmd = new AngleDownManualCmd(angleSubsystem);
    private final ElevatorUpManualCmd elevatorUpManualCmd = new ElevatorUpManualCmd(elevatorSubsystem);
    private final ElevatorDownManualCmd elevatorDownManualCmd  = new ElevatorDownManualCmd(elevatorSubsystem);
    private final Auto1Cmd auto1 = new Auto1Cmd();

    public static PhotonCamera camera = new PhotonCamera("Caméra 1");
   
    public static CommandXboxController manette = new CommandXboxController(0);
    public static Timer m_timer = new Timer();

    public Command getAutonomousCommand() {
        return new Auto1Cmd();
    }

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        configureButtonBindings();
        driveSubsystem.setDefaultCommand(driveCmd);
    }

    
    /**
     * Utilisez cette méthode pour définir les associations de déclencheur -> commande. Les déclencheurs peuvent être créés via
     * le constructeur {@link Trigger#Trigger(java.util.function.BooleanSupplier)} avec un prédicat arbitraire,
     * ou via les fabriques nommées dans les sous-classes {@link CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
     * PS4} ou {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
     * joysticks}.
     */
    private void configureButtonBindings() {   // Configure les associations de boutons
        
        Trigger yButton = manette.y();
        Trigger rBumper = manette.rightBumper();
        Trigger lBumper = manette.leftBumper();
        Trigger aButton = manette.a();
        Trigger bButton = manette.b();
        Trigger xButton = manette.x();
        Trigger UpButton = manette.povUp();
        Trigger DownButton = manette.povDown();
        Trigger LeftButton = manette.povLeft();
        Trigger RightButton = manette.povRight();

        yButton.onTrue(new InstantCommand(() -> driveSubsystem.reverse())); // Mouvement inversé
        rBumper.onTrue(new InstantCommand(() -> driveSubsystem.speedUp()));
        lBumper.onTrue(new InstantCommand(() -> driveSubsystem.speedDown()));
        aButton.whileTrue(
            new PrepareLaunchTeleop(shooterSubsytem)
            .withTimeout(1)
            .andThen(new LaunchNoteTeleop(shooterSubsytem))
            .withTimeout(3)
            .handleInterrupt(() -> shooterSubsytem.stop())
        );
        bButton.whileTrue(new IntakeTeleopCmd(intakeSubsystem));
        UpButton.whileTrue(new AngleUpManualCmd(angleSubsystem));
        DownButton.whileTrue(new AngleDownManualCmd(angleSubsystem));
        LeftButton.whileTrue(new ElevatorDownManualCmd(elevatorSubsystem));
        RightButton.whileTrue(new ElevatorUpManualCmd(elevatorSubsystem));
    }
}