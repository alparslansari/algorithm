package leetcode.problems;

public class _747LargestNumberTester {
    public static void main(String[] args) {
        _747LargestNumber tester = new _747LargestNumber();
        int[] nums1 = {3,6,1,0};
        if(tester.dominantIndex(nums1) != 1) System.out.println("Test case failed! nums1 ");

        int[] nums2 = {1,2,3,4};
        if(tester.dominantIndex(nums2) != -1) System.out.println("Test case failed! nums2 ");

        int[] nums3 = {1};
        if(tester.dominantIndex(nums3) != 0) System.out.println("Test case failed! nums3 ");

        int[] nums4 = {1,0};
        if(tester.dominantIndex(nums4) != 0) System.out.println("Test case failed! nums4 ");

    }
}
