package org.firstinspires.ftc.teamcode.FTC2022;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.checkerframework.checker.units.qual.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Autonomous 2022", group = "2022", preselectTeleOp = "Drive2022")
public class Autonomous extends LinearOpMode{

    org.firstinspires.ftc.teamcode.FTC2022.hardwareMap hardware = new hardwareMap();
    double x_position;

    @Override
    public void runOpMode(){
        hardware.init(hardwareMap);
        hardware.setBrakeMode(DcMotor.ZeroPowerBehavior.BRAKE);

        Orientation orientation;

        waitForStart();
        if (opModeIsActive()) {
            while (opModeIsActive()) {

                org.firstinspires.ftc.robotcore.external.navigation.Acceleration accel = hardware.imu.getLinearAcceleration();
                Velocity vel = hardware.imu.getVelocity();

                orientation = getAxisOrientation();
                telemetry.addData("X Velocity", vel.xVeloc);
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

    private void getdisplacement(){
        org.firstinspires.ftc.robotcore.external.navigation.Acceleration accel = hardware.imu.getLinearAcceleration();

        x_position += Math.sqrt(accel.xAccel)/accel.xAccel;
    }
}
