/*
 * Name: Jaznik Patel
 * PID:  A17268450
 */

import java.util.*;

/**
 * Binary search tree implementation.
 * 
 * @author Jaznik Patel
 * @since  May 13 2024
 */
public class BSTree<T extends Comparable<? super T>> implements Iterable {

    /* * * * * BST Instance Variables * * * * */

    private int nelems; // number of elements stored
    private BSTNode root; // reference to root node

    /* * * * * BST Node Inner Class * * * * */

    protected class BSTNode {

        T key;
        LinkedList<T> dataList;
        BSTNode left;
        BSTNode right;

        /**
         * A constructor that initializes the BSTNode instance variables.
         *
         * @param left     Left child
         * @param right    Right child
         * @param dataList Linked list of related info
         * @param key      Node's key
         */
        public BSTNode(BSTNode left, BSTNode right, LinkedList<T> dataList, T key) {
            /* Initilize variables */
            this.left = left;
            this.right = right;
            this.key = key;
            this.dataList = dataList;
        }

        /**
         * A constructor that initializes BSTNode variables. Note: This constructor is
         * used when you want to add a key with no related information yet. In this
         * case, you must create an empty LinkedList for the node.
         *
         * @param left  Left child
         * @param right Right child
         * @param key   Node's key
         */
        public BSTNode(BSTNode left, BSTNode right, T key) {
            /* Initilize instance variables */
            this.left = left;
            this.right = right;
            this.key = key;
            this.dataList = new LinkedList<>();
        }

        /**
         * Return the key
         *
         * @return The key
         */
        public T getKey() {
            /* grabs the key */
            return this.key;
        }

        /**
         * Return the left child of the node
         *
         * @return The left child of the node
         */
        public BSTNode getLeft() {
            /* grabs left variable */
            return this.left;
        }

        /**
         * Return the right child of the node
         *
         * @return The right child of the node
         */
        public BSTNode getRight() {
            return this.right;
        }

        /**
         * Return the linked list of the node
         *
         * @return The linked list of the node
         */
        public LinkedList<T> getDataList() {
            /* Grabs the DataList */
            return this.dataList;
        }

        /**
         * Setter for left child of the node
         *
         * @param newleft New left child
         */
        public void setLeft(BSTNode newleft) {
            /* sets the left node */
            this.left = newleft;
        }

        /**
         * Setter for right child of the node
         *
         * @param newright New right child
         */
        public void setRight(BSTNode newright) {
            /* sets new right */
            this.right = newright;
        }

        /**
         * Setter for the linked list of the node
         *
         * @param newData New linked list
         */
        public void setDataList(LinkedList<T> newData) {
            /* sets new data in list */
            this.dataList = newData;
        }

        /**
         * Append new data to the end of the existing linked list of the node
         *
         * @param data New data to be appended
         */
        public void addNewInfo(T data) {
            /* adds data to linked list */
            dataList.add(data);
        }

        /**
         * Remove 'data' from the linked list of the node and return true. If the linked
         * list does not contain the value 'data', return false.
         *
         * @param data Info to be removed
         * @return True if data was found, false otherwise
         */
        public boolean removeInfo(T data) {
            /* checks if datalist has data, then removes it */
            if(dataList.contains(data)){
                dataList.remove(data);
                return true;
            }
            return false;
        }
    }

    /* * * * * BST Methods * * * * */

    /**
     * 0-arg constructor that initializes root to null and nelems to 0
     */
    public BSTree() {
        /* Initialize instance variables */
        this.root = null;
        this.nelems = 0;
    }

    /**
     * Return the root of BSTree. Returns null if the tree is empty
     *
     * @return The root of BSTree, null if the tree is empty
     */
    public BSTNode getRoot() {
        /* returns root */
        if (nelems == 0) {
            return null;
        }
        return root;
    }

    /**
     * Return the BST size
     *
     * @return The BST size
     */
    public int getSize() {
        /* returns nelems */
        return nelems;
    }

    /**
     * Insert a key into BST
     * 
     * @param key
     * @return true if insertion is successful and false otherwise
     */
    public boolean insert(T key) {
        /* Adds key */
        if (key == null){
            throw new NullPointerException();
        }
        root = insertRecursive(root, key);
        if (root != null) {
            nelems++;
            return true;
        }
        return false;
    }
    private BSTNode insertRecursive(BSTNode currRoot, T key) {
        if (currRoot == null) {
            return new BSTNode(null, null, key);
        }
        if (currRoot.getLeft() != null) {
            if (currRoot.getLeft().getKey() == key) {
                return null;
            }
        }
        if (currRoot.getRight() != null) {
            if (currRoot.getRight().getKey() == key) {
                return null;
            }
        }
        int compareResult = key.compareTo(currRoot.getKey());
        if (compareResult < 0) {
            currRoot.setLeft
                    (insertRecursive(currRoot.getLeft(), key));
        }
        else if (compareResult > 0) {
            currRoot.setRight
                    (insertRecursive(currRoot.getRight(), key));
        }
        else {
            return currRoot;
        }
        return currRoot;
    }

