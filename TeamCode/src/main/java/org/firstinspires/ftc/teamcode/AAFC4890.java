/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;



/*

Things to do:
- Write a method to return the color value
- Write Auto
- Test Auto
- Write TeleOp
 */


@Autonomous(name="AAFC4890wifi", group="")
//@Disabled
public class AAFC4890wifi extends LinearOpMode {

    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor rack;
    private DcMotor slide;
    private DcMotor grabber;
    private DcMotor flipper;

    private ColorSensor colorSensorBackRight;
    private ColorSensor colorSensorBackLeft;

    @Override
    public void runOpMode() {

        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        rack = hardwareMap.get(DcMotor.class, "rackAndPinion");
        grabber = hardwareMap.get(DcMotor.class, "grabber");
        flipper = hardwareMap.get(DcMotor.class, "flipper");

        colorSensorBackRight = hardwareMap.get(ColorSensor.class, "csbr");
        colorSensorBackLeft = hardwareMap.get(ColorSensor.class, "csbl");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.FORWARD);
        rack.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        if(opModeIsActive()) {

//                telemetry.addData("Red: ", colorSensorBackRight.red());
//                telemetry.addData("Green: ", colorSensorBackRight.green());
//                telemetry.addData("Blue: ", colorSensorBackRight.blue());
//                telemetry.addData("Alpha: ", colorSensorBackRight.alpha());
//                telemetry.addData("ARGB: ", colorSensorBackRight.argb());
//
//                telemetry.addData("Red: ", colorSensorBackLeft.red());
//                telemetry.addData("Green: ", colorSensorBackLeft.green());
//                telemetry.addData("Blue: ", colorSensorBackLeft.blue());
//                telemetry.addData("Alpha: ", colorSensorBackRight.alpha());
//                telemetry.addData("ARGB: ", colorSensorBackRight.argb());

            drive(0.5, 10);

            // land();drive(0.5, 0);
            // turn(0.5, 180);
            // drive(0.5, 0);
            // sleep(500);
            // driveSide(0.5, -0);
            // sleep(500);
            // if(colorSensorBackLeft.blue() < colorSensorBackRight.blue()){
            //     driveSide(0.5, 0);
            //     sleep(500);
            //     drive(0.5, 0);
            //     sleep(500);
            //     drive(0.5, -0);
            //     sleep(500);
            //     turn(0.5, 180);
            //     sleep(500);
            //     drive(0.5, -0);
            //     sleep(500);
            //     attach();
            // }else{
            //     drive(0.5, 0);
            //     sleep(500);
            //     turn(0.5, 45);
            //     sleep(500);
            //     drive(0.5, 0);
            //     putToken();
            //     turn(0.5, -45);



            // }

            telemetry.update();
        }

    }

    public void drive(double power, double inches){

        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //this is the amount of inches the motor travels per 1440/tick
        double inchesPerTick = 0.028;
        // turns is equal to the amount of turns
        // required to achieved the amount of inches required
        // ~ that is what she said
        double turns = (inches * inchesPerTick);

        //double circumference = 3.14 * 8.89;
        //double rotationsNeeded = turns/circumference;
        double offset = 0.6;
        int tick = 1440;
        int encoderDrivingTarget = (int)(tick * turns);

        frontRight.setTargetPosition((int)(encoderDrivingTarget));
        frontLeft.setTargetPosition((int)(encoderDrivingTarget));
        backRight.setTargetPosition((int)(encoderDrivingTarget));
        backLeft.setTargetPosition((int)(encoderDrivingTarget));

        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setPower(-power);
        frontLeft.setPower(power);
        backRight.setPower(-power);
        backLeft.setPower(power);

        while(frontRight.isBusy() && frontLeft.isBusy()
                && backRight.isBusy() && backLeft.isBusy()){
            telemetry.addData("Path", "Driving " + " inches");
            telemetry.update();
        }

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);

