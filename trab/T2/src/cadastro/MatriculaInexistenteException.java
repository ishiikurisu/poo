package T2.src.cadastro;

public class MatriculaInexistenteException extends Exception {
  private String message = "Matrícula inexistente";

  public MatriculaInexistenteException() {
    super();
  }

  public String getMessage() {
    return this.message;
  }
}
