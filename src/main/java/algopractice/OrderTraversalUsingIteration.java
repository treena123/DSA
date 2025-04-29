package algopractice;

import com.sun.source.tree.Tree;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @author trinapal
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
        this.left = this.right = null;
    }
}
public class OrderTraversalUsingIteration {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        inOrderUsingIteration(root);
        System.out.println();
        preOrderUsingIteration(root);
        System.out.println();
        postOrderUsingIteration(root);
    }

    private static void postOrderUsingIteration(Node root) {
        //traversal left -> right -> root
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        Node lastVisited = null;
        Node curr = root;
            while(!stack.isEmpty() || curr != null){
                if (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                else {
                    Node peekNode = stack.peek();
                    // If right child exists and hasn't been visited yet
                    if (peekNode.right != null && lastVisited != peekNode.right) {
                        curr = peekNode.right;
                    } else {
                        System.out.print(" " + peekNode.val);
                        lastVisited = stack.pop();
                    }
                }


        }
    }

    private static void preOrderUsingIteration(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node curr = stack.pop();
            System.out.print( " " + curr.val);
            res.add(curr.val);
            if(curr.right != null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }

        }


    }

    private static ArrayList<Integer> inOrderUsingIteration(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Node curr = root;
        Stack<Node> stack = new Stack<>();
        while(curr != null || !stack.isEmpty()){
            // Reach the left most Node of the curr Node
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(" " + curr.val);
            ans.add(curr.val);

            // we have visited the node and its
            // left subtree. Now, it's right
            // subtree's turn
            curr = curr.right;
        }
        return ans;
    }
}
