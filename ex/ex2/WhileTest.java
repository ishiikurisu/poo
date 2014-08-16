public class WhileTest {
  public static final void main(String args[]) {
    byte i = 1;

    System.out.println("while:");
    while (i <= 10) {
      System.out.println("Interacao no " + i);
      ++i;
    }

    i = 1;
    System.out.println("do while:");
    do {
      System.out.println("Interacao no " + i);
      ++i;
    }
    while (i <= 10);
  }
}
