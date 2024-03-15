package frc.robot;






import frc.robot.commands.NothingCmd;
import frc.robot.commands.All_DriveCmd.DriveBackward2sCmd;
import frc.robot.commands.TurnToAngleCmd;
import frc.robot.commands.All_AngleCmd.AngleDownBasCmd;
import frc.robot.commands.All_AngleCmd.AngleDownChariotCmd;
import frc.robot.commands.All_AngleCmd.AngleDownShootCmd;
import frc.robot.commands.All_AngleCmd.AngleDownTeleopCmd;
import frc.robot.commands.All_AngleCmd.AngleUpChariotCmd;
import frc.robot.commands.All_AngleCmd.AngleUpIntakeCmd;
import frc.robot.commands.All_AngleCmd.AngleUpShootCmd;
import frc.robot.commands.All_AngleCmd.AngleUpTeleopCmd;
import frc.robot.commands.All_AutonomousCmd.AutoParallelIntakeLaunch;
import frc.robot.commands.All_AutonomousCmd.Auto2NotesCmd;
import frc.robot.commands.All_AutonomousCmd.Auto2NotesDCmd;
import frc.robot.commands.All_AutonomousCmd.Auto2NotesGCmd;
import frc.robot.commands.All_AutonomousCmd.AutoParalleAngleDownElevatorUp;
import frc.robot.commands.All_DriveCmd.DriveCmd;
import frc.robot.commands.All_DriveCmd.DriveForDistanceCmd;
import frc.robot.commands.All_DriveCmd.DriveForward2sCmd;
import frc.robot.commands.All_ElevatorCmd.ElevatorDownAutoCmd;
import frc.robot.commands.All_ElevatorCmd.ElevatorDownLimitlessCmd;
import frc.robot.commands.All_ElevatorCmd.ElevatorDownManualCmd;
import frc.robot.commands.All_ElevatorCmd.ElevatorUpLimitlessCmd;
import frc.robot.commands.All_ElevatorCmd.ElevatorUpManualCmd;
import frc.robot.commands.All_IntakeCmd.IntakeCmdRamassage;
import frc.robot.commands.All_IntakeCmd.IntakeCmdTeleop;
import frc.robot.commands.All_IntakeCmd.ReverseIntakeCmd;
import frc.robot.commands.All_ShooterCmd.LaunchNoteTeleop;
import frc.robot.commands.All_ShooterCmd.PrepareLaunchAuto;
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
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
  public final DriveForDistanceCmd driveForDistance5 = new DriveForDistanceCmd(5);
  public final frc.robot.commands.All_DriveCmd.WaitCmd Wait = new frc.robot.commands.All_DriveCmd.WaitCmd(driveSubsystem);
  public final NothingCmd nothing = new NothingCmd(driveSubsystem);

  public SendableChooser<Command> m_Chooser = new SendableChooser<Command>();
  public final TurnToAngleCmd turnToAngle13Cmd = new TurnToAngleCmd(driveSubsystem, 13);
  public final TurnToAngleCmd turnToAngle90Cmd = new TurnToAngleCmd(driveSubsystem, 90);

  public final PrepareLaunchTeleop prepareLaunch = new PrepareLaunchTeleop(shooterSubsytem);
  public final LaunchNoteTeleop launchNote = new LaunchNoteTeleop(shooterSubsytem);

  public final IntakeCmdTeleop intakeCmd = new IntakeCmdTeleop(intakeSubsystem);

  public final AngleUpIntakeCmd angleUpManualCmd = new AngleUpIntakeCmd(angleSubsystem);
  public final AngleDownBasCmd angleDownManualCmd = new AngleDownBasCmd(angleSubsystem);

  public final ElevatorUpManualCmd elevatorUpManualCmd = new ElevatorUpManualCmd(elevatorSubsystem);
  public final ElevatorDownManualCmd elevatorDownManualCmd  = new ElevatorDownManualCmd(elevatorSubsystem);
    
 
  private final Auto2NotesCmd autoMiddle = new Auto2NotesCmd();
  private final Auto2NotesDCmd autoRight = new Auto2NotesDCmd();
  private final Auto2NotesGCmd autoLeft = new Auto2NotesGCmd();

    public static PhotonCamera camera = new PhotonCamera("Caméra 1");
   
    public static CommandJoystick joystick = new CommandJoystick(1);
    public static CommandXboxController manette = new CommandXboxController(0);
    public static Timer m_timer = new Timer();
    public static AnalogInput Potentio = new AnalogInput(0);
    public static AnalogInput ultrason = new AnalogInput(1);
    public static DigitalInput analogAngle = new DigitalInput(2);
   
    public static  boolean angleShoot = false;
    public static boolean angleIntake = false;
    public static boolean angleBumper = false;
    public static boolean angleLimit = false;

    

    /** The container for the robot. Contains subsystems, OI devices, and commands. */

    
    
  public Command getAutonomousCommand() {
      
    return m_Chooser.getSelected();
   }
    
  
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    configureButtonBindings();

    driveSubsystem.setDefaultCommand(driveCmd);
    

    // Add commands to the autonomous command chooser
    m_Chooser.setDefaultOption("Auto Middle", autoMiddle);
    m_Chooser.addOption("Auto Left", autoLeft);
    m_Chooser.addOption("Auto Right", autoRight);
    m_Chooser.addOption("Backward",driveForDistance5);
    m_Chooser.addOption("wait",nothing);
  
    //Put the chooser on the dashboard
    SmartDashboard.putData(m_Chooser);

    
    

    
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
        Trigger Button7m = manette.button(7);
        Trigger Button8m = manette.button(8);
        Trigger Button7 = joystick.button(7);
        Trigger Button8 = joystick.button(8);
        Trigger Button9 = joystick.button(9);
        Trigger Button10 = joystick.button(10);
        Trigger Button11 = joystick.button(11);
        Trigger Button12 = joystick.button(12);
        
        
        

        yButton.onTrue(new InstantCommand(() -> driveSubsystem.reverse())); // Mouvement inversé
        rBumper.onTrue(new InstantCommand(() -> driveSubsystem.speedUp())); // Vitesse augmenté
        lBumper.onTrue(new InstantCommand(() -> driveSubsystem.speedDown())); // vitesse baissé

        aButton.onTrue( 
          new PrepareLaunchTeleop(shooterSubsytem)
          .withTimeout(0.2)
          .andThen(new AutoParallelIntakeLaunch())
          .handleInterrupt(() -> shooterSubsytem.stop()));
 
        bButton.whileTrue(new IntakeCmdTeleop(intakeSubsystem));

        UpButton.onTrue(new ElevatorUpManualCmd(elevatorSubsystem));

        DownButton.onTrue(new ElevatorDownManualCmd(elevatorSubsystem));

        LeftButton.onTrue(new AngleDownTeleopCmd(angleSubsystem));
        RightButton.onTrue(new AngleUpTeleopCmd(angleSubsystem));
       
        Button5.onTrue(new AngleDownTeleopCmd(angleSubsystem));
        Button6.onTrue(new AngleUpTeleopCmd(angleSubsystem)); //whileTrue(new TurnToAngleCmd(driveSubsystem, 90));

        Button7.whileTrue(new ReverseIntakeCmd(intakeSubsystem));
        Button8.whileTrue(shooterSubsytem.reverseShootCommand());
        
        Button10.whileTrue(new AngleUpIntakeCmd(angleSubsystem));
        Button9.whileTrue(new AngleDownBasCmd(angleSubsystem));

        Button11.onTrue(new ElevatorDownLimitlessCmd(elevatorSubsystem));
        Button12.onTrue(new ElevatorUpLimitlessCmd(elevatorSubsystem));

        

        
    }
}