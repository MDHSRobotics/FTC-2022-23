package org.firstinspires.ftc.teamcode.FTC2022;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.checkerframework.checker.units.qual.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Autonomous 2022", group = "2022")
public class Autonomous extends LinearOpMode{

    org.firstinspires.ftc.teamcode.FTC2022.hardwareMap hardware = new hardwareMap();

    @Override
    public void runOpMode(){
        hardware.init(hardwareMap);
        hardware.setBrakeMode(DcMotor.ZeroPowerBehavior.BRAKE);

        Acceleration acceleration;
        double z_orientation;

        waitForStart();
        if (opModeIsActive()) {
            while (opModeIsActive()) {
                acceleration = (Acceleration) hardware.imu.getAcceleration();
                z_orientation = getZAxisOrientation();
                telemetry.addData("Acceleration", acceleration);
                telemetry.addData("Z Rotation", z_orientation);
            }
        }
    }

    public double getZAxisOrientation(){
        Orientation rotation = hardware.imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        double zOrientation = rotation.firstAngle;
        return zOrientation;
    }
    private void moveTo(double x, double y, double rotation_degrees){

    }
}
