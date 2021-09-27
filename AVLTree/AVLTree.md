## AVL Tree

**Balanced Tree**: `|height(left) - height(right)| <= 1`

### Self-Balancing Trees

- AVL Tree
- Red-Black Tree
- B-Tree
- Spaly Tree

### AVL Tree
AVL tree is a BST in which the heights of the left and right subtrees of every node differ by at most 1.
I.e., A balanced BST.

Whenever a height imbalance occurs due to insertion or deletion, rebalancing is done using rotations.

**Rotations:**
- LL (left-left): imbalance at left child, left subtree
- RR (right-right): imbalance at right child, right subtree
- LR (left-right): imbalance at left child, right subtree
- RL (right-left): imbalance at right child, left subtree