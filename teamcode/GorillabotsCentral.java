package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.components.Servos;


import org.firstinspires.ftc.teamcode.components.Drive;


import static java.lang.Math.abs;

public abstract class GorillabotsCentral extends LinearOpMode {

    public Drive drive;
    public ElapsedTime timer;
    public Servos servos;


    public void initializeComponents() {
        timer = new ElapsedTime();

        drive = new Drive(hardwareMap, telemetry);

        servos = new Servos(hardwareMap, telemetry);

        telemetry.addData("done:", "init");

    }

    public void moveTurret(int direction){
        double CURRENT_POS = servos.turret.getPosition();
        if(direction == -1) {
            servos.turret.setPosition(CURRENT_POS - .125);
        }
        else if(direction == 1){
            servos.turret.setPosition(CURRENT_POS + .125);
        }
    }

    public void columnUp(){
        servos.column.setPosition(.05);
    }
    public void  columnDown(){
        servos.column.setPosition(1);
    }


}