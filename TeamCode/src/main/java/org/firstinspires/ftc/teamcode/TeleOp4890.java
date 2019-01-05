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

@TeleOp(name="TeleOp4890Compwifi", group="Linear Opmode")
//@Disabled
public class TeleOp4890Wifi extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor rack;
    private DcMotor slide;
    private DcMotor grabber;
    private DcMotor flipper;

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
        slide = hardwareMap.get(DcMotor.class, "slide");
        grabber = hardwareMap.get(DcMotor.class, "grabber");
        flipper = hardwareMap.get(DcMotor.class, "flipper");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.FORWARD);
        rack.setDirection(DcMotor.Direction.FORWARD);
        slide.setDirection((DcMotor.Direction.FORWARD));
        grabber.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            rightPower = gamepad1.right_stick_y;
            leftPower = gamepad1.left_stick_y;

            if(gamepad1.dpad_right){
                frontRight.setPower(0.6);
                frontLeft.setPower(-0.6);
                backLeft.setPower(0.6);
                backRight.setPower(-0.6);
            }else if(gamepad1.dpad_left) {
                frontRight.setPower(-0.6);
                frontLeft.setPower(0.6);
                backLeft.setPower(-0.6);
                backRight.setPower(0.6);
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

            if(gamepad1.dpad_up){
                slide.setPower(1);
            }else if(gamepad1.dpad_down){
                slide.setPower(-1);
            }else{
                slide.setPower(0);
            }

            if(gamepad1.right_trigger > 0){
                flipper.setPower(0.5);
            }else if(gamepad1.left_trigger > 0){
                flipper.setPower(-0.5);
            }else{
                flipper.setPower(0);
            }

            if(gamepad1.x){
                grabber.setPower(1);
            }else if(gamepad1.b){
                grabber.setPower(-1);
            }else{
                grabber.setPower(0);
            }


            frontLeft.setPower((0.6)*leftPower);
            frontRight.setPower((0.6)*rightPower);
            backLeft.setPower((0.6)*leftPower);
            backRight.setPower((0.6)*rightPower);

        }
    }
}