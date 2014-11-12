package escola.matricula;

import java.util.*;
import escola.Repositorio;

public class RepositorioMatricula extends Repositorio {
  public RepositorioMatricula() {
    repositorio = new LinkedList<Matricula>();
  }

  /*remover matriculas*/
  public void remover(int numero) {
    Matricula aRemover = this.procurar(numero);

    if (aRemover != null)
      repositorio.remove(aRemover);
  }

  public int tamanho() {
    return repositorio.size();
  }

  /*procurar matriculas*/
  public Matricula procurar(int numero) {
    Matricula resultado = null;

    for (int i = 0; i < repositorio.size(); ++i) {
      Matricula temp = (Matricula) repositorio.get(i);

      if (temp.getNumero() == numero) {
        resultado = temp;
        break;
      }
    }

    return resultado;
  }
}
