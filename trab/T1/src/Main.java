/**
* Classe principal do 1o projeto da matéria Programação Orientada a Objetos
* <p>
* O objetivo deste trabalho é criar um sistema de cadastro para uma escola baseado
* nas espeficicações fornecidas pelo professor.
* </p>
* <p>
* Aqui, vamos lidar com o cadastro de alunos, de cursos e as matrículas associadas
* a estes. Para tanto, criamos uma classe para cada um destes tipos e um classe de
* repositório para lidar com grandes quantidades de cada um destes objetos.
* </p>
* <p>
* Para usar o programa, criamos uma classe de interface do tipo textual, que permite
* o usuário usar todas as funcionalidades permitidas pelo programa a partir de um
* menu principal.
* </p>
* @author Cristiano Silva Jr - 13/0070629 <cristianoalvesjr@gmail.com>
*/

public class Main {
  /* Atributos */
  private static RepositorioAluno repositorioAlunos = new RepositorioAluno();
  private static RepositorioCurso repositorioCursos = new RepositorioCurso();
  private static RepositorioMatricula repositorioMatriculas = new RepositorioMatricula();
  private static Interface intfc = new Interface();

  /* FUNÇÕES DE NEGÓCIO */

  /**
  * Cadastra um novo aluno
  */
  public static void cadastrarAluno() {
    Aluno aluno = null;
    String nome = null;
    String endereco = null;
    String telefone = null;
    int idade = 0;

    intfc.escrever("Cadastro de novx alunx");
    nome = intfc.pedir("Digite o nome", nome);
    endereco = intfc.pedir("Digite o endereço", endereco);
    telefone = intfc.pedir("Digite o telefone", telefone);
    idade = intfc.pedir("Digite a idade", idade);

    aluno = new Aluno(nome, endereco, telefone, idade);
    repositorioAlunos.adicionar(aluno);
  }

  /**
  * Procura por um já cadastrado aluno
  */
  public static void procurarAluno() {
    Aluno aluno = null;
    String nome = null;

    intfc.escrever("Procura de alunos");
    nome = intfc.pedir("Digite o nome", nome);

    aluno = repositorioAlunos.procurar(nome);
    if (aluno != null) {
      intfc.escrever("Alunx encontradx: ");
      intfc.escrever("  Nome: " + aluno.getNome());
      intfc.escrever("  Endereço: " + aluno.getEndereco());
      intfc.escrever("  Telefone: " + aluno.getTelefone());
      intfc.escrever("  Idade: " + aluno.getIdade());
    }
    else {
      intfc.reportarErro("Aluno não encontrado");
    }
  }

  /**
  * Atualiza os dados cadastrais de um determinado aluno
  */
  public static void atualizarAluno() {
    Aluno aluno;
    String nome = null;

    intfc.escrever("Atualização de alunx");
    nome = intfc.pedir("Digite o nome", nome);
    aluno = repositorioAlunos.procurar(nome);

    if (aluno != null) {
      String endereco = null;
      String telefone = null;
      int idade = 0;

      intfc.escrever("Alunx encontradx! Atualize:");
      nome = intfc.pedir("Digite o novo nome", nome);
      endereco = intfc.pedir("Digite o novo endereço", endereco);
      telefone = intfc.pedir("Digite o novo telefone", telefone);
      idade = intfc.pedir("Digite a nova idade", idade);

      aluno.setNome(nome);
      aluno.setEndereco(endereco);
      aluno.setTelefone(telefone);
      aluno.setIdade(idade);
    }
    else {
      intfc.reportarErro("Alunx não encontradx");
    }
  }

  /**
  * Descadastra um aluno
  */
  public static void descadastrarAluno() {
    String aluno = null;

    intfc.escrever("Descadastro de novo aluno");
    aluno = intfc.pedir("Digite o nome", aluno);

    if (aluno == null)
      intfc.reportarErro("Aluno não encontrado");
    else {
      repositorioAlunos.remover(aluno);
      intfc.escrever("Alunx removidx");
    }
  }

  /**
  * Cadastra um novo curso
  */
  public static void cadastrarCurso() {
    Curso curso;
    String codigo = null;
    String nome = null;
    String instrutor = null;

    intfc.escrever("Cadastro de curso");
    codigo = intfc.pedir("Digite o código", codigo);
    nome = intfc.pedir("Digite o nome", nome);
    instrutor = intfc.pedir("Digite o nome do instrutor", instrutor);

    curso = new Curso(codigo, nome, instrutor);
    repositorioCursos.adicionar(curso);
  }

