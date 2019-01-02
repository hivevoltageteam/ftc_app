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

@TeleOp(name="TeleOp4890", group="Linear Opmode")
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

        double rightPower;
        double leftPower;

        double rackPower = 1;

        @Override
        public void runOpMode() {
            telemetry.addData(".", ".");

            telemetry.update();

            frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
            frontRight = hardwareMap.get(DcMotor.class, "frontRight");
            backLeft  = hardwareMap.get(DcMotor.class, "backLeft");
            backRight = hardwareMap.get(DcMotor.class, "backRight");
            rack = hardwareMap.get(DcMotor.class, "rackAndPinion");
            //slide = hardwareMap.get(DcMotor.class, "slide");
            //grabber = hardwareMap.get(DcMotor.class, "grabber");
            //colorSensor = hardwareMap.get(ModernRoboticsI2cColorSensor.class, "colorSensor");

            frontLeft.setDirection(DcMotor.Direction.REVERSE);
            frontRight.setDirection(DcMotor.Direction.FORWARD);
            backLeft.setDirection(DcMotor.Direction.REVERSE);
            backRight.setDirection(DcMotor.Direction.FORWARD);
            rack.setDirection(DcMotor.Direction.FORWARD);
            //slide.setDirection((DcMotor.Direction.FORWARD));
            //grabber.setDirection(DcMotor.Direction.FORWARD);

            waitForStart();
            runtime.reset();

            while (opModeIsActive()) {

                rightPower = gamepad1.right_stick_y;
                leftPower = gamepad1.left_stick_y;

                frontLeft.setPower((0.6)*leftPower);
                frontRight.setPower((0.6)*rightPower);
                backLeft.setPower((0.6)*leftPower);
                backRight.setPower((0.6)*rightPower);

                if(gamepad1.dpad_right){
                    frontRight.setPower(-0.6);
                    frontLeft.setPower(-0.6);
                    backLeft.setPower(0.6);
                    backRight.setPower(0.6);
                }else if(gamepad1.dpad_left) {
                    frontRight.setPower(0.6);
                    frontLeft.setPower(0.6);
                    backLeft.setPower(-0.6);
                     backRight.setPower(-0.6);
                }

                if(gamepad1.y){
                    rack.setPower(rackPower);
                }else if(gamepad1.a){
                    rack.setPower(-rackPower);
                }else{
                    rack.setPower(0);
                }

//            if(gamepad1.right_bumper){
//                slide.setPower(1);
//            }else if(gamepad1.left_bumper){
//                slide.setPower(-1);
//            }else{
//                slide.setPower(0);
//            }

                telemetry.addData("Status", "Run Time: " + runtime.toString());
                telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
                telemetry.update();
            }
        }
    }