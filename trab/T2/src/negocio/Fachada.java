package src.negocio;

/**
* Esta classe junta todas as aplicações em uma
*/
public class Fachada {
  /* Atributos */
  private Cadastro cadastro = new Cadastro();
  private static boolean unicaFachada = false;

  /* Construtores */
  public Fachada() {
    if (unicaFachada == false)
      unicaFachada = true;
    else
      throw new FachadaDuplicadaException();
  }

  /* Funcionalidades */

  /**
  * Cadastra um novo aluno
  */
  public void cadastrarAluno
  (String nome, String nome, String endereco, String telefone, int idade) {
    cadastro.cadastrar(nome, endereco, telefone, idade);
  }

  /**
  * Procura por um já cadastrado aluno
  */
  public String[] procurarAluno(String nome) throws PesquisaSemResultadoException {
    Aluno aluno = null;
    String[] outlet;

    aluno = cad.procurarAluno(nome);
    if (aluno == null)
      throw new PesquisaSemResultadoException(nome);

    outlet = new String[9];
    outlet[0] = 4;
    outlet[1] = "Nome";
    outlet[2] = aluno.getNome();
    outlet[3] = "Endereço"
    outlet[4] = aluno.getEndereco();
    outlet[5] = "Telefone";
    outlet[6] = aluno.getTelefone();
    outlet[7] = "Idade";
    outlet[8] = aluno.getIdade() + "";

    return outlet;
  }

  /**
  * Atualiza os dados cadastrais de um determinado aluno
  */
  public static void atualizarAluno
  (String nome, String novoNome, String endereco, String telefone, int idade)
  throws  FalhaAtualizacaoException {
    Aluno aluno = cadastro.atualizar(nome, novoNome, endereco, telefone, idade);
    if (aluno == null)
      throw new FalhaAtualizacaoException(nome);
  }

  /**
  * Descadastra um aluno
  */
  public static void descadastrarAluno(String aluno) {
    cadastro.descadastrarAluno(aluno);
  }

  /**
  * Cadastra um novo curso
  */
  public static void cadastrarCurso
  (String codigo, String nome, String instrutor) {
    cadastro.cadastrar(codigo, nome, instrutor);
  }

  /**
  * Procura por um determinado curso
  */
  public static void procurarCurso(String nome)
  throws PesquisaSemResultadoException {
    String nome = null;
    Curso curso;
    String[] info;

    curso = cadastro.procurarCurso(nome);
    if (info == null)
      throw new PesquisaSemResultadoException(nome);

    info = new String[7];
    info[0] = "7";
    info[1] = "Código";
    info[2] = curso.getCodigo()
    info[3] = "Nome";
    info[4] = curso.getNome();
    info[5] = "Instrutor";
    info[7] = curso.getInstrutor();

    return info;
  }

  /**
  * Descadastra um curso
  */
  public static void descadastrarCurso() {
    String curso = null;

    intfc.escrever("Descadastro de curso");
    curso = intfc.pedir("Digite o nome", curso);
    cad.descadastrarCurso(curso);
  }

  /**
  * Atualiza as informações cadastrais de um curso
  */
  public static void atualizarCurso() {
    String curso = null;
    String nome = null;
    String codigo = null;
    String instrutor = null;
    Curso flag;

    intfc.escrever("Atualização de curso");
    curso = intfc.pedir("Digite o nome", curso);
    if (cad.existeCurso(curso)) {
      nome = intfc.pedir("Digite o novo nome", nome);
      codigo = intfc.pedir("Digite o novo código", codigo);
      instrutor = intfc.pedir("Digite o novo instrutor", instrutor);

      cad.atualizar(curso, codigo, nome, instrutor);
      intfc.escrever("Curso atualizado!");
    }

    else {
      intfc.reportarErro("Curso não encontrado");
    }
  }

  /**
  * Matricula um aluno em um curso
  */
  public static void matricularAluno() {
    String aluno = null;
    String curso = null;

    intfc.escrever("Matrícula");
    aluno = intfc.pedir("Nome do aluno", aluno);
    curso = intfc.pedir("Nome do curso", curso);
    int matricula = cad.matricularAluno(aluno, curso);

    if (matricula == 0)
      intfc.reportarErro("Erro interno");
    else {
      intfc.escrever("Matrícula gerada: " + matricula);
    }
  }

