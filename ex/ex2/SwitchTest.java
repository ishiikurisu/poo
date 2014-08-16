public class SwitchTest {
  public static void without() {
    byte number = 3;

    System.out.println("without:");
    switch (number) {
      case 1:
        System.out.println(1);

      case 2:
        System.out.println(2);

      case 3:
        System.out.println(3);

      default:
        System.out.println(4);
    }
  }

  public static void with() {
    byte number = 3;

    System.out.println("with:");
    switch (number) {
      case 1:
        System.out.println(1);
        break;
      case 2:
        System.out.println(2);
        break;
      case 3:
        System.out.println(3);
        break;
      default:
        System.out.println(4);
        break;
    }
  }

  public static final void main(String args[]) {
    without();
    with();
  }
}
