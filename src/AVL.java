/**
 * AVL Tree Class that inherits from the Binaty Tree class
 * @author Edson Shivuri
 **/

public class AVL<T extends Comparable<? super T >> extends BT<T>{

	//instrumentation 
	public static int insertCount = 0;
	public static int findCount = 0;

	/**
	 * Method to get the height of a particular node in the tree
	 * @param node node you want to get the height of
	 * @return height returns the height of the node if the node is not null, otherwise returns -1 to subtract from the height of the total tree
	 **/
	public int height (BTNode<T> node){
		if(node != null) return node.getHeight();
		return -1;
	}

	/**
	 * Method to calculate the balance factor, i.e. the difference in height between the heights of the left and right subtrees
	 * @param node "root" node of the subtree whos children to compare for balancing
	 * @return height difference between child nodes
	 **/
	public int balanceFactor(BTNode<T> node){
		return height(node.getRight()) - height(node.getLeft());
	}

	/**
	 * Method to adjust the height of the subtree
	 * @param node subtree "root" node to adjust the height of
	 **/
	public void fixHeight(BTNode<T> node){
		node.setHeight(Math.max(height(node.getLeft()),height(node.getRight()))+1);
	}

	/**
	 * Method to make a right tree rotation after adding to the left child
	 * @param p parent node to which the left child has been added
	 * @return node that rotated to the position of p
	 **/
	private BTNode<T> rotateRight(BTNode<T> p){
		BTNode<T> q = p.getLeft();
		p.setLeft(q.getRight());
		q.setRight(p);
		fixHeight(p);
		fixHeight(q);
		return q;
	}

	 /**
         * Method to make a left tree rotation after adding to the right child
         * @param p parent node to which the right child has been added
         * @return the node that rotated to the position of p
         **/
        private BTNode<T> rotateLeft(BTNode<T> p){
                BTNode<T> q = p.getRight();
                p.setRight(q.getLeft());
                q.setLeft(p);
                fixHeight(q);
                fixHeight(p);
                return q;
        }

	/**
	 * Balancing method for the AVL treee class
	 * @param p node from which to balance from 
	 * @return the node which rotated to the position of p
	 **/
	public BTNode<T> balance (BTNode<T> p){
		fixHeight(p);
		// right has more elements
		if(balanceFactor(p) == 2){
			// if the right subtree is unbalanced, balance the subtree first then 
			if(balanceFactor(p.getRight()) < 0) p.setRight(rotateRight(p.getRight()));
			return rotateLeft(p);
		}

		//left has more elements
		if(balanceFactor(p) == -2){
			//left is unbalanced
			if(balanceFactor(p.getLeft()) > 0) p.setLeft(rotateLeft(p.getLeft()));
			return rotateRight(p);
		}

		//tree is balanced so just return the node
		return p;
	}

	/**
	 * Method to insert new data into the tree. Calls the private insert method to recursively insert a node containing the data in the correct place
	 * @param data Object to be inserted into the tree
	 **/
	public void insert(T data){
		root = insert(data, root);
	}

	

	/**
	 * Insert method that places a new node in the correct position
	 * @param data Data Item to be inserted 
	 * @param node parent node to insert from 
	 * @return inserted node
	 **/
	private BTNode<T> insert(T data, BTNode<T> node){
		// if the node does not exist, create it
		insertCount++;
		if(node == null) return new BTNode<T>(data, null, null);

		//left placement
		insertCount++;
		if(data.compareTo(node.getData()) <= 0) node.setLeft(insert(data, node.getLeft()));

		else node.setRight(insert(data, node.getRight()));

		//balance the tree after insertion
		return balance(node);
	}

	// delete not needed for this assinment so not added
	//
	
	/**
	 *Method to find a particular item in the tree. Calls the private find method to recursively find a node containing the data.
	 * @param data Data Item to be found
	 * @return node containing the data
	 **/
	public BTNode<T> find ( T data ){
		//reset the find count
		findCount = 0;
		      		
		if (root == null) 
			return null;
      		else
         		return find (data, root);
   	}


	/**
         *Method to find a particular item in the tree
         * @param data Data Item to be found
         * @param node parent node to start searching from
         * @return node containing the data
         **/

   	private BTNode<T> find ( T data, BTNode<T> node ){
      		findCount++;
		if (data.compareTo (node.getData()) == 0){
         		return node;
		}else {
		findCount++;
		if (data.compareTo (node.getData()) < 0){
         		return (node.getLeft() == null) ? null : find (data, node.getLeft());
		}else{
         		return (node.getRight() == null) ? null : find (data, node.getRight());
		}
		}
   }

}
