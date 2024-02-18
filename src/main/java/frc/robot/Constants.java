// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  
  public static final class DrivetrainConstants {

    public static final int m_MotorRightID = 1;
    public static final int m_MotorRightFollowID = 2;
    public static final int m_MotorLeftID = 4;
    public static final int m_MotorLeftFollowID = 3;

    public static final int m_joystickPort = 0;
  }
  public static final class ShooterConstants {

    public static final int m_launchWheelID = 5;
    public static final int m_feedWheelID = 7;
    public static final int kLauncherCurrentLimit = 80;
    public static final int kFeedCurrentLimit = 80;
    public static final double kLauncherSpeed = 1.0;
    public static final double kLaunchFeederSpeed = 1.0;
  }
  public static final class IntakeConstants {

    public static final int m_intakeMotorID = 8;
  }
  public static final class AngleElevatorConstants {

    public static final int m_angleMotorID = 9;
  }
  public static class ElevatorConstants {
    public static final int kElevatorMotorID = 6;
  }
}
