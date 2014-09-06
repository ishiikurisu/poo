public class Curso {
  /**
  * Atributos
  */
  private String codigo;
  private String nome;
  private String instrutor;

  /**
  * Construtores
  */
  public Curso() {}
  public Curso(String codigo, String nome, String instrutor) {
    this.codigo = codigo;
    this.nome = nome;
    this.instrutor = instrutor;
  }

  /**
  * Métodos get e set
  */
  public String getCodigo() {
    return this.codigo;
  }
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return this.nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getInstrutor() {
    return this.instrutor;
  }
  public void setInstrutor(String instrutor) {
    this.instrutor = instrutor;
  }
}
