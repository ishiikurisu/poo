package escola.cadastro;

public class PesquisaSemResultadoException extends Exception {
  private String message;

  public PesquisaSemResultadoException(String query) {
    message = "A pesquisa \"" + query + "\" não retornou resultado";
  }

  public String getMessage() {
    return message;
  }
}
