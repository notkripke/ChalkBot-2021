package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.components.Column;
import org.firstinspires.ftc.teamcode.components.TankDriveArcade;
import org.firstinspires.ftc.teamcode.components.Turret;

import static java.lang.Math.abs;

public abstract class GorillabotsCentral extends LinearOpMode {

    public ElapsedTime timer;
    public Turret turret;
    public Column column;
    public TankDriveArcade tank;

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





}