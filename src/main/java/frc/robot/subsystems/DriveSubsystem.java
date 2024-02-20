package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

 
public class DriveSubsystem extends SubsystemBase {
  
     public static DifferentialDrive m_drive;
     public double direction = 1.0;
     public double speed_changer = 0.6;

    WPI_TalonSRX m_MotorRight = new WPI_TalonSRX(Constants.DrivetrainConstants.m_MotorRightID);
    WPI_TalonSRX m_MotorRightFollow = new WPI_TalonSRX(Constants.DrivetrainConstants.m_MotorRightFollowID);
    WPI_TalonSRX m_MotorLeft = new WPI_TalonSRX(Constants.DrivetrainConstants.m_MotorLeftID);
    WPI_TalonSRX m_MotorLeftFollow = new WPI_TalonSRX(Constants.DrivetrainConstants.m_MotorLeftFollowID);
    public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();

    public static RelativeEncoder encoderDrive;


  public DriveSubsystem() {
    
    m_MotorRightFollow.follow(m_MotorRight);  
    m_MotorLeftFollow.follow(m_MotorRight);  

    m_drive = new DifferentialDrive(m_MotorLeft,m_MotorRight);
    
    m_MotorRight.setInverted(false);
    m_MotorRightFollow.setInverted(false);
    m_MotorLeft.setInverted(true);
    m_MotorLeftFollow.setInverted(true);

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

    //encoderDrive = m_drive.getEncoder();
    }

    public void arcadeDrive(double fwd, double rot) {
      m_drive.arcadeDrive(fwd, rot);
      m_drive.setMaxOutput(speed_changer*direction);
    }

    public void setMaxOutput(double speed_changer) {
      m_drive.setMaxOutput(speed_changer);
    }

    public void reverse(){
      direction = -direction;
    }

    public void speedUp(){
      if(speed_changer <= 0.8){
      speed_changer = speed_changer + 0.3;
      }
    }
    public void speedDown(){
      if(speed_changer >= 0.1){
      speed_changer = speed_changer - 0.3;
      }
    }
    public double getAngle(){
      return gyro.getAngle();
    }
    public double getRate(){
      return gyro.getRate();
    }
    public void resetGyro(){
      gyro.reset();
    } 
    public void calibrateGyro(){
      gyro.calibrate();
    }

  @Override
  public void periodic() {} // This method will be called once per scheduler run

  public void setDriveMotors(double forward, double turn){
    
    m_MotorRight.setInverted(false);
    m_MotorRightFollow.setInverted(false);
    m_MotorLeft.setInverted(true);
    m_MotorLeftFollow.setInverted(true);
    m_MotorRight.configVoltageCompSaturation(11.0);
    m_MotorRightFollow.configVoltageCompSaturation(11.0);
    m_MotorLeft.configVoltageCompSaturation(11.0);
    m_MotorLeftFollow.configVoltageCompSaturation(11.0);
    
    m_MotorRightFollow.follow(m_MotorRight);  
    m_MotorLeftFollow.follow(m_MotorLeft); 
     
    double left = forward - turn;
    double right = forward + turn;

    m_MotorRight.set(TalonSRXControlMode.PercentOutput, right);
    m_MotorLeft.set(TalonSRXControlMode.PercentOutput, left);
  }

}
