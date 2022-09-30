package org.firstinspires.ftc.teamcode.FTC2022;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.BNO055IMUImpl;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

/*
->FTC PowerPlay 2022-2023<-
=HardwareMap by Anthony and TJ=
This class:
    1. connects the motors from the configuration into the programs
    2. sets up the motors and their modes
    3. initializes the IMU

 */

public class hardwareMap {
    //Create Motors
    public DcMotor frontRight = null;
    public DcMotor frontLeft = null;
    public DcMotor backRight = null;
    public DcMotor backLeft = null;
    public DcMotor centerArm = null;
    public DcMotor centerArm2 = null;
    public DcMotor extender = null;
    public DcMotor spinner = null;
    public BNO055IMU imu = null;

    //Create Servo
    //public Servo servo1 = null;

    //Create IMU

    //Additional Variable
    com.qualcomm.robotcore.hardware.HardwareMap hardwareMap = null;
    public ElapsedTime period = new ElapsedTime();

    //Constructor
    public hardwareMap(com.qualcomm.robotcore.hardware.HardwareMap hwMap) {
        initialize(hwMap);
    }

    //New method
    private void initialize(com.qualcomm.robotcore.hardware.HardwareMap hwMap) {
        hardwareMap = (hwMap);
    }

    public hardwareMap() {
    }

    // Initialize standard Hardware interfaces
    public void init(HardwareMap ahwMap) {
        hardwareMap = ahwMap;

        // Connect Motors
        frontRight = hardwareMap.get(DcMotor.class, "FR");
        frontLeft = hardwareMap.get(DcMotor.class, "FL");
        backLeft = hardwareMap.get(DcMotor.class, "BL");
        backRight = hardwareMap.get(DcMotor.class, "BR");
        centerArm = hardwareMap.get(DcMotor.class, "ARM");
        centerArm2 = hardwareMap.get(DcMotor.class, "ARM2");
        extender = hardwareMap.get(DcMotor.class, "topArm");
        spinner = hardwareMap.get(DcMotor.class, "spinner");

        //Connect Servo
        //servo1 = hardwareMap.get(Servo.class, "servo1");

        //IMU Inititalization
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        Init_IMU(imu);

        //Set up the directions
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.FORWARD);
        centerArm.setDirection(DcMotor.Direction.FORWARD);
        centerArm2.setDirection(DcMotor.Direction.FORWARD);
        extender.setDirection(DcMotor.Direction.FORWARD);
        spinner.setDirection(DcMotor.Direction.FORWARD);
        //Set Motor Mode
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        centerArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        centerArm2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        extender.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        spinner.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        centerArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        centerArm2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        extender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        spinner.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Set Zero Power Behaviour
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        centerArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        centerArm2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        extender.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        spinner.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        //Set Motors to use no power
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        centerArm2.setPower(0);
        centerArm.setPower(0);
        extender.setPower(0);
        spinner.setPower(0);
    }

    private void Init_IMU(BNO055IMU imu) {
        BNO055IMU.Parameters IMUparameters = new BNO055IMU.Parameters();

        IMUparameters.mode = BNO055IMU.SensorMode.IMU;
        IMUparameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        IMUparameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        imu.initialize(IMUparameters);
    }
    public void setBrakeMode(DcMotor.ZeroPowerBehavior ZPB){
        frontRight.setZeroPowerBehavior(ZPB);
        frontLeft.setZeroPowerBehavior(ZPB);
        backRight.setZeroPowerBehavior(ZPB);
        backLeft.setZeroPowerBehavior(ZPB);
    }
}