    /**
     * Return true if the 'key' is found in the tree, false otherwise
     *
     * @param key To be searched
     * @return True if the 'key' is found, false otherwise
     * @throws NullPointerException If key is null
     */
    public boolean findKey(T key) {
        /* Finds key in the BT */
        if (key == null){
            throw new NullPointerException();
        }
        return findKeyRecursive(root, key);
    }
    private boolean findKeyRecursive(BSTNode currRoot, T key) {
        if (currRoot == null) {
            return false;
        }
        int compareResult = key.compareTo(currRoot.key);

        if (compareResult == 0) {
            return true;
        } else if (compareResult < 0) {
            return findKeyRecursive(currRoot.left, key);
        } else {
            return findKeyRecursive(currRoot.right, key);
        }
    }

    /**
     * Insert 'data' into the LinkedList of the node whose key is 'key'
     *
     * @param key  Target key
     * @param data To be added to key's LinkedList
     * @throws NullPointerException     If either key or data is null
     * @throws IllegalArgumentException If key is not found in the BST
     */
    public void insertData(T key, T data) {
        /* inserts data */
        if (key == null || data == null) {
            throw new NullPointerException();
        }
        insertDataRecursive(root, key, data);
    }
    private void insertDataRecursive(BSTNode node, T key, T data) {
        if (node == null) {
            throw new IllegalArgumentException();
        }
        int compareResult = key.compareTo(node.getKey());
        if (compareResult < 0) {
            insertDataRecursive(node.getLeft(), key, data);
        } else if (compareResult > 0) {
            insertDataRecursive(node.getRight(), key, data);
        } else {
            node.addNewInfo(data);
        }
    }

    /**
     * Return the LinkedList of the node with key value 'key'
     *
     * @param key Target key
     * @return LinkedList of the node whose key value is 'key'
     * @throws NullPointerException     If key is null
     * @throws IllegalArgumentException If key is not found in the BST
     */
    public LinkedList<T> findDataList(T key) {
        /* finds data in datalist */
        if (key == null){
            throw new NullPointerException();
        }
        return findDataListRecursive(root, key);
    }
    private LinkedList<T> findDataListRecursive(BSTNode currRoot, T key) {
        if (currRoot == null) {
            throw new IllegalArgumentException();
        }
        int compareResult = key.compareTo(currRoot.key);
        if (compareResult == 0) {
            return currRoot.dataList;
        } else if (compareResult < 0) {
            return findDataListRecursive(currRoot.left, key);
        } else {
            return findDataListRecursive(currRoot.right, key);
        }
    }

    /**
     * Return the height of the tree
     *
     * @return The height of the tree, -1 if BST is empty
     */
    public int findHeight() {
        /* returns the height*/
        return findHeightHelper(root);
    }

    /**
     * Helper for the findHeight method
     *
     * @param root Root node
     * @return The height of the tree, -1 if BST is empty
     */
    private int findHeightHelper(BSTNode root) {
        /* checks left and right node of the key */
        if (root == null) {
            return -1;
        }
        int leftHeight = findHeightHelper(root.left);
        int rightHeight = findHeightHelper(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /* * * * * BST Iterator * * * * */

    public class BSTree_Iterator implements Iterator<T> {
        private Stack<BSTNode> stack;
        public BSTree_Iterator() {
            /* makes new stack and calls pushLeft on root */
            stack = new Stack<>();
            pushLeft(root);
        }

        public boolean hasNext() {
            /* checks if the stack has next */
            return !stack.isEmpty();
        }

        public T next() {
            /* gives the next item */
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            BSTNode node = stack.pop();
            T result = node.getKey();
            if (node.getRight() != null) {
                pushLeft(node.getRight());
            }
            return result;
        }
        private void pushLeft(BSTNode node) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
        }
    }


    public Iterator<T> iterator() {
        /* makes new bst iterator */
        return new BSTree_Iterator();
    }

    /* * * * * Extra Credit Methods * * * * */

    public ArrayList<T> intersection(Iterator<T> iter1, Iterator<T> iter2) {
        /* TODO */
        return null;
    }

    public T levelMax(int level) {
        /* TODO */
        return null;
    }
}