//        double stopping = 1;
//        while(stopping > 0) {
//            frontRight.setPower(power * stopping);
//            frontLeft.setPower(-power * stopping);
//            backRight.setPower(power * stopping);
//            backLeft.setPower(-power * stopping);
//            sleep(100);
//            stopping -= 0.1;
//        }

        telemetry.addData("Path", "Complete");
        telemetry.update();

    }

    public void turn(double power, double degrees){

        double inches;
        double inchesPerTick;
        double turns;
        double offset;
        double stopping;
        double TEMPdegrees;
        int tick;
        int encoderDrivingTarget;


        while(degrees > 0){

            if(degrees > 90){
                TEMPdegrees = 90;
            }
            else{
                TEMPdegrees = degrees;
            }

            inches = TEMPdegrees * 0.24;

            inchesPerTick = 0.027;

            turns = (inches * inchesPerTick);

            offset = 0.6;
            tick = 1440;
            encoderDrivingTarget = (int)(tick * turns);

            frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            frontRight.setTargetPosition((int)(-encoderDrivingTarget));
            frontLeft.setTargetPosition((int)(encoderDrivingTarget));
            backRight.setTargetPosition((int)(-encoderDrivingTarget));
            backLeft.setTargetPosition((int)(encoderDrivingTarget));

            frontRight.setPower(power);
            frontLeft.setPower(-power);
            backRight.setPower(power);
            backLeft.setPower(-power);

            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            //        while(frontRight.isBusy() && frontLeft.isBusy()
            //                && backRight.isBusy() && backLeft.isBusy()){
            //            telemetry.addData("Path", "Driving " + " inches");
            //            telemetry.update();
            //        }

            stopping = 1;
            while(stopping > 0) {
                frontRight.setPower(power * stopping);
                frontLeft.setPower(-power * stopping);
                backRight.setPower(power * stopping);
                backLeft.setPower(-power * stopping);
                sleep(100);
                stopping -= 0.1;
            }

            degrees -= 90;
        }

        telemetry.addData("Path", "Complete");
        telemetry.update();
    }

    public void driveSide(double power, double inches){

        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //this is the amount of inches the motor travels per 1440/tick
        double inchesPerTick = 0.027;
        // turns is equal to the amount of turns
        // required to achieved the amount of inches required
        // ~ that is what she said
        double turns = (inches * inchesPerTick);

        //double circumference = 3.14 * 8.89;
        //double rotationsNeeded = turns/circumference;
        double offset = 0.6;
        int tick = 1440;
        int encoderDrivingTarget = (int)(tick * turns);

        frontRight.setTargetPosition((int)(encoderDrivingTarget));
        frontLeft.setTargetPosition((int)(-encoderDrivingTarget));
        backRight.setTargetPosition((int)(-encoderDrivingTarget));
        backLeft.setTargetPosition((int)(encoderDrivingTarget));

        frontRight.setPower(power);
        frontLeft.setPower(-power);
        backRight.setPower(power);
        backLeft.setPower(-power);

        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(frontRight.isBusy() && frontLeft.isBusy()
                && backRight.isBusy() && backLeft.isBusy()){
            telemetry.addData("Path", "Driving " + " inches");
            telemetry.update();
        }

        double stopping = 1;
        while(stopping > 0) {
            frontRight.setPower(power * stopping);
            frontLeft.setPower(-power * stopping);
            backRight.setPower(-power * stopping);
            backLeft.setPower(power * stopping);
            sleep(100);
            stopping -= 0.1;
        }
        telemetry.addData("Path", "Complete");
        telemetry.update();

    }

    public void land(){
        rack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rack.setTargetPosition((int)(538 * 0));

        rack.setPower(1);

        rack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        rack.setPower(0);

        drive(0.5, 5);

        rack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rack.setTargetPosition(-(int)(538 * 0));

        rack.setPower(-1);

        rack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        rack.setPower(0);

    }

    public void putToken(){
        flipper.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        flipper.setTargetPosition(-(int)(538 * 0));

        flipper.setPower(1);

        flipper.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        flipper.setPower(0);


        flipper.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        flipper.setTargetPosition(-(int)(538 * 0));

        flipper.setPower(-1);

        flipper.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        flipper.setPower(0);
    }

    public void attach(){

        rack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rack.setTargetPosition(-(int)(538 * 0));

        rack.setPower(-1);

        rack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        rack.setPower(0);

    }

}
