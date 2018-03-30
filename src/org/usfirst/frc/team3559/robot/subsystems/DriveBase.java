package org.usfirst.frc.team3559.robot.subsystems;

import org.usfirst.frc.team3559.robot.commands.DriveTankStyle;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */
public class DriveBase extends Subsystem {
	private WPI_TalonSRX lf_driveMotor, lr_driveMotor;
	private SpeedControllerGroup sc_left;
	private WPI_TalonSRX rf_driveMotor, rr_driveMotor;
	private SpeedControllerGroup sc_right;
	public DifferentialDrive drivebase;
	Encoder encL = new Encoder(1,2,false,Encoder.EncodingType.k4X);
	Encoder encR = new Encoder(3,4,false,Encoder.EncodingType.k4X);
	
	private double speedModifier = 0.7;
	
	public DriveBase() {
		super();
		lf_driveMotor = new WPI_TalonSRX(1);
		lr_driveMotor = new WPI_TalonSRX(2);
		sc_left = new SpeedControllerGroup(lf_driveMotor, lr_driveMotor);
		
		rf_driveMotor = new WPI_TalonSRX(3);
		rr_driveMotor = new WPI_TalonSRX(4);
		sc_right = new SpeedControllerGroup(rf_driveMotor, rr_driveMotor);
		
		drivebase = new DifferentialDrive(sc_left, sc_right);
		drivebase.setSafetyEnabled(true);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveTankStyle());
    }
    
    public void drive(double left, double right) {
    	drivebase.tankDrive(-speedModifier*left, -speedModifier*right);
    }
    
    public void stop() {
    	drivebase.tankDrive(0.0, 0.0);
    }
    
    public void modifySpeed(double newSpeedModifier) {
    	this.speedModifier = newSpeedModifier;
    }
    
    public void AutoF() {
     	drivebase.tankDrive(0.7, 0.7);
    }
    
    public void AutoFEnc() {
    	encL.reset();
    	encR.reset();
    	do {
    		drivebase.tankDrive(0.7, 0.7);
    	}while(encL.getDistance()<50.0);
    		drivebase.tankDrive(0.0, 0.0);
    }
    
    public void AutoB() {
    	drivebase.tankDrive(-0.6, -0.6);
    }
    
    public void AutoL() {
    	drivebase.tankDrive(-0.6, 0.0);
    	Timer.delay(1.0);
    	drivebase.tankDrive(0.0, 0.0);
    }
    public void AutoR() {
    	drivebase.tankDrive(0.0, 0.6);
    	Timer.delay(1.0);
    	drivebase.tankDrive(0.0, 0.0);
    }
    
    public void Null() {//
    	drivebase.tankDrive(0.0,0.0);//
    }//
    public void Encoders() {
    	encL.setMaxPeriod(1.0);
    	encL.setMinRate(10);
    	encL.setDistancePerPulse(5);
    	encL.setReverseDirection(true);
    	encL.setSamplesToAverage(7);
    	
    	encR.setMaxPeriod(1.0);
    	encR.setMinRate(10);
    	encR.setDistancePerPulse(5);
    	encR.setReverseDirection(true);
    	encR.setSamplesToAverage(7);
    	
    	encR.reset();
    }
}




