package org.usfirst.frc.team3559.robot;

import org.usfirst.frc.team3559.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;

public class OI {
	Joystick gamepad = new Joystick(0);
	Joystick gamepad2 = new Joystick(1);
	Button lTrigger = new JoystickButton(gamepad, 5);
	Button rTrigger = new JoystickButton(gamepad, 6);
	Button GreenA2 = new JoystickButton(gamepad2, 1);
	Button RedB2 = new JoystickButton(gamepad2, 2);
	Button YellowY2 = new JoystickButton(gamepad2, 3);
	Button BlueX2 = new JoystickButton(gamepad2, 4);
	Button LeftStick = new JoystickButton(gamepad2, 9);
	Button RightStick = new JoystickButton(gamepad2, 10);
	Button RightButton = new JoystickButton(gamepad2, 6);

	public OI() {
		lTrigger.whileHeld(new SloGear());
		rTrigger.whileHeld(new HiGear());
		BlueX2.whenPressed(new JudgeJudy());
		GreenA2.whenPressed(new LowShoot());
		RedB2.whenPressed(new MidShoot());
		YellowY2.whenPressed(new HighShoot());
		RightStick.whenPressed(new BendUp());
		LeftStick.whenPressed(new BendDown());
	}

	public Joystick getJoystick() {
		return gamepad;
	}

	public double getLeftSpeed() {
		return gamepad.getY();
	}

	public double getRightSpeed() {
		return gamepad.getRawAxis(5);
	}

	public double getLeftTrigger() {
		return 0.5 - gamepad.getRawAxis(2) / 2;
	}

	public double getRightTrigger() {
		return 0.5 + gamepad.getRawAxis(2) / 2;
	}
}

/**
 * @return True if the DPad is pushed right, False if it is not pressed
 */
