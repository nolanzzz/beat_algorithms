package DataStructures.Tree;

public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree();
        t.insert(7);
        t.insert(4);
        t.insert(9);
        t.insert(1);
        t.insert(6);
        t.insert(8);
        t.insert(10);

        System.out.println(t.find(7));
        System.out.println(t.find(5));

        t.delete(7);
        t.delete(1);
        t.delete(10);

        System.out.println("done");
    }
    private class Node {
        private int value;
        private Node leftChild, rightChild;
        public Node(int value) {
            this.value = value;
            leftChild = rightChild = null;
        }
        public String toString() {
            return "Node=" + value;
        }
    }
    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        Node cur = root;
        while (true) {
            if (cur.value > value) {
                if (cur.leftChild == null) {
                    cur.leftChild = new Node(value);
                    break;
                }
                cur = cur.leftChild;
            }
            else if (cur.value < value) {
                if (cur.rightChild == null) {
                    cur.rightChild = new Node(value);
                    break;
                }
                cur = cur.rightChild;
            }
            else {
                break;
            }
        }
    }
    public boolean find(int value) {
        Node cur = root;
        while (cur != null) {
            if (cur.value == value) {
                return true;
            }
            else if (cur.value < value) {
                cur = cur.rightChild;
            }
            else {
                cur = cur.leftChild;
            }
        }
        return false;
    }
    public void delete(int value) {
        root = deleteNode(root, value);
    }
    private Node deleteNode(Node root, int value) {
        if (root == null) {
            return null;
        }

        // Case 1 - 要删除的在左分叉
        if (value < root.value) {
            root.leftChild = deleteNode(root.leftChild, value);
        }
        // Case 2 - 要删除的在有分叉
        else if (value > root.value) {
            root.rightChild = deleteNode(root.rightChild, value);
        }
        // Case 3 - root就是要删除的值
        else {
            // Case A - root没有children
            if (root.leftChild == null && root.rightChild == null) {
                return null;
            }
            // Case B - root只有left child
            else if (root.rightChild == null) {
                return root.leftChild;
            }
            // Case C - root只有right child
            else if (root.leftChild == null) {
                return root.rightChild;
            }
            // Case D - root有两个children，需要找到left child中最小的node
            else {
                root.value = findMinNode(root).value;
                root.leftChild = deleteNode(root.leftChild, root.value);
            }
        }
        return root;
    }
    private Node findMinNode(Node root) {
        Node minNode = root;
        while (minNode.leftChild != null) {
            minNode = minNode.leftChild;
        }
        return minNode;
    }
}


