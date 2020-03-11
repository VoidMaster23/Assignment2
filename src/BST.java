/**
 *Binary Search Tree class
 *@author Edson Shivuri
 **/

public class BST<T extends Comparable<? super T>> extends BT<T>{
	public static int finCount = 0;
	public static int insCount = 0;
	

	/**
	 * Inserts a node into the BST
	 * @param data Data object to be inserted
	 **/
	public void insert(T data){
		
		insCount++;
		//if there is no root node, create one
		if(root == null) root  = new BTNode<T>(data, null, null);
		//place the data in the tree
		else insert(data, root);

	
	}

	/**
	 * Inserts a node into the BST in the correct place relative to a reference node
	 * @param data data object to be inserted
	 * @param node reference node to be compared to
	 **/
	private void insert(T data, BTNode<T> node){
		insCount++;
		if(data.compareTo(node.getData()) <= 0){
			insCount++;
			if(node.getLeft() == null ) 
				node.setLeft(new BTNode<T>(data,null,null));
			else 
				insert(data, node.getLeft());
		}else{
			if(node.getRight() == null)
				node.setRight(new BTNode<T>(data, null, null));
			else
				insert(data, node.getRight());
		
		}

	
	}

	/**
	 * Finds a specific data object in the BST
	 * @param data Data object to look for
	 * @return Null if the object was not found and the node if it was
	 **/
	public BTNode<T> find(T data){
		
		if(root == null)
			return null;
		else 
			return find(data, root);
	}

	/**
	 * Looks for the data in the chilren of a given node
	 * @param data Data object to look for
	 * @param node Parent node to start from
	 * @return Null if the item was not found and the node if it was
	 **/
	private BTNode<T> find(T data, BTNode<T> node){
		finCount++;
		if(data.compareTo(node.getData()) == 0){
			
			return node;
		}
	
		else{ 
			finCount++;
			if(data.compareTo(node.getData()) < 0){
				return (node.getLeft() == null) ? null : find(data, node.getLeft());
			}else{
				return (node.getRight() == null) ? null: find(data, node.getRight());
			}
		}





}
}
