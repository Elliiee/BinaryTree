import jdk.nashorn.api.tree.Tree;
import java.util.HashMap;

public class ConstructBTreeInorderPostorder {
    int post_idx;
    int[] postorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<>();

    public TreeNode helper(int in_left, int in_right){
        if (in_left > in_right) return null;

        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        int index = idx_map.get(root_val);

        post_idx--;
        root.right = helper(index + 1, in_right); // can't change the sequence, have to get right first
        root.left = helper(in_left, index - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder){
        this.inorder = inorder;
        this.postorder = postorder;
        post_idx = postorder.length - 1;

        int idx = 0;
        for (Integer val : inorder)
            idx_map.put(val, idx++);

        return helper(0, inorder.length - 1);

    }
}
