package leetcode.problems.linkedin;

import java.util.Arrays;

/** 319. Bulb Switcher
 * There are n bulbs that are initially off. You first turn on all the bulbs, then you turn off every second bulb.
 * On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on).
 * For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb.
 *
 * Return the number of bulbs that are on after n rounds.
 *
 * Example 1:
 * Input: n = 3
 * Output: 1
 * Explanation: At first, the three bulbs are [off, off, off].
 * After the first round, the three bulbs are [on, on, on].
 * After the second round, the three bulbs are [on, off, on].
 * After the third round, the three bulbs are [on, off, off].
 * So you should return 1 because there is only one bulb is on.
 *
 * Example 2:
 * Input: n = 0
 * Output: 0
 *
 * Example 3:
 * Input: n = 1
 * Output: 1
 */
public class _319BulbSwitcher {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }

    public int bulbSwitchBF(int n) {
        if(n==1) return 1;
        int[] bulbs = new int[n+1];
        Arrays.fill(bulbs, 1); // first round
        for(int i=2;i<n;i++)
            for(int j=i;j<n+1;j=j+i)
            {
                if(j>n) break;
                bulbs[j] = bulbs[j] == 0 ? 1 : 0;
            }
        bulbs[n] = bulbs[n] == 0 ? 1 : 0;
        int result = 0;
        for(int i=1;i<n+1;i++)
            result += bulbs[i] == 1 ? 1 : 0;

        return result;
    }
}