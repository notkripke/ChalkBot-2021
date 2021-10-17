package org.firstinspires.ftc.teamcode.teleop;
import org.firstinspires.ftc.teamcode.GorillabotsCentral;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.components.MecanumDrive;
import org.firstinspires.ftc.teamcode.components.RevGyro;

// ****** PLEASE NOTE: This teleop draws by a TOGGLE process, where a press of a button will hold ***********
// ****** down the chalk until told to stop or chalk color is swapped.

@Disabled
@TeleOp(group="main", name="DrawDrive")
public class DrawDrive extends GorillabotsCentral
{
    MecanumDrive drive;
    RevGyro gyro;

    @Override
    public void runOpMode()
    {
        ElapsedTime timer = new ElapsedTime();
        ElapsedTime swap_timer = new ElapsedTime();

        drive = new MecanumDrive(hardwareMap, telemetry);
        gyro = new RevGyro(hardwareMap, telemetry);

        boolean slow_check = false;
        boolean press_down = false;

        int ChalkPosition = 1;

        waitForStart();

        while(opModeIsActive())
        {
            double x = gamepad1.left_stick_x;
            double y = -gamepad1.left_stick_y;
            double r = gamepad1.right_stick_x;

           if(gamepad1.right_trigger > 0.45){
               press_down = true;
           }
           if(gamepad1.left_trigger > 0.45){
               press_down = false;
           }

           if(!press_down) {
               column.columnDown();
           } else {
               column.columnUp();
           }

            if(gamepad1.right_bumper && swap_timer.time() >= 0.75){
                ShiftChalkRight();
                ChalkPosition += 1;
                swap_timer.reset();
            }

            if(gamepad1.left_bumper && swap_timer.time() >= 0.75){
                ShiftChalkLeft();
                ChalkPosition -= 1;
                swap_timer.reset();
            }

            if(!slow_check) {
                drive.go(x, y, r);
            } else {
                drive.go(x * 0.3, y * 0.3, r * 0.3);
            }

            if(gamepad1.a)
            {
                drive.resetDrivenDistance();
                gyro.resetAngle();
            }

            if(gamepad1.b && timer.time() >= 0.5){
                slow_check = !slow_check;
                timer.reset();
            }

            if(ChalkPosition == -1 || ChalkPosition == 9){
                ChalkPosition = 8;
            }

            telemetry.addData("Chalk Position", ChalkPosition);
            telemetry.addData("Distance", drive.getDrivenDistance());
            telemetry.addData("Slow drive activated?", slow_check);
            telemetry.update();
        }
    }
}
