package org.usfirst.frc.team3559.robot.subsystems;

import org.usfirst.frc.team3559.robot.commands.DriveTankStyle;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveBase extends Subsystem {
	private WPI_TalonSRX lf_driveMotor, lr_driveMotor;
	private SpeedControllerGroup sc_left;
	private WPI_TalonSRX rf_driveMotor, rr_driveMotor;
	private SpeedControllerGroup sc_right;
	public DifferentialDrive drivebase;
	
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
}

