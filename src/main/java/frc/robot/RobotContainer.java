package frc.robot;






import frc.robot.commands.NothingCmd;
import frc.robot.commands.All_DriveCmd.DriveBackward2sCmd;
import frc.robot.commands.TurnToAngleCmd;
import frc.robot.commands.All_AngleCmd.AngleDownManualCmd;
import frc.robot.commands.All_AngleCmd.AngleUpManualCmd;
import frc.robot.commands.All_AutonomousCmd.Auto3NotesCmd;
import frc.robot.commands.All_AutonomousCmd.AutoParallelCmd1;
import frc.robot.commands.All_AutonomousCmd.Auto1Cmd;
import frc.robot.commands.All_DriveCmd.DriveCmd;
import frc.robot.commands.All_DriveCmd.DriveForDistanceCmd;
import frc.robot.commands.All_DriveCmd.DriveForward2sCmd;
import frc.robot.commands.All_ElevatorCmd.ElevatorDownManualCmd;

import frc.robot.commands.All_ElevatorCmd.ElevatorUpManualCmd;
import frc.robot.commands.All_IntakeCmd.IntakeCmdTeleop;
import frc.robot.commands.All_IntakeCmd.ReverseIntakeCmd;
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
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
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
  public final DriveForDistanceCmd driveForDistanceCmd = new DriveForDistanceCmd(1, 0.2);
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

  public final ElevatorUpManualCmd elevatorUpManualCmd = new ElevatorUpManualCmd(elevatorSubsystem, 20);
  public final ElevatorDownManualCmd elevatorDownManualCmd  = new ElevatorDownManualCmd(elevatorSubsystem);
    
 
    private final Auto1Cmd auto1 = new Auto1Cmd();

    public static PhotonCamera camera = new PhotonCamera("Caméra 1");
   
    public static CommandJoystick joystick = new CommandJoystick(1);
    public static CommandXboxController manette = new CommandXboxController(0);
    
     
    public static Timer m_timer = new Timer();
    public static AnalogInput analog = new AnalogInput(0);
    public static DigitalInput analogAngle = new DigitalInput(2);

    

    /** The container for the robot. Contains subsystems, OI devices, and commands. */

    
    
  public Command getAutonomousCommand() {

    //return new Auto2Cmd();
    return new Auto3NotesCmd();
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
        Trigger rBumper = manette.rightBumper();
        Trigger lBumper = manette.leftBumper();
        Trigger aButton = manette.a();
        Trigger bButton = manette.b();
        Trigger xButton = manette.x();
        Trigger UpButton = manette.povUp();
        Trigger DownButton = manette.povDown();
        Trigger LeftButton = manette.povLeft();
        Trigger RightButton = manette.povRight();
        Trigger Button3 = joystick.button(3);
        Trigger Button4 = joystick.button(4);
        Trigger Button5 = joystick.button(5);
        Trigger Button6 = joystick.button(6);

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
        bButton.whileTrue(new IntakeCmdTeleop(intakeSubsystem));

        UpButton.onTrue(new AngleUpManualCmd(angleSubsystem));
        DownButton.onTrue(new AngleDownManualCmd(angleSubsystem));
        LeftButton.whileTrue(new ElevatorDownManualCmd(elevatorSubsystem));
        RightButton.whileTrue(new ElevatorUpManualCmd(elevatorSubsystem,20));

        Button3.whileTrue(new ReverseIntakeCmd(intakeSubsystem));
        Button4.whileTrue(shooterSubsytem.getIntakeCommand());
        Button5.whileTrue(new TurnToAngleCmd(driveSubsystem, 13));
        Button6.whileTrue(new TurnToAngleCmd(driveSubsystem, 90));
    }
}