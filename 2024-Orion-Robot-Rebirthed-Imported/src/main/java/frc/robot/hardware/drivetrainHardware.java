package frc.robot.hardware;

import com.ctre.phoenix.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.RobotMap;


public class drivetrainHardware implements drivetrainHardwareOI {
    private TalonSRX left1;
    private TalonSRX left2;
    private TalonSRX right1;
    private TalonSRX right2;
    
    public drivetrainHardware(){
        left1 = new TalonSRX(RobotMap.DRIVE_LEFT_1);
        left2 = new TalonSRX(RobotMap.DRIVE_LEFT_2);
        right1 = new TalonSRX(RobotMap.DRIVE_RIGHT_1);
        right2 =new TalonSRX(RobotMap.DRIVE_RIGHT_2);
    }
    @Override
    public void setLeftSidePower(double val) {
        left1.set(ControlMode.PercentOutput, val);
        left2.set(ControlMode.PercentOutput, val); //Maybe a CAN ID conflict with these ones?
    }

    @Override
    public void setRightSidePower(double val) {
        right1.set(ControlMode.PercentOutput,-val);
        right2.set(ControlMode.PercentOutput,val); //Maybe a CAN ID conflict with these ones?
    }

    @Override
    public double getLeftEncoderPos() {
        return 0;
    }

    @Override
    public double getRightEncoderPos() {
        return 0;
    }

    @Override
    public void resetEncoderPos() {
        
    }

    @Override
    public void resetGyro() {
       
    }

    @Override
    public double getAngle() {
        return 0.;
    }
}
