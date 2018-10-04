import java.util.ArrayList;

public class Node {

  private Object data;
  private ArrayList<Node> children;

  public Node(Object data) {
    this.data = data;
    this.children = new ArrayList<>();
  }

  public Object getData() {
    return data;
  }

  public ArrayList<Node> getChildren() {
    return children;
  }

  public void setChildren(ArrayList<Node> children) {
    this.children = children;
  }
}


