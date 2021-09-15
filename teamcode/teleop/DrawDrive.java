package org.firstinspires.ftc.teamcode.teleop;
import org.firstinspires.ftc.teamcode.GorillabotsCentral;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;


// ****** PLEASE NOTE: This teleop draws by a TOGGLE process, where a press of a button will hold ***********
// ****** down the chalk until told to stop or chalk color is swapped.

@Disabled
@TeleOp(group="main", name="DrawDrive")
public class DrawDrive extends GorillabotsCentral
{

    @Override
    public void runOpMode()
    {
        ElapsedTime timer = new ElapsedTime();
        ElapsedTime swap_timer = new ElapsedTime();

        boolean slow_check = false;
        boolean press_down = false;

        int ChalkPosition = 1;

        waitForStart();

        while(opModeIsActive())
        {
            double l = gamepad1.left_stick_y;
            double r = gamepad1.right_stick_y;

           if(gamepad1.right_trigger > 0.45){
               press_down = true;
           }
           if(gamepad1.left_trigger > 0.45){
               press_down = false;
           }

           if(press_down == false){
               column.columnDown();
           }

           if(press_down == true){
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

            if(slow_check == false) {
                tank.goTank(r, l);
            }

            else if (slow_check == true){
                tank.goTank(r * 0.3, l * 0.3);
        }

            if(gamepad1.b && timer.time() >= 1.0){
                slow_check = !slow_check;
                timer.reset();
            }

            if(ChalkPosition == -1 || ChalkPosition == 9){
                ChalkPosition = 8;
            }

            telemetry.addData("Chalk Position", ChalkPosition);
            telemetry.addData("Slow drive activated?", slow_check);
            telemetry.update();
        }
    }
}
