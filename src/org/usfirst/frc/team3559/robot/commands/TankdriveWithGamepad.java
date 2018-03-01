package org.usfirst.frc.team3559.robot.commands;

import org.usfirst.frc.team3559.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class TankdriveWithGamepad extends Command {

    public TankdriveWithGamepad() {
        requires(Robot.drivebase);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.drivebase.drive(Robot.m_oi.getLeftSpeed(), Robot.m_oi.getRightSpeed());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.drivebase.stop();
    }

    protected void interrupted() {
    	end();
    }
}