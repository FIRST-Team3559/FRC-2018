/**
 * DriveBase.class for 2018 Robot
 * Created by Fred Routson
 * Creation Date: 14 January 2018
 * Modified: 16 January 2018, Fred Routson
 * Note(s): 1st iteration just sets up basic movement w/o feedback
 */

package org.usfirst.frc.team3559.robot.subsystems;


import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveBase extends Subsystem {

	private WPI_TalonSRX m_frontLeft, m_frontRight;
	private WPI_TalonSRX m_rearLeft, m_rearRight;
	private DifferentialDrive driveBase;
	private Timer m_timer = new Timer();
	private ADXRS450_Gyro gyro;
	private double speedModifier = -0.75;					//Adjust the max input for speed limiting.
	private double Kp = 0.03;
	private double angle;
	
	
	public DriveBase(){
		super();
		m_frontLeft = new WPI_TalonSRX(1);
		m_rearLeft = new WPI_TalonSRX(2);
		SpeedControllerGroup sc_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
		
		m_frontRight = new WPI_TalonSRX(3);
		m_rearRight = new WPI_TalonSRX(4);
		SpeedControllerGroup sc_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
		
		DifferentialDrive driveBase = new DifferentialDrive(sc_left, sc_right);
		driveBase.setSafetyEnabled(false);
		
		gyro = new ADXRS450_Gyro();
		
	}
		
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new TankDriveWithGamepad());
    }
    
    public void drive(double left, double right) {
    	driveBase.tankDrive(-left, -right);
    }
    
    public void stop() {
    	this.drive(0.0, 0.0);
    }
    
    public void moveAhead(double time) {
    	m_timer.reset();
    	m_timer.start();
    	gyro.reset();
    	if (m_timer.get() < time) {
        	angle = gyro.getAngle();
    		driveBase.arcadeDrive(0.5, -angle*Kp);
    		Timer.delay(0.004);
    	} else {
    		driveBase.stopMotor();
    	}
    }
    
    /**
     * Code to drive with gamepad
     */
    public void drive(Joystick gamepad) {
    	drive(speedModifier*gamepad.getY(), speedModifier*gamepad.getRawAxis(5));
    }
    
    public void modifySpeed(double newSpeed) {
    	this.speedModifier = newSpeed;
    }
   
}
