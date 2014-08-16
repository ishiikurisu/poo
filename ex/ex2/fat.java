public class fat {
  public static long fatorial(long number) {
    for (long i = number - 1; i != 1; --i) {
      number *= i;
    }

    return number;
  }

  public static final void main(String args[]) {
    long number = 5L;

    System.out.println(fatorial(number));
  }
}
