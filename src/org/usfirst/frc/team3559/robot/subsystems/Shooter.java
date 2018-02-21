package org.usfirst.frc.team3559.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class Shooter extends Subsystem {
	public static Subsystem Shooter;
	private Spark A_Left = new Spark(1);
	private Spark A_Right = new Spark(2);
	private Spark B_Left = new Spark(3);
	private Spark B_Right = new Spark(4);
	private Spark Transition = new Spark(5);
	private SpeedControllerGroup Shooter_A = new SpeedControllerGroup(A_Left, A_Right);
	private SpeedControllerGroup Shooter_B = new SpeedControllerGroup(B_Left, B_Right);
	//^speed controller groups above probably aren't needed ^
	private boolean ShootHi  = false;
	private boolean ShootMid = false;
	private boolean ShootLow = false;
	private double MotorDelayS = 0.25;
	private double MotorDelayL = 1.0;
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void Shoot() {
    	if(ShootHi = true) {
    		//set all the motors to shoot High
    		A_Left.set(0.9);
    		A_Right.set(0.9);
    		B_Left.set(0.9);
    		B_Right.set(0.9);
    		Timer.delay(MotorDelayS);
    		Transition.set(0.9);
    		Timer.delay(MotorDelayS);
    		Transition.set(0.0);
    		Timer.delay(MotorDelayL);
    		A_Left.set(0.0);
    		A_Right.set(0.0);
    		B_Left.set(0.0);
    		B_Right.set(0.0);
    		boolean ShootHi = false;
        	boolean ShootMid = false;
        	boolean ShootLow = false;
    	}else {
    	if(ShootMid = true) {		
    		//set all the motors to shoot Mid
    		A_Left.set(0.9);
    		A_Right.set(0.9);
    		B_Left.set(0.9);
    		B_Right.set(0.9);
    		Timer.delay(MotorDelayS);
    		Transition.set(0.9);
    		Timer.delay(MotorDelayS);
    		Transition.set(0.0);
    		Timer.delay(MotorDelayL);
    		A_Left.set(0.0);
    		A_Right.set(0.0);
    		B_Left.set(0.0);
    		B_Right.set(0.0);
    		boolean ShootHi = false;
        	boolean ShootMid = false;
        	boolean ShootLow = false;
    	}else {
    	if(ShootLow = true) {
    	//set all the motors to shoot Low
    		A_Left.set(0.9);
    		A_Right.set(0.9);
    		B_Left.set(0.9);
    		B_Right.set(0.9);
    		Timer.delay(MotorDelayS);
    		Transition.set(0.9);
    		Timer.delay(MotorDelayS);
    		Transition.set(0.0);
    		Timer.delay(MotorDelayL);
    		A_Left.set(0.0);
    		A_Right.set(0.0);
    		B_Left.set(0.0);
    		B_Right.set(0.0);
    		boolean ShootHi = false;
        	boolean ShootMid = false;
        	boolean ShootLow = false;
    	}else {
    	boolean ShootHi = false;
    	boolean ShootMid = false;
    	boolean ShootLow = false;
    	}
    		
    	
    	
    	
    
    	}
   } 	
    	}
}