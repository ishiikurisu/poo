public class Cliente {
  private String nome;
  private String cpf;

  public Cliente() {

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
  public int getCpf() {
    return cpf;
  }
  public int setCpf(int novoCpf) {
    cpf = novoCpf;
    return cpf;
  }
  // ...
}
