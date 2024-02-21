package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class DriveForwardGyroCmd extends Command {
  DriveSubsystem driveSubsystem;

    public DriveForwardGyroCmd(DriveSubsystem drivesubsystem){

        this.driveSubsystem = drivesubsystem;
        
       
        addRequirements(driveSubsystem);

    }   
}
