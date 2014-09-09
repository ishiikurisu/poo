public class Cadastro {
  private static RepositorioAluno repositorioAlunos = new RepositorioAluno();
  private static RepositorioCurso repositorioCursos = new RepositorioCurso();
  private static RepositorioMatricula repositorioMatriculas = new RepositorioMatricula();

  public Cadastro() {}

  /* ALUNOS */

  public void cadastrar(String nome, String endereco, String telefone, int idade) {
    Aluno aluno = new Aluno(nome, endereco, telefone, idade);
    repositorioAlunos.adicionar(aluno);
  }

  public Aluno procurarAluno(String nome) {
    return repositorioAlunos.procurar(nome);
  }

  public Aluno atualizar(String nome, String novoNome, String novoEndereco, String novoTelefone, int novaIdade) {
    Aluno aluno = this.procurarAluno(nome);
    if (aluno != null) {
      aluno.setNome(novoNome);
      aluno.setEndereco(novoEndereco);
      aluno.setTelefone(novoTelefone);
      aluno.setIdade(novaIdade);
    }

    return aluno;
  }

  public void descadastrarAluno(String nome) {
    repositorioAlunos.remover(nome);
  }

  /* CURSOS */
  public boolean existeCurso(String nome) {
    Curso curso = repositorioCursos.procurar(nome);

    if (curso != null)
      return true;
    else
      return false;
  }

  public void cadastrar(String codigo, String nome, String instrutor) {
    Curso curso = new Curso(codigo, nome, instrutor);
    repositorioCursos.adicionar(curso);
  }

  public String[] procurarCurso(String nome) {
    Curso curso = repositorioCursos.procurar(nome);

    if (curso != null) {
      String[] info = {
        "3",
        "Código", curso.getCodigo(),
        "Nome", curso.getNome(),
        "Instrutor", curso.getInstrutor()
      };
      return info;
    }
    else
      return null;
  }

  public void descadastrarCurso(String nome) {
    repositorioCursos.remover(nome);
  }

  public Curso atualizar(String nome, String novoCodigo, String novoNome, String novoInstrutor) {
    Curso curso = repositorioCursos.procurar(nome);

    if (curso != null) {
      curso.setCodigo(novoCodigo);
      curso.setNome(novoNome);
      curso.setInstrutor(novoInstrutor);
    }

    return curso;
  }
  /* MATRÍCULAS */
  public int matricularAluno(String nomeAluno, String nomeCurso) {
    Aluno aluno = repositorioAlunos.procurar(nomeAluno);
    Curso curso = repositorioCursos.procurar(nomeCurso);

    if (aluno == null || curso == null) {
      return 0;
    }

    Matricula matricula = new Matricula(aluno, curso);
    repositorioMatriculas.adicionar(matricula);

    return matricula.getNumero();
  }

  public String[] procurarMatricula(int numeroMatricula) {
    Matricula matricula = repositorioMatriculas.procurar(numeroMatricula);

    if (matricula == null) {
      return null;
    }
    else {
      String[] info = {
        "6",
        "Aluno", matricula.getAluno().getNome(),
        "Curso", matricula.getCurso().getNome(),
        "Número", "" + matricula.getNumero()
      };
      return info;
    }
  }

  public void cancelarMatricula(int numeroMatricula) {
    repositorioMatriculas.remover(numeroMatricula);
  }

  /* LISTAGENS */

}
