import java.util.Stack;

public class BinTreeNode {
  public boolean isOperator;
  public char symbol;
  public int value;
  public BinTreeNode left;
  public BinTreeNode right;

  public BinTreeNode() {
    isOperator = false;
    symbol = ' ';
    value = 0;
    left = null;
    right = null;
  }

  /**
   * Constructor that is a parent node
   * 
   * @param isOperator if it is an operator
   * @param symbol     operator
   * @param left       left node
   * @param right      right node
   */
  public BinTreeNode(boolean isOperator, char symbol, BinTreeNode left, BinTreeNode right) {
    this.isOperator = isOperator;
    this.symbol = symbol;
    this.left = left;
    this.right = right;
  }

  /**
   * Constructor that is a leaf node
   * 
   * @param isOperator if it is an operator
   * @param value      value of the node
   * @param left       left node
   * @param right      right node
   */
  public BinTreeNode(boolean isOperator, int value, BinTreeNode left, BinTreeNode right) {
    this.isOperator = false;
    this.value = value;
    this.left = null;
    this.right = null;
  }

}
