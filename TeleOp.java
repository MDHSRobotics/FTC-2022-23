
package org.firstinspires.ftc.teamcode.FTC2022;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DigitalChannel;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Drive2022", group = "2022")
public class TeleOp extends LinearOpMode {

    /*
    private Servo claw;
    private DistanceSensor frontsensor;
    private DistanceSensor cdv3_DistanceSensor;
    private ColorSensor cdv3;
    */

    org.firstinspires.ftc.teamcode.FTC2022.hardwareMap hardware = new hardwareMap();
    private DigitalChannel front;

    //This function is executed when this Op Mode is selected from the Driver Station.
    @Override
    public void runOpMode() {
        double drivey;
        double drivex;
        double right;
        double left;
        double mult = 0.5;
        double strafeX;

        double armPower;

        double extenderPower = 0;

        hardware.init(hardwareMap);
        hardware.setBrakeMode(DcMotor.ZeroPowerBehavior.FLOAT);

        // Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {
            //motorpos = rot.getCurrentPosition();
            // Put run blocks here.
            while (opModeIsActive()) {
                // Drive
                drivey = gamepad1.left_stick_y;
                drivex = gamepad1.left_stick_x;
                right = drivey + drivex;
                left = drivex - drivey;

                hardware.frontRight.setPower(right * mult);
                hardware.frontLeft.setPower(left * mult);
                hardware.backLeft.setPower(left * mult);
                hardware.backRight.setPower(right * mult);

                // Strafe
                strafeX = gamepad1.right_stick_x;
                hardware.backLeft.setPower(strafeX * -1);
                hardware.backRight.setPower(strafeX * 1);
                hardware.frontLeft.setPower(strafeX * 1);
                hardware.frontRight.setPower(strafeX * -1);

                // ZeroPowerBehavior Changer
                // Test to decide whether to use this or auto braking.
                if (gamepad1.a) {
                    hardware.setBrakeMode(DcMotor.ZeroPowerBehavior.BRAKE);
                } else if (gamepad1.b) {
                    hardware.setBrakeMode(DcMotor.ZeroPowerBehavior.FLOAT);
                }

                //Arm
                if (gamepad2.left_stick_y == 0) {
                    armPower = -0.005;
                } else {
                    armPower = 0.32 * gamepad2.left_stick_y;
                }
                hardware.spinner.setPower(gamepad2.left_stick_x);
                hardware.centerArm.setPower(-armPower);
                hardware.centerArm2.setPower(armPower); //test if we need a 2nd motor

                // Extender
                if (hardware.extender.getCurrentPosition() > 0) {
                    if (gamepad2.left_trigger == 0 && gamepad2.right_trigger == 0) {
                        extenderPower = 0;
                    } else if (gamepad2.left_trigger == 1) {
                        extenderPower = 1;
                    } else if (gamepad2.right_trigger == 1) {
                        extenderPower = -1;
                    }
                } else {
                    extenderPower = 0;
                }
                hardware.extender.setPower(extenderPower);

                //telemetry
                telemetry.addData("Extender Position:", hardware.extender.getCurrentPosition());
                telemetry.addData("IMU Rotation:", hardware.imu.getAngularOrientation());
                telemetry.update();
                /*telemetry.addData("frontsensor", frontsensor.getDistance(DistanceUnit.CM));
                telemetry.addData("fr",hardware.backLeft.getCurrentPosition());
                telemetry.update();
                */
            }
        }
    }

}