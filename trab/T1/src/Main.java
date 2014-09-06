import java.util.*;

public class Main {
  private static RepositorioAluno repositorioAlunos = new RepositorioAluno();
  private static RepositorioCurso repositorioCursos = new RepositorioCurso();
  private static RepositorioMatricula repositorioMatriculas = new RepositorioMatricula();
  private static Scanner input = new Scanner(System.in);

  public static final void mensagemErro(String msg) {
    System.out.println(msg);
  }
  public static final void mensagemDeErro(String msg) {
    mensagemErro(msg);
  }

  /**
  * FUNÇÕES DE NEGÓCIO
  */
  static void cadastrarAluno() {
    Aluno aluno;
    String nome;
    String endereco;
    String telefone;
    int idade;

    System.out.println("Cadastro de novx alunx");
    System.out.print("  Digite o nome: ");
    nome = input.nextLine().trim();
    System.out.print("  Digite o endereço: ");
    endereco = input.nextLine().trim();
    System.out.print("  Digite o telefone: ");
    telefone = input.nextLine().trim();
    System.out.print("  Digite a idade: ");
    idade = input.nextInt();

    aluno = new Aluno(nome, endereco, telefone, idade);
    repositorioAlunos.adicionar(aluno);
  }

  static void procurarAluno() {
    Aluno aluno;
    String nome;

    System.out.println("Procura de alunos");
    System.out.print("  Digite o nome: ");
    nome = input.nextLine().trim();

    aluno = repositorioAlunos.procurar(nome);
    if (aluno != null) {
      System.out.println("Alunx encontradx: ");
      System.out.println("  Nome: " + aluno.getNome());
      System.out.println("  Endereço: " + aluno.getEndereco());
      System.out.println("  Telefone: " + aluno.getTelefone());
      System.out.println("  Idade: " + aluno.getIdade());
    }
    else {
      mensagemErro("Aluno não encontrado");
    }
  }

  static void atualizarAluno() {
    Aluno aluno;
    String nome;

    System.out.println("Atualização de aluno");
    System.out.print("  Digite o nome: ");
    nome = input.next();
    aluno = repositorioAlunos.procurar(nome);

    if (aluno != null) {
      String endereco;
      String telefone;
      int idade;

      System.out.print("  Digite o novo nome: ");
      nome = input.nextLine().trim();
      System.out.print("  Digite o novo endereço: ");
      endereco = input.nextLine().trim();
      System.out.print("  Digite o novo telefone: ");
      telefone = input.nextLine().trim();
      System.out.print("  Digite a nova idade: ");
      idade = input.nextInt();

      aluno.setNome(nome);
      aluno.setEndereco(endereco);
      aluno.setTelefone(telefone);
      aluno.setIdade(idade);
    }
    else {
      mensagemDeErro("Alunx não encontradx");
    }
  }

  static void descadastrarAluno() {
    String aluno;

    System.out.println("Descadastro de novo aluno");
    System.out.print("  Digite o nome: ");
    aluno = input.next();

    if (aluno == null)
      mensagemErro("Aluno não encontrado");
    else {
      repositorioAlunos.remover(aluno);
      System.out.println("Alunx removidx");
    }
  }

  static void cadastrarCurso() {
    Curso curso;
    String codigo;
    String nome;
    String instrutor;

    System.out.println("Cadastro de curso");
    System.out.print("  Digite o código: ");
    codigo = input.nextLine().trim();
    System.out.print("  Digite o nome: ");
    nome = input.nextLine().trim();
    System.out.print("  Digite o nome do instrutor: ");
    instrutor = input.nextLine().trim();

    curso = new Curso(codigo, nome, instrutor);
    repositorioCursos.adicionar(curso);
  }

  static void procurarCurso() {
    Curso curso;
    String nome;

    System.out.println("Procura de cursos");
    System.out.print("  Digite o nome: ");
    nome = input.nextLine().trim();

    curso = repositorioCursos.procurar(nome);
    if (curso != null) {
      System.out.println("Curso encontrado: ");
      System.out.println("  Código: " + curso.getCodigo());
      System.out.println("  Nome: " + curso.getNome());
      System.out.println("  Instrutor: " + curso.getInstrutor());
    }
    else {
      mensagemErro("Curso não encontrado");
    }
  }

