package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.GorillabotsCentral;
@Disabled
@TeleOp(group="main", name="BasicDrive")
public class BasicDrive extends GorillabotsCentral
{
    @Override
    public void runOpMode()
    {
        waitForStart();

        while(opModeIsActive())
        {
            double r = gamepad1.right_stick_y;
            double l = gamepad1.left_stick_y;


            tank.goTank(r, l);

            telemetry.update();
        }
    }
}
