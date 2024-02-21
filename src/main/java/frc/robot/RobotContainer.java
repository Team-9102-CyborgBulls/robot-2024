package frc.robot;






import frc.robot.commands.NothingCmd;
import frc.robot.commands.All_DriveCmd.DriveBackward2sCmd;
import frc.robot.commands.TurnToAngleCmd;
import frc.robot.commands.All_AngleCmd.AngleDownManualCmd;
import frc.robot.commands.All_AngleCmd.AngleUpManualCmd;
<<<<<<< HEAD
import frc.robot.commands.All_AutonomousCmd.Auto2Cmd;
=======
import frc.robot.commands.All_AutonomousCmd.Auto1Cmd;
>>>>>>> 94036b86cd03d3b5626c29a19e60095fe18782b4
import frc.robot.commands.All_DriveCmd.DriveCmd;
import frc.robot.commands.All_DriveCmd.DriveForward2sCmd;
import frc.robot.commands.All_ElevatorCmd.ElevatorDownManualCmd;
import frc.robot.commands.All_ElevatorCmd.ElevatorUpManualCmd;
<<<<<<< HEAD
import frc.robot.commands.All_IntakeCmd.IntakeCmdTeleop;
=======
import frc.robot.commands.All_IntakeCmd.IntakeTeleopCmd;
>>>>>>> 94036b86cd03d3b5626c29a19e60095fe18782b4
import frc.robot.commands.All_ShooterCmd.LaunchNoteTeleop;
import frc.robot.commands.All_ShooterCmd.PrepareLaunchTeleop;
import frc.robot.subsystems.AngleSubsystem;
import frc.robot.subsystems.DriveSubsystem;

import java.io.NotActiveException;

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
<<<<<<< HEAD
  // The robot's subsystems and commands are defined here...
  public final static DriveSubsystem driveSubsystem = new DriveSubsystem();
  final static VisionSubsystem visionSubsystem = new VisionSubsystem();
  public final static ShooterSubsystem shooterSubsytem = new ShooterSubsystem();
  public static final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public static final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  public static final AngleSubsystem angleSubsystem = new AngleSubsystem();
  
  public final DriveCmd driveCmd = new DriveCmd(driveSubsystem);
  public final DriveBackward2sCmd backward = new DriveBackward2sCmd(driveSubsystem);
  public final DriveForward2sCmd forward = new DriveForward2sCmd(driveSubsystem);
  public final frc.robot.commands.All_DriveCmd.WaitCmd Wait = new frc.robot.commands.All_DriveCmd.WaitCmd(driveSubsystem);
  public final NothingCmd nothing = new NothingCmd(driveSubsystem);

  //    public SendableChooser<Command> m_Chooser = new SendableChooser<Command>();
  public final TurnToAngleCmd turnToAngle13Cmd = new TurnToAngleCmd(driveSubsystem, 13);
  public final TurnToAngleCmd turnToAngle90Cmd = new TurnToAngleCmd(driveSubsystem, 90);

  public final PrepareLaunchTeleop prepareLaunch = new PrepareLaunchTeleop(shooterSubsytem);
  public final LaunchNoteTeleop launchNote = new LaunchNoteTeleop(shooterSubsytem);

  public final IntakeCmdTeleop intakeCmd = new IntakeCmdTeleop(intakeSubsystem);

  public final AngleUpManualCmd angleUpManualCmd = new AngleUpManualCmd(angleSubsystem);
  public final AngleDownManualCmd angleDownManualCmd = new AngleDownManualCmd(angleSubsystem);

  public final ElevatorUpManualCmd elevatorUpManualCmd = new ElevatorUpManualCmd(elevatorSubsystem);
  public final ElevatorDownManualCmd elevatorDownManualCmd  = new ElevatorDownManualCmd(elevatorSubsystem);
=======
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
>>>>>>> 94036b86cd03d3b5626c29a19e60095fe18782b4

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

    
<<<<<<< HEAD
    
  public Command getAutonomousCommand() {

    return new Auto2Cmd();
   
   
   
   
   /*  return new SequentialCommandGroup(

  


  public static XboxController manette = new XboxController(0);
  //public static final Joystick m_joystick = new Joystick(0);

  public static Timer m_timer = new Timer();

   // A simple auto routine that drives forward a specified distance, and then stops.




   public Command getAutonomousCommand() {

    //return m_Chooser.getSelected();

    //mettre Wait avant backward et faire test
    return new SequentialCommandGroup(backward,Wait,forward);
    
      new RunCommand(()-> driveSubsystem.setDriveMotors(0,0))
      .withTimeout(3)
      .andThen(new TurnToAngleCmd(driveSubsystem))
      .withTimeout(1)
      .andThen(new DriveBackward2sCmd(driveSubsystem))
      
      .andThen(new RunCommand(() ->driveSubsystem.setDriveMotors(0,0)))
    );*/
   }
    
  
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    configureButtonBindings();

    driveSubsystem.setDefaultCommand(driveCmd);
    

    // Add commands to the autonomous command chooser
    //    m_Chooser.setDefaultOption("backward", backward);
    //    m_Chooser.addOption("forward", forward);
  
    // Put the chooser on the dashboard
    //    SmartDashboard.putData(m_Chooser);

    
    

    
  }
    // Configure the trigger bindings
     /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
   

    private void configureButtonBindings() {
      //mouvement inversée
        Trigger yButton =  manette.y();
=======
    /**
     * Utilisez cette méthode pour définir les associations de déclencheur -> commande. Les déclencheurs peuvent être créés via
     * le constructeur {@link Trigger#Trigger(java.util.function.BooleanSupplier)} avec un prédicat arbitraire,
     * ou via les fabriques nommées dans les sous-classes {@link CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
     * PS4} ou {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
     * joysticks}.
     */
    private void configureButtonBindings() {   // Configure les associations de boutons
        
        Trigger yButton = manette.y();
>>>>>>> 94036b86cd03d3b5626c29a19e60095fe18782b4
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
<<<<<<< HEAD

        aButton.whileTrue( 
          new PrepareLaunchTeleop(shooterSubsytem)
          .withTimeout(1)
          .andThen(new LaunchNoteTeleop(shooterSubsytem))
          .withTimeout(3)
          .handleInterrupt(() -> shooterSubsytem.stop()));

        bButton.whileTrue(new IntakeCmdTeleop(intakeSubsystem));

=======
        aButton.whileTrue(
            new PrepareLaunchTeleop(shooterSubsytem)
            .withTimeout(1)
            .andThen(new LaunchNoteTeleop(shooterSubsytem))
            .withTimeout(3)
            .handleInterrupt(() -> shooterSubsytem.stop())
        );
        bButton.whileTrue(new IntakeTeleopCmd(intakeSubsystem));
>>>>>>> 94036b86cd03d3b5626c29a19e60095fe18782b4
        UpButton.whileTrue(new AngleUpManualCmd(angleSubsystem));
        DownButton.whileTrue(new AngleDownManualCmd(angleSubsystem));
        LeftButton.whileTrue(new ElevatorDownManualCmd(elevatorSubsystem));
        RightButton.whileTrue(new ElevatorUpManualCmd(elevatorSubsystem));
    }
}