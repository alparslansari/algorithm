package leetcode.problems;

public class _67AddBinaryTester {
    public static void main(String[] args) {
        _67AddBinaryv1 tester1 = new _67AddBinaryv1();
        String bit1 = "11";
        String bit2 = "1";
        String expected = "100";
        String result = tester1.addBinary(bit1, bit2);
        if(expected.equals(result))
            System.out.println("Tester1 is passed");
        else
            System.out.println("Tester1 is failed: expected="+expected
            +" output="+result);

        bit1 = "1010";
        bit2 = "1011";
        expected = "10101";
        result = tester1.addBinary(bit1, bit2);
        if(expected.equals(result))
            System.out.println("Tester1 is passed");
        else
            System.out.println("Tester1 is failed: expected="+expected
                    +" output="+result);
    }
}