  /**
  * Procura por uma matrícula
  */
  public static void procurarMatricula() {
    Matricula matricula;
    int numeroMatricula = 0;
    String info[] = null;

    intfc.escrever("Procura de matrículas");
    numeroMatricula = intfc.pedir("Digite o número da matrícula", numeroMatricula);
    info = cad.procurarMatricula(numeroMatricula);

    if (info == null)
      intfc.reportarErro("Erro interno");
    else {
      intfc.escrever("Matrícula encontrado");
      intfc.mostrar(info);
    }
  }

  /**
  * Cancela uma matrícula em um curso
  */
  public static void cancelarMatricula() {
    Matricula matricula;
    int numeroMatricula = 0;

    intfc.escrever("Cancelamento de matrícula");
    numeroMatricula = intfc.pedir("Digite o número da matrícula", numeroMatricula);
    cad.cancelarMatricula(numeroMatricula);
    intfc.escrever("Matrícula cancelada");
  }

  /* FUNÇÕES DE LISTAGEM */

  /**
  * Lista todas as matrículas
  */
  public static void listarMatriculas() {
    intfc.escrever("Todas as matrículas");
    intfc.mostrarVarios(cad.listarMatriculas());
  }

  /**
  * Lista todos os cursos cadastrados
  */
  public static void listarCursos() {
    intfc.escrever("Todos os cursos cadastrados");
    intfc.mostrarVarios(cad.listarCursos());
  }

  /**
  * Lista todos os alunos
  */
  public static void listarAlunos() {
    intfc.escrever("Todos os alunos");
    intfc.mostrarVarios(cad.listarAlunos());
  }

  /**
  * Lista todos os alunos de um determinado curso
  */
  public static void listarAlunosCurso() {
    String filtro = null;

    intfc.escrever("Todos os alunos de um curso");
    filtro = intfc.pedir("Digite um curso", filtro);
    intfc.mostrarVarios(cad.listarAlunos("curso", filtro));
  }

  /**
  * Lista todos os alunos de todos os cursos
  */
  public static void listarTodosAlunos() {
    intfc.escrever("Todos os alunos, por curso");
    intfc.mostrarVarios(cad.listarAlunos("todos", null));
  }

  /**
  * Lista todos os cursos nos quais um aluno está cadastrado
  */
  public static void listarCursosAluno() {
    String filtro = null;

    intfc.escrever("Todos os cursos de um aluno");
    filtro = intfc.pedir("Digite o nome do aluno", filtro);
    intfc.mostrarVarios(cad.listarCursos("alunos", filtro));
  }

  /**
  * Lista todos os cursos de todos os alunos
  */
  public static void listarTodosCursos() {
    intfc.escrever("Todos os cursos de todos os alunos");
    intfc.mostrarVarios(cad.listarCursos("todos", null));
  }

  /**
  * Lista todas as matrículas de um aluno
  */
  public static void listarMatriculasAluno() {
    String aluno = null;

    intfc.escrever("Todas as matrículas de um aluno");
    aluno = intfc.pedir("Digite o nome do aluno", aluno);
    intfc.mostrarVarios(cad.listarMatriculas("aluno", aluno));
  }

  /**
  * Lista todas as matrículas existentes de um curso
  */
  public static void listarMatriculasCurso() {
    String curso = null;

    intfc.escrever("Todas as matrículas de um curso");
    curso = intfc.pedir("Digite o nome do curso", curso);
    intfc.mostrarVarios(cad.listarMatriculas("curso", curso));
  }

  /**
  * Lista todos os alunos que não estão cadastrados em algum curso
  */
  public static void listarAlunosSemCurso() {
    intfc.escrever("Todos os alunos sem curso");
    intfc.mostrarVarios(cad.listarAlunos("sem", null));
  }

  /**
  * Lista todos os cursos que não possuem alunos
  */
  public static void listarCursosSemAluno() {
    intfc.escrever("Todos os cursos sem alunos");
    intfc.mostrarVarios(cad.listarCursos("sem", null));
  }
}
