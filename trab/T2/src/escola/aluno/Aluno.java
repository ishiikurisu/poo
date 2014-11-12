package escola.aluno;

public class Aluno {
  /**
  * Atributos
  */
  private String nome;
  private String endereco;
  private String telefone;
  private int idade;

  /**
  * Construtores
  */
  public Aluno() {}
  public Aluno(String novoNome, String novoEndereco, String novoTelefone, int novaIdade) {
    nome = novoNome;
    endereco = novoEndereco;
    telefone = novoTelefone;
    idade = novaIdade;
  }

  /**
  * Métodos get e set
  */
  public String getNome() {
    return this.nome;
  }
  public void setNome(String novoNome) {
    this.nome = novoNome;
  }

  public String getEndereco() {
    return this.endereco;
  }
  public void setEndereco(String novoEndereco) {
    this.endereco = novoEndereco;
  }

  public String getTelefone() {
    return this.telefone;
  }
  public void setTelefone(String novoTelefone) {
    this.telefone = novoTelefone;
  }

  public int getIdade() {
    return this.idade;
  }
  public void setIdade(int novaIdade) {
    this.idade = novaIdade;
  }
}
