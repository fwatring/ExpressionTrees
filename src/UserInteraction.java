import java.util.Scanner;

public class UserInteraction {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String postFix = scan.nextLine();

    ExpressionTree tree = new ExpressionTree(postFix);

    System.out.println("Input: " + postFix + '\n');

    System.out.println("Output: " + '\n');

    System.out.println("Prefix: " + tree.getPrefixNotation());
    System.out.println("Infix: " + tree.getInfixNotation());
    System.out.println("Result: " + tree.getValue());

  }

}
