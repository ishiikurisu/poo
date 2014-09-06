public class Matricula {
  /**
  * Atributos
  */
  private Aluno aluno;
  private Curso curso;
  private final int numero;

  /**
  * Construtores
  */
  public Matricula() {}
  public Matricula(Aluno aluno, Curso curso, int numero) {
    this.aluno = aluno;
    this.curso = curso;
    this.numero = numero;
  }

  /**
  * Métodos get e set
  */
  public Aluno getAluno() {
    return this.aluno;
  }
  public void setAluno(Aluno aluno) {
    this.aluno = aluno;
  }

  public Curso getCurso() {
    return this.curso();
  }
  public void setCurso(Curso curso) {
    this.curso = curso;
  }

  public int getNumero() {
    return this.numero;
  }
  public void setNumero(int numero) {
    this.numero = numero;
  }
}
