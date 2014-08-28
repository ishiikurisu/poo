public class Cliente {
  private String nome;
  private String cpf;

  public Cliente() {
    nome = "Joe";
    cpf = "666";
  }
  public Cliente(String meuNome, String meuCpf) {
    nome = meuNome;
    cpf = meuCpf;
  }

  // Métodos para nome
  public String getNome() {
    return nome;
  }
  public String setNome(String novoNome) {
    nome = novoNome;
    return nome;
  }
  // ...

  // Métodos para CPF
  public String getCpf() {
    return cpf;
  }
  public String setCpf(String novoCpf) {
    cpf = novoCpf;
    return cpf;
  }
  // ...
}
