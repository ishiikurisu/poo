package T2.src.ui;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import T2.src.Fachada;

/*
Esta classe implementa a interface gr�fica para que o usu�rio possa
usar a aplicação.
*/
public class Interface {
  /* Atributos */
  private InputStreamReader ir = new InputStreamReader(System.in);
  private BufferedReader in = new BufferedReader(ir);
  private Fachada fachada;

  private int OP_CAD_ALUNO = 1;
  private int OP_PROC_ALUNO = 2;
  private int OP_ATUAL_ALUNO = 3;
  private int OP_DESCAD_ALUNO = 4;
  private int OP_CAD_CURSO = 5;
  private int OP_PROC_CURSO = 6;
  private int OP_ATUAL_CURSO = 7;
  private int OP_DESCAD_CURSO = 8;
  private int OP_MAT_ALUNO = 9;
  private int OP_PROC_MAT = 10;
  private int OP_CANCEL_MAT = 11;
  private int OP_LIST_TODAS_MATS = 12;
  private int OP_LIST_TODOS_CURSOS = 13;
  private int OP_LIST_TODOS_ALUNOS_CAD = 14;
  private int OP_LIST_TODOS_ALUNOS_CURSO = 15;
  private int OP_LIST_TODOS_ALUNOS_TODOS_CURSOS = 16;
  private int OP_LIST_TODOS_CURSOS_ALUNO = 17;
  private int OP_LIST_TODOS_CURSOS_TODOS_ALUNOS = 18;
  private int OP_LIST_TODAS_MATS_ALUNO = 19;
  private int OP_LIST_TODAS_MATS_CURSO = 20;
  private int OP_LIST_ALUNOS_SEM_CURSO = 21;
  private int OP_LIST_CURSOS_SEM_ALUNO = 22
  private int OP_EXIT = 23;


