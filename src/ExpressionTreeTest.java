import static org.junit.Assert.*;
import org.junit.Test;

public class ExpressionTreeTest {

  // Testing the Constructor for ExpressionTree
  @Test
  public void ExpressionTreeConstructorTest() {
    ExpressionTree tree = new ExpressionTree("10 6 * 4 3 + -");
    assertEquals("ConstructorTest fails", '-', tree.root.symbol);
  }

  // Testing the PrefixNotation method
  @Test
  public void getPrefixNotationTest() {
    ExpressionTree tree = new ExpressionTree("10 6 * 4 3 + -");
    assertEquals("PrefixNotation fails", "- * 10 6 + 4 3 ", tree.getPrefixNotation());

  }

  // Testing the PrefixNotation method
  @Test
  public void getPrefixNotationTest2() {
    ExpressionTree tree = new ExpressionTree("2 3 + 9 8 * -");
    assertEquals("PrefixNotation fails", "- + 2 3 * 9 8 ", tree.getPrefixNotation());

  }

  // Testing the InfixNotation method
  @Test
  public void getInfixNotationTest() {
    ExpressionTree tree = new ExpressionTree("10 6 * 4 3 + -");
    assertEquals("InfixNotation fails", "((10 * 6) - (4 + 3))", tree.getInfixNotation());

  }

  // Testing the InfixNotation method
  @Test
  public void getInfixNotationTest2() {
    ExpressionTree tree = new ExpressionTree("2 3 + 9 8 * -");
    assertEquals("InfixNotation fails", "((2 + 3) - (9 * 8))", tree.getInfixNotation());

  }

  // Testing the getValue method
  @Test
  public void getValueTest() {
    ExpressionTree tree = new ExpressionTree("10 6 * 4 3 + -");
    assertEquals("InfixNotation fails", 53, tree.getValue());

  }

  // Testing the getValue method
  @Test
  public void getValueTest2() {
    ExpressionTree tree = new ExpressionTree("2 3 + 9 8 * -");
    assertEquals("InfixNotation fails", -67, tree.getValue());

  }
}
