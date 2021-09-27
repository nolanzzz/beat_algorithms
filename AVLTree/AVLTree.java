package DataStructures.AVLTree;

public class AVLTree {
    private class AVLNode {
        private int value;
        private int height;
        private AVLNode left = null;
        private AVLNode right = null;
        public AVLNode(int value) {
            this.value = value;
        }
        public String toString() {
            return "value=" + this.value;
        }
    }
    private AVLNode root = null;
    public void insert(int value) {
        this.root = insert(this.root, value);
    }
    private AVLNode insert(AVLNode root, int value) {
        if (root == null) {
            return new AVLNode(value);
        }
        if (value < root.value) {
            root.left = insert(root.left, value);
        }
        else {
            root.right = insert(root.right, value);
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        // balance factor = height(L) - height(R)
        int balanceFactor = height(root.left) - height(root.right);
        // > 1 => left heavy
        if (isLeftHeavy(root)) {
            System.out.println("left heavy: " + root);
        }
        // < 1 => right heavy
        else if (isRightHeavy(root)) {
            System.out.println("right heavy: " + root);
        }
        return root;
    }
    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }
    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }
    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    private int height(AVLNode node) {
        return node == null ? -1 : node.height;
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
    }
}
