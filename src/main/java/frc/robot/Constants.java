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
    // Identifiant du moteur droit
    public static final int m_MotorRightID = 2;
    // Identifiant du moteur droit suiveur
    public static final int m_MotorRightFollowID = 4;
    // Identifiant du moteur gauche
    public static final int m_MotorLeftID = 3;
    // Identifiant du moteur gauche suiveur
    public static final int m_MotorLeftFollowID = 1;

    public static final double kEncoderdistancePerRotation = 2*Math.PI*0.0762;
   
}

public static final class ShooterConstants {
    // Identifiant de la roue de lancement
    public static final int m_launchWheelID = 7;
    // Identifiant de la roue d'alimentation
    public static final int m_feedWheelID = 9;
    // Limite de courant du launcher
    public static final int kLauncherCurrentLimit = 80;
    // Limite de courant du launcher
    public static final int kFeedCurrentLimit = 80;
    // Vitesse de la 1ère roue du shooter
    public static final double kLauncherSpeed = 0.2;
    // Vitesse de la 2nd roue du shooter
    public static final double kLaunchFeederSpeed = 0.2;
}

public static final class IntakeConstants {
    // Identifiant du moteur d'intake
    public static final int m_intakeMotorID = 8;
}

public static final class AngleElevatorConstants {
    // Identifiant du moteur d'angle
    public static final int m_angleMotorID = 5;
}

public static class ElevatorConstants {
    // Identifiant du moteur du chariot
    public static final int kElevatorMotorID = 6;
}
}

