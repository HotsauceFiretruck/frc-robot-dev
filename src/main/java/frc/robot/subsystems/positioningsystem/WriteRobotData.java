package frc.robot.subsystems.positioningsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteRobotData {
    BufferedWriter writer;
    private ArrayList<double[]> data;

    public WriteRobotData()
    { }

    public void update()
    {
        /*
        if robot is turning:
            get Gyroscope Recordings
            get Encoding Recordings
            ** leaving this here to remind myself **
            - If I'm right about this, the gyroscope will return a global direction,
              and it will be in degrees.
            - I'm praying to the robotics god that the encoding will work the way I expected,
              which is to return a value indicating how far the thing have gone,
              and I'm praying that we can reset encoding to 0.
              This is my poison.
              !!! magnitude will be encoding value, whatever it may be.
            data add DependentPositionSystem.getGlobalPosition
         */
    }

    private void recordData() throws IOException {
        File file = new File("C:/RobotDataPosition.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        writer = new BufferedWriter(new FileWriter(file));
        writer.write(data.size());
        for (int i = 0; i < data.size(); i++)
        {
            writer.write(Double.toString(data.get(i)[0]) + Double.toString(data.get(i)[1]));
        }
        writer.close();
    }
}