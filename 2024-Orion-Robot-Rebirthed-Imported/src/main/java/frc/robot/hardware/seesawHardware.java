package frc.robot.hardware;

import com.ctre.phoenix.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.RobotMap;



public class seesawHardware implements seesawHardwareOI {
    private TalonSRX motor;

    public seesawHardware() {
        motor = new TalonSRX(RobotMap.SEESAW_MOTOR);
        motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
    }
    @Override
    public void setPower(double val) {
        motor.set(ControlMode.PercentOutput, val);
    }
    @Override
    public double getAngleToDeg() {
        double encoderPos = motor.getSelectedSensorPosition(0) % 4096; // 4096 ticks per rotation
        double convertedAngle = encoderPos * (360/4096); // I'll double-check this math later
        return convertedAngle;
    }
    @Override
    public double getRawAngle() {
        return motor.getSelectedSensorPosition(0) % 4096;
    }
    @Override
    public void resetAngle() {
        return;
    }
}
