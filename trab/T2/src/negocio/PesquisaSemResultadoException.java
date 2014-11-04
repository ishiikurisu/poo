package

public class PesquisaSemResultadoException {
  private String message;

  public PesquisaSemResultadoException(String query) {
    message = "A pesquisa \"" + query + "\" não retornou resultado";
  }

  public String getMessage() {
    return message;
  }
}
