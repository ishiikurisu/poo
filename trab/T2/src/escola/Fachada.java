package escola;

import java.util.List;

import escola.aluno.Aluno;
import escola.curso.Curso;
import escola.matricula.Matricula;
import escola.cadastro.*;

/**
* Esta classe junta todas as aplicações em uma
*/
public class Fachada {
  /* Atributos */
  private static Cadastro cadastro = new Cadastro();
  private static boolean unicaFachada = false;

  /* Construtores */
  public Fachada() {
  }

  public static Fachada obterInstancia() throws FachadaDuplicadaException {
    if (unicaFachada == false)
      unicaFachada = true;
    else
      throw new FachadaDuplicadaException();

    return new Fachada();
  }

  /* Funcionalidades */

  /**
  * Cadastra um novo aluno
  */
  public static void cadastrarAluno (String nome, String endereco, String telefone, int idade) {
    cadastro.cadastrar(nome, endereco, telefone, idade);
  }

  /**
  * Procura por um já cadastrado aluno
  */
  public static String[] procurarAluno(String nome) throws PesquisaSemResultadoException {
    Aluno aluno = null;
    String[] outlet;

    aluno = cadastro.procurarAluno(nome);
    if (aluno == null)
      throw new PesquisaSemResultadoException(nome);

    outlet = new String[9];
    outlet[0] = "4";
    outlet[1] = "Nome";
    outlet[2] = aluno.getNome();
    outlet[3] = "Endereço";
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
  public void descadastrarAluno(String aluno) {
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
  public static String[] procurarCurso(String nome)
  throws PesquisaSemResultadoException {
    String[] info;

    info = cadastro.procurarCurso(nome);
    if (info == null)
      throw new PesquisaSemResultadoException(nome);

    return info;
  }

  /**
  * Descadastra um curso
  */
  public static void descadastrarCurso(String curso) {
    cadastro.descadastrarCurso(curso);
  }

  /**
  * Atualiza as informações cadastrais de um curso
  */
  public static void atualizarCurso
  (String curso, String nome, String codigo, String instrutor)
  throws PesquisaSemResultadoException {
    if (cadastro.existeCurso(curso))
      cadastro.atualizar(curso, codigo, nome, instrutor);
    else
      throw new PesquisaSemResultadoException(curso);
  }

  /**
  * Matricula um aluno em um curso
  */
  public static int matricularAluno(String aluno, String curso)
  throws ErroInternoException {
    int matricula = cadastro.matricularAluno(aluno, curso);

    if (matricula == 0)
      throw new ErroInternoException();
    else
      return matricula;
  }

  /**
  * Procura por uma matrícula
  */
  public static String[] procurarMatricula(int numeroMatricula)
  throws MatriculaInexistenteException {
    String[] info = cadastro.procurarMatricula(numeroMatricula);

    if (info == null) throw new MatriculaInexistenteException();

    return info;
  }

  /**
  * Cancela uma matrícula em um curso
  */
  public static void cancelarMatricula(int numeroMatricula) {
    cadastro.cancelarMatricula(numeroMatricula);
  }

  /* FUNÇÕES DE LISTAGEM */

  /**
  * Lista todas as matrículas
  */
  public static List listarMatriculas() {
    return cadastro.listarMatriculas();
  }

  /**
  * Lista todos os cursos cadastrados
  */
  public static List listarCursos() {
    return cadastro.listarCursos();
  }

  /**
  * Lista todos os alunos
  */
  public static List listarAlunos() {
    return cadastro.listarAlunos();
  }

  /**
  * Lista todos os alunos de um determinado curso
  */
  public static List listarAlunosCurso(String filtro) {
    return cadastro.listarAlunos("curso", filtro);
  }

  /**
  * Lista todos os alunos de todos os cursos
  */
  public static List listarTodosAlunos() {
    return cadastro.listarAlunos("todos", null);
  }

  /**
  * Lista todos os cursos nos quais um aluno está cadastrado
  */
  public static List listarCursosAluno(String filtro) {
    return cadastro.listarCursos("alunos", filtro);
  }

  /**
  * Lista todos os cursos de todos os alunos
  */
  public static List listarTodosCursos() {
    return cadastro.listarCursos("todos", null);
  }

  /**
  * Lista todas as matrículas de um aluno
  */
  public static List listarMatriculasAluno(String aluno) {
    return cadastro.listarMatriculas("aluno", aluno);
  }

  /**
  * Lista todas as matrículas existentes de um curso
  */
  public static List listarMatriculasCurso(String curso) {
    return cadastro.listarMatriculas("curso", curso);
  }

  /**
  * Lista todos os alunos que não estão cadastrados em algum curso
  */
  public static List listarAlunosSemCurso() {
    return cadastro.listarAlunos("sem", null);
  }

  /**
  * Lista todos os cursos que não possuem alunos
  */
  public static List listarCursosSemAluno() {
    return cadastro.listarCursos("sem", null);
  }
}
