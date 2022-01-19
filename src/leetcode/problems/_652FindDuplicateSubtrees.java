package leetcode.problems;

import leetcode.models.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _652FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<TreeNode> result = new LinkedList<>();
        dfs(root, result, map);
        return result;
    }

    public String dfs(TreeNode node, List<TreeNode> result, Map<Integer,Integer> map){

        //null will be define to N
        if(node == null) return "N";

        //Pattern for node [val.[LEFT.val].[RIGHT.val]] ==> 3.N.N
        StringBuilder builder = new StringBuilder();
        builder.append(node.val).append(".");
        builder.append(dfs(node.left, result, map)).append(".");
        builder.append(dfs(node.right, result, map)).append(".");

        int hashVal = builder.toString().hashCode(); // This step to save space in case multi level, but actually no need this test.
        map.put(hashVal, map.getOrDefault(hashVal, 0) + 1);

        if(map.get(hashVal) == 2){ //Duplicate value, found pattern twice times. Add to result
            result.add(node);
        }

        return builder.toString();
    }
}
