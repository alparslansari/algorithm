package leetcode.problems.linkedin;

import leetcode.models.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 297. Serialize and Deserialize Binary Tree
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection
 * link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on
 * how your serialization/deserialization algorithm should work. You just need to ensure that
 * a binary tree can be serialized to a string and this string can be deserialized to the original
 * tree structure.
 * <p>
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree.
 * You do not necessarily need to follow this format, so please be creative and come up with
 * different approaches yourself.
 */
public class _297SerializeAndDeserializeBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        public String rserialize(TreeNode root, String str) {
            // Recursive serialization.
            if (root == null) {
                str += "null,";
            } else {
                str += root.val + ",";
                str = rserialize(root.left, str);
                str = rserialize(root.right, str);
            }
            return str;
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return rserialize(root, "");
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] data_array = data.split(",");
            List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
            return rdeserialize(data_list);
        }

        public TreeNode rdeserialize(List<String> l) {
            // Recursive deserialization.
            if (l.get(0).equals("null")) {
                l.remove(0);
                return null;
            }

            TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
            l.remove(0);
            root.left = rdeserialize(l);
            root.right = rdeserialize(l);

            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
