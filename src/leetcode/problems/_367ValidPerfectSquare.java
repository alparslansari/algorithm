package leetcode.problems;

/** 367. Valid Perfect Square
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Follow up: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 * Input: num = 16
 * Output: true
 *
 * Example 2:
 * Input: num = 14
 * Output: false
 */
public class _367ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        return binarySearch(num);
    }

    private boolean bruteForce(int num)
    {
        if(num==1) return true;
        int val = 0;
        for(int i = 1;i<=(num/2); i++)
        {
            val = i * i;
            if(val == num) return true;
            else if (val > num) break;
        }
        return false;
    }

    private boolean binarySearch(int num)
    {
        if(num==1) return true;
        long left = 2, right = num / 2, x, guessSquared;
        while(left<=right){
            x = left + (right - left) / 2;
            guessSquared = x * x;
            if(guessSquared == num) return true;
            if(guessSquared > num) right = x - 1;
            else left = x + 1;
        }
        return false;
    }

    // Newton's Method
    public boolean isPerfectSquareV2(int num) {
        if (num < 2) return true;

        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return (x * x == num);
    }
}
