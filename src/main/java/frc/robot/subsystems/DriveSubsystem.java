// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.motorcontrol.MotorController;

//import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
//import frc.robot.commands.DriveCmd;
 
public class DriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
     public static DifferentialDrive m_drive;
  

    
    
 
    WPI_TalonSRX m_MotorRight = new WPI_TalonSRX(Constants.DrivetrainConstants.m_MotorRightID);
    WPI_TalonSRX m_MotorRightFollow = new WPI_TalonSRX(Constants.DrivetrainConstants.m_MotorRightFollowID);
    WPI_TalonSRX m_MotorLeft = new WPI_TalonSRX(Constants.DrivetrainConstants.m_MotorLeftID);
    WPI_TalonSRX m_MotorLeftFollow = new WPI_TalonSRX(Constants.DrivetrainConstants.m_MotorLeftFollowID);





    
    

  
 

    public DriveSubsystem() {
    
    
   
    m_MotorRightFollow.follow(m_MotorRight);  
    m_MotorLeftFollow.follow(m_MotorRight);  

    m_drive = new DifferentialDrive(m_MotorLeft,m_MotorRight);
    
    m_MotorRight.setInverted(true);
    m_MotorRightFollow.setInverted(true);
    m_MotorLeft.setInverted(false);
    m_MotorLeftFollow.setInverted(false);

    m_MotorRightFollow.follow(m_MotorRight);
    m_MotorLeftFollow.follow(m_MotorLeft);

    m_MotorRight.configVoltageCompSaturation(11.0);
    m_MotorRightFollow.configVoltageCompSaturation(11.0);
    m_MotorLeft.configVoltageCompSaturation(11.0);
    m_MotorLeftFollow.configVoltageCompSaturation(11.0);
    
    m_MotorRight.setSafetyEnabled(true);
    m_MotorRightFollow.setSafetyEnabled(true);
    m_MotorLeft.setSafetyEnabled(true);
    m_MotorLeftFollow.setSafetyEnabled(true);
   
    /*m_MotorRight.setExpiration(.00001);
    m_MotorRightFollow.setExpiration(.00001);
    m_MotorLeftFollow.setExpiration(.00001);
    m_MotorLeft.setExpiration(.00001);*/
    
    
    

    }
    public void arcadeDrive(double fwd, double rot) {
      m_drive.arcadeDrive(fwd, rot);
    }

    /*public CommandBase ExAuto(double speed){

      return runOnce(
      
      run(()-> m_drive.arcadeDrive(speed, 0))

      )
    }*/
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }

  public void setDriveMotors(double forward, double turn){
    
    
    
    m_MotorRight.setInverted(true);
    m_MotorRightFollow.setInverted(true);
    m_MotorLeft.setInverted(false);
    m_MotorLeftFollow.setInverted(false);
    m_MotorRight.configVoltageCompSaturation(11.0);
    m_MotorRightFollow.configVoltageCompSaturation(11.0);
    m_MotorLeft.configVoltageCompSaturation(11.0);
    m_MotorLeftFollow.configVoltageCompSaturation(11.0);
    
    

    m_MotorRightFollow.follow(m_MotorRight);  
    m_MotorLeftFollow.follow(m_MotorLeft); 
     
    double left = forward - turn;
    double right = forward + turn;

    m_MotorRight.set(TalonSRXControlMode.PercentOutput, left);
    m_MotorLeft.set(TalonSRXControlMode.PercentOutput, right);
  }

  public void initDefaultCommand(){
    
  }

 



  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
