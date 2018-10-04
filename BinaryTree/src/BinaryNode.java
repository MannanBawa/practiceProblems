public class BinaryNode {

  protected Object data;
  protected BinaryNode leftChild;
  protected BinaryNode rightChild;

  public BinaryNode() {
    data = null;
    leftChild = null;
    rightChild = null;
  }

  public BinaryNode (Object data) {
    this.data = data;
    this.leftChild = null;
    this.rightChild = null;
  }

  public BinaryNode (Object data, BinaryNode leftChild, BinaryNode rightChild) {
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

  public BinaryNode getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(BinaryNode leftChild) {
    if (this.leftChild == null) {
      this.leftChild = leftChild;
    } else {
      throw new IllegalArgumentException("Node: " + data + "already has it's leftChild assigned");
    }
  }

  public BinaryNode getRightChild() {
    return this.rightChild;
  }

  public void setRightChild(BinaryNode rightChild) {
    if (this.rightChild == null) {
      this.rightChild = rightChild;
    } else {
      throw new IllegalArgumentException("Node: " + data + "already has it's rightChild assigned");
    }
  }

}
