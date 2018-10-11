package org.usfirst.frc.team3559.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3559.robot.Robot;

/**
 *
 */
public class GoingUp extends Command {

    public GoingUp() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.feeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//setTimeout(1.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.feeder.Lift(0.99);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.feeder.liftLimit.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.feeder.StopFlipMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
