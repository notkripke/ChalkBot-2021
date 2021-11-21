package org.firstinspires.ftc.teamcode.components;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Drive
{
    Telemetry tele;

    public DcMotor ml, mr;

    public Drive(HardwareMap hardwareMap, Telemetry telemetry)
    {
        tele = telemetry;

        ml = hardwareMap.dcMotor.get("ml");
        mr = hardwareMap.dcMotor.get("mr");

        mr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ml.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    private double l,r;

    public void go(double lP, double rP)
    {

        l = lP;
        r = rP;

        ml.setPower(lP);
        mr.setPower(rP);

    }


}