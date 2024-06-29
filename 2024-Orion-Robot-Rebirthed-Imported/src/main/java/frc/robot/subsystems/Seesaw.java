package frc.robot.subsystems;

import frc.robot.hardware.seesawHardwareOI;

public class Seesaw {
    seesawHardwareOI hardware;
    double offsetAngle;
    private final double ACCEPTABLE_RANGE = 15;
    private final double MAX_ANGLE = 105;
    private final double MIN_ANGLE = 75;
    private final double kP = 0.015;
    private final double kFGravity = 0.015; // unsure whether anti-falling constant is needed...

    public Seesaw(seesawHardwareOI hardware) {
        this.hardware = hardware;
        offsetAngle = 0;
    }

    private double cap(double val, double min, double max) {
        if(val < min) return min;
        if(val > max) return max;
        return val;
    }
    //assume that arm range is 60 degrees only
    public void setAngle(int desiredAngle) {
        double currentAngle = getAngle();
        double error = desiredAngle - currentAngle;
        double feedForwardVal = Math.cos(Math.toRadians(currentAngle) * kFGravity);
        if(error <= ACCEPTABLE_RANGE) {
            if(currentAngle < MIN_ANGLE || currentAngle > MAX_ANGLE) {
                hardware.setPower(0);
            } else {
                hardware.setPower(feedForwardVal);
            }
        } else {
            double output = cap((error * kP) + feedForwardVal, -0.6, 0.6);
            hardware.setPower(output);
        }
    }

    public double getAngle() {
        return hardware.getAngleToDeg() - offsetAngle;
    }
}
