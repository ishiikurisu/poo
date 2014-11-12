package escola.ui;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import escola.Fachada;
import escola.cadastro.ErroInternoException;
import escola.cadastro.FachadaDuplicadaException;
import escola.cadastro.FalhaAtualizacaoException;
import escola.cadastro.MatriculaInexistenteException;
import escola.cadastro.PesquisaSemResultadoException;

/*
Esta classe implementa a interface gr�fica para que o usu�rio possa
usar a aplicação.
*/
public class Interface {
  /* Atributos */
  private static InputStreamReader ir = new InputStreamReader(System.in);
  private static BufferedReader in = new BufferedReader(ir);
  private static Fachada fachada;

  private static final int OP_CAD_ALUNO = 1;
  private static final int OP_PROC_ALUNO = 2;
  private static final int OP_ATUAL_ALUNO = 3;
  private static final int OP_DESCAD_ALUNO = 4;
  private static final int OP_CAD_CURSO = 5;
  private static final int OP_PROC_CURSO = 6;
  private static final int OP_ATUAL_CURSO = 7;
  private static final int OP_DESCAD_CURSO = 8;
  private static final int OP_MAT_ALUNO = 9;
  private static final int OP_PROC_MAT = 10;
  private static final int OP_CANCEL_MAT = 11;
  private static final int OP_LIST_TODAS_MATS = 12;
  private static final int OP_LIST_TODOS_CURSOS = 13;
  private static final int OP_LIST_TODOS_ALUNOS_CAD = 14;
  private static final int OP_LIST_TODOS_ALUNOS_CURSO = 15;
  private static final int OP_LIST_TODOS_ALUNOS_TODOS_CURSOS = 16;
  private static final int OP_LIST_TODOS_CURSOS_ALUNO = 17;
  private static final int OP_LIST_TODOS_CURSOS_TODOS_ALUNOS = 18;
  private static final int OP_LIST_TODAS_MATS_ALUNO = 19;
  private static final int OP_LIST_TODAS_MATS_CURSO = 20;
  private static final int OP_LIST_ALUNOS_SEM_CURSO = 21;
  private static final int OP_LIST_CURSOS_SEM_ALUNO = 22;
  private static final int OP_EXIT = 23;


