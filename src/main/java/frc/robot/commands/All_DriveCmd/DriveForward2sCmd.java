package frc.robot.commands.All_DriveCmd;

import edu.wpi.first.wpilibj2.command.Command;

//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
//import java.util.function.DoubleSupplier;

public class DriveForward2sCmd extends Command{
    
    DriveSubsystem driveSubsystem;
  
    public DriveForward2sCmd(DriveSubsystem drivesubsystem){

        this.driveSubsystem = drivesubsystem;
       
        addRequirements(driveSubsystem);

    }
    
    @Override
  public void initialize() {

    RobotContainer.m_timer.reset();   
    RobotContainer.m_timer.start(); 

    System.out.println("a");
    driveSubsystem.setDriveMotors(0.5,0.0);
  }

 
  @Override
  public void execute() {
  
    System.out.println("b");
    System.out.println(RobotContainer.m_timer.get());

    
   double speed = 0.5;
    driveSubsystem.setDriveMotors(speed,0.0);
  }

  @Override
  public void end(boolean interrupted) {
    driveSubsystem.setDriveMotors(0, 0);
    System.out.println("arrêt");
  }

 
  @Override
  public boolean isFinished() {
    
    System.out.println("c");

      return  RobotContainer.m_timer.get() >= 2;
      
     
   
  }
}


