import java.util.*;

public class RepositorioAluno extends Repositorio {
  /*remover alunos*/
  public void remover(String nomeAluno) {
    Aluno removido = this.procurar(nomeAluno);

    if (removido != null)
      repositorio.remove(removido);
  }

  /*procurar alunos*/
  public Aluno procurar(String nomeAluno) {
    Aluno resultado = null;
    int i = 0;

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
