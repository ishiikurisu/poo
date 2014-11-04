package src.gui;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/*
Esta classe implementa a interface gr�fica para que o usu�rio possa
usar a aplicação.
*/
public class Interface {
  /* Atributos */
  private InputStreamReader ir = new InputStreamReader(System.in);
  private BufferedReader in = new BufferedReader(ir);
  private Fachada fachada = new Fachada();

  /* Construtores */
  public static Interface() {
    int opcao;

    while (true) {
      menuPrincipal();
      opcao = this.pedir("Favor escolher uma opcao", opcao);
      realizar(opcao);
    }
  }

  /* Métodos */
  public static void reportarErro(String mensagemDeErro) {
    System.out.println(mensagemDeErro);
  }
  public static void escrever(String mensagem) {
    System.out.println(mensagem);
  }

  /**
  * Escreve mensagens no terminal pedindo informações e retorna
  * o que o usuário responde
  */
  public static String pedir(String msg, String pedido) {
    System.out.print("  " + msg + ": ");
    try {
      pedido = in.readLine().trim();
    } catch (IOException e) {}


    return pedido;
  }
  public static int pedir(String msg, int pedido) {
    System.out.print("  " + msg + ": ");
    try { pedido = Integer.parseInt(in.readLine());
    } catch (IOException e) {}

    return pedido;
  }

  /**
  * Mostra uma coleção de dados por vez
  */
  public static void mostrar(String[] info) {
    int tamanho = Integer.parseInt(info[0]);
    String tag;
    String obj;
    String result;

    for (int i = 1; i <= tamanho; ++i) {
      tag = info[2*i-1];
      obj = info[2*i];
      result = tag + ": " + obj;

      System.out.println("  " + result);
    }
    System.out.println(" ");
  }

  /**
  * Mostra várias coleções de dados
  */
  public static void mostrarVarios(List infos) {
    for (Object info: infos) {
      mostrar((String[]) info);
    }
  }

  /**
  * Mostra quais as opções disponíveis no programa em quest�o
  */
  public static void menuPrincipal() {
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

  /**
  * Chama uma determinada funcionalidade da fachada
  */
  static void realizar(int opcao) {
    String[] lista;
    String nome;
    String novo;
    String endereco;
    String telefone;
    String codigo;
    String instrutor;
    int idade;

    switch (opcao) {
      case 1:
        /*cadastrar aluno*/
        this.escrever("Cadastro de novx alunx");
        nome = this.pedir("Digite o nome", nome);
        endereco = this.pedir("Digite o endereço", endereco);
        telefone = this.pedir("Digite o telefone", telefone);
        idade = this.pedir("Digite a idade", idade);

        fachada.cadastrarAluno(nome, endereco, telefone, idade);
        break;

      case 2:
        /*procurar aluno*/
        try {
          this.escrever("Procura de alunos");
          nome = this.pedir("Digite o nome", nome);
          lista = fachada.procurarAluno(nome);
          System.out.println("Alunx encontradx");
          this.mostrar(lista);
        }
        catch (PesquisaSemResultadoException e) {
          System.out.println(e.getMessage());
        }
        break;

      case 3:
        /*atualizar aluno*/
        try {
          this.escrever("Atualização de alunx");
          nome = this.pedir("Digite o nome", nome);
          novo = this.pedir("Digite o novo nome", novo);
          endereco = this.pedir("Digite o novo endereço", endereco);
          telefone = this.pedir("Digite o novo telefone", telefone);
          idade = this.pedir("Digite a nova idade", idade);
          fachada.atualizarAluno(nome, novo, endereco, telefone, idade);
          this.escrever("Alunx atualizadx");
        }
        catch (FalhaAtualizacaoException e) {
          this.escrever(e.getMessage());
        }
        break;

      case 4:
        /*descadastrar aluno*/
        this.escrever("Descadastro de alunx");
        nome = this.pedir("Digite o nome dx alunx", nome);
        fachada.descadastrarAluno();
        this.escrever("Alunx descadastradx");
        break;

      case 5:
        /*cadastrar curso*/
        this.escrever("Cadastro de curso");
        codigo = this.pedir("Digite o código", codigo);
        nome = this.pedir("Digite o nome", nome);
        instrutor = this.pedir("Digite o nome do instrutor", instrutor);
        fachada.cadastrarCurso();
        break;

      case 6:
        /*procurar curso*/
        fachada.procurarCurso();
        try {
          this.escrever("Procura de cursos");
          nome = this.pedir("Digite o nome", nome);
          lista = fachada.procurarCurso(nome);
          this.escrever("Curso encontrado:");
          this.mostrar(lista);
        }
        catch (PesquisaSemResultadoException e) {
          this.escrever(e.getMessage());
        }
        break;

      case 7:
        /*atualizar curso*/
        fachada.atualizarCurso();
        break;
      case 8:
        /*descadastrar curso*/
        fachada.descadastrarCurso();
        break;
      case 9:
        /*matricular aluno*/
        fachada.matricularAluno();
        break;
      case 10:
        /*procurar matrícula*/
        fachada.procurarMatricula();
        break;
      case 11:
        /*cancelar matrícula*/
        fachada.cancelarMatricula();
        break;
      case 12:
        /*listar todas as matrículas feitas*/
        fachada.listarMatriculas();
        break;
      case 13:
        /*listar todos os cursos cadastrados*/
        fachada.listarCursos();
        break;
      case 14:
        /*listar todos os alunos cadastrados*/
        fachada.listarAlunos();
        break;
      case 15:
        /*listar todos os alunos de um curso*/
        fachada.listarAlunosCurso();
        break;
      case 16:
        /*listar todos os alunos de todos os cursos*/
        fachada.listarTodosAlunos();
        break;
      case 17:
        /*listar todos os cursos de um aluno*/
        fachada.listarCursosAluno();
        break;
      case 18:
        /*listar todos os cursos de todos os alunos*/
        fachada.listarTodosCursos();
        break;
      case 19:
        /*listar todas as matrículas de um aluno*/
        fachada.listarMatriculasAluno();
        break;
      case 20:
        /*listar todas as matrículas de um curso*/
        fachada.listarMatriculasCurso();
        break;
      case 21:
        /*listar alunos cadastrados sem curso*/
        fachada.listarAlunosSemCurso();
        break;
      case 22:
        /*listar cursos cadastrados sem alunos*/
        fachada.listarCursosSemAluno();
        break;
      case 23:
        /* sai do programa */
        System.out.println("Obrigado por usar a aplicação.");
        exit();
        break;

      default:
        System.out.println("Opção inexistente");
    }
  }
}
