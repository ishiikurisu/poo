package unb.banco.cliente;

import unb.banco.interfaceUsuario.InterfaceTextual;


public class RepositorioClientesArray implements RepositorioClientes {
	private Cliente[]  clientes;
	private int indice;
	private final static int tamanhoCache = 100;

	public RepositorioClientesArray() {
	  indice = 0;
	  clientes = new Cliente[tamanhoCache];
	}
  
     /* (non-Javadoc)
	 * @see RepositorioClientes#getClientes()
	 */
    public Cliente [] getClientes () {
       return clientes;
     }

     /* (non-Javadoc)
	 * @see RepositorioClientes#getIndice()
	 */
    public int getIndice() {
       return indice;
     }

	/* (non-Javadoc)
	 * @see RepositorioClientes#atualizar(Cliente)
	 */
	public void atualizar(Cliente c){
	  int i = procurarIndice(c.getCpf());
	  if (i != -1) {
	    clientes[i] = c;
	  } else {
		  InterfaceTextual.mostra_mensagem("Cliente nao encontrado");
	  }
	}
	/* (non-Javadoc)
	 * @see RepositorioClientes#existe(java.lang.String)
	 */
	public boolean existe(String cpf) {
	  boolean resp = false;

	  int i = this.procurarIndice(cpf);
	  if(i != -1){
		resp = true;
	  }

	  return resp;
	}
	/* (non-Javadoc)
	 * @see RepositorioClientes#inserir(Cliente)
	 */
	public void inserir(Cliente c){
	    clientes[indice] = c;
	    indice = indice + 1;
	}
	/* (non-Javadoc)
	 * @see RepositorioClientes#procurar(java.lang.String)
	 */
	public Cliente procurar(String cpf){
		
	  Cliente c = null;
	  if (existe(cpf)) {
  	    int i = this.procurarIndice(cpf);
	    c = clientes[i];
	  } else {
		  InterfaceTextual.mostra_mensagem("Cliente nao encontrado");
	  }

	  return c;
	}

	private int procurarIndice(String cpf) {
	  int     i = 0;
	  int     ind = -1;
	  boolean achou = false;

	  while ((i < indice) &&!achou) {
	    if ((clientes[i].getCpf()).equals(cpf)) {
		ind = i;
		achou = true;
	    }
	    i = i + 1;
	  }
	  return ind;
	}

	/* (non-Javadoc)
	 * @see RepositorioClientes#remover(java.lang.String)
	 */
	public void remover(String cpf){
	  if (existe(cpf)) {
  	    int i = this.procurarIndice(cpf);
	    clientes[i] = clientes[indice - 1];
	    clientes[indice - 1] = null;
	    indice = indice - 1;
	  } else {
		  InterfaceTextual.mostra_mensagem("Cliente nao encontrado");
	  }
	}
}