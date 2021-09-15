package org.firstinspires.ftc.teamcode.components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class TankDriveArcade
{
    Telemetry tele;

    public DcMotor ml, mr;

    public TankDriveArcade(HardwareMap hardwareMap, Telemetry telemetry)
    {
        tele = telemetry;

        ml = hardwareMap.dcMotor.get("ml");
        mr = hardwareMap.dcMotor.get("mr");
        mr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ml.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    private double pr, pl;

    public void goTank(double r, double l)
    {
        double speedCap = 0.85;

        tele.addData("right", r);
        tele.addData("left", l);

        pr = r;
        pl = l;

        ml.setPower(pl * speedCap);
        mr.setPower(pr * speedCap);
    }
}
