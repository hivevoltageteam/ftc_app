package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.teamcode.R;


@Autonomous(name = "Vuforia")
public class HopeVuforiaWorks extends LinearOpMode {

    VuforiaLocalizer vuforiaLocalizer;
    VuforiaLocalizer.Parameters parameters;
    VuforiaTrackables visionTargets;
    VuforiaTrackable target;
    VuforiaTrackableDefaultListener listener;

    OpenGLMatrix lastKnownLocation;
    OpenGLMatrix phoneLocation;

    public static final String VUFORIA_KEY = "AYI8I2T/////AAABmcGuVH/R50l2vwdWKHNUFHGOO85LO6wfEi+" +
            "ruslSPW4m7sWGRj9cGcEHgAyaewm8dJ8O49vIGsoSxRKMWobSHaQZtXyriMPGjCUCjSHvnCDDHlk3a1yvfuWn04" +
            "yEJCaiOCsvyL74+ym7ZAwG6uqmtm0ZieVgesYNAsZiP4+fnWdVcHxvvqGRNrKKLbvHpMLYSgHnlTeUJn74S6KruDD+" +
            "NrO74Sx8SG4Al0uqOdfIhz/TEGRE0kaSOvFxxI2mDOY15ah7D7p+Lkxm4S6DSWoyNs2Z997SgfVSofHhatyIXBpGY" +
            "joerVmNQ/CRPQMNZ4nSZwC+0e700Wlw7L5jO1ELPrwMtQagJgGn6tkOqAaHsEXg";

    public void runOpMode() throws InterruptedException
    {
        setupVuforia();

        lastKnownLocation = createMatrix(0, 0, 0, 0, 0, 0);

        waitForStart();

        visionTargets.activate();

        waitForStart();

        while(opModeIsActive()){
            OpenGLMatrix latestLocation = listener.getUpdatedRobotLocation();

            if(latestLocation != null) {
                lastKnownLocation = latestLocation;
            }

            telemetry.addData("Tracking " + target.getName(), listener.isVisible());
            telemetry.addData("Last Known Location", formatMatrix(lastKnownLocation));

            telemetry.update();
            idle();
        }
    }

    public void setupVuforia(){
        parameters = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);
        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        vuforiaLocalizer = ClassFactory.createVuforiaLocalizer(parameters);

        //visionTargets = vuforiaLocalizer.loadTrackablesFromAsset(""); //File with images we want to track

        target = visionTargets.get(0);
        target.setName("Wheels Target"); //We can add this string later
        target.setLocation(createMatrix(0, 0, 0, 0, 0, 0));

        phoneLocation = createMatrix(0, 0, 0, 0, 0, 0);

        listener = (VuforiaTrackableDefaultListener) target.getListener();
        listener.setPhoneInformation(phoneLocation, parameters.cameraDirection);
    }

    public OpenGLMatrix createMatrix(float x, float y, float z, float u, float v, float w){
        return OpenGLMatrix.translation(x, y, z).
                multiplied(Orientation.getRotationMatrix(
                        AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES, u, v, w));
    }

    public String formatMatrix(OpenGLMatrix matrix){
        return matrix.formatAsTransform();
    }
}