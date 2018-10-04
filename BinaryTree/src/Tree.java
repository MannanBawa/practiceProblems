import java.util.ArrayList;

public class Tree {


  public Tree () {
  }

  public static void depthFirstPrint(Node rootNode) {

    printNode(rootNode);

    ArrayList<Node> children = rootNode.getChildren();

    if (children.size() > 0) {
      for (Node child : children) {
        depthFirstPrint(child);
      }
    }
  }

  public static void printNode(Node thisNode) {
    System.out.println(thisNode.getData());
  }



}
