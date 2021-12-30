package leetcode.utilities;

public class TesterHelper {

    public static final String PASSED = "Test is passed.";
    public static final String FAILED = "Test is failed.";

    public boolean check(int expected, int output)
    {
        if(expected == output) {
            print(PASSED,expected,output);
            return true;
        } else
        {
            print(FAILED,expected,output);
            return false;
        }

    }

    public boolean check(String expected, String output)
    {
        if(expected.equals(output)) {
            print(PASSED,expected,output);
            return true;
        } else
        {
            print(FAILED,expected,output);
            return false;
        }

    }

    private <T> void print(String msg, T expected, T output){
        System.out.println(msg+" Expected="+expected+" Output="+output);
    }
}