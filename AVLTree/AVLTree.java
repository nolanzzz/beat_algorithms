package DataStructures.AVLTree;

public class AVLTree {
    private class AVLNode {
        private int value;
        private int height;
        private AVLNode left;
        private AVLNode right;
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
        updateHeight(root);
        root = balance(root);
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
    private AVLNode balance(AVLNode root) {
        // > 1 => left heavy
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.left) < 0) {
                root.left = rotateLeft(root.left);
            }
            root = rotateRight(root);
        }
        // < 1 => right heavy
        else if (isRightHeavy(root)) {
            if (balanceFactor(root.right) > 0) {
                root.right = rotateRight(root.right);
            }
            root = rotateLeft(root);
        }
        return root;
    }
    private AVLNode rotateRight(AVLNode root) {
        AVLNode newRoot = root.left;
        if (newRoot.right != null) {
            root.left = newRoot.right;
        }
        newRoot.right = root;
        updateHeight(root);
        updateHeight(newRoot);
        return newRoot;
    }
    private AVLNode rotateLeft(AVLNode root) {
        AVLNode newRoot = root.right;
        if (newRoot.left != null) {
            root.right = newRoot.left;
        }
        newRoot.left = root;
        updateHeight(root);
        updateHeight(newRoot);
        return newRoot;
    }

    private void updateHeight(AVLNode node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    public static void main(String[] args)  {
        AVLTree tree = new AVLTree();
        tree.insert(30);
        tree.insert(10);
        tree.insert(5);
        System.out.println("done");
    }
}
