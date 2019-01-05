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

@TeleOp(name="TeleOp4890Inspection", group="Linear Opmode")
//@Disabled
public class TeleOp4890 extends LinearOpMode {

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
        //grabber.setDirection(DcMotor.Direction.FORWARD);
        //flipper = hardwareMap.get(DcMotor.class, "flipper");


//            ////////////////////////////////////
//            //3.5
//            backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//            //this is the amount of inches the motor travels per 1440/tick
//            double inchesPerTick = 0.027;
//            // turns is equal to the amount of turns
//            // required to achieved the amount of inches required
//            // ~ that is what she said
//            double turns = (inches * inchesPerTick);
//
//            //double circumference = 3.14 * 8.89;
//            //double rotationsNeeded = turns/circumference;
//            double offset = 0.6;
//            int tick = 1440;
//            int encoderDrivingTarget = (int)(tick * turns);
//
//            frontRight.setTargetPosition(encoderDrivingTarget);
//
//            frontRight.setPower(power);
//
//            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//            /////////////////////////////////

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

//                if(gamepad1.y){
//                    rack.setPower(1);
//                }else if(gamepad1.a){
//                    rack.setPower(-1);
//                }else{
//                    rack.setPower(0);
//                }

//                if(gamepad1.y){
//                        rack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//                        int encoderDrivingTarget = (int)(538 * 3.5);
//
//                        rack.setTargetPosition(encoderDrivingTarget);
//
//                        rack.setPower(0.5);
//
//                        rack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//                }else if(gamepad1.a){
//                        rack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//                        int encoderDrivingTarget = (int) (538 * 3.5);
//
//                        rack.setTargetPosition(-encoderDrivingTarget);
//
//                        rack.setPower(0.5);
//
//                        rack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
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

                if(gamepad1.right_bumper){
                    flipper.setPower(1);
                }else if(gamepad1.left_bumper){
                    flipper.setPower(-1);
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