  /* Construtores */
  public static Interface() {
    int opcao;

    try {
      fachada = Fachada.obterInstancia();
    }
    catch (FachadaDuplicadaException e) {
      System.out.println("Fachada duplicada");
      System.exit();
    }

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
    String aluno;
    String curso;
    String nome;
    String novo;
    String endereco;
    String telefone;
    String codigo;
    String instrutor;
    int idade;
    int matricula;

    switch (opcao) {
      case OP_CAD_ALUNO:
        /*cadastrar aluno*/
        this.escrever("Cadastro de novx alunx");
        nome = this.pedir("Digite o nome", nome);
        endereco = this.pedir("Digite o endereço", endereco);
        telefone = this.pedir("Digite o telefone", telefone);
        idade = this.pedir("Digite a idade", idade);

        fachada.cadastrarAluno(nome, endereco, telefone, idade);
      break;

      case OP_PROC_ALUNO:
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

      case OP_ATUAL_ALUNO:
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

      case OP_DESCAD_ALUNO:
        /*descadastrar aluno*/
        this.escrever("Descadastro de alunx");
        nome = this.pedir("Digite o nome dx alunx", nome);
        fachada.descadastrarAluno();
        this.escrever("Alunx descadastradx");
      break;

      case OP_CAD_CURSO:
        /*cadastrar curso*/
        this.escrever("Cadastro de curso");
        codigo = this.pedir("Digite o código", codigo);
        nome = this.pedir("Digite o nome", nome);
        instrutor = this.pedir("Digite o nome do instrutor", instrutor);
        fachada.cadastrarCurso();
      break;

      case OP_PROC_CURSO:
        /*procurar curso*/
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

      case OP_ATUAL_CURSO:
        /*atualizar curso*/
        try {
          intfc.escrever("Atualização de curso");
          nome = this.pedir("Digite o nome", curso);
          novo = this.pedir("Digite o novo nome", nome);
          codigo = this.pedir("Digite o novo código", codigo);
          instrutor = this.pedir("Digite o novo instrutor", instrutor);
          fachada.atualizarCurso(nome, novoNome, codigo, instrutor);
          this.escrever("Curso atualizado!");
        }
        catch (PesquisaSemResultadoException e) {
          this.escrever(e.getMessage());
        }
      break;

      case OP_DESCAD_CURSO:
        /*descadastrar curso*/
        this.escrever("Descadastrar curso");
        nome = this.pedir("Digite o nome", nome);
        fachada.descadastrarCurso(nome);
      break;

      case OP_MAT_ALUNO:
        /*matricular aluno*/
        try {
          this.escrever("Matrícula");
          aluno = this.pedir("Nome do aluno", aluno);
          curso = this.pedir("Nome do curso", curso);
          matricula = fachada.matricularAluno(aluno, curso);
          this.escrever("Matricula gerada: " + matricula);
        }
        catch (ErroInternoException e) {
          this.escrever("Algum dos itens não existe");
        }
      break;

      case OP_PROC_MAT:
        /*procurar matrícula*/
        try {
          this.escrever("Procura de matrículas");
          matricula = this.pedir("Digite o número da matrícula", matricula);
          lista = fachada.procurarMatricula(matricula);
          this.mostrar(lista);
        }
        catch (MatriculaInexistenteException e) {
          this.escrever(e.getMessage());
        }

      case OP_CANCEL_MAT:
        /*cancelar matrícula*/
        this.escrever("Cancelamento de matrícula");
        matricula = this.pedir("Digite o número da matrícula", matricula);
        fachada.cancelarMatricula(matricula);
        this.escrever("Matrícula cancelada");
      break;

      case OP_LIST_TODAS_MATS:
        /*listar todas as matrículas feitas*/
        this.escrever("Todas as matrículas");
        this.mostrarVarios(fachada.listarMatriculas());
      break;

      case OP_LIST_TODOS_CURSOS:
        /*listar todos os cursos cadastrados*/
        this.escrever("Todas os cursos");
        this.mostarVarios(fachada.listarCursos());
      break;

      case OP_LIST_TODOS_ALUNOS_CAD:
        /*listar todos os alunos cadastrados*/
        this.escrever("Todas os alunos cadastrados");
        this.mostarVarios(fachada.listarAlunos());
      break;

      case OP_LIST_TODOS_ALUNOS_CURSO:
        /*listar todos os alunos de um curso*/
        this.escrever("Todos os alunos de um curso");
        curso = this.pedir("Digite um curso", curso);
        this.mostrarVarios(fachada.listarAlunosCurso(curso));
      break;

      case OP_LIST_TODOS_ALUNOS_TODOS_CURSOS:
        /*listar todos os alunos de todos os cursos*/
        this.escrever("Todos os alunos, por curso");
        this.mostrarVarios(fachada.listarTodosAlunos());
      break;

      case OP_LIST_TODOS_CURSO_ALUNO:
        /*listar todos os cursos de um aluno*/
        this.escrever("Todos os cursos de um aluno");
        aluno = this.pedir("Digite o nome de um aluno", aluno);
        this.mostrarVarios(fachada.listarCursosAluno());
      break;

      case OP_LIST_TODOS_CURSOS_TODOS_ALUNOS:
        /*listar todos os cursos de todos os alunos*/
        this.escrever("Todos os alunos de todos os cursos");
        this.mostrarVarios(fachada.listarTodosCursos());
      break;

      case OP_LIST_TODAS_MATS_ALUNO:
        /*listar todas as matrículas de um aluno*/
        this.escrever("Todas as matrículas de um aluno");
        aluno = this.pedir("Digite o nome do aluno", aluno);
        this.mostrarVarios(fachada.listarMatriculasAluno(aluno));
      break;

      case OP_LIST_TODAS_MATS_CURSO:
        /*listar todas as matrículas de um curso*/
        this.escrever("Todas as matrículas de um curso");
        curso = this.pedir("Digite o nome do curso", curso);
        this.mostrar(fachada.listarMatriculasCurso());
      break;

      case OP_LIST_ALUNOS_SEM_CURSO:
        /*listar alunos cadastrados sem curso*/
        this.escrever("Todos os alunos sem curso");
        this.mostrarVarios(fachada.listarAlunosSemCurso());
      break;

      case OP_LIST_CURSOS_SEM_ALUNO:
        /*listar cursos cadastrados sem alunos*/
        this.escrever("Todos os cursos sem alunos");
        this.mostrarVarios(fachada.listarCursosSemAluno());
      break;

      case OP_EXIT:
        /* sai do programa */
        System.out.println("Obrigado por usar a aplicação.");
        System.exit();
      break;

      default:
        System.out.println("Opção inexistente");
    }
  }
}
