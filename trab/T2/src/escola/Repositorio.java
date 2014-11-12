package escola;

import java.util.List;
import java.util.LinkedList;

public class Repositorio {
  /**
  *Atributos
  */
  public List repositorio;

  /**
  * Construtores
  */
  public Repositorio() {
    repositorio = new LinkedList();
  }

  /**
  * Métodos
  */
  /* adicionar itens */
  public void adicionar(Object obj) {
    repositorio.add(obj);
  }

  /* funções de interação */
  public Object obter(int index) {
    return repositorio.get(index);
  }

  public int tamanho() {
    return repositorio.size();
  }

  /* remover itens
  public void remover(String nome) {
    Object removido = this.procurar(nome);

    if (removido != null)
      repositorio.remove(removido);
  }
  public void remover(int numero) {
    Object removido = this.procurar(numero);

    if (removido != null)
      repositorio.remove(removido);
  }

  /* procurar itens
  public Aluno procurarAluno(String nomeAluno) {
    Aluno resultado = null;
    int i = 0;

    while (i < repositorio.size() && resultado == null) {
      Aluno temporario = repositorio.get(i);
      if (temporario.getNome().equals(nomeAluno))
        resultado = temporario;
      else
        ++i;
    }

    return resultado;
  }

  */
}