  /* Construtores */
  public Interface() {
    int opcao = 0;

    try {
      fachada = Fachada.obterInstancia();
    }
    catch (FachadaDuplicadaException e) {
      System.out.println("Fachada duplicada");
      System.exit(1);
    }

    while (true) {
      menuPrincipal();
      opcao = pedir("Favor escolher uma opcao", opcao);
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

  public static void mostrar(List info) {
    mostrar((String[]) info.toArray());
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
  public static void realizar(int opcao) {
    String[] lista = null;
    String aluno = null;
    String curso = null;
    String nome = null;
    String novo = null;
    String endereco = null;
    String telefone = null;
    String codigo = null;
    String instrutor = null;
    int idade = 0;
    int matricula = 0;

    switch (opcao) {
      case OP_CAD_ALUNO:
        /*cadastrar aluno*/
        escrever("Cadastro de novx alunx");
        nome = pedir("Digite o nome", nome);
        endereco = pedir("Digite o endereço", endereco);
        telefone = pedir("Digite o telefone", telefone);
        idade = pedir("Digite a idade", idade);

        fachada.cadastrarAluno(nome, endereco, telefone, idade);
      break;

      case OP_PROC_ALUNO:
        /*procurar aluno*/
        try {
          escrever("Procura de alunos");
          nome = pedir("Digite o nome", nome);
          lista = fachada.procurarAluno(nome);
          System.out.println("Alunx encontradx");
          mostrar(lista);
        }
        catch (PesquisaSemResultadoException e) {
          System.out.println(e.getMessage());
        }
      break;

      case OP_ATUAL_ALUNO:
        /*atualizar aluno*/
        try {
          escrever("Atualização de alunx");
          nome = pedir("Digite o nome", nome);
          novo = pedir("Digite o novo nome", novo);
          endereco = pedir("Digite o novo endereço", endereco);
          telefone = pedir("Digite o novo telefone", telefone);
          idade = pedir("Digite a nova idade", idade);
          fachada.atualizarAluno(nome, novo, endereco, telefone, idade);
          escrever("Alunx atualizadx");
        }
        catch (FalhaAtualizacaoException e) {
          escrever(e.getMessage());
        }
      break;

      case OP_DESCAD_ALUNO:
        /*descadastrar aluno*/
        escrever("Descadastro de alunx");
        nome = pedir("Digite o nome dx alunx", nome);
        fachada.descadastrarAluno(nome);
        escrever("Alunx descadastradx");
      break;

      case OP_CAD_CURSO:
        /*cadastrar curso*/
        escrever("Cadastro de curso");
        codigo = pedir("Digite o código", codigo);
        nome = pedir("Digite o nome", nome);
        instrutor = pedir("Digite o nome do instrutor", instrutor);
        fachada.cadastrarCurso(codigo, nome, instrutor);
      break;

      case OP_PROC_CURSO:
        /*procurar curso*/
        try {
          escrever("Procura de cursos");
          nome = pedir("Digite o nome", nome);
          lista = fachada.procurarCurso(nome);
          escrever("Curso encontrado:");
          mostrar(lista);
        }
        catch (PesquisaSemResultadoException e) {
          escrever(e.getMessage());
        }
      break;

      case OP_ATUAL_CURSO:
        /*atualizar curso*/
        try {
          escrever("Atualização de curso");
          nome = pedir("Digite o nome", curso);
          novo = pedir("Digite o novo nome", nome);
          codigo = pedir("Digite o novo código", codigo);
          instrutor = pedir("Digite o novo instrutor", instrutor);
          fachada.atualizarCurso(nome, novo, codigo, instrutor);
          escrever("Curso atualizado!");
        }
        catch (PesquisaSemResultadoException e) {
          escrever(e.getMessage());
        }
      break;

      case OP_DESCAD_CURSO:
        /*descadastrar curso*/
        escrever("Descadastrar curso");
        nome = pedir("Digite o nome", nome);
        fachada.descadastrarCurso(nome);
      break;

      case OP_MAT_ALUNO:
        /*matricular aluno*/
        try {
          escrever("Matrícula");
          aluno = pedir("Nome do aluno", aluno);
          curso = pedir("Nome do curso", curso);
          matricula = fachada.matricularAluno(aluno, curso);
          escrever("Matricula gerada: " + matricula);
        }
        catch (ErroInternoException e) {
          escrever("Algum dos itens não existe");
        }
      break;

      case OP_PROC_MAT:
        /*procurar matrícula*/
        try {
          escrever("Procura de matrículas");
          matricula = pedir("Digite o número da matrícula", matricula);
          lista = fachada.procurarMatricula(matricula);
          mostrar(lista);
        }
        catch (MatriculaInexistenteException e) {
          escrever(e.getMessage());
        }

      case OP_CANCEL_MAT:
        /*cancelar matrícula*/
        escrever("Cancelamento de matrícula");
        matricula = pedir("Digite o número da matrícula", matricula);
        fachada.cancelarMatricula(matricula);
        escrever("Matrícula cancelada");
      break;

      case OP_LIST_TODAS_MATS:
        /*listar todas as matrículas feitas*/
        escrever("Todas as matrículas");
        mostrarVarios(fachada.listarMatriculas());
      break;

      case OP_LIST_TODOS_CURSOS:
        /*listar todos os cursos cadastrados*/
        escrever("Todas os cursos");
        mostrarVarios(fachada.listarCursos());
      break;

      case OP_LIST_TODOS_ALUNOS_CAD:
        /*listar todos os alunos cadastrados*/
        escrever("Todas os alunos cadastrados");
        mostrarVarios(fachada.listarAlunos());
      break;

      case OP_LIST_TODOS_ALUNOS_CURSO:
        /*listar todos os alunos de um curso*/
        escrever("Todos os alunos de um curso");
        curso = pedir("Digite um curso", curso);
        mostrarVarios(fachada.listarAlunosCurso(curso));
      break;

      case OP_LIST_TODOS_ALUNOS_TODOS_CURSOS:
        /*listar todos os alunos de todos os cursos*/
        escrever("Todos os alunos, por curso");
        mostrarVarios(fachada.listarTodosAlunos());
      break;

      case OP_LIST_TODOS_CURSOS_ALUNO:
        /*listar todos os cursos de um aluno*/
        escrever("Todos os cursos de um aluno");
        aluno = pedir("Digite o nome de um aluno", aluno);
        mostrarVarios(fachada.listarCursosAluno(aluno));
      break;

      case OP_LIST_TODOS_CURSOS_TODOS_ALUNOS:
        /*listar todos os cursos de todos os alunos*/
        escrever("Todos os alunos de todos os cursos");
        mostrarVarios(fachada.listarTodosCursos());
      break;

      case OP_LIST_TODAS_MATS_ALUNO:
        /*listar todas as matrículas de um aluno*/
        escrever("Todas as matrículas de um aluno");
        aluno = pedir("Digite o nome do aluno", aluno);
        mostrarVarios(fachada.listarMatriculasAluno(aluno));
      break;

      case OP_LIST_TODAS_MATS_CURSO:
        /*listar todas as matrículas de um curso*/
        escrever("Todas as matrículas de um curso");
        curso = pedir("Digite o nome do curso", curso);
        mostrar(fachada.listarMatriculasCurso(curso));
      break;

      case OP_LIST_ALUNOS_SEM_CURSO:
        /*listar alunos cadastrados sem curso*/
        escrever("Todos os alunos sem curso");
        mostrarVarios(fachada.listarAlunosSemCurso());
      break;

      case OP_LIST_CURSOS_SEM_ALUNO:
        /*listar cursos cadastrados sem alunos*/
        escrever("Todos os cursos sem alunos");
        mostrarVarios(fachada.listarCursosSemAluno());
      break;

      case OP_EXIT:
        /* sai do programa */
        System.out.println("Obrigado por usar a aplicação.");
        System.exit(0);
      break;

      default:
        System.out.println("Opção inexistente");
    }
  }
}
