package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="MainTeleOp4890wifi", group="Linear Opmode")
@Disabled
public class MainTeleOp4890wifi extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor rack;
    private DcMotor grabber;
    private DcMotor flipper;
    private DcMotor flipper2;

    double rightPower;
    double leftPower;

    @Override
    public void runOpMode() {
        telemetry.addData(".", ".");

        telemetry.update();

        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft  = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        rack = hardwareMap.get(DcMotor.class, "rackAndPinion");
        grabber = hardwareMap.get(DcMotor.class, "grabber");
        flipper = hardwareMap.get(DcMotor.class, "flipper");
        flipper2 = hardwareMap.get(DcMotor.class, "flipper2");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.FORWARD);
        rack.setDirection(DcMotor.Direction.FORWARD);
        grabber.setDirection(DcMotor.Direction.FORWARD);
        flipper.setDirection(DcMotor.Direction.FORWARD);
        flipper2.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            rightPower = gamepad1.right_stick_y;
            leftPower = gamepad1.left_stick_y;

            if(gamepad1.dpad_right){
                frontRight.setPower(1);
                frontLeft.setPower(-1);
                backLeft.setPower(1);
                backRight.setPower(-1);
            }else if(gamepad1.dpad_left) {
                frontRight.setPower(-1);
                frontLeft.setPower(1);
                backLeft.setPower(-1);
                backRight.setPower(1);
            }else{
                frontRight.setPower(0);
                frontLeft.setPower(0);
                backLeft.setPower(0);
                backRight.setPower(0);
            }

            if(gamepad1.y){
                rack.setPower(1);
            }else if(gamepad1.a) {
                rack.setPower(-1);
            }else{
                rack.setPower(0);

            }

            // if(gamepad1.dpad_up){
            //     flipper.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            //     flipper2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            //     flipper.setTargetPosition(1440);
            //     flipper.setTargetPosition(1440);

            //     flipper.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            //     flipper2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            //     flipper.setPower(0.8);
            //     flipper2.setPower(0.8);
            // }else if(gamepad1.dpad_down){
            //     flipper.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            //     flipper2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            //     flipper.setTargetPosition(-1440);
            //     flipper.setTargetPosition(-1440);

            //     flipper.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            //     flipper2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            //     flipper.setPower(0.8);
            //     flipper2.setPower(0.8);
            // }else{
            //     flipper.setPower(0);
            //     flipper2.setPower(0);
            // }

            if(gamepad1.left_bumper){
                grabber.setPower(1);
            }else if(gamepad1.right_bumper){
                grabber.setPower(-1);
            }else{
                grabber.setPower(0);
            }

            if(gamepad1.dpad_up){
                flipper.setPower(-0.8);
                flipper2.setPower(-0.8);
            }else if(gamepad1.dpad_down){
                flipper.setPower(0.8);
                flipper2.setPower(0.8);
            }else{
                flipper.setPower(0);
                flipper2.setPower(0);
            }


            frontLeft.setPower(leftPower);
            frontRight.setPower(rightPower);
            backLeft.setPower(leftPower);
            backRight.setPower(rightPower);

        }
    }

}