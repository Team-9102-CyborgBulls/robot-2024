// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;      

import frc.robot.commands.All_DriveCmd.DriveBackward2sCmd;
import frc.robot.commands.TurnToAngleCmd;
import frc.robot.commands.All_AngleCmd.AngleDownManualCmd;
import frc.robot.commands.All_AngleCmd.AngleUpManualCmd;
import frc.robot.commands.All_DriveCmd.DriveCmd;
import frc.robot.commands.All_DriveCmd.DriveForward2sCmd;
import frc.robot.commands.All_ElevatorCmd.ElevatorDownManualCmd;
import frc.robot.commands.All_ElevatorCmd.ElevatorUpManualCmd;
import frc.robot.commands.All_IntakeCmd.IntakeCmd;
import frc.robot.commands.All_ShooterCmd.LaunchNote;
import frc.robot.commands.All_ShooterCmd.PrepareLaunch;
import frc.robot.subsystems.AngleSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.VisionSubsystem;
import org.photonvision.PhotonCamera;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;



public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final static DriveSubsystem driveSubsystem = new DriveSubsystem();
  final static VisionSubsystem visionSubsystem = new VisionSubsystem();
  final static ShooterSubsystem shooterSubsytem = new ShooterSubsystem();
  private static final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private static final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  private static final AngleSubsystem angleSubsystem = new AngleSubsystem();
  
  private final DriveCmd driveCmd = new DriveCmd(driveSubsystem);
  private final DriveBackward2sCmd backward = new DriveBackward2sCmd(driveSubsystem);
  private final DriveForward2sCmd forward = new DriveForward2sCmd(driveSubsystem);

  private final TurnToAngleCmd turnToAngle13Cmd = new TurnToAngleCmd(driveSubsystem, 13);
  private final TurnToAngleCmd turnToAngle90Cmd = new TurnToAngleCmd(driveSubsystem, 90);

  private final PrepareLaunch prepareLaunch = new PrepareLaunch(shooterSubsytem);
  private final LaunchNote launchNote = new LaunchNote(shooterSubsytem);

  private final IntakeCmd intakeCmd = new IntakeCmd(intakeSubsystem);

  private final AngleUpManualCmd angleUpManualCmd = new AngleUpManualCmd(angleSubsystem);
  private final AngleDownManualCmd angleDownManualCmd = new AngleDownManualCmd(angleSubsystem);

  private final ElevatorUpManualCmd elevatorUpManualCmd = new ElevatorUpManualCmd(elevatorSubsystem);
  private final ElevatorDownManualCmd elevatorDownManualCmd  = new ElevatorDownManualCmd(elevatorSubsystem);

    public static PhotonCamera camera = new PhotonCamera("Caméra 1");
    public static CommandXboxController manette = new CommandXboxController(0);
    public static Timer m_timer = new Timer();
    
    
  public Command getAutonomousCommand() {

    return new SequentialCommandGroup(turnToAngle90Cmd);
   
   
   
   
   /*  return new SequentialCommandGroup(

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

        yButton.onTrue(new InstantCommand(() -> driveSubsystem.reverse()));
        rBumper.onTrue(new InstantCommand(() -> driveSubsystem.speedUp()));
        lBumper.onTrue(new InstantCommand(() -> driveSubsystem.speedDown()));

        aButton.whileTrue( 
          new PrepareLaunch(shooterSubsytem)
          .withTimeout(1)
          .andThen(new LaunchNote(shooterSubsytem))
          .withTimeout(3)
          .handleInterrupt(() -> shooterSubsytem.stop()));

        bButton.whileTrue(new IntakeCmd(intakeSubsystem));

        UpButton.whileTrue(new AngleUpManualCmd(angleSubsystem));
        DownButton.whileTrue(new AngleDownManualCmd(angleSubsystem));

        LeftButton.whileTrue(new ElevatorDownManualCmd(elevatorSubsystem));
        RightButton.whileTrue(new ElevatorUpManualCmd(elevatorSubsystem));




        
        


     
  
    
  
 /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  }
}