  static void descadastrarCurso() {
    String curso;

    System.out.println("Descadastro de curso");
    System.out.print("  Digite o nome: ");
    curso = input.nextLine().trim();
    repositorioCursos.remover(curso);
  }

  static void atualizarCurso() {
    Curso curso;
    String nome;

    System.out.println("Atualização de curso");
    System.out.print("  Digite o nome: ");
    nome = input.next();
    curso = repositorioCursos.procurar(nome);

    if (curso != null) {
      String codigo;
      String instrutor;

      System.out.print("  Digite o novo nome: ");
      nome = input.nextLine().trim();
      System.out.print("  Digite o novo código: ");
      codigo = input.nextLine().trim();
      System.out.print("  Digite o novo instrutor: ");
      instrutor = input.nextLine().trim();

      curso.setNome(nome);
      curso.setCodigo(codigo);
      curso.setInstrutor(instrutor);
    }
    else {
      mensagemDeErro("Curso não encontrado");
    }
  }

  /**
  * FUNÇÕES DE LIGAÇÃO
  */
  static void realizar(int opcao) {
    switch (opcao) {
      case 1:
        /*cadastrar aluno*/
        cadastrarAluno();
        break;
      case 2:
        /*procurar aluno*/
        procurarAluno();
        break;
      case 3:
        /*atualizar aluno*/
        atualizarAluno();
        break;
      case 4:
        /*descadastrar aluno*/
        descadastrarAluno();
        break;
      case 5:
        /*cadastrar curso*/
        cadastrarCurso();
        break;
      case 6:
        /*procurar curso*/
        procurarCurso();
        break;
      case 7:
        /*atualizar curso*/
        atualizarCurso();
        break;
      case 8:
        /*descadastrar curso*/
        mensagemErro("Opção não implementada.");
        break;
      case 9:
        /*matricular aluno*/
        mensagemErro("Opção não implementada.");
        break;
      case 10:
        /*procurar matrícula*/
        mensagemErro("Opção não implementada.");
        break;
      case 11:
        /*cancelar matrícula*/
        mensagemErro("Opção não implementada.");
        break;
      case 12:
        /*listar todas as matrículas feitas*/
        mensagemErro("Opção não implementada.");
        break;
      case 13:
        /*listar todos os cursos cadastrados*/
        mensagemErro("Opção não implementada.");
        break;
      case 14:
        /*listar todos os alunos cadastrados*/
        mensagemErro("Opção não implementada.");
        break;
      case 15:
        /*listar todos os alunos de um curso*/
        mensagemErro("Opção não implementada.");
        break;
      case 16:
        /*listar todos os alunos de todos os cursos*/
        mensagemErro("Opção não implementada.");
        break;
      case 17:
        /*listar todos os cursos de um aluno*/
        mensagemErro("Opção não implementada.");
        break;
      case 18:
        /*listar todos os cursos de todos os alunos*/
        mensagemErro("Opção não implementada.");
        break;
      case 19:
        /*listar todas as matrículas de um aluno*/
        mensagemErro("Opção não implementada.");
        break;
      case 20:
        /*listar todas as matrículas de um curso*/
        mensagemErro("Opção não implementada.");
        break;
      case 21:
        /*listar alunos cadastrados sem curso*/
        mensagemErro("Opção não implementada.");
        break;
      case 22:
        /*listar cursos cadastrados sem alunos*/
        mensagemErro("Opção não implementada.");
        break;
      case 23:
        /*do some shit*/
        //mensagemErro("Opção não implementada.");
        break;

      default:
        mensagemErro("Opção inexistente.");
        break;
    }
  }

  public static final void main(String[] args) {
    Interface intf = new Interface();
    int opcao;

    while (true) {
      intf.menuPrincipal();
      opcao = intf.escolher();
      if (opcao == 0) break;
      else realizar(opcao);
    }
  }
}