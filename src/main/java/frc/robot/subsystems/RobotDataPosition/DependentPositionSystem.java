package frc.robot.subsystems.RobotDataPosition;
// The heart of the robot data position system

// Every position calculations are dependent on the last position
// If you've worked on A-Western-Story, you will realized that this is
// the same math I used for the bullet entity class.

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.SPI;

public class DependentPositionSystem {
    private static double[] previousGlobalPosition = new double[]{0.0, 0.0};;
    private static double[] currentGlobalPosition = new double[]{0.0, 0.0};;
    public static final Gyro gyro = new ADXRS450_Gyro(SPI.Port.kMXP);
    public static final Encoder encoder1 = new Encoder(0, 1);
    public static final Encoder encoder2 = new Encoder(2, 3);
    
    public static void init()
    {
        encoder1.reset();
        encoder2.reset();
        encoder1.setDistancePerPulse((6.0 * Math.PI) / 1440.0);
        encoder2.setDistancePerPulse((6.0 * Math.PI) / 1440.0);
    }

    private static double[] getRelativePosition(double direction, double distance)
    {
        double normalizedX = Math.cos(direction);
        double normalizedY = Math.sin(direction);
        double relativeX = normalizedX * distance;
        double relativeY = normalizedY * distance;
        return new double[]{relativeX, relativeY};
    }

    public static double[] getGlobalPosition(double direction, double distance)
    {
        /*
            ** leaving this here to remind myself **
            - We can get the global position relative to 0, 0.
            - However, this is dependent on previous position.
            - Therefore, if the previous position is slightly off,
              then our calculation's mistake will be magnified.
            - I'm hoping that the field is small enough that this will not
              be an issue.
            - However, if the issue arise, my plan is to create a 2D representation
              of the field and do the calculation in accordance to that field.
            - But this will require EFFORT and MENTAL STABILITY.
        */
        double[] relativePosition = getRelativePosition(direction, distance);
        previousGlobalPosition[0] = currentGlobalPosition[0] = previousGlobalPosition[0] + relativePosition[0];
        previousGlobalPosition[1] = currentGlobalPosition[1] = previousGlobalPosition[1] + relativePosition[1];

        encoder1.reset();
        encoder2.reset();
        
        return currentGlobalPosition;
    }

    public static double[] getDirectionAndDistance(double curXPos, double curYPos, double tarXPos, double tarYPos)
    {
        double distX = tarXPos - curXPos;
        double distY = tarYPos - curYPos;
        double magnitude = Math.sqrt(distX * distX + distY * distY);
        double normalizeX = 0;
        double normalizeY = 0;

        if (magnitude > 0)
        {
            normalizeX = distX / magnitude;
            normalizeY = distY / magnitude;
        } else
        {
            normalizeX = 1;
        }

        double radians = Math.atan2(normalizeY, normalizeX);
        double degrees = Math.toDegrees(radians);

        return new double[]{degrees, magnitude};
    }
}