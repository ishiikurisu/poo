public class StringTest {
  public static void msm_palavra(String s1, String s2) {
    if (s1.equals(s2)) {
      System.out.println("s1 eh igual a s2");
    }
    else {
      System.out.println("s1 num eh igual a s2");
    }
  }

  public static void msm_obj(String s1, String s2) {
    if (s1 == s2) {
      System.out.println("s1 eh o msm obj q s2");
    }
    else {
      System.out.println("s1 num eh o msm obj q s2");
    }
  }

  public static final void main(String args[]) {
    String s1 = new String("joe");
    String s2 = new String("joe");
    String s3 = "frank";
    String s4 = "frank";

    // Exercicio 3
    System.out.println("ex3");
    System.out.println(s1 + " tem " + s1.length() + " letras.");
    System.out.println(s2 + " tem " + s2.length() + " letras.");

    // Exercicio 4
    System.out.println("ex4");
    msm_palavra(s1, s2);

    // Exercicio 5
    System.out.println("ex5");
    msm_obj(s1, s2);

    // Exercicio 7
    System.out.println("ex7");
    msm_palavra(s3, s4);
    msm_obj(s3, s4);

    // Exercicio 8
    System.out.println("ex8");
    s3 = "luke";
    msm_palavra(s3, s4);
    msm_obj(s3, s4);
  }
}
