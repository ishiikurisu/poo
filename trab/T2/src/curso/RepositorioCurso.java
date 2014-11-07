package T2.src.repositorio;

import java.util.List;
import T2.src.Repositorio;

public class RepositorioCurso extends Repositorio {
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

    if (nomeCurso == null) return null;

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
