package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.GorillabotsCentral;


@TeleOp(group = "AAAAAAAAAA", name = "DrawDrive")
public class DrawDrive extends GorillabotsCentral {

    @Override
    public void runOpMode() {

        initializeComponents();

        double r;
        double l;

        waitForStart();

        while (opModeIsActive()) {

            r = gamepad1.right_stick_y;
            l = gamepad1.left_stick_y;

            if(gamepad1.left_bumper){
                moveTurret(-1);
            }
            if(gamepad1.right_bumper){
                moveTurret(1);
            }
            if(gamepad1.left_trigger >= .2){
                columnUp();
            }
            if(gamepad1.right_trigger >= .2){
                columnDown();
            }

            drive.go(l, r);

        }
    }
}