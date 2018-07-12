package Main;

import java.util.ArrayList;

public class Employee {

  //public boolean Present;
  //public int handsShaken ;

  private int employeeNumber;
  private ArrayList<Handshake> handshakes;

  public Employee(int newNum) {
    employeeNumber = newNum;
    handshakes = new ArrayList<>();
  }

  public int getEmployeeNumber() {
    return employeeNumber;
  }

  public ArrayList<Handshake> getHandshakes() {
    return handshakes;
  }

  public Handshake shakeHands(Employee other) {
    Handshake thisShake = new Handshake(this, other);
    return thisShake;
  }

  public boolean equals(Employee otherEmployee) {
    return  (this.employeeNumber == otherEmployee.getEmployeeNumber());
  }

  @Override
  public String toString() {
    return "Employee " + employeeNumber;
  }





}
