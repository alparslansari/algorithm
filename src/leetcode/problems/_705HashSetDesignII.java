package leetcode.problems;

import leetcode.models.TreeNodePrimitive;

public class _705HashSetDesignII {

    MyHashSet obj = new MyHashSet();

    class MyHashSet {
        private Bucket[] bucketArray;
        private int keyRange;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            this.keyRange = 769;
            this.bucketArray = new Bucket[this.keyRange];
            for (int i = 0; i < this.keyRange; ++i)
                this.bucketArray[i] = new Bucket();
        }

        protected int _hash(int key) {
            return (key % this.keyRange);
        }

        public void add(int key) {
            int bucketIndex = this._hash(key);
            this.bucketArray[bucketIndex].insert(key);
        }

        public void remove(int key) {
            int bucketIndex = this._hash(key);
            this.bucketArray[bucketIndex].delete(key);
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int bucketIndex = this._hash(key);
            return this.bucketArray[bucketIndex].exists(key);
        }
    }


    class Bucket {
        private BSTree tree;

        public Bucket() {
            tree = new BSTree();
        }

        public void insert(Integer key) {
            this.tree.root = this.tree.insertIntoBST(this.tree.root, key);
        }

        public void delete(Integer key) {
            this.tree.root = this.tree.deleteNode(this.tree.root, key);
        }

        public boolean exists(Integer key) {
            TreeNodePrimitive node = this.tree.searchBST(this.tree.root, key);
            return (node != null);
        }
    }

    class BSTree {
        TreeNodePrimitive root = null;

        public TreeNodePrimitive searchBST(TreeNodePrimitive root, int val) {
            if (root == null || val == root.val)
                return root;

            return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
        }

        public TreeNodePrimitive insertIntoBST(TreeNodePrimitive root, int val) {
            if (root == null)
                return new TreeNodePrimitive(val);

            if (val > root.val)
                // insert into the right subtree
                root.right = insertIntoBST(root.right, val);
            else if (val == root.val)
                // skip the insertion
                return root;
            else
                // insert into the left subtree
                root.left = insertIntoBST(root.left, val);
            return root;
        }

        /*
         * One step right and then always left
         */
        public int successor(TreeNodePrimitive root) {
            root = root.right;
            while (root.left != null)
                root = root.left;
            return root.val;
        }

        /*
         * One step left and then always right
         */
        public int predecessor(TreeNodePrimitive root) {
            root = root.left;
            while (root.right != null)
                root = root.right;
            return root.val;
        }

        public TreeNodePrimitive deleteNode(TreeNodePrimitive root, int key) {
            if (root == null)
                return null;

            // delete from the right subtree
            if (key > root.val)
                root.right = deleteNode(root.right, key);
                // delete from the left subtree
            else if (key < root.val)
                root.left = deleteNode(root.left, key);
                // delete the current node
            else {
                // the node is a leaf
                if (root.left == null && root.right == null)
                    root = null;
                    // the node is not a leaf and has a right child
                else if (root.right != null) {
                    root.val = successor(root);
                    root.right = deleteNode(root.right, root.val);
                }
                // the node is not a leaf, has no right child, and has a left child
                else {
                    root.val = predecessor(root);
                    root.left = deleteNode(root.left, root.val);
                }
            }
            return root;
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}