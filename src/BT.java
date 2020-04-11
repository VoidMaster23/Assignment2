
/**
 * Super Class of Binary Trees
 * @author Edson Shivuri
 **/
public class BT<T>{
	//stores the root node 
	 BTNode<T> root;

	/**
	 * Constructor for the BT class
	 **/
	public BT(){
		root = null;
	}

	/**
	 * Recursively find the height of the tree by calling the overloaded {@link #getHeight(BTNode<T> node) getHeight} method
	 * @return the height of the entire tree
	 **/
	public int getHeight(){
		return getHeight(root);
	}

	/**
	 * Finds the height of each subtree
	 * @param node The root node of the tree and all subsequent subtrees
	 * @return the height of each subtre
	 **/
	private int getHeight(BTNode<T> node){
		//if there are no children
		if(node==null) return -1;
		//find the maximum number of nodes from root to leaf
		else return 1+ Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
	
	}

	/**
	 * Count all the nodes in the entire tree
	 * @return The number of nodes in the tree
	 **/
	public int getSize(){
		return getSize(root);
	}

	/**
	 * Count all the nodes in each subtree
	 * @param node The root node of the tree and all subsequent subtrees
	 * @return The number of nodes in the subtree
	 **/
	private int getSize(BTNode<T> node){
		//stop when there are no nodes left
		if(node == null) return 0;
		//find the size of each subtree
		else return 1 + getSize(node.getLeft()) + getSize(node.getRight());
	}


	
	/**
	 * Prints out the node data or the search term found in the SearchItem class
	 *@param node Node to be acted upon
	 */
	public void visit(BTNode<T> node){
	//this checks to see if there is actually something to search for
	if(SearchItem.toSearch != null){
		String output = node.getData().toString();
		if(!output.equals("")){
		System.out.println(output);
	    	}
	}
	}


	/**
	 * Perform a preOrder traversal recursively starting at the root
	 **/
	public void preOrder(){
		preOrder(root);
	}

	/**
	 * Perfom an action on the current node and visit each child
	 * @param node The root node of the tree and all subsequent subtrees
	 **/
	private void preOrder(BTNode<T> node){
		if(node != null){
			visit(node);
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	
	}

	/**
         * Perform a postOrder traversal recursively starting at the root
         **/
        public void postOrder(){
                postOrder(root);
        }

	/**
         *  Visit each child then perform an action on the parent node
         * @param node The root node of the tree and all subsequent subtrees
         **/
        private void postOrder(BTNode<T> node){
                if(node != null){
     
                        postOrder(node.getLeft());
                        postOrder(node.getRight());
			visit(node);
                }

        }

	/**
         * Perform a inOrder traversal recursively starting at the root
         **/
        public void inOrder(){
                inOrder(root);
        }

        /**
         *  Visit left child, perform an action on the parent node then visit the right child
         * @param node The root node of the tree and all subsequent subtrees
         **/
        private void inOrder(BTNode<T> node){
                if(node != null){

                        inOrder(node.getLeft());
			visit(node);
                        inOrder(node.getRight());
                }

        }






}
