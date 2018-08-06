/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3559.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3559.robot.commands.AutoForward;
import org.usfirst.frc.team3559.robot.commands.AutoBackwards;
import org.usfirst.frc.team3559.robot.commands.NullAuto;
import org.usfirst.frc.team3559.robot.subsystems.DriveBase;
import org.usfirst.frc.team3559.robot.subsystems.Feeder;
import org.usfirst.frc.team3559.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Spark;

public class Robot extends TimedRobot {
	public String ourSwitch = "UNKNOWN";
	public String theirSwitch = "UNKNOWN";
	public String middleScale = "UNKNOWN";
	public String ourStartPos = "UNKNOWN";
	public static DriveBase drivebase = new DriveBase();
	public static Feeder feeder = new Feeder();
	public static Shooter shooter = new Shooter();
	CameraServer cameraserver = CameraServer.getInstance();
	public static OI m_oi;
	private Spark blinkin= new Spark(0);
	
	//use this if using an auto variable
		//public double drivetime=1.7;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		m_chooser.addDefault("Move Forward", new AutoForward());
		m_chooser.addObject("No Auto", new NullAuto());
		m_chooser.addObject("DriveBackwards", new AutoBackwards());
		SmartDashboard.putData("Auto mode", m_chooser);
		cameraserver.startAutomaticCapture(0);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void getGameData() {
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		//LRL
		// Left - Ours, Right - MIddle, L - Theirs
		this.ourSwitch = parseGameData(gameData, 0);
		this.theirSwitch = parseGameData(gameData, 1);
		this.middleScale = parseGameData(gameData, 2);
	}
	
	public String parseGameData(String gameData, int index) {
		gameData = gameData.toUpperCase();
		char mode = gameData.charAt(index);
		switch (mode) {
			
		case 'L':
				return "LEFT";
		case 'R':
					return "RIGHT";
				default:
					return "UNKNOWN";
		}
	}
	
	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
			getGameData();
			
			
			if(gameData.length()>0) {
				if(gameData.length()>=8) {
					blinkin.set(-0.23);//set blue
				}else {
					blinkin.set(-0.25);//set red
				}
			//if(gameData.charAt(0)=='L') {
					//run left auto
				//AutoBackwards();
			//}else {
					//run right auto
				//}
			}
		
		m_autonomousCommand = m_chooser.getSelected();

		switch (this.ourStartPos) {
		
			case "LEFT":
				//m_autonomousCommand = NEW LEFT COMMAND pass in the this.ourSwitch
				break;
			case "RIGHT":
				//m_autonomousCommand = NEW RIGHT COMMAND pass in the this.ourSwitch
				break;
			deafult:
				//m_autonomousCommand = NEW UNKNOWN COMMAND pass in the this.ourSwitch
				break;
		}
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
