import org.junit.Test;

public class BinaryTreeTest {

  @Test
  public void DFprintTest() {

    BinaryNode node0 = new BinaryNode("rootBinaryNode");
    BinaryNode node1 = new BinaryNode("BinaryNode 1");
    BinaryNode node2 = new BinaryNode("BinaryNode 2");
    BinaryNode node3 = new BinaryNode("BinaryNode 3");
    BinaryNode node4 = new BinaryNode("BinaryNode 4");
    BinaryNode node5 = new BinaryNode("BinaryNode 5");
    BinaryNode node6 = new BinaryNode("BinaryNode 6");
    BinaryNode node7 = new BinaryNode("BinaryNode 7");

    node0.setLeftChild(node1);
    node0.setRightChild(node2);

    node1.setLeftChild(node3);
    node1.setRightChild(node4);

    node2.setLeftChild(node5);
    node2.setRightChild(node6);

    node3.setLeftChild(node7);

    BinaryTree.depthFirstPrint(node0);

  }

  @Test
  public void BFprintTest() {

    BinaryNode node0 = new BinaryNode("rootBinaryNode");
    BinaryNode node1 = new BinaryNode("BinaryNode 1");
    BinaryNode node2 = new BinaryNode("BinaryNode 2");
    BinaryNode node3 = new BinaryNode("BinaryNode 3");
    BinaryNode node4 = new BinaryNode("BinaryNode 4");
    BinaryNode node5 = new BinaryNode("BinaryNode 5");
    BinaryNode node6 = new BinaryNode("BinaryNode 6");
    BinaryNode node7 = new BinaryNode("BinaryNode 7");

    node0.setLeftChild(node1);
    node0.setRightChild(node2);

    node1.setLeftChild(node3);
    node1.setRightChild(node4);

    node2.setLeftChild(node5);
    node2.setRightChild(node6);

    node3.setLeftChild(node7);

    BinaryTree.breadthFirstPrint(node0);

  }
}
