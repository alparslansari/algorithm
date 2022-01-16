package leetcode.problems;

import java.util.HashMap;

/** 136. Single Number
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 *
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 */
public class _136SingleNumber {

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashTable = new HashMap<>();
        for(int num:nums)
            hashTable.put(num,hashTable.getOrDefault(num,0)+1);
        for(int num:nums)
            if(hashTable.get(num)==1) return num;
        return 0;
    }

    public int singleNumberV2(int[] nums) {
        HashMap<Integer, Integer> hashTable = new HashMap<>();
        for(int i=0;i<nums.length;i++)
            if(!hashTable.containsKey(nums[i]))
                hashTable.put(nums[i],1);
            else
                hashTable.put(nums[i],2);
        for(int i=0;i<nums.length;i++)
            if(hashTable.get(nums[i])!=2)
                return nums[i];
        return -1;
    }

}
