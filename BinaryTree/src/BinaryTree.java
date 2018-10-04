import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {

  public static void depthFirstPrint(BinaryNode rootBinaryNode) {

    printBinaryNode(rootBinaryNode);

    BinaryNode leftChild = rootBinaryNode.getLeftChild();
    BinaryNode rightChild = rootBinaryNode.getRightChild();

    if (leftChild != null) {
      depthFirstPrint(leftChild);
    }

    if (rightChild != null) {
      depthFirstPrint(rightChild);
    }
  }

  public static void breadthFirstPrint(BinaryNode rootBinaryNode) {

    Queue<BinaryNode> printQ = new LinkedList<BinaryNode>();

    printQ.add(rootBinaryNode);

    while (!printQ.isEmpty()) {
      BinaryNode thisBinaryNode = printQ.remove();
      BFprint(thisBinaryNode, printQ);
    }
  }

  public static void printBinaryNode(BinaryNode thisBinaryNode) {
    System.out.println(thisBinaryNode
            .getData());
  }

  private static void BFprint(BinaryNode thisBinaryNode, Queue printingQ){

    System.out.println(thisBinaryNode.getData());

    BinaryNode leftChild = thisBinaryNode.getLeftChild();
    BinaryNode rightChild = thisBinaryNode.getRightChild();

    if (leftChild != null) {
      printingQ.add(leftChild);
    }

    if (rightChild != null) {
      printingQ.add(rightChild);
    }
  }

}


