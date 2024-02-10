// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;      






import frc.robot.commands.All_DriveCmd.DriveBackward2sCmd;
import frc.robot.commands.All_DriveCmd.DriveCmd;
import frc.robot.commands.All_DriveCmd.DriveForward2sCmd;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.VisionSubsystem;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
//import edu.wpi.first.wpilibj.PS4Controller.Button;
//import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
//import edu.wpi.first.wpilibj2.command.button.CommandJoystick;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  final static DriveSubsystem driveSubsystem = new DriveSubsystem();
  final static VisionSubsystem visionSubsystem = new VisionSubsystem();


  private final DriveCmd driveCmd = new DriveCmd(driveSubsystem);
  
  private final DriveBackward2sCmd backward = new DriveBackward2sCmd(driveSubsystem);
  private final DriveForward2sCmd forward = new DriveForward2sCmd(driveSubsystem);

  public SendableChooser<Command> m_Chooser = new SendableChooser<Command>();

  




  


  


  public static XboxController manette = new XboxController(0);
  //public static final Joystick m_joystick = new Joystick(0);

  public static Timer m_timer = new Timer();

   // A simple auto routine that drives forward a specified distance, and then stops.




   public Command getAutonomousCommand() {

    return m_Chooser.getSelected();
   }
    
  
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    configureButtonBindings();

    driveSubsystem.setDefaultCommand(driveCmd);
    

    // Add commands to the autonomous command chooser
    m_Chooser.setDefaultOption("backward", backward);
    m_Chooser.addOption("forward", forward);
  
    // Put the chooser on the dashboard
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
      //mouvement inversée
      new Trigger(() -> manette.getYButtonPressed()).onTrue(new InstantCommand(() -> driveSubsystem.reverse()));
      //changement de vitesse
          new Trigger(() -> manette.getRightBumperPressed()).onTrue(new InstantCommand(() -> driveSubsystem.speedUp()));
          new Trigger(() -> manette.getLeftBumperPressed()).onTrue(new InstantCommand(() -> driveSubsystem.speedDown()));
      }

      //Trigger yButton = new JoystickButton(manette, XboxController.Button.kY.value);
     //yButton.whileTrue(reverseCmd);

    /*JoystickButton button6 = new JoystickButton(m_joystick, 6);
    JoystickButton button5 = new JoystickButton(m_joystick, 5);
    JoystickButton button1 = new JoystickButton(m_joystick, 1);
    JoystickButton button3 = new JoystickButton(m_joystick, 3);
    JoystickButton button4 = new JoystickButton(m_joystick, 4);
    */  
  }
    
  
 /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
