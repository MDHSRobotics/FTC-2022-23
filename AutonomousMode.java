package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Autonomous 2022")
public class AutonomousMode extends LinearOpMode{

    hardwareMap2022 hardware = new hardwareMap2022();

    @Override
    public void runOpMode(){
        hardware.init(hardwareMap);

        waitForStart();
        if (opModeIsActive()) {
            while (opModeIsActive()) {

            }
        }
    }
    private void moveTo(double x, double y, double rotation_degrees){

    }
}
