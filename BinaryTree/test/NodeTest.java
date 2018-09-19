import org.junit.Test;

public class NodeTest {

  @Test
  public void DFprintTest() {

    Node node0 = new Node("rootNode");
    Node node1 = new Node("Node 1");
    Node node2 = new Node("Node 2");
    Node node3 = new Node("Node 3");
    Node node4 = new Node("Node 4");
    Node node5 = new Node("Node 5");
    Node node6 = new Node("Node 6");
    Node node7 = new Node("Node 7");

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

    Node node0 = new Node("rootNode");
    Node node1 = new Node("Node 1");
    Node node2 = new Node("Node 2");
    Node node3 = new Node("Node 3");
    Node node4 = new Node("Node 4");
    Node node5 = new Node("Node 5");
    Node node6 = new Node("Node 6");
    Node node7 = new Node("Node 7");

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
