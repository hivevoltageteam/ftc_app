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


@Autonomous(name="AAFCTime", group="")
//@Disabled
public class TemporaryAuto extends LinearOpMode {

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

        colorSensorBackLeft = hardwareMap.get(ColorSensor.class, "csbr");
        colorSensorBackRight = hardwareMap.get(ColorSensor.class, "csbl");

        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.REVERSE);
        rack.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        if(opModeIsActive()) {

            land();
            driveForward(0.25, 4000);
            putToken();
            turnRight(0.25, 2500); //135 degrees
            driveForward(0.25, 10000);
            /*
            land();
            driveForward(0.25, 0); //d
            turnLeft(0.25 , 0); //180
            driveForward(0.25, 0); //e
            sideRight(0.25, 0); //b
            if(colorSensorBackRight.blue() > colorSensorBackLeft.blue()) {
                sideRight(0.25, 0); //c
                driveBackward(0.25, 0); //a
                turnLeft(0.25, 0); //135 degrees
                putToken();
                turnLeft(0.25, 0); //45 degrees
                driveBackward(0.25, 0); //a
                sideRight(0.25, 0); //b + c
                driveBackward(0.25, 0); //d + e
                attach();
            }else{
                sideLeft(0.25, 0);
                driveBackward(0.25, 0); //g
                turnLeft(0.25, 0); //180 degrees
                putToken();
                driveBackward(0.25, 0); //d + e + g
                attach();
            }
            */
        }

    }

    public void driveForward(double power, int milliseconds){

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

    public void driveBackward(double power, int milliseconds){

        //int milliseconds = inches * 0;

        frontRight.setPower(-power);
        frontLeft.setPower(-power);
        backLeft.setPower(-power);
        backRight.setPower(-power);

        sleep(milliseconds);

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        sleep(500);

    }

    public void turnLeft(double power, int milliseconds){

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

    public void turnRight(double power, int milliseconds){

        frontRight.setPower(-power);
        frontLeft.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(-power);
        sleep(milliseconds);
        frontRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    public void sideLeft(double power, int milliseconds){

        frontRight.setPower(power);
        frontLeft.setPower(-power);
        backLeft.setPower(power);
        backRight.setPower(-power);

        sleep(milliseconds);

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        sleep(500);

    }

    public void sideRight(double power, int milliseconds){

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
        grabber.setPower(0.25);
        sleep(500);
    }

    public void land(){
        rack.setPower(0.5);
        sleep(1000);
        rack.setPower(-0.5);
        sleep(500);
        //driveForward(0.5, 0);
        //sleep(500);
    }

    public void attach(){
        rack.setPower(1);
        sleep(500);
        rack.setPower(1);
        sleep(500);
    }

}
