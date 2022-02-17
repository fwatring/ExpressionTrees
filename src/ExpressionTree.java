import java.util.Stack;

public class ExpressionTree {
  BinTreeNode root;

  /**
   * Constructor that converts the string to a Stack
   * 
   * @param postfixExpression string entered by the user
   * 
   */
  public ExpressionTree(String postfixExpression) {
    Stack<BinTreeNode> stack = new Stack<BinTreeNode>();
    String[] postfixArray;
    postfixArray = postfixExpression.split(" ");
    for (int i = 0; i < postfixArray.length; i++) {

      if (postfixArray[i].equals("*") || postfixArray[i].equals("/") || postfixArray[i].equals("+")
          || postfixArray[i].equals("-")) {
        BinTreeNode node = new BinTreeNode(true, postfixArray[i].charAt(0), null, null);
        node.right = stack.peek();
        stack.pop();
        node.left = stack.peek();
        stack.pop();
        stack.push(node);
      } else {
        BinTreeNode node = new BinTreeNode(false, Integer.parseInt(postfixArray[i]), null, null);
        stack.push(node);
      }
      root = stack.peek();

    }
  }

  /**
   * Calls the private method getPrefixNotation
   * 
   * @return the Prefix Notation of the tree
   */
  public String getPrefixNotation() {

    return getPrefixNotation(root);
  }

  /**
   * Calls the private method getInfixNotation
   * 
   * @return the Infix Notation of the tree
   */
  public String getInfixNotation() {
    return getInfixNotation(root);
  }

  /**
   * Calls the private method getValue
   * 
   * @return the evaluation of the expression tree
   */
  public int getValue() {
    return getValue(root);
  }

  /**
   * Gets the Prefix Notation of the tree
   * 
   * @param node the current node in the tree
   * @return the Prefix Notation of the tree
   */
  private String getPrefixNotation(BinTreeNode node) {
    String prefix = "";
    if (node != null) {

      if (node.isOperator) {
        prefix += node.symbol;
        prefix += " ";

      } else {
        prefix += node.value;
        prefix += " ";
      }
      prefix += getPrefixNotation(node.left);

      prefix += getPrefixNotation(node.right);
    }
    return prefix;
  }

  /**
   * Gets the Infix Notation of the tree
   * 
   * @param node the current node in the tree
   * @return the Infix Notation of the tree
   */
  private String getInfixNotation(BinTreeNode node) {
    String infix = "";

    if (node != null) {

      if (node.isOperator) {
        infix += "(";
        infix += getInfixNotation(node.left);
        infix += " ";

        infix += node.symbol;
        infix += " ";

        infix += getInfixNotation(node.right);
        infix += ")";

      } else {
        infix += node.value;

      }

    }
    return infix;

  }

  /**
   * Evaluates the expression of the given tree
   * 
   * @param node the current node in the tree
   * @return result of the expression
   */
  private int getValue(BinTreeNode node) {
    int totalVal = 0;
    int valOne = 0;
    int valTwo = 0;
    if (node == null)
      totalVal = 0;
    else {
      if (node.isOperator) {
        valOne = getValue(node.left);
        valTwo = getValue(node.right);
        totalVal = computeExpression(node.symbol, valOne, valTwo);
      } else
        totalVal = node.value;
    }

    return totalVal;

  }

  /**
   * Computes the expression based on the operator that is given
   * 
   * @param symbol   the operator
   * @param valueTwo left nodes value
   * @param valueOne right nodes value
   * @return value of the expression
   */
  private static int computeExpression(char symbol, int valueOne, int valueTwo) {
    int result = 0;
    if (symbol == '*')
      result = valueOne * valueTwo;
    else if (symbol == '/')
      result = valueOne / valueTwo;
    else if (symbol == '+')
      result = valueOne + valueTwo;
    else
      result = valueOne - valueTwo;

    return result;
  }
}
