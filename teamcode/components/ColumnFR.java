package org.firstinspires.ftc.teamcode.components;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ColumnFR
{
    public Telemetry tele;

    public Servo column;

    public static final double downPos = 1;
    public static final double upPos = 0.05;

    public ColumnFR(HardwareMap hardwareMap, Telemetry telemetry)
    {
        tele = telemetry;
        column = hardwareMap.servo.get("column");
    }

    public void columnDownFR()
    {
        column.setPosition(downPos);
    }

    public void columnUpFR(){
        column.setPosition(upPos);
    }

}
