public class Main {
  private static RepositorioAluno repositorioAlunos = new RepositorioAluno();
  private static RepositorioCurso repositorioCursos = new RepositorioCurso();
  private static RepositorioMatricula repositorioMatriculas = new RepositorioMatricula();
  private static Interface intfc = new Interface();

  /**
  * FUNÇÕES DE NEGÓCIO
  */
  static void cadastrarAluno() {
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

  static void procurarAluno() {
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

  static void atualizarAluno() {
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

  static void descadastrarAluno() {
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

  static void cadastrarCurso() {
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

  static void procurarCurso() {
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

  static void descadastrarCurso() {
    String curso = null;

    intfc.escrever("Descadastro de curso");
    curso = intfc.pedir("Digite o nome", curso);
    repositorioCursos.remover(curso);
  }

  static void atualizarCurso() {
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

  static void matricularAluno() {
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
        descadastrarCurso();
        break;
      case 9:
        /*matricular aluno*/
        matricularAluno();
        break;
      case 10:
        /*procurar matrícula*/
        intfc.reportarErro("Opção não implementada.");
        break;
      case 11:
        /*cancelar matrícula*/
        intfc.reportarErro("Opção não implementada.");
        break;
      case 12:
        /*listar todas as matrículas feitas*/
        intfc.reportarErro("Opção não implementada.");
        break;
      case 13:
        /*listar todos os cursos cadastrados*/
        intfc.reportarErro("Opção não implementada.");
        break;
      case 14:
        /*listar todos os alunos cadastrados*/
        intfc.reportarErro("Opção não implementada.");
        break;
      case 15:
        /*listar todos os alunos de um curso*/
        intfc.reportarErro("Opção não implementada.");
        break;
      case 16:
        /*listar todos os alunos de todos os cursos*/
        intfc.reportarErro("Opção não implementada.");
        break;
      case 17:
        /*listar todos os cursos de um aluno*/
        intfc.reportarErro("Opção não implementada.");
        break;
      case 18:
        /*listar todos os cursos de todos os alunos*/
        intfc.reportarErro("Opção não implementada.");
        break;
      case 19:
        /*listar todas as matrículas de um aluno*/
        intfc.reportarErro("Opção não implementada.");
        break;
      case 20:
        /*listar todas as matrículas de um curso*/
        intfc.reportarErro("Opção não implementada.");
        break;
      case 21:
        /*listar alunos cadastrados sem curso*/
        intfc.reportarErro("Opção não implementada.");
        break;
      case 22:
        /*listar cursos cadastrados sem alunos*/
        intfc.reportarErro("Opção não implementada.");
        break;

      default:
        intfc.reportarErro("Opção inexistente.");
        break;
    }
  }

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
