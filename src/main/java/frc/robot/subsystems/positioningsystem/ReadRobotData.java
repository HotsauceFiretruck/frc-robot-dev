package frc.robot.subsystems.positioningsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//***********Please document */
public class ReadRobotData {    
    private double[][] data;
    private int numberOfOperations;

    public ReadRobotData(String filePath) throws Exception
    {
        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        numberOfOperations = Integer.parseInt(reader.readLine()); //the first line tell us how many lines there are
        data = new double[numberOfOperations][];

        for (int i = 0; i < numberOfOperations; i++ )
        {
            data[i] = parseData(reader.readLine());
        }

        reader.close();
    }

    private double[] parseData(String str)
    {
        String[] doubleStrings = str.split(" ");
        double[] doubles= new double[doubleStrings.length];
        // Creates the integer array.
        for (int i = 0; i < doubles.length; i++){
            doubles[i] = Double.parseDouble(doubleStrings[i]);
        }
        return doubles;
    }

    /*
        operationType: 0 = nextTargetXPosition
                       1 = nextTargetYPosition
        Ask Dustin to turn these into enums!
    */
    public double getOperation(int operationNumber, int operationType)
    {
        return data[operationNumber][operationType];
    }
}