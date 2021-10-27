package org.firstinspires.ftc.teamcode.components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Drive {
    public Telemetry tele;

    public DcMotor left, right;

    public Drive(HardwareMap hardwareMap, Telemetry telemetry) {
        tele = telemetry;

        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");

        right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void go(double l, double r) {
        left.setPower(-l);
        right.setPower(r);
    }
}
