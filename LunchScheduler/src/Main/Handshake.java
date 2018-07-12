package Main;

public class Handshake {

  private Employee shaker1;
  private Employee shaker2;

  public Handshake(Employee first, Employee second) {
    shaker1 = first;
    shaker2 = second;
  }

  public Employee getShaker1() {
    return shaker1;
  }
  public Employee getShaker2() {
    return shaker2;
  }

  public boolean equals(Handshake input) {

    //System.out.println("EQUALS CALL 1:" + shaker1 + " 2:" + shaker2);

    if (this.shaker1.equals(input.getShaker1()) && this.shaker2.equals(input.getShaker2()) ) {
      return true;
    } else if (this.shaker1.equals(input.getShaker2()) && this.shaker2.equals(input.getShaker1())) {
      return true;
    } else {
      return false;
    }
  }

  public boolean reverseEquals(Handshake input) {

    //System.out.println("EQUALS CALL 1:" + shaker1 + " 2:" + shaker2);
    if (this.shaker1.equals(input.getShaker2()) && this.shaker2.equals(input.getShaker1())) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public String toString() {
    return shaker1.toString() + " shakes hands with " + shaker2.toString();
  }
}
