import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {


  public BinaryTree() {}

  public static void depthFirstPrint(Node rootNode) {

    printNode(rootNode);

    Node leftChild = rootNode.getLeftChild();
    Node rightChild = rootNode.getRightChild();

    if (leftChild != null) {
      depthFirstPrint(leftChild);
    }

    if (rightChild != null) {
      depthFirstPrint(rightChild);
    }
  }

  public static void breadthFirstPrint(Node rootNode) {

    Queue<Node> printQ = new LinkedList<Node>();

    printQ.add(rootNode);

    while (!printQ.isEmpty()) {
      Node thisNode = printQ.remove();
      BFprint(thisNode, printQ);
    }
  }

  public static void printNode(Node thisNode) {
    System.out.println(thisNode.getData());
  }

  private static void BFprint(Node thisNode, Queue printingQ){

    System.out.println(thisNode.getData());

    Node leftChild = thisNode.getLeftChild();
    Node rightChild = thisNode.getRightChild();

    if (leftChild != null) {
      printingQ.add(leftChild);
    }

    if (rightChild != null) {
      printingQ.add(rightChild);
    }
  }

}


