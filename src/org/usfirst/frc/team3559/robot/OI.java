/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3559.robot;

import org.usfirst.frc.team3559.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
		Joystick gamepad = new Joystick (0);
		Joystick gamepad2 = new Joystick (1);
		Button lTrigger = new JoystickButton(gamepad, 5);
		Button rTrigger = new JoystickButton(gamepad, 6);
		Button greenA2 = new JoystickButton(gamepad2, 1);
		Button redB2 = new JoystickButton(gamepad2, 2);
		Button yellowY2 = new JoystickButton(gamepad2, 4);
		Button blueX2 = new JoystickButton(gamepad2, 3);
		
		public OI() {
			lTrigger.whileHeld(new SloGear());
			rTrigger.whileHeld(new HiGear());
			greenA2.whenPressed(new LowShoot());
			redB2.whenPressed(new MidShoot());
			yellowY2.whenPressed(new HiShoot());
			
		}


		public Joystick getJoystick() {
			return gamepad;
		}
		public int DPad() {
		    return gamepad.getPOV(0);
		}

		/**
		 * @return True if the DPad is pushed right, False if it is not pressed
		 */
		public boolean DPadRight() {
		  if (gamepad.getPOV(0) == 90) {
		        return true;
		  }else {
		        return false;
		}
		}

		/**
		 * @return True if the DPad is pushed down, False if it is not pressed
		 */
		public boolean DPadDown() {
		    if (gamepad.getPOV(0) == 180) {
		        return true;
		    }else {
		        return false;
		}
		}
		public boolean DPadUp() {
		    if (gamepad.getPOV(0) == 0) {
		        return true;
		    }else {
		        return false;
		}
		}

		/**
		 * @return True if the DPad is pushed left, False if it is not pressed
		 */
		public boolean DPadLeft() {
		    if (gamepad.getPOV(0) == 270 ) {
		        return true;
		    } else {
		        return false;
		    }
		}
		}
