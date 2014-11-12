package escola.cadastro;

public class MatriculaInexistenteException extends Exception {
  private String message;

  public MatriculaInexistenteException() {
    message = "Matrícula inexistente";
  }

  public String getMessage() {
    return this.message;
  }
}
