package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.components.Column;
import org.firstinspires.ftc.teamcode.components.Turret;
import org.firstinspires.ftc.teamcode.components.AutoDrive;
import org.firstinspires.ftc.teamcode.components.MecanumDrive;
import org.firstinspires.ftc.teamcode.components.RevGyro;

import static java.lang.Math.abs;

public abstract class GorillabotsCentral extends LinearOpMode {

    public AutoDrive ADrive;
    public MecanumDrive drive;
    public RevGyro gyro;
    public ElapsedTime timer;
    public Turret turret;
    public Column column;

    /*
    HUB # 1

    Motors:
    0: mfr
    1: mbr

    Servos:
    0: rotate
    1: rollerF
    3: hookR
    5: parker

    I2C:
    0: imu
    1: rangeF
    2: rangeB
    3: rangeR

    HUB # 2

    Motors:
    1: lift
    2: mfl
    3: mbl

    Servos:
    5: rollerB
    4: hookL

    I2C:
    1: rangeL

    Digital Channels:
    3: liftBot
     */

    public void initializeComponents()
    {
        timer = new ElapsedTime();

        //ADrive = new AutoDrive(hardwareMap,telemetry);

        column = new Column(hardwareMap, telemetry);

        turret = new Turret(hardwareMap, telemetry);

        //gyro = new RevGyro(hardwareMap,telemetry);

        telemetry.addData("done:","init");
        telemetry.update();
    }

    public void initializeComponentsAutonomous()
    {
        timer = new ElapsedTime();

        ADrive = new AutoDrive(hardwareMap,telemetry);

        drive = new MecanumDrive(hardwareMap,telemetry);

        gyro = new RevGyro(hardwareMap,telemetry);

        telemetry.addData("done:","init");
        telemetry.update();
    }

    public static final int degreeCorrection = 180;
//160
    public static final double COUNTS_PER_MOTOR_REV = 384;     //12.5:1
    public static final double DRIVE_GEAR_REDUCTION = 1.0;     // This is < 1.0 if geared UP
    public static final double WHEEL_DIAMETER_INCHES = 4.0;     // For figuring circumference
    public static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);


    public void ShiftChalkLeft(){
        column.columnUp();
        turret.turretLeft();
    }
    public void ShiftChalkRight(){
        column.columnUp();
        turret.turretRight();
    }

    public void stopMotors()
    {
        drive.mfr.setPower(0);
        drive.mfl.setPower(0);
        drive.mbr.setPower(0);
        drive.mbl.setPower(0);
    }
    public void setMotorsBackwards(){
        drive.mfr.setDirection(DcMotor.Direction.REVERSE);
        drive.mfl.setDirection(DcMotor.Direction.FORWARD);
        drive.mbr.setDirection(DcMotor.Direction.REVERSE);
        drive.mbl.setDirection(DcMotor.Direction.FORWARD);
    }

    public void setDriveEncoderOn(boolean on) {
        if (on) {
            drive.mfr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            drive.mfr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            drive.mfr.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            drive.mbr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            drive.mbr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            drive.mbr.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            drive.mfl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            drive.mfl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            drive.mfl.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            drive.mbl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            drive.mbl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            drive.mbl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        } else {
            drive.mfr.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            drive.mbr.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            drive.mfl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            drive.mbl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }
}
