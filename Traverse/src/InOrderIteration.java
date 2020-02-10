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

    /*
    Input: [1, null, 2, 3]
     */
    public static void main(String[] args){
        InOrderIteration ii = new InOrderIteration();

        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = ii.inorderTraversal(root);

        for (Integer r : result)
            System.out.print(r + " ");
    }

}
