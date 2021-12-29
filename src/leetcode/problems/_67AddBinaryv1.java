package leetcode.problems;

public class _67AddBinaryv1 {
    private int bitOp(char a, char b, int reminder)
    {
        if(a == '0' && b == '0')
        {
            if(reminder == 0) return 0;
            else return 1;
        }
        else if( (a=='0' && b=='1') || (a=='1' && b=='0'))
        {
            if(reminder == 0) return 1;
            else return 2;
        }
        else if(a=='1' && b=='1')
        {
            if(reminder == 0) return 2;
            else return 3;
        }
        return 0;
    }

    private String helper(String longest, String shortest)
    {
        char[] arr1 = longest.toCharArray();
        char[] arr2 = shortest.toCharArray();
        String result="";
        int reminder = 0;
        for(int i=0;i<shortest.length();i++)
        {
            int temp = bitOp(arr1[arr1.length-i-1], arr2[arr2.length-i-1], reminder);
            if(temp==0) {
                result = "0" + result;
                reminder = 0;
            }
            else if(temp==1) {
                result = "1" + result;
                reminder = 0;
            }
            else if(temp==2){
                result = "0" + result;
                reminder = 1;
            } else {
                result = "1" + result;
                reminder = 1;
            }
        }

        for(int i=shortest.length(); i<longest.length();i++)
        {
            int temp = bitOp(arr1[arr1.length-i-1], '0', reminder);
            if(temp==0) {
                result = "0" + result;
                reminder = 0;
            }
            else if(temp==1) {
                result = "1" + result;
                reminder = 0;
            }
            else if(temp==2){
                result = "0" + result;
                reminder = 1;
            } else {
                result = "1" + result;
                reminder = 1;
            }
        }
        if(reminder == 1) result = '1'+result;
        return result;

    }

    public String addBinary(String a, String b) {
        if(a.length() > b.length()) return helper(a, b);
        else return helper(b, a);
    }
}
