package leetcode.problems.linkedin;

/** 528. Random Pick with Weight
 *  You are given a 0-indexed array of positive integers w where w[i] describes
 *  the weight of the ith index.
 *
 * You need to implement the function pickIndex(), which randomly picks an index
 * in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking
 * an index i is w[i] / sum(w).
 *
 *     For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25
 *     (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
 */
public class _528RandomPickWithWeight {
    private int[] prefixSums;
    private int totalSum;

    public _528RandomPickWithWeight(int[] w) {
        this.prefixSums = new int[w.length];
        int prefixSum = 0;
        for (int i = 0; i < w.length; ++i) {
            prefixSum += w[i];
            this.prefixSums[i] = prefixSum;
        }
        this.totalSum = prefixSum;
    }

    public int pickIndex() {
        double target = this.totalSum * Math.random();

        // run a binary search to find the target zone
        int low = 0, high = this.prefixSums.length;
        while (low < high) {
            // better to avoid the overflow
            int mid = low + (high - low) / 2;
            if (target > this.prefixSums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
