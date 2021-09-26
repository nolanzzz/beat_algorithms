package DataStructures.Tree;

import java.util.ArrayList;

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
    public ArrayList<Integer> getNodesAtDistance(int distance) {
        ArrayList<Integer> list = new ArrayList<>();
        getNodesAtDistance(root, distance, list);
        return list;
    }
    private ArrayList<Integer> getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null) {
            return list;
        }
        if (distance == 0) {
            list.add(root.value);
            return list;
        }
        getNodesAtDistance(root.left, distance - 1, list);
        getNodesAtDistance(root.right, distance - 1, list);
        return list;
    }
    public static void main(String[] args) {
        Tree t = new Tree();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        System.out.println(t.getNodesAtDistance(0));
    }
}
