package tpfinalMDC;

public class BinaryTree<E> {
	private E data;
	  private BinaryTree<E> left;
	  private BinaryTree<E>right;
	  private BinaryTree<E>middle;
	  private BinaryTree<E> parent;
	    public BinaryTree() {
	        data = null; // null value designates an empty tree
	        parent = null;
	        left = this;
	        right = this;
	    }
	  public BinaryTree (E initialData, BinaryTree<E> initialLeft, BinaryTree<E> initialRight)
	  {
	    data = initialData;
	    left = initialLeft;
	    right = initialRight;
	    middle=null;
	    parent=null;
	  }
	  public BinaryTree (E initialData, BinaryTree<E> initialLeft, BinaryTree<E> initialRight,BinaryTree<E> imiddle)
	  {
	    data = initialData;
	    left = initialLeft;
	    right = initialRight;
	    middle=imiddle;
	    parent=null;
	  }
	  private void setParent(BinaryTree<E> newParent) {
	        if (!isEmpty()) { // do nothing on empty trees
	            parent = newParent;
	        }
	    }
	  public BinaryTree(E value) {
	        if (value == null) {
	            // non-empty nodes cannot store null
	            throw new IllegalArgumentException("value cannot be null");
	        }
	        this.data = value;
	        parent = null;
	        left = new BinaryTree<E>(); // left and right are empty subtrees
	        right = left;
	        middle=left;
	    }

	  public E value() {
		  return this.data;
	  }
	  public BinaryTree<E> left(){
		  return this.left;
	  }
	  public BinaryTree<E> right(){
		  return this.right;
	  }
	  public BinaryTree<E> middle(){
		  return this.middle;
	  }
	  // check if this is an empty tree
	    public boolean isEmpty() {
	        return data == null;
	    }

	    // check if this is a root node
	    public boolean isRoot() {
	        return parent == null;
	    }

	    // check if this is a leaf node
	    public boolean isLeaf() {
	        return left.isEmpty() && right.isEmpty();
	    }
	    
	    // get number of nodes in the tree
	    public int size() {
	        if (isEmpty()) {
	            return 0;
	        }
	        return left.size() + right.size() + 1;
	    }
	    
	    // get root of tree that this node is part of
	    public BinaryTree<E> root() {
	        if (isRoot()) {
	            return this;
	        }
	        return parent.root();
	    }
	    
	    // get depth of node (path length from root to this node)
	    public int depth() {
	        if (isRoot()) {
	            return 0;
	        }
	        return parent.depth() + 1;
	    }
	    
	    // get height of tree (maximum path length to some descendant)
	    public int height() {
	        if (isEmpty()) {
	            return -1; // leaf has zero height, empty tree has -1 height
	        }
	        int k=Math.max(left.height(), right.height());
	        return Math.max(k, middle.height()) + 1;
	    }
	    
}
