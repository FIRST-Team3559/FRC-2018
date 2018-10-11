package org.usfirst.frc.team3559.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3559.robot.Robot;
//import org.usfirst.frc.team3559.robot.OI;

/**
 *
 */
public class AutoLeft extends Command {

    public AutoLeft() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivebase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(2.0);
    	//setTimeout(drivetime);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivebase.AutoL();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivebase.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
