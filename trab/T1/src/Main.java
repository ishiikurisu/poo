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
  private static Cadastro cad = new Cadastro();
  private static Interface intfc = new Interface();

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

    cad.cadastrar(nome, endereco, telefone, idade);
  }

  /**
  * Procura por um já cadastrado aluno
  */
  public static void procurarAluno() {
    Aluno aluno = null;
    String nome = null;

    intfc.escrever("Procura de alunos");
    nome = intfc.pedir("Digite o nome", nome);

    aluno = cad.procurarAluno(nome);
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
    String nome = null;
    String novoNome = null;
    String endereco = null;
    String telefone = null;
    int idade = 0;

    intfc.escrever("Atualização de alunx");
    nome = intfc.pedir("Digite o nome", nome);
    novoNome = intfc.pedir("Digite o novo nome", nome);
    endereco = intfc.pedir("Digite o novo endereço", endereco);
    telefone = intfc.pedir("Digite o novo telefone", telefone);
    idade = intfc.pedir("Digite a nova idade", idade);
    Aluno aluno = cad.atualizar(nome, novoNome, endereco, telefone, idade);

    if (aluno != null) {
      intfc.escrever("Alunx atualizadx!");
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
    cad.descadastrarAluno(aluno);
    intfc.escrever("Alunx removidx");
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
    cad.cadastrar(codigo, nome, instrutor);
  }

  /**
  * Procura por um determinado curso
  */
  public static void procurarCurso() {
    Curso curso;
    String nome = null;
    String[] info;

    intfc.escrever("Procura de cursos");
    nome = intfc.pedir("Digite o nome", nome);
    info = cad.procurarCurso(nome);

    if (info == null)
      intfc.reportarErro("Erro interno");
    else {
      intfc.escrever("Curso encontrado: ");
      intfc.mostrar(info);
    }
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

  /* FUNÇÕES DE LIGAÇÃO */
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
        cancelarMatricula();
        break;
      case 12:
        /*listar todas as matrículas feitas*/
        listarMatriculas();
        break;
      case 13:
        /*listar todos os cursos cadastrados*/
        listarCursos();
        break;
      case 14:
        /*listar todos os alunos cadastrados*/
        listarAlunos();
        break;
      case 15:
        /*listar todos os alunos de um curso*/
        listarAlunosCurso();
        break;
      case 16:
        /*listar todos os alunos de todos os cursos*/
        listarTodosAlunos();
        break;
      case 17:
        /*listar todos os cursos de um aluno*/
        listarCursosAluno();
        break;
      case 18:
        /*listar todos os cursos de todos os alunos*/
        listarTodosCursos();
        break;
      case 19:
        /*listar todas as matrículas de um aluno*/
        listarMatriculasAluno();
        break;
      case 20:
        /*listar todas as matrículas de um curso*/
        listarMatriculasCurso();
        break;
      case 21:
        /*listar alunos cadastrados sem curso*/
        listarAlunosSemCurso();
        break;
      case 22:
        /*listar cursos cadastrados sem alunos*/
        listarCursosSemAluno();
        break;

      default:
        intfc.reportarErro("Opção inexistente.");
        break;
    }
  }

  /**
  * Dá início ao programa
  */
  public static final void main(String[] args) {
    int opcao = 0;

    while (true) {
      intfc.menuPrincipal();
      opcao = intfc.pedir("Favor escolher uma opção", opcao);
      if (opcao == 23 || opcao == 0) break;
      else realizar(opcao);
    }
  }
}
