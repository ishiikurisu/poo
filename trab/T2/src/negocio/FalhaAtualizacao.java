package T2.src.negocio;

public class FalhaAtualizacaoException extends Exception {
  private String mensagem;

  public FalhaAtualizacaoException (String nome) {
    mensagem = "Falha ao atualizar " + nome;
  }

  public String getMessage() {
    return mensagem;
  }
}
