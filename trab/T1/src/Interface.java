import java.util.Scanner;
import java.util.List;

public class Interface {
  /* Atributos */
  private static Scanner input;
  private static int option;

  /* Construtores */
  public Interface() {
    input = new Scanner(System.in);
  }

  /* Métodos */
  public static void reportarErro(String mensagemDeErro) {
    System.out.println(mensagemDeErro);
    //System.exit(1);
  }
  public static void escrever(String mensagem) {
    System.out.println(mensagem);
  }

  /**
  * Escreve mensagens no terminal pedindo informações
  */
  public static String pedir(String msg, String pedido) {
    System.out.print("  " + msg + ": ");
    pedido = input.next().trim();

    return pedido;
  }
  public static int pedir(String msg, int pedido) {
    System.out.print("  " + msg + ": ");
    pedido = input.nextInt();

    return pedido;
  }

  /**
  * Mostra uma coleção de dados por vez
  */
  public static void mostrar(String[] info, int maxSize) {
    String tag;
    String obj;
    String result;

    for (int i = 0; i < maxSize; ++i) {
      tag = info[2*i];
      obj = info[2*i+1];
      result = tag + ": " + obj;

      System.out.println("  " + result);
    }
    System.out.println("---");
  }

  /**
  * Mostra quais as opções disponíveis no programa em questão
  */
  public static void menuPrincipal() {
    /* TO DO: MOSTRAR POSSIVEIS OPCOES*/
    System.out.println("*** CENTRO DE ENSINO XYZ ***");
    System.out.println("Operações Disponíveis");
    System.out.println("1. Cadastrar aluno");
    System.out.println("2. Procurar aluno");
    System.out.println("3. Atualizar aluno");
    System.out.println("4. Descadastrar aluno");
    System.out.println("5. Cadastrar curso");
    System.out.println("6. Procurar curso");
    System.out.println("7. Atualizar curso");
    System.out.println("8. Descadastrar curso");
    System.out.println("9. Matricular aluno");
    System.out.println("10. Procurar matrícula");
    System.out.println("11. Cancelar matrícula");
    System.out.println("12. Listar todas as matrículas feitas");
    System.out.println("13. Listar todos os cursos cadastrados");
    System.out.println("14. Listar todos os alunos cadastrados");
    System.out.println("15. Listar todos os alunos de um curso");
    System.out.println("16. Listar todos os alunos de todos os cursos");
    System.out.println("17. Listar todos os cursos de um aluno");
    System.out.println("18. Listar todos os cursos de todos os alunos");
    System.out.println("19. Listar todas as matrículas de um aluno");
    System.out.println("20. Listar todas as matrículas de um curso");
    System.out.println("21. Listar alunos cadastrados sem curso");
    System.out.println("22. Listar cursos cadastrados sem alunos");
    System.out.println("23. SAIR");
  }

}
