package org.usfirst.frc.team3559.robot.subsystems;

import org.usfirst.frc.team3559.robot.commands.GetCube;
<<<<<<< HEAD
import edu.wpi.first.wpilibj.DigitalInput;
=======

>>>>>>> parent of eb2fe0f... working 30mar 12:09
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
	//private Spark shootMotorBottomLeft = new Spark();
	//private Spark shootMotorTopLeft = new Spark();
	//private Spark shootMotorBottomRight = new Spark();
	//private Spark shootMotorTopRight = new Spark();
	public boolean Lift = false;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new GetCube());
    }

<<<<<<< HEAD
    public void Lift(double speedValue) {   	
   		FlipMotor.set(-speedValue);
=======
    public void Lift() {
    	FlipMotor.set(0.6);
    	Timer.delay(1.0);
    	FlipMotor.set(0.0);
    	Lift = true;
>>>>>>> parent of eb2fe0f... working 30mar 12:09
    }
    
    public void Lower() {
    	FlipMotor.set(-0.6);
    	Timer.delay(1.0);
    	FlipMotor.set(0.0);
    	Lift = false;
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
    
    public void Judge() {
    	if(Lift == true) {
    		Lower();
    	}else {
    		Lift();	
			}
    }
    
    public void AutoShoot (double speedValue) {
    	feedMotorLeft.set(speedValue);
    }
	
}