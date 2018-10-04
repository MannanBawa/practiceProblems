public class RBNode extends BinaryNode{

  boolean isRed;

  public RBNode() {
    super.data = null;
    super.leftChild = null;
    super.rightChild = null;
    this.isRed = true;
  }

  public RBNode(Object data) {
    super.data = data;
    super.leftChild = null;
    super.rightChild = null;
    this.isRed = true;
  }

  public RBNode(Object data, RBNode leftChild) {
    super.data = data;
    super.leftChild = leftChild;
    super.rightChild = null;
    this.isRed = true;
  }

  public RBNode(Object data, RBNode leftChild, RBNode rightChild) {
    super.data = data;
    super.leftChild = leftChild;
    super.rightChild = rightChild;
    this.isRed = true;
  }



}
