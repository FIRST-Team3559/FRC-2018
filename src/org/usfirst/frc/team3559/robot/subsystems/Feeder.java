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
	public boolean Lifted = false;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void FeedIn() {
    	feedMotorLeft.set(0.5);
    	feedMotorRight.set(0.5);
    	Timer.delay(0.5);
    	feedMotorLeft.set(0.0);
    	feedMotorRight.set(0.0);
    }

    public void FeedOut() {
    	feedMotorLeft.set(-0.5);
    	feedMotorRight.set(-0.5);
    	Timer.delay(0.5);
    	feedMotorLeft.set(0.0);
    	feedMotorRight.set(0.0);
    }

    public void Lift() {
    	FlipMotor.set(0.6);
    	Timer.delay(1.0);
    	FlipMotor.set(0.0);
    	Lifted = true;
    }
    public void Lower() {
    	FlipMotor.set(-0.6);
    	Timer.delay(1.0);
    	FlipMotor.set(0.0);
    	Lifted = false;
    }
    /***************
     * Make a determiniation on position of intake and reverse the postion.
     * This should be modified to add limit switches and position detection.
     */
    public void Judge() {
    	if(Lifted == true) {
    		Lower();
    	}else {
    		Lift();	
			}
	}
    
    public void StopAll() {
    	FlipMotor.set(0.0);
    	feedMotorLeft.set(0.0);
    	feedMotorRight.set(0.0);
    	
    }

}