  /**
  * Procura por um determinado curso
  */
  public static void procurarCurso() {
    Curso curso;
    String nome = null;

    intfc.escrever("Procura de cursos");
    nome = intfc.pedir("Digite o nome", nome);

    curso = repositorioCursos.procurar(nome);
    if (curso != null) {
      intfc.escrever("Curso encontrado: ");
      intfc.escrever("  Código: " + curso.getCodigo());
      intfc.escrever("  Nome: " + curso.getNome());
      intfc.escrever("  Instrutor: " + curso.getInstrutor());
    }
    else {
      intfc.reportarErro("Curso não encontrado");
    }
  }

  /**
  * Descadastra um curso
  */
  public static void descadastrarCurso() {
    String curso = null;

    intfc.escrever("Descadastro de curso");
    curso = intfc.pedir("Digite o nome", curso);
    repositorioCursos.remover(curso);
  }

  /**
  * Atualiza as informações cadastrais de um curso
  */
  public static void atualizarCurso() {
    Curso curso;
    String nome = null;

    intfc.escrever("Atualização de curso");
    nome = intfc.pedir("Digite o nome", nome);
    curso = repositorioCursos.procurar(nome);

    if (curso != null) {
      String codigo = null;
      String instrutor = null;

      intfc.escrever("Curso encontrado! Atualize:");
      nome = intfc.pedir("Digite o novo nome", nome);
      codigo = intfc.pedir("Digite o novo código", codigo);
      instrutor = intfc.pedir("Digite o novo instrutor", instrutor);

      curso.setNome(nome);
      curso.setCodigo(codigo);
      curso.setInstrutor(instrutor);
    }
    else {
      intfc.reportarErro("Curso não encontrado");
    }
  }

  /**
  * Matricula um aluno em um curso
  */
  public static void matricularAluno() {
    String nomeAluno = null;
    String nomeCurso = null;

    intfc.escrever("Matrícula");
    nomeAluno = intfc.pedir("Digite o nome do aluno", nomeAluno);
    nomeCurso = intfc.pedir("Digite o nome do curso", nomeCurso);

    Aluno aluno = repositorioAlunos.procurar(nomeAluno);
    Curso curso = repositorioCursos.procurar(nomeCurso);

    if (aluno == null || curso == null)
      intfc.reportarErro("Erro interno");
    else {
      Matricula matricula = new Matricula(aluno, curso);
      repositorioMatriculas.adicionar(matricula);
      intfc.escrever("Matrícula gerada: " + matricula.getNumero());
    }
  }

  /**
  * Procura por uma matrícula
  */
  public static void procurarMatricula() {
    Matricula matricula;
    int numeroMatricula = 0;

    intfc.escrever("Procura de matrículas");
    numeroMatricula = intfc.pedir("Digite o número da matrícula", numeroMatricula);
    matricula = repositorioMatriculas.procurar(numeroMatricula);
    if (matricula == null)
      intfc.reportarErro("Erro interno");
    else {
      intfc.escrever("Matrícula encontrada!");
      intfc.escrever("  Aluno: " + matricula.getAluno().getNome());
      intfc.escrever("  Curso: " + matricula.getCurso().getNome());
      intfc.escrever("  Número: " + matricula.getNumero());
    }
  }

  /* FUNÇÕES DE LIGAÇÃO */
  /**
  * Chama as outras funções baseados na opção escolhida
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
        descadastrarCurso();
        break;
      case 9:
        /*matricular aluno*/
        matricularAluno();
        break;
      case 10:
        /*procurar matrícula*/
        procurarMatricula();
        break;
      case 11:
        /*cancelar matrícula*/

      case 12:
        /*listar todas as matrículas feitas*/

      case 13:
        /*listar todos os cursos cadastrados*/

      case 14:
        /*listar todos os alunos cadastrados*/

      case 15:
        /*listar todos os alunos de um curso*/

      case 16:
        /*listar todos os alunos de todos os cursos*/

      case 17:
        /*listar todos os cursos de um aluno*/

      case 18:
        /*listar todos os cursos de todos os alunos*/

      case 19:
        /*listar todas as matrículas de um aluno*/

      case 20:
        /*listar todas as matrículas de um curso*/

      case 21:
        /*listar alunos cadastrados sem curso*/

      case 22:
        /*listar cursos cadastrados sem alunos*/
        intfc.reportarErro("Opção não implementada.");
        break;

      default:
        intfc.reportarErro("Opção inexistente.");
        break;
    }
  }

  /**
  * Dá início do programa
  */
  public static final void main(String[] args) {
    int opcao;

    while (true) {
      intfc.menuPrincipal();
      opcao = intfc.escolher();
      if (opcao == 0) break;
      else realizar(opcao);
    }
  }
}
