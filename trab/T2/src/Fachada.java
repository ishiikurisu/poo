package T2.src;

import java.util.List;

import T2.src.cadastro.*;
import T2.src.negocio.*;

/**
* Esta classe junta todas as aplicações em uma
*/
public class Fachada {
  /* Atributos */
  private Cadastro cadastro = new Cadastro();
  private static boolean unicaFachada = false;

  /* Construtores */
  public Fachada() {
  }

  public static Fachada obterFachada() throws FachadaDuplicadaException {
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
  public void atualizarAluno
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
  public void cadastrarCurso
  (String codigo, String nome, String instrutor) {
    cadastro.cadastrar(codigo, nome, instrutor);
  }

  /**
  * Procura por um determinado curso
  */
  public void procurarCurso(String nome)
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
  public void descadastrarCurso(String curso) {
    cad.descadastrarCurso(curso);
  }

  /**
  * Atualiza as informações cadastrais de um curso
  */
  public void atualizarCurso
  (String curso, String nome, String codigo, String instrutor) {
    if (cad.existeCurso(curso))
      cad.atualizar(curso, codigo, nome, instrutor);
    else
      throw new PesquisaSemResultadoException(curso);
  }

  /**
  * Matricula um aluno em um curso
  */
  public int matricularAluno(String aluno, String curso)
  throws ErroInternoException {
    int matricula = cad.matricularAluno(aluno, curso);

    if (matricula == 0)
      throw new ErroInternoException();
    else
      return matricula;
  }

  /**
  * Procura por uma matrícula
  */
  public String[] procurarMatricula() {
    Matricula matricula;
    info = cad.procurarMatricula(numeroMatricula);

    if (info == null) throw new MatriculaInexistenteException();

    return info;
  }

  /**
  * Cancela uma matrícula em um curso
  */
  public void cancelarMatricula(int numeroMatricula) {
    cad.cancelarMatricula(numeroMatricula);
  }

  /* FUNÇÕES DE LISTAGEM */

  /**
  * Lista todas as matrículas
  */
  public List listarMatriculas() {
    return cad.listarMatriculas();
  }

  /**
  * Lista todos os cursos cadastrados
  */
  public List listarCursos() {
    return cad.listarCursos();
  }

  /**
  * Lista todos os alunos
  */
  public List listarAlunos() {
    return cad.listarAlunos();
  }

  /**
  * Lista todos os alunos de um determinado curso
  */
  public List listarAlunosCurso(String filtro) {
    return cad.listarAlunos("curso", filtro);
  }

  /**
  * Lista todos os alunos de todos os cursos
  */
  public List listarTodosAlunos() {
    return cad.listarAlunos("todos", null);
  }

  /**
  * Lista todos os cursos nos quais um aluno está cadastrado
  */
  public List listarCursosAluno(String filtro) {
    return cad.listarCursos("alunos", filtro);
  }

  /**
  * Lista todos os cursos de todos os alunos
  */
  public List listarTodosCursos() {
    return cad.listarCursos("todos", null);
  }

  /**
  * Lista todas as matrículas de um aluno
  */
  public List listarMatriculasAluno(String aluno) {
    return cad.listarMatriculas("aluno", aluno);
  }

  /**
  * Lista todas as matrículas existentes de um curso
  */
  public List listarMatriculasCurso(String curso) {
    return cad.listarMatriculas("curso", curso);
  }

  /**
  * Lista todos os alunos que não estão cadastrados em algum curso
  */
  public List listarAlunosSemCurso() {
    return cad.listarAlunos("sem", null);
  }

  /**
  * Lista todos os cursos que não possuem alunos
  */
  public List listarCursosSemAluno() {
    return cad.listarCursos("sem", null);
  }
}
