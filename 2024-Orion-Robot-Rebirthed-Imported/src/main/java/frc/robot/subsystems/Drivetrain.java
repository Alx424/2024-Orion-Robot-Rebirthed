package frc.robot.subsystems;

import frc.robot.hardware.drivetrainHardwareOI;
import java.lang.Math;

public class Drivetrain {
    private drivetrainHardwareOI hardware;
    private double offsetAngle;

    public Drivetrain(drivetrainHardwareOI hardware) {
        this.hardware = hardware;
        offsetAngle = 0; // to be tuned
    }

    private double capInput(double val, double min, double max) {
        if(val < min) return min;
        if(val > max) return max;
        return val;
    }

    public void arcadeDrive(double forward, double rotate) {
        double leftSidePower = capInput(forward + rotate, -1., 1.);
        double rightSidePower = capInput(forward - rotate, -1., 1.);
        hardware.setLeftSidePower(leftSidePower);
        hardware.setRightSidePower(rightSidePower);
    }

    public void resetEncoders() {
        hardware.resetEncoderPos();
    }

    public double getEncoderPos() {
        // return ((hardware.getLeftEncoderPos() + hardware/getRightEncoderPos()) / 2);
        return hardware.getLeftEncoderPos();
    }

    public double getAngle() {
        return hardware.getAngle() - offsetAngle;
    }

    public double getHeading() {
        return hardware.getAngle() % 360.;
    }

    private double convertEncoder(double encoderPos) {
        // ratio needs to be tuned
        double converterConst = -3.;
        double convertedDist = encoderPos / converterConst;
        return convertedDist;
    }
}
