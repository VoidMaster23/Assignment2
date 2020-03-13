/**
 * AVL Tree Class that inherits from the Binaty Tree class
 * @author Edson Shivuri
 **/

public class AVL< T extends Comparable<? super T >> extends BT<T>{

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
	 * @param node subtree "root" node tp adjust the height of
	 **/
	public void fixHeight(BTNode<T> node){
		node.setHeight(Math.max(height(node.getLeft()),height(node.getRight()))+1);
	}

	// conttinue from here

}
