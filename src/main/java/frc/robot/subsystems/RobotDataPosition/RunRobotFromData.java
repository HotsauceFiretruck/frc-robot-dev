package frc.robot.subsystems.RobotDataPosition;

//untested
public class RunRobotFromData {
    public RunRobotFromData(String filePath) throws Exception {
        ReadRobotData reader = new ReadRobotData(filePath);
    }

    /*
       operationType:
                      0 = target x-position
                      1 = target y-position
       Ask Dustin to turn these into enums! ReadRobotData
   */
    public void update()
    {
        /*
        if current operation is finished:
            read distance, direction, x-position, y-position
            turn robot to direction
                ** leaving this note to remind myself! **
                Regarding 'turn robot to direction':
                - I don't think that gyroscope is even necessary,
                  we can calculate direction or even velocity
                  from previous x and y position and it would probably be more accurate.
                  However, just in case lets leave this here for now.
            run robot until distance is reached
         */

        if (this.isOperationFinished())
        {
               
        }
    }

    private boolean isOperationFinished()
    {
        /*
            operation is finished when current distance == data distance.
         */
        return false;
    }
}