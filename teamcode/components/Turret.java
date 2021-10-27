package org.firstinspires.ftc.teamcode.components;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Turret {
    public Telemetry tele;
    
    public Servo turret;

    public static final double shiftConstant = 0.125;

    public Turret(HardwareMap hardwareMap, Telemetry telemetry)
    {
        tele = telemetry;
        turret = hardwareMap.servo.get("turret");
    }

    public void turretLeft()
    {
        turret.setPosition(-shiftConstant);
    }

    public void turretRight(){
        turret.setPosition(shiftConstant);
    }

}
