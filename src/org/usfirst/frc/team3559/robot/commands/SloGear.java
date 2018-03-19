package org.usfirst.frc.team3559.robot.commands;

import org.usfirst.frc.team3559.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SloGear extends Command {

    public SloGear() {
        // Use requires() here to declare subsystem dependencies
      requires(Robot.drivebase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivebase.modifySpeed(0.6);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivebase.drive(Robot.m_oi.getLeftStick(), Robot.m_oi.getRightStick());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivebase.modifySpeed(0.75);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
