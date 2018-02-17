package org.usfirst.frc.team3559.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3559.robot.Robot;

/**
 *
 */
public class HiGear extends Command {

    public HiGear() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivebase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivebase.modifySpeed(0.99);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}