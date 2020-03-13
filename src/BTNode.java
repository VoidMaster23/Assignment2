/**
 * Generic Class for Binary Tree Nodes
 * @author Edson Shivuri
 **/

public class BTNode<T>{
	private T data;
	private BTNode<T> left;
	private BTNode<T> right;
	private int height;
	
	/**
	 * Constructor for the node. Also initialises the height and sets it to 0.
	 * @param data data to be stored
	 * @param left left child of current node
	 * @param right right child of current node
	 **/
	public BTNode(T data, BTNode<T> left, BTNode<T> right){
		this.data = data;
		this.left = left;
		this.right = right;
		height = 0;
	}

	
	/**
	 *Retrieve the data stored in the node 
	 *@return the data object stored in the node
	 **/
	public T getData(){
		return this.data;
	}

	/**
	 * Set the node data
	 * @param data Data object to be entered
	 **/
	public void setData(T data){
	this.data = data;
	}

	 /**
         * Set the leftNode
         * @param node Node to be entered
         **/
        public void setLeft(BTNode<T> node){
        this.left = node;
        }
	
       	/**
         * Set the right node
         * @param node Node  to be entered
         **/
        public void setRight(BTNode<T> node){
        this.right = node;
        }


	/**
	 * Get the height variable
	 * @return the height of that particular node 
	 **/
	public int getHeight(){
		return this.height;
	}


	/**
	 * Retrieve the left child node
	 * @return the left child node
	 **/
	public BTNode<T> getLeft() {return left;}

	/**
         * Retrieve the right child node
         * @return the right child node
         **/
	public BTNode<T> getRight(){return right;}


	/**
	 * Set the height of the node
	 * @param height to be set
	 **/
	public void setHeight(int h){
		this.height = h;
	}

}

