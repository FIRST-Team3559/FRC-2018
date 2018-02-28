package org.usfirst.frc.team3559.robot;

import org.usfirst.frc.team3559.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;

public class OI {
		Joystick gamepad = new Joystick (0);
		Button lTrigger = new JoystickButton(gamepad, 5);
		Button rTrigger = new JoystickButton(gamepad, 6);
		
		public OI() {
			lTrigger.whileHeld(new SloGear());
			rTrigger.whileHeld(new HiGear());
		}
		
		public Joystick getJoystick() {
			return gamepad;
		}

}
