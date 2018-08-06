package org.usfirst.frc.team3559.robot.subsystems;

import org.usfirst.frc.team3559.robot.Robot;
import org.usfirst.frc.team3559.robot.commands.GetCube;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Feeder extends Subsystem {
	private Spark FlipMotor = new Spark(7);
	private Spark feedMotorLeft = new Spark(5);
	private Spark feedMotorRight = new Spark(6);
	public DigitalInput liftLimit = new DigitalInput(9);
	public boolean Lift = false;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new GetCube());
    }

    public void Lift(double speedValue) {   	
   		FlipMotor.set(-speedValue);
    }
    	
    
    
    public void Lower(double speedValue) {
        FlipMotor.set(speedValue);
    }
    
    
    public void FeedIn(double speedValue) {
    	feedMotorLeft.set(-speedValue);
    	feedMotorRight.set(speedValue);
    	
    }
    
    public void FeedOut(double speedValue) {
    	feedMotorLeft.set(speedValue);
    	feedMotorRight.set(-speedValue);
   }
    
    public void StopFeedMotors() {
    	feedMotorLeft.set(0.0);
    	feedMotorRight.set(0.0);
    }
    
    public void StopFlipMotor() {
    	FlipMotor.set(0.0);
    }
    
    public void AutoShoot (double speedValue) {
    	feedMotorLeft.set(speedValue);
    	feedMotorRight.set(speedValue);
    }
   
    
    /*public void AutoLift(double speedValue) {
    	setTimeout(0.5);
    	if(TopLimitSwitch.get()) {
    		StopFlipMotor();
    	}else 
    		FlipMotor.set(-speedValue);
    		Lift = true;
    	}*/
}