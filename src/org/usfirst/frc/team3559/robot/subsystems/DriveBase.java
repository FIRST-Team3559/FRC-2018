/**
 * DriveBase.class for 2018 Robot
 * Created by Fred Routson
 * Creation Date: 14 January 2018
 * Modified: 16 January 2018, Fred Routson
 * Note(s): 1st iteration just sets up basic movement w/o feedback
 */

package org.usfirst.frc.team3559.robot.subsystems;

import org.usfirst.frc.team3559.robot.commands.TankdriveWithGamepad;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;



public class DriveBase extends Subsystem {

	private WPI_TalonSRX m_frontLeft, m_frontRight;
	private SpeedControllerGroup sc_left;
	private WPI_TalonSRX m_rearLeft, m_rearRight;
	private SpeedControllerGroup sc_right;
	public DifferentialDrive driveBase;
	private Servo testServo;
	private double speedModifier = 0.75;					//Adjust the max input for speed limiting.


	public DriveBase(){
		super();
		m_frontLeft = new WPI_TalonSRX(1);
		m_rearLeft = new WPI_TalonSRX(2);
		sc_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
		
		m_frontRight = new WPI_TalonSRX(3);
		m_rearRight = new WPI_TalonSRX(4);
		sc_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
		
		driveBase = new DifferentialDrive(sc_left, sc_right);
		driveBase.setSafetyEnabled(true);
		
		testServo = new Servo(0);
		testServo.set(speedModifier);
	
	}
		
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TankdriveWithGamepad());
    }
    
    public void drive(double left, double right) {
    	driveBase.tankDrive(-speedModifier*left, -speedModifier*right);
    }
    
    public void stop() {
    	driveBase.tankDrive(0.0, 0.0);
    }
       
    public void modifySpeed(double newSpeed) {
    	this.speedModifier = newSpeed;
    	this.testServo.set(newSpeed);  	
    }   
}
