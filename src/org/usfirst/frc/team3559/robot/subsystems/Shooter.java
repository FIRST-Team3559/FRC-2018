package org.usfirst.frc.team3559.robot.subsystems;

import org.usfirst.frc.team3559.robot.commands.Shoot;

import edu.wpi.first.wpilibj.Spark;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	private Spark LeftShooterB = new Spark(1);
	private Spark RightShooterB = new Spark(2); //Reminder this is 2
	private Spark LeftShooterA = new Spark(3);
	private Spark RightShooterA = new Spark(4);
	private double speedLimiter = 0.60;				//must be a value between 0 and 1
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Shoot());
    }
    
    public void SpinUp(double speedValue) {
    	LeftShooterA.set(-speedLimiter*speedValue);
    	RightShooterA.set(speedLimiter*speedValue);
    	LeftShooterB.set(-0.9*speedLimiter*speedValue);
    	RightShooterB.set(0.9*speedLimiter*speedValue);
    	
    	
    }
    
    public void StopAllMotors() {
    	LeftShooterA.set(0.0);
    	RightShooterA.set(0.0);
    	LeftShooterB.set(0.0);
    	RightShooterB.set(0.0);
    }
    
    public void autoShoot() {
    }
}

