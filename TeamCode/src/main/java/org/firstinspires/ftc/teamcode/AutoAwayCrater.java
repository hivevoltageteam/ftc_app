package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="AutoAwayCrater", group="Linear Opmode")
//@Disabled
public class AutoAwayCrater extends LinearOpMode {

       private DcMotor frontLeft;
       private DcMotor frontRight;
       private DcMotor backLeft;
       private DcMotor backRight;
       private DcMotor rackAndPinion;
       private DcMotor slide;
       private DcMotor grabber;

       final double DEFAULT_POWER = 0.5;

       public void turnLeft(double power, int milliseconds) {
         frontLeft.setPower(-power);
         backLeft.setPower(-power);
         frontRight.setPower(power);
         backRight.setPower(power);
         sleep(milliseconds);
         frontLeft.setPower(0);
         backLeft.setPower(0);
         frontRight.setPower(0);
         backRight.setPower(0);
         sleep(800);
       }

       public void turnRight(double power, int milliseconds) {
         frontLeft.setPower(power);
         backLeft.setPower(power);
         frontRight.setPower(-power);
         backRight.setPower(-power);
         sleep(milliseconds);
         frontLeft.setPower(0);
         backLeft.setPower(0);
         frontRight.setPower(0);
         backRight.setPower(0);
         sleep(800);
       }

       public void driveForwards(double power, int milliseconds){
         frontLeft.setPower(power);
         backLeft.setPower(power);
         frontRight.setPower(power);
         backRight.setPower(power);
         sleep(milliseconds);
         frontLeft.setPower(0);
         backLeft.setPower(0);
         frontRight.setPower(0);
         backRight.setPower(0);
         sleep(800);
       }

       public void driveBackward(double power, int milliseconds) {
         frontLeft.setPower(-power);
         backLeft.setPower(-power);
         frontRight.setPower(-power);
         backRight.setPower(-power);
         sleep(milliseconds);
         frontLeft.setPower(0);
         backLeft.setPower(0);
         frontRight.setPower(0);
         backRight.setPower(0);
         sleep(800);
       }


       public void slideRight(double power, int milliseconds) {
         frontLeft.setPower(power);
         backLeft.setPower(-power);
         frontRight.setPower(-power);
         backRight.setPower(power);
         sleep(milliseconds);
         frontLeft.setPower(0);
         backLeft.setPower(0);
         frontRight.setPower(0);
         backRight.setPower(0);
         sleep(800);
       }

       public void slideLeft(double power, int milliseconds) {
         frontLeft.setPower(-power);
         backLeft.setPower(power);
         frontRight.setPower(power);
         backRight.setPower(-power);
         sleep(milliseconds);
         frontLeft.setPower(0);
         backLeft.setPower(0);
         frontRight.setPower(0);
         backRight.setPower(0);
         sleep(800);
        }
}