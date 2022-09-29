package org.firstinspires.ftc.teamcode.FTC2022;

import static java.lang.Math.round;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.checkerframework.checker.units.qual.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Autonomous 2022", group = "2022", preselectTeleOp = "Drive2022")
public class Autonomous extends LinearOpMode{

    org.firstinspires.ftc.teamcode.FTC2022.hardwareMap hardware = new hardwareMap();

    @Override
    public void runOpMode(){
        hardware.init(hardwareMap);
        hardware.setBrakeMode(DcMotor.ZeroPowerBehavior.BRAKE);

        Orientation orientation;

        waitForStart();
        if (opModeIsActive()) {
            while (opModeIsActive()) {
                orientation = getAxisOrientation();
                telemetry.addData("Z Rotation", round(orientation.firstAngle));
                telemetry.addData("Y Rotation", round(orientation.secondAngle));
                telemetry.addData("X Rotation", round(orientation.thirdAngle));
                telemetry.update();
            }
        }
    }

    public Orientation getAxisOrientation(){
        Orientation rotation = hardware.imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        return rotation;
    }

    private void moveTo(double x, double y, double rotation_degrees){

    }
}
