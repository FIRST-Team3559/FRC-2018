package org.usfirst.frc.team3559.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

	private Spark A_Left = new Spark(1);
	private Spark A_Right = new Spark(2);
	private Spark B_Left = new Spark(3);
	private Spark B_Right = new Spark(4);
	private double MotorDelayS = 0.25;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void ShootHi() {
    		A_Left.set(0.9);
    		A_Right.set(0.9);
    		B_Left.set(0.9);
    		B_Right.set(0.9);
    		Timer.delay(MotorDelayS);
     		A_Left.set(0.0);
    		A_Right.set(0.0);
    		B_Left.set(0.0);
    		B_Right.set(0.0);
    		
    	}
    public void ShootMid() {
    	
    		A_Left.set(0.9);
    		A_Right.set(0.9);
    		B_Left.set(0.9);
    		B_Right.set(0.9);
    		Timer.delay(MotorDelayS);
    		A_Left.set(0.0);
    		A_Right.set(0.0);
    		B_Left.set(0.0);
    		B_Right.set(0.0);
    		
    	}
    
    public void ShootLow() {
    		A_Left.set(0.9);
    		A_Right.set(0.9);
    		B_Left.set(0.9);
    		B_Right.set(0.9);
    		Timer.delay(MotorDelayS);
    		A_Left.set(0.0);
    		A_Right.set(0.0);
    		B_Left.set(0.0);
    		B_Right.set(0.0);

    	}
}
    



    	
    


