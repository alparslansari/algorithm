package leetcode.utilities;

public class TesterHelper {

    public boolean check(int expected, int output)
    {
        if(expected == output) {
            System.out.println("Test1 is passed.");
            return true;
        } else
        {
            System.out.println("Test1 is failed.");
            return false;
        }

    }
}
