package org.firstinspires.ftc.teamcode.teleop;
import org.firstinspires.ftc.teamcode.GorillabotsCentral;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.components.Column;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.components.Drive;
import org.firstinspires.ftc.teamcode.components.RevGyro;
//import org.firstinspires.ftc.teamcode.components.Turret;

// ****** PLEASE NOTE: This teleop draws by a TOGGLE process, where a press of a button will hold ***********
// ****** down the chalk until told to stop or chalk color is swapped.

@TeleOp(group="main", name="DrawDrive")
public class DrawDrive extends GorillabotsCentral
{
    RevGyro gyro;

    Drive drive;

    Column column;

  //  Turret turret;

    @Override
    public void runOpMode()
    {
        ElapsedTime timer = new ElapsedTime();
        ElapsedTime swap_timer = new ElapsedTime();

        gyro = new RevGyro(hardwareMap, telemetry);

        drive = new Drive(hardwareMap, telemetry);

        column = new Column(hardwareMap, telemetry);

        //turret = new Turret(hardwareMap, telemetry);



        boolean slow_check = false;
        boolean drawing = false;

        int ChalkPosition = 1;

        waitForStart();

        Servo column;
        column = hardwareMap.get(Servo.class, "column");

        while(opModeIsActive())
        {
           double l = gamepad1.left_stick_y;
           double r = gamepad1.right_stick_y;
           
           if(gamepad1.right_trigger > 0.45) {
               column.setPosition(1);
               drawing = true;
           } else {
               column.setPosition(.05);
               drawing = false;
           }

           /* if(gamepad1.right_bumper && swap_timer.time() >= 0.75){
                ShiftChalkRight();
                ChalkPosition += 1;
                swap_timer.reset();
            }

            if(gamepad1.left_bumper && swap_timer.time() >= 0.75){
                ShiftChalkLeft();
                ChalkPosition -= 1;
                swap_timer.reset();
            }*/

            if(!slow_check) {
                drive.go(l, r);
            } else {
                drive.go(l * 0.3, r * 0.3);
            }


            if(gamepad1.b && timer.time() >= 0.5){
                slow_check = !slow_check;
                timer.reset();
            }

            if(ChalkPosition == 0 || ChalkPosition == 9){
                ChalkPosition = 8;
            }

            telemetry.addData("Chalk Position", ChalkPosition);
            telemetry.addData("Slow drive activated?", slow_check);
            telemetry.addData("Drawing?", drawing);
            telemetry.update();
        }
    }
}
