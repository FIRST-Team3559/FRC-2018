package org.usfirst.frc.team3559.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Feeder extends Subsystem {
	private Spark FlipMotor = new Spark(7);
	private Spark feedMotorLeft = new Spark(5);
	private Spark feedMotorRight = new Spark(6);
	private double feedMotorSpeed = 0.8;
	public boolean Lift = false;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void Lift() {
    	FlipMotor.set(0.6);
    	Timer.delay(1.0);
    	FlipMotor.set(0.0);
    	Lift = true;
    }
    
    public void Lower() {
    	FlipMotor.set(-0.6);
    	Timer.delay(1.0);
    	FlipMotor.set(0.0);
    	Lift = false;
    }
    
    public void FeedIn() {
    	feedMotorLeft.set(feedMotorSpeed);
    	feedMotorRight.set(-feedMotorSpeed);
    	Timer.delay(0.2);
    	feedMotorLeft.set(0.0);
    	feedMotorRight.set(0.0);
    }
    
    public void FeedOut() {
    	feedMotorLeft.set(-feedMotorSpeed);
    	feedMotorRight.set(feedMotorSpeed);
    	Timer.delay(0.2);
    	feedMotorLeft.set(0.0);
    	feedMotorRight.set(0.0);
    }
    
    public void Judge() {
    	if(Lift == true) {
    		Lower();
    	}else {
    		Lift();	
			}
	}

}
