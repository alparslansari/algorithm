package leetcode.problems.linkedin;

import leetcode.models.TreeNode;

import java.util.ArrayDeque;

/** 449. Serialize and Deserialize BST
 * Serialization is converting a data structure or object into a sequence
 * of bits so that it can be stored in a file or memory buffer, or transmitted
 * across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You need to ensure that a binary search tree can be serialized to a string,
 * and this string can be deserialized to the original tree structure.
 *
 * The encoded string should be as compact as possible.
 *
 * Example 1:
 * Input: root = [2,1,3]
 * Output: [2,1,3]
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 *     The number of nodes in the tree is in the range [0, 104].
 *     0 <= Node.val <= 104
 *     The input tree is guaranteed to be a binary search tree.
 */
public class _449SerializeAndDeserializeBST {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    // Approach 1: Postorder traversal to optimise space for the tree structure.
    public class Codec {
        public StringBuilder postorder(TreeNode root, StringBuilder sb) {
            if (root == null)
                return sb;
            postorder(root.left, sb);
            postorder(root.right, sb);
            sb.append(root.val);
            sb.append(' ');
            return sb;
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = postorder(root, new StringBuilder());
            if (sb.length() > 0)
                sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        public TreeNode helper(Integer lower, Integer upper, ArrayDeque<Integer> nums) {
            if (nums.isEmpty())
                return null;
            int val = nums.getLast();
            if (val < lower || val > upper)
                return null;

            nums.removeLast();
            TreeNode root = new TreeNode(val);
            root.right = helper(val, upper, nums);
            root.left = helper(lower, val, nums);
            return root;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty())
                return null;
            ArrayDeque<Integer> nums = new ArrayDeque<Integer>();
            for (String s : data.split("\\s+"))
                nums.add(Integer.valueOf(s));
            return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;

    /**
     * Approach 3: Get rid of delimiters.
     * Intuition: Approach 2 works well except for delimiter usage.
     * Since all node values are now encoded as 4-bytes strings, one could just split the encoded string into 4-bytes chunks,
     * convert each chunk back to the integer and proceed further.
     */
    public class Codec2 {
        // Encodes a tree to a list.
        public void postorder(TreeNode root, StringBuilder sb) {
            if (root == null)
                return;
            postorder(root.left, sb);
            postorder(root.right, sb);
            sb.append(intToString(root.val));
        }

        // Encodes integer to bytes string
        public String intToString(int x) {
            char[] bytes = new char[4];
            for (int i = 3; i > -1; --i) {
                bytes[3 - i] = (char) (x >> (i * 8) & 0xff);
            }
            return new String(bytes);
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            postorder(root, sb);
            return sb.toString();
        }

        // Decodes list to tree.
        public TreeNode helper(Integer lower, Integer upper, ArrayDeque<Integer> nums) {
            if (nums.isEmpty())
                return null;
            int val = nums.getLast();
            if (val < lower || val > upper)
                return null;

            nums.removeLast();
            TreeNode root = new TreeNode(val);
            root.right = helper(val, upper, nums);
            root.left = helper(lower, val, nums);
            return root;
        }

        // Decodes bytes string to integer
        public int stringToInt(String bytesStr) {
            int result = 0;
            for (char b : bytesStr.toCharArray()) {
                result = (result << 8) + (int) b;
            }
            return result;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            ArrayDeque<Integer> nums = new ArrayDeque<Integer>();
            int n = data.length();
            for (int i = 0; i < (int) (n / 4); ++i) {
                nums.add(stringToInt(data.substring(4 * i, 4 * i + 4)));
            }

            return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
        }
    }

}
