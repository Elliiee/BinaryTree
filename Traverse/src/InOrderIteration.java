import java.util.LinkedList;
import java.util.List;

public class InOrderIteration {
    public List<Integer> inorderTraversal(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root == null) return output;

        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.add(node);
                node = node.left;
            }
            node = stack.pollLast();
            output.add(node.val);
            node = node.right;
        }
        return output;
    }

}
