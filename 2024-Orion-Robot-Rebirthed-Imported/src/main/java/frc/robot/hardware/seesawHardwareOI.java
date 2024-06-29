package frc.robot.hardware;

public interface seesawHardwareOI {
    public void setPower(double val);

    public double getAngleToDeg();

    public double getRawAngle();

    public void resetAngle();
}
