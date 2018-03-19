/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3559.robot;

import org.usfirst.frc.team3559.robot.commands.EjectCube;
import org.usfirst.frc.team3559.robot.commands.HiGear;
import org.usfirst.frc.team3559.robot.commands.SloGear;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick gamepad = new Joystick(0);
	private Joystick gamepad1 = new Joystick(1);
	Button lshoulder1 = new JoystickButton(gamepad, 5);
	Button rshoulder1 = new JoystickButton(gamepad, 6);
	Button greenA1 = new JoystickButton(gamepad1, 1);
	
	public OI() {
		lshoulder1.whileHeld(new SloGear());
		rshoulder1.whileHeld(new HiGear());
		greenA1.whileHeld(new EjectCube());
	}
	
	public double getLeftStick() {
		return gamepad.getY();
	}
	
	public double getRightStick() {
		return gamepad.getRawAxis(5);
	}
	
	public double getLeftTrigger() {
		return gamepad1.getRawAxis(2);
	}
	
	public double getRightTrigger() {
		return gamepad1.getRawAxis(3);
	}
}
