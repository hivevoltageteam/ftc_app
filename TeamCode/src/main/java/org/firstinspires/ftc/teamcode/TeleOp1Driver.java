package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="TeleOp1Driver", group="")
//@Disabled
public class TeleOp1Driver extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor flipper;
    private DcMotor bucket;
    private DcMotor latcher;
    private DcMotor arm;

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
        flipper  = hardwareMap.get(DcMotor.class, "flipper");
        bucket = hardwareMap.get(DcMotor.class, "bucket");
        latcher = hardwareMap.get(DcMotor.class, "latcher");
        arm = hardwareMap.get(DcMotor.class, "arm");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.FORWARD);
        flipper.setDirection(DcMotor.Direction.FORWARD);
        bucket.setDirection(DcMotor.Direction.FORWARD);
        latcher.setDirection(DcMotor.Direction.FORWARD);
        arm.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            rightPower = gamepad1.right_stick_y;
            leftPower = gamepad1.left_stick_y;

            frontLeft.setPower(leftPower);
            frontRight.setPower(rightPower);
            backLeft.setPower(leftPower);
            backRight.setPower(rightPower);

            if(gamepad1.dpad_up){
                latcher.setPower(1);
            }else if(gamepad1.dpad_down){
                latcher.setPower(-1);
            }else{
                latcher.setPower(0);
            }

            if(gamepad1.y){
                bucket.setPower(1);
            }else if(gamepad1.a){
                bucket.setPower(-1);
            }else{
                bucket.setPower(0);
            }

            if(gamepad1.right_bumper){
                arm.setPower(1);
            }else if(gamepad1.left_bumper){
                arm.setPower(-1);
            }else{
                arm.setPower(0);
            }

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

        }
    }

}