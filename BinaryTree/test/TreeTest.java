import org.junit.Test;

import java.util.ArrayList;

public class TreeTest {

  @Test
  public void testOne() {

    Node node0 = new Node("rootNode");
    Node node1 = new Node("Node 1");
    Node node2 = new Node("Node 2");
    Node node3 = new Node("Node 3");
    Node node4 = new Node("Node 4");
    Node node5 = new Node("Node 5");
    Node node6 = new Node("Node 6");
    Node node7 = new Node("Node 7");

    ArrayList node0Kids = new ArrayList();
    node0Kids.add(node1);
    node0Kids.add(node2);
    node0Kids.add(node3);
    node0Kids.add(node4);
    node0.setChildren(node0Kids);

    ArrayList node1Kids = new ArrayList();
    node1Kids.add(node5);
    node1Kids.add(node6);
    node1.setChildren(node1Kids);

    ArrayList node4Kids = new ArrayList();
    node4Kids.add(node7);
    node4.setChildren(node4Kids);

    Tree.depthFirstPrint(node0);

  }
}
