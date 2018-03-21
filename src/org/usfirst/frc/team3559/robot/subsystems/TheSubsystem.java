package org.usfirst.frc.team3559.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TheSubsystem extends Subsystem {
	private Spark Blinkin = new Spark(7);
	private double carson = 0.1;
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void Bendup() {
    	carson = carson + 0.2;
    	Blinkin.set(carson);
    }
    public void Benddown() {
    	carson = carson - 0.2;
    	Blinkin.set(carson);
    }
}

