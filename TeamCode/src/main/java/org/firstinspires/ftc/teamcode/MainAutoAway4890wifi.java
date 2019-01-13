package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import java.util.Map;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Autonomous(name="MainAutoAway4890wifi", group="")
//@Disabled
public class MainAutoAway4890wifi extends LinearOpMode {

    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor rack;
    private DcMotor slide;
    private DcMotor grabber;
    private DcMotor flipper;

    @Override
    public void runOpMode() {

        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        rack = hardwareMap.get(DcMotor.class, "rackAndPinion");
        grabber = hardwareMap.get(DcMotor.class, "grabber");
        flipper = hardwareMap.get(DcMotor.class, "flipper");

        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.REVERSE);
        rack.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        if (opModeIsActive()) {

            land();
            drive(0.25, 640);
            turn(0.25, 3500);
            drive(0.25, 1280);
            turn(0.25, 3500);
            putToken();
            turn(-0.25, 875);
            drive(-0.5, 6000);

            //land();
            //drive(0.25, 640);
            //turn(0.25, 1750);
            //drive(0.25, );
            //turn(0.25, );
            //drive(-0.25, )
            //turn(0.25, );
            //drive(0.25,);
            //putToken();
            //drive(-0.25);
        }
    }
    public void turn(double power, int milliseconds){

        frontRight.setPower(power);
        frontLeft.setPower(-power);
        backLeft.setPower(-power);
        backRight.setPower(power);

        sleep(milliseconds);

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        sleep(500);

    }


    public void drive(double power, int milliseconds){

        frontRight.setPower(power);
        frontLeft.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);

        sleep(milliseconds);

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        sleep(500);

    }

    public void driveSide(double power, int milliseconds){

        frontRight.setPower(-power);
        frontLeft.setPower(power);
        backLeft.setPower(-power);
        backRight.setPower(power);

        sleep(milliseconds);

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        sleep(500);

    }

    public void putToken(){
        grabber.setPower(0.8);
        sleep(1000);
    }

    public void land(){
        rack.setPower(-1);
        sleep(3300);
        drive(0.25, 200);
        rack.setPower(1);
        sleep(2000);
        rack.setPower(0);
        sleep(500);
    }

}