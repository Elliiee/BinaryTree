import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointerLevelOrder {
    public Node connect(Node root){
        if (root == null) return root;

        Queue<Node> Q = new LinkedList<>();
        Q.add(root);

        while (Q.size() > 0){
            int size = Q.size();
            for (int i = 0; i < size; i++){
                Node node = Q.poll();

                if (i < size - 1)
                    node.next = Q.peek();

                if (node.left != null) Q.add(node.left);
                if (node.right != null) Q.add(node.right);
            }
        }
        return root;
    }
}
