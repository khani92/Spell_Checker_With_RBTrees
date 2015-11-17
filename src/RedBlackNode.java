
/**
 * The RedBlackNode class acts as the blueprint for each node of our RB-Tree
 * @author Nikhil
 *
 */
public class RedBlackNode {

	public static final int BLACK = 0;
	public static final int RED = 1;

	private String data;
	private int color;
	private RedBlackNode p, lc, rc;

	/**
	 * 
	 * @param data
	 *            : A simple value held in the tree
	 * @param color
	 *            : Either RED or BLACK
	 * @param p
	 *            : Pointer to the parent
	 * @param lc
	 *            : Pointer to the left child (will be null only for the
	 *            node that represents all external nulls.
	 * @param rc
	 *            :Pointer to the right child (will be null only for the
	 *            node that represents all external nulls.
	 */

	public RedBlackNode(String data, int color, RedBlackNode p,
			RedBlackNode lc, RedBlackNode rc) {
		this.data = data;
		this.color = color;
		this.p = p;
		this.lc = lc;
		this.rc = rc;
	}

	/**
	 * The getData() method returns the data in the node.
	 * 
	 * @return The data value in the node
	 */
	public String getData() {
		return data;
	}

	/**
	 * The setData() method sets the data or key of the RedBlackNode.
	 * 
	 * @param data
	 *            : is an {@link String} holding a node's data value
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * The getColor() method returns RED or BLACK.
	 * 
	 * @return the color value (RED or BLACK)
	 */
	public int getColor() {
		return color;
	}

	/**
	 * The setColor() method sets the color of the RedBlackNode.
	 * 
	 * @param color
	 *            : is either RED or BLACK
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * The getP() method returns the parent of the RedBlackNode.
	 * 
	 * @return The parent field
	 */
	public RedBlackNode getP() {
		return p;
	}

	/**
	 * The setP() method sets the parent of the RedBlackNode.
	 * 
	 * @param p
	 *            : establishes a parent pointer for this node
	 */
	public void setP(RedBlackNode p) {
		this.p = p;
	}

	/**
	 * The getLc() method returns the left child of the RedBlackNode.
	 * 
	 * @return The left child field
	 */
	public RedBlackNode getLc() {
		return lc;
	}

	/**
	 * The setLc() method sets the left child of the RedBlackNode.
	 * 
	 * @param lc
	 *            : establishes a left child for this node
	 */
	public void setLc(RedBlackNode lc) {
		this.lc = lc;
	}

	/**
	 * The getRc() method returns the right child of the RedBlackNode.
	 * 
	 * @return The right child field
	 */
	public RedBlackNode getRc() {
		return rc;
	}

	/**
	 * The setRc() method sets the right child of the RedBlackNode.
	 * 
	 * @param rc
	 *            : establishes a right child for this node.
	 */
	public void setRc(RedBlackNode rc) {
		this.rc = rc;
	}

	/**
	 * The toString() methods returns a string representation of the
	 * RedBlackNode.
	 */
	public String toString() {
		String color = (getColor()== BLACK) ? "Black": "Red";
		return "[data = " + getData() + ":Color = " + color + ":Parent = "
				+ getP().getData() + ":LC = " + getLc().getData() + ":RC = " + getRc().getData();
	}
}
