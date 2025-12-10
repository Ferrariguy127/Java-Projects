//David D Bulin,
//Assignment 5 BST Comparisons
//November 13 2023

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

//I will be honest, I pulled this code from the exercise in class dealing with BST in class, it can also be found here: https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data) {
            root.left = insertRec(root.left, key);
        } else if (key > root.data) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    //in order traversal performs like this.  At first traverse left subtree then visit the root and then traverse the right subtree. source:https://www.geeksforgeeks.org/binary-search-tree-traversal-inorder-preorder-post-order/#
    void inorderTraversal(Node root, FileWriter writer) throws IOException {
        if (root != null) {
            inorderTraversal(root.left, writer);
            writer.write(root.data + " ");
            inorderTraversal(root.right, writer);
        }
    }

    //preorder traversal performs like this. At first visit the root then traverse left subtree and then traverse the right subtree. same site as before.
    void preorderTraversal(Node root, FileWriter writer) throws IOException {
        if (root != null) {
            writer.write(root.data + " ");
            preorderTraversal(root.left, writer);
            preorderTraversal(root.right, writer);
        }
    }
    //postorder traversal performs like this. At first traverse left subtree then traverse the right subtree and then visit the root. Source is still GeeksforGeeks using the same link.
    void postorderTraversal(Node root, FileWriter writer) throws IOException {
        if (root != null) {
            postorderTraversal(root.left, writer);
            postorderTraversal(root.right, writer);
            writer.write(root.data + " ");
        }
    }
    //level-order traversal operations.  Find height of tree. Then for each level, run a recursive function by maintaining current height. Whenever the level of a node matches, print that node. Link: https://www.geeksforgeeks.org/level-order-tree-traversal/#
    void levelOrderTraversal(Node root, FileWriter writer) throws IOException {
        if (root == null) {
            return;
        }
        //the queue is used to track how many levels must be traversed per tree, left right or root.
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        //
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            writer.write(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
}