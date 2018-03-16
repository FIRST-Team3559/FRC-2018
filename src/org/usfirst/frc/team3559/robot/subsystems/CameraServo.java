package org.usfirst.frc.team3559.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CameraServo extends Subsystem {
	private Servo cameraServo = new Servo(0);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void point(double val) {
    	if (val >= 0.0 && val <= 1.0)
    		cameraServo.set(val);
    }
    public void reset() {
    	cameraServo.set(0.5);
    }
}

