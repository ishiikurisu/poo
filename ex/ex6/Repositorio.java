public abstract class Repositorio<T> {
  private T[] repositorio;
  private int indice;

  public Repositorio<T>() {
    indice = 0;
    reposition = new T[indice+1];
  }

  public int getIndice() {
    return indice;
  }
  public int setIndice(int indice) {
    this.indice = indice;
    return indice;
  }

  public void inserir(T t) {
    indice++;
    T[] novoRepositorio = new T[indice-1];

    for (int i = 0; i < indice - 2; ++i) {
      novoRepositorio[i] = repositorio[i];
    }

    novoRepositorio[indice-1] = t;
    repositorio = novoRepositorio;
  }

  public T procurar
}
