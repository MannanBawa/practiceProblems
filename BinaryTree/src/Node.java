public class Node {

  private Object data;
  private Node leftChild;
  private Node rightChild;

  public Node (Object data) {
    this.data = data;
    this.leftChild = null;
    this.rightChild = null;
  }

  public Node (Object data, Node leftChild, Node rightChild) {
    this.data = data;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public Node getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(Node leftChild) {
    if (this.leftChild == null) {
      this.leftChild = leftChild;
    } else {
      throw new IllegalArgumentException("Node: " + data + "already has it's leftChild assigned");
    }
  }

  public Node getRightChild() {
    return this.rightChild;
  }

  public void setRightChild(Node rightChild) {
    if (this.rightChild == null) {
      this.rightChild = rightChild;
    } else {
      throw new IllegalArgumentException("Node: " + data + "already has it's rightChild assigned");
    }
  }

}
