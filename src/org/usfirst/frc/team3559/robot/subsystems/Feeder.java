package org.usfirst.frc.team3559.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Feeder extends Subsystem {
	private Spark FlipMotor = new Spark(9);
	private Spark Feed1 = new Spark(10);
	private Spark Feed2 = new Spark(11);
	public boolean Lift = false;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

public void Lift() {
	Feed1.set(0.5);
	Feed2.set(0.5);
	Timer.delay(0.5);
	Feed1.set(0.0);
	Feed2.set(0.0);
	Timer.delay(0.1);
	FlipMotor.set(0.6);
	Timer.delay(1.0);
	FlipMotor.set(0.0);
	Lift = true;
}
public void Lower() {
	Feed1.set(0.5);
	Feed2.set(0.5);
	Timer.delay(0.5);
	Feed1.set(0.0);
	Feed2.set(0.0);
	Timer.delay(0.1);
	FlipMotor.set(-0.6);
	Timer.delay(1.0);
	FlipMotor.set(0.0);
	Lift = false;
}
public void Judge() {
	if(Lift = true) {
		Lower();
	}else {
	if(Lift = false) {
		Lift();
					}	
			}
	}

}
