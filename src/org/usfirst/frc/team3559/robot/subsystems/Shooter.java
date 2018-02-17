package org.usfirst.frc.team3559.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 *
 */
public class Shooter extends Subsystem {
	public static Subsystem Shooter;
	private Spark A_Left = new Spark(1);
	private Spark A_Right = new Spark(2);
	private Spark B_Left = new Spark(3);
	private Spark B_Right = new Spark(4);
	private SpeedControllerGroup Shooter_A = new SpeedControllerGroup(A_Left, A_Right);
	private SpeedControllerGroup Shooter_B = new SpeedControllerGroup(B_Left, B_Right);
	private boolean ShootHi  = false;
	private boolean ShootMid = false;
	private boolean ShootLow = false;
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void Shoot() {
    }
    
}

