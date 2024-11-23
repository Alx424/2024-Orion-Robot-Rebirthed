package frc.robot.oi;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;

public class OperatorInterface implements IOperatorInterface {
    private Joystick drivetrainController;
    private Joystick operatorController;

    public OperatorInterface() {
        drivetrainController = new Joystick(0);
        operatorController = new Joystick(1);
    }

    @Override
    public double getDriveTrainForward() {
        return -drivetrainController.getRawAxis(1);

    }

    @Override
    public double getDriveTrainRotate() {
        return RobotMap.SINGLE_JOYSTICK?drivetrainController.getRawAxis(0):drivetrainController.getRawAxis(3);
    }


  
}