package org.firstinspires.ftc.teamcode.components;


import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Servos
{
    Telemetry tele;

    public Servo column;
    public Servo turret;



    public Servos(HardwareMap hardwareMap, Telemetry telemetry)
    {
        tele = telemetry;

        final double TURRET_INCREMENT = .125;
        final double COLUMN_UP = .05;
        final double COLUMN_DOWN = 1;

        column = hardwareMap.servo.get("column");
        turret = hardwareMap.servo.get("turret");
    }
}