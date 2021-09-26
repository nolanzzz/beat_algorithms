package DataStructures.Tree;

public class Tree {
    class Node {
        private int value;
        private Node left;
        private Node right;
        Node(int value) {
            this.value = value;
        }
    }
    private Node root;
    public Tree() {
        root = null;
    }
    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }
        Node cur = root;
        while (true) {
            if (cur.left == null) {
                cur.left = newNode;
                return;
            }
            else if (cur.right == null) {
                cur.right = newNode;
                return;
            }
            else {
                cur = cur.left;
            }
        }
    }
    public void printNodesAtDistance(int distance) {
        printNodesAtDistance(root, distance);
    }
    private void printNodesAtDistance(Node root, int distance) {
        if (root == null) {
            return;
        }
        if (distance == 0) {
            System.out.println(root.value);
            return;
        }
        printNodesAtDistance(root.left, distance - 1);
        printNodesAtDistance(root.right, distance - 1);
    }
    public static void main(String[] args) {
        Tree t = new Tree();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.printNodesAtDistance(1);
    }
}
