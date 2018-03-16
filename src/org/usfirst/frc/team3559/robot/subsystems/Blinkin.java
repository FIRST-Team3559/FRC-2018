package org.usfirst.frc.team3559.robot.subsystems;
 
import org.usfirst.frc.team3559.robot.Robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Blinkin extends Subsystem {

    public Spark LEDController = new Spark(7);
    public double carson = -0.07;
    // private double rest = 0.89;

    
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    
    public void Bend() {
   LEDController.set(carson);
    }
    public void CarsonUp() {
  carson = carson + 0.02;
  Robot.Blinkin.Bend();
    }
    public void CarsonDown() {
    	  carson = carson - 0.02;
    	  Robot.Blinkin.Bend();
    }
}
   