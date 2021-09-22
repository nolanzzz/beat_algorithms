package DataStructures.Tree;

public class BinarySearchTree<T extends Comparable<T>> {
    class Node<T> {
        T value;
        Node<T> left, right;
        Node(T value) {
            this.value = value;
            left = right = null;
        }
        public String toString() {
            return "Node=" + value +"";
        }
    }
    private Node<T> root = null;
    public void insert(T value) {
        // 1. 如果root为空，value设为root
        if (root == null) {
            root = new Node<>(value);
            return;
        }
        // 2. 找到插入的点
        Node<T> curr = root;
        while (true) {
            int c = value.compareTo(curr.value);
            // A 比curr大，往右走
            if (c > 0) {
                if (curr.right == null) {
                    curr.right = new Node<>(value);
                    break;
                }
                curr = curr.right;
            }
            // B 比curr小，往左走
            else if (c < 0) {
                if (curr.left == null) {
                    curr.left = new Node<>(value);
                    break;
                }
                curr = curr.left;
            }
            // C 跟curr重复，无法insert
            else {
                break;
            }
        }

    }
    public boolean find(T value) {
        Node<T> curr = root;
        while (curr != null) {
            int c = value.compareTo(curr.value);
            if (c == 0) {
                return true;
            }
            else if (c < 0) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }
        return false;
    }
    public void delete(T value) {
        root = deleteNode(root, value);
    }
    private Node<T> deleteNode(Node<T> root, T value) {
        if (root == null) {
            return null;
        }
        int c = value.compareTo(root.value);
        // 1 - 要删除的在右边
        if (c > 0) {
            root.right = deleteNode(root.right, value);
        }
        // 2 - 要删除的在左边
        else if (c < 0) {
            root.left = deleteNode(root.left, value);
        }
        // 3 - 要删除root
        else {
            // A - 没有child，直接删除
            if (root.left == null && root.right == null) {
                return null;
            }
            // B - 只有左边，左边
            else if (root.right == null) {
                return root.left;
            }
            // C - 只有右边
            else if (root.left == null) {
                return root.right;
            }
            // D - 有两个children，root设为left里最小的值，并删除那个最小值
            else {
                root.value = getMinNode(root.left).value;
                root.left = deleteNode(root.left, root.value);
            }
        }
        return root;
    }
    private Node<T> getMinNode(Node<T> root) {
        Node<T> minNode = root;
        while (minNode.left != null) {
            minNode = minNode.left;
        }
        return minNode;
    }

    public static void main(String[] args) {
        BinarySearchTree<String> t = new BinarySearchTree<>();
        t.insert("A");
        t.insert("B");
        t.insert("C");
        t.insert("E");
        t.insert("G");
        t.insert("Z");

        System.out.println(t.find("F"));
        System.out.println(t.find("D"));

        t.insert("D");
        System.out.println(t.find("D"));
        t.delete("E");

        System.out.println("done");
    }
}