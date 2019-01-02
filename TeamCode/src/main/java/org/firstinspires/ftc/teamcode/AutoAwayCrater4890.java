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

@Autonomous(name="AutoAwayCrater4890", group="Linear Opmode")
//@Disabled
public class AutoAwayCrater4890 extends LinearOpMode {

       private DcMotor frontLeft;
       private DcMotor frontRight;
       private DcMotor backLeft;
       private DcMotor backRight;
       private DcMotor rackAndPinion;
       private DcMotor slide;
       private DcMotor grabber;

       //colorSensor
       public ModernRoboticsI2cColorSensor rightColorSensor = null;
       HardwareMap hwMap = null;

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

       public void init(HardwareMap ahwMap) {
         hwMap = ahwMap;
         rightColorSensor = hwMap.get(ModernRoboticsI2cColorSensor.class, "sensor_color");
       }

       @Override
       public void runOpMode() {
         telemetry.addData("Status", "Initialized");
         telemetry.update();

         frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
         frontRight = hardwareMap.get(DcMotor.class, "frontRight");
         backLeft  = hardwareMap.get(DcMotor.class, "backLeft");
         backRight = hardwareMap.get(DcMotor.class, "backRight");
         rackAndPinion = hardwareMap.get(DcMotor.class, "rackAndPinion");
         slide = hardwareMap.get(DcMotor.class, "slide");
         grabber = hardwareMap.get(DcMotor.class, "grabber");

         frontLeft.setDirection(DcMotor.Direction.FORWARD);
         frontRight.setDirection(DcMotor.Direction.REVERSE);
         backLeft.setDirection(DcMotor.Direction.FORWARD);
         backRight.setDirection(DcMotor.Direction.REVERSE);
         rackAndPinion.setDirection(DcMotor.Direction.FORWARD);
         slide.setDirection(DcMotor.Direction.FORWARD);
         grabber.setDirection(DcMotor.Direction.FORWARD);

       waitForStart();
<<<<<<< HEAD
       //landRobot();
=======
       slideRight();
       robot.frontColorSensor.enabled(true);
       while (opModeIsActive()) {
           telemetry.addData("Color Number", robot.frontColorSensor.readUnsignedByte(ModernRoboticsI2cColorSensor.Register.COLOR_NUMBER));
           telemetry.update();
       }
>>>>>>> e93748e64335f0dc29010f18a463292f5835c374
       }
}