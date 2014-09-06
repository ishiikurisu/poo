import java.util.*;

public class RepositorioCurso extends Repositorio {
  private List repositorio;

  public RepositorioCurso() {
    repositorio = new LinkedList<Curso>();
  }

  /*remover cursos*/
  public void remover(String nome) {
    Curso removido = this.procurar(nome);

    if (removido != null)
      repositorio.remove(removido);
  }

  /*procurar cursos*/
  public Curso procurar(String nomeCurso) {
    Curso resultado = null;
    int i = 0;

    while (i < repositorio.size() && resultado == null) {
      Curso temporario = (Curso) repositorio.get(i);
      if (temporario.getNome().equals(nomeCurso))
        resultado = temporario;
      else
        ++i;
    }

    return resultado;
  }
}
