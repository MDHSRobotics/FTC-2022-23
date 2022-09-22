package org.firstinspires.ftc.teamcode.FTC2022;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Autonomous 2022", group = "2022")
public class Autonomous extends LinearOpMode{

    org.firstinspires.ftc.teamcode.FTC2022.hardwareMap hardware = new hardwareMap();

    @Override
    public void runOpMode(){
        hardware.init(hardwareMap);
        hardware.setBrakeMode(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();
        if (opModeIsActive()) {
            while (opModeIsActive()) {

            }
        }
    }
    private void moveTo(double x, double y, double rotation_degrees){

    }
}
