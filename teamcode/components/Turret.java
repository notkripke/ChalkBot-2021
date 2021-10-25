/*package org.firstinspires.ftc.teamcode.components;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Turret
{
    private Telemetry tele;

    private Servo turret;

    public static final double shiftConstant = 0.125;
    // ^This is the amount by which the turret will rotate with each increment.
    // Since there are 8 chalk slots, the turret must rotate by 1/8th of a full rotation
    // in order to reach the next slot.

    public Turret(HardwareMap hardwareMap, Telemetry telemetry)
    {
        tele = telemetry;
        turret = hardwareMap.servo.get("turret");
    }

    public void moveTurret(double pos)
    {
        turret.setPosition(pos);
    }


    public void turretLeft()
    {
        turret.setPosition(-shiftConstant);
    }

    public void turretRight(){
        turret.setPosition(shiftConstant);
    }

}*/
