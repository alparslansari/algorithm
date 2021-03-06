package leetcode.problems;

/** 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Constraints:
 *     1 <= strs.length <= 200
 *     0 <= strs[i].length <= 200
 *     strs[i] consists of only lower-case English letters.
 */
public class _14LongestCommonPrefix {
    // Approach 1: Horizontal scanning
    public String longestCommonPrefixByHorizontalScan(String[] strs){
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++)
            while(strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        return prefix;
    }

    // Approach 2: Vertical scanning
    public String longestCommonPrefixByVerticalScanning(String[] strs) {
        if(strs==null || strs.length==0) return "";
        for(int i=0;i< strs.length;i++)
        {
            char c = strs[0].charAt(i);
            for(int j = 1; j<strs.length; j++)
            {
                if(i==strs[j].length() || strs[j].charAt(i)!=c)
                    return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }

    // Approach 3: Divide and conquer
    public String longestCommonPrefixByDivideAndConquer(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if(l==r) return strs[l];
        else {
            int mid = (l+r) / 2;
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid+1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    private String commonPrefix(String left, String right){
        int min = Math.min(left.length(),right.length());
        for(int i=0;i<min;i++){
            if(left.charAt(i) != right.charAt(i)) return left.substring(0,i);
        }
        return left.substring(0,min);
    }

    // Approach 4: Binary search
    public String longestCommonPrefixByBinarySearch(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }

}
