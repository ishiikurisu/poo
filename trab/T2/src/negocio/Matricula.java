package T2.src.negocio;

public class Matricula {
  /**
  * Atributos
  */
  private Aluno aluno;
  private Curso curso;
  private int numero;
  private static int count = 1000;

  /**
  * Construtores
  */
  public Matricula() {}
  public Matricula(Aluno aluno, Curso curso) {
    this.aluno = aluno;
    this.curso = curso;
    this.numero = count;
    count++;
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
    return this.curso;
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
