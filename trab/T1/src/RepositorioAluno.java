import java.util.*;

public class RepositorioAluno extends Repositorio {
  /*remover alunos*/
  public void remover(String nomeAluno) {
    Aluno removido = this.procurar(nomeAluno);

    if (removido != null)
      repositorio.remove(removido);
  }

  private boolean existe(String nomeAluno) {
    if (this.procurar(nomeAluno) != null)
      return true;
    else
      return false;
  }

  /*procurar alunos*/
  public Aluno procurar(String nomeAluno) {
    Aluno resultado = null;
    int i = 0;

    if (nomeAluno == null) return null;

    while (i < repositorio.size() && resultado == null) {
      Aluno temporario = (Aluno) repositorio.get(i);

      if (temporario.getNome().equals(nomeAluno))
        resultado = temporario;
      else
        ++i;
    }

    return resultado;
  }
}
