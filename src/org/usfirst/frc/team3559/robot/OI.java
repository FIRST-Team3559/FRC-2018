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
		Joystick gamepad = new Joystick (0);
		Joystick gamepad2 = new Joystick (1);
		Button lShoulder = new JoystickButton(gamepad, 5);
		Button rShoulder = new JoystickButton(gamepad, 6);
	
		
		public OI() {
			lShoulder.whileHeld(new SloGear());
			rShoulder.whileHeld(new HiGear());
		}


		public Joystick getJoystick() {
			return gamepad;
		}
}