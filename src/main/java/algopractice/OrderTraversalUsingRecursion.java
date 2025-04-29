package algopractice;

/**
 * @author trinapal
 */

class Node {
    Node left;
    Node right;
    int val;

    Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class OrderTraversalUsingRecursion {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        inOrderTraverseUsingRecursion(root);
        System.out.println();
        preOrderUsingRecursion(root);
        System.out.println();
        postOrderUsingRecursion(root);
        System.out.println();
    }

    private static void postOrderUsingRecursion(Node root) {
        //edge case
        if(root == null) {
            return;
        }
        postOrderUsingRecursion(root.left);
        postOrderUsingRecursion(root.right);
        System.out.print(" " + root.val);
    }

    private static void preOrderUsingRecursion(Node root) {
        //edge case
        if(root == null)
            return;

        System.out.print(" " + root.val);
        preOrderUsingRecursion(root.left);
        preOrderUsingRecursion(root.right);



    }

    public static void inOrderTraverseUsingRecursion(Node root){
        //edge case
        if(root == null) return;
        inOrderTraverseUsingRecursion(root.left);
            System.out.print(" " + root.val);
        inOrderTraverseUsingRecursion(root.right);
        }

    }

