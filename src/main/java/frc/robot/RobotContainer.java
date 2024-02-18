// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;      





import frc.robot.commands.All_DriveCmd.DriveBackward2sCmd;

import frc.robot.commands.TurnToAngle13Cmd;
import frc.robot.commands.TurnToAngle90Cmd;
import frc.robot.commands.All_DriveCmd.DriveCmd;
import frc.robot.commands.All_DriveCmd.DriveForward2sCmd;
import frc.robot.commands.All_ShooterCmd.LaunchNote;
import frc.robot.commands.All_ShooterCmd.PrepareLaunch;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.VisionSubsystem;

import org.photonvision.PhotonCamera;


import edu.wpi.first.wpilibj.ADXRS450_Gyro;
//import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
//import edu.wpi.first.wpilibj.PS4Controller.Button;
//import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import edu.wpi.first.wpilibj2.command.button.Trigger;
//import edu.wpi.first.wpilibj2.command.button.CommandJoystick;


public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final static DriveSubsystem driveSubsystem = new DriveSubsystem();
  final static VisionSubsystem visionSubsystem = new VisionSubsystem();
  final static ShooterSubsystem shooterSubsytem = new ShooterSubsystem();

  private final DriveCmd driveCmd = new DriveCmd(driveSubsystem);

  private final DriveBackward2sCmd backward = new DriveBackward2sCmd(driveSubsystem);
  private final DriveForward2sCmd forward = new DriveForward2sCmd(driveSubsystem);
  private final TurnToAngle13Cmd turnToAngle13Cmd = new TurnToAngle13Cmd(driveSubsystem);
  //public SendableChooser<Command> m_Chooser = new SendableChooser<Command>();
  private final TurnToAngle90Cmd turnToAngle90Cmd = new TurnToAngle90Cmd(driveSubsystem);

  private final PrepareLaunch prepareLaunch = new PrepareLaunch(shooterSubsytem);
  private final LaunchNote launchNote = new LaunchNote(shooterSubsytem);

  




  

  public static PhotonCamera camera = new PhotonCamera("Caméra 1");
  


  public static CommandXboxController manette = new CommandXboxController(0);
  //public static final Joystick m_joystick = new Joystick(0);

  public static Timer m_timer = new Timer();

   // A simple auto routine that drives forward a specified distance, and then stops.
   
   public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();



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
    

    // Add commands to the autonomous command chooser
   /*  m_Chooser.setDefaultOption("backward", backward);
    m_Chooser.addOption("forward", forward);
  
    // Put the chooser on the dashboard
    SmartDashboard.putData(m_Chooser);*/

    
    

    
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
        yButton.onTrue(new InstantCommand(() -> driveSubsystem.reverse()));

        rBumper.onTrue(new InstantCommand(() -> driveSubsystem.speedUp()));
        lBumper.onTrue(new InstantCommand(() -> driveSubsystem.speedDown()));

        aButton.onTrue( 
          new PrepareLaunch(shooterSubsytem)
          .withTimeout(1)
          .andThen(new LaunchNote(shooterSubsytem))
          .handleInterrupt(() -> shooterSubsytem.stop()));

     
  
    
  
 /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  }
}