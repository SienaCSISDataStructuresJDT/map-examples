/**
 * A binary search tree (BST) data structure for storing Comparable
 * values. The tree has the property that for every node n, all values
 * in n's left subtree are less than or equal to n's data value and
 * all values in n's right subtree are larger.
 * 
 * @author Starter code by Siena College Faculty, modified by Pauline White
 * for CSIS 210, updated by Jim Teresco
 * @version Fall 2020
 *
 */
public class BinarySearchTreeT<T extends Comparable>
{
    private Node root;

    /**
     * Constructs an empty binary search tree (BST).
     */
    public BinarySearchTreeT() 
    {
        root = null;
    }

    /**
     * Inner class representing one node in a BST.
     */
    private class Node 
    {
        private T data;
        private Node left;
        private Node right;

        /**
         * Constructs a node with a value and left and right
         * references.
         * 
         * @param data The data value for the node.
         * @param left A reference to the child of the node or
         * null if this node has no left child.
         * @param right A reference to the right child of the
         * node or null if this node has no right child.
         */
        private Node(T data, Node left, Node right) 
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Adds the value to the tree maintianing the BST
     * property that for every tree node n, all values in n's left
     * subtree are less than or equal to n's data value and all values
     * in n's right subtree are larger.
     * 
     * @param value The value to be added to the BST.
     */ 
    public void add(T value) 
    {
        if (root == null) {
            root = new Node(value, null, null);
        } else {
            recursiveAdd(value, root);
        }
    }

    /**
     * Recursive method to add a value to a BST with root n.
     * 
     * Precondition: n is not null
     * @param value The value to be added to the BST.
     * @param n The root of the BST.
     */ 
    private void recursiveAdd(T value, Node n) 
    {
        if ((value.compareTo(n.data) > 0) && (n.right == null)) {
            // value is added as the right child of n
            n.right = new Node(value, null, null);
        }
        else if ((value.compareTo(n.data) <= 0) && (n.left == null)) {
            // value is added as the left child of n
            n.left = new Node(value, null, null);
        }
        else if ((value.compareTo(n.data) > 0) && (n.right != null)) {
            // insert value into n's right subtree
            recursiveAdd(value, n.right);
        }
        else {
            // the following is true: ((value <= n.data) && (n.left != null))
            // insert value into n's left subtree
            recursiveAdd(value, n.left);
        }
    }

    /**
     * Prints the values in the BST.
     */
    public void printAll() 
    {
        recursivePrintAll(root);

        //New line after printing all values
        System.out.println(""); 
    }

    /**
     * Recursively prints the values in the BST whose root is n.
     * 
     * @param n The root of the tree (or subtree).
     */
    private void recursivePrintAll(Node n) 
    {
        if(n != null)
        {
            System.out.print(n.data + " "); 
            recursivePrintAll(n.left);
            recursivePrintAll(n.right);
        }
    }
    
    /**
     * Find the actual tree element equivalant to the given parameter.
     * 
     * @param item The element to search for.
     * @return The actual tree element equivalant to the given parameter,
     * or null if it is not found.
     */
    public T get(T item) {
     
        return get(item, root);
    }
    
    private T get(T item, Node n) {
    
        if (n == null) return null;
        if (item.equals(n.data)) return n.data;
        if (item.compareTo(n.data) < 0) return get(item, n.left);
        return get(item, n.right);
    }
}
