import java.util.*;

public class Main {
  private static Scanner input = new Scanner(System.in);
  private static RepositorioContasArray repositorio = new RepositorioContasArray();
  private static Cliente clientes[] = new Cliente[100];
  private static int quantidadeClientes = 0;

  public static final void pass(){}

  public static Cliente criarCliente()
  {
    String novoCliente;
    String novoCpf;
    Cliente cliente;

    System.out.print("Informe seu nome: ");
    novoCliente = input.next();
    System.out.print("Informe seu CPF: ");
    novoCpf = input.next();

    cliente = new Cliente(novoCliente, novoCpf);
    clientes[quantidadeClientes] = cliente;
    quantidadeClientes++;

    return cliente;
  }

  public static Cliente consultarCliente()
  {
    String cpfAConsultar;
    Cliente resultado = null;
    int i = 0;

    System.out.print("Informe o CPF: ");
    cpfAConsultar = input.next();
    System.out.println("buscando " + cpfAConsultar + "...");

    for (i = 0; i < quantidadeClientes; i++)
    {
      //System.out.println("cliente..."clientes[i].getNome());
      /*
      while(clientes[i] == null && i < quantidadeClientes)
      {
        i++;
      }
      if (i == quantidadeClientes)
      {
        pass();
      }
      */
      if (clientes[i].getCpf().equals(cpfAConsultar))
      {
        resultado = clientes[i];
        i = quantidadeClientes;
      }
    }

    if (resultado == null)
    {
      System.out.println("cliente nao encontrado!");
    }

    System.out.println("cliente encontrado: " + resultado.getNome());
    return resultado;
  }

  public static void atualizarCliente()
  {
    Cliente sujeito = consultarCliente();
    String novoNome;

    if (sujeito == null)
    {
      return;
    }

    System.out.print("Digite o novo nome: ");
    novoNome = input.next();

    sujeito.setNome(novoNome);
  }

  public static void removerCliente()
  {
    String cpfAConsultar;
    int i = 0;

    System.out.print("Informe o CPF: ");
    cpfAConsultar = input.next();

    for (i = 0; i < quantidadeClientes; i++)
    {
      if (clientes[i].getCpf().equals(cpfAConsultar))
      {
        clientes[i] = null;
        break;
      }
    }
    for (; i < quantidadeClientes - 1; i++)
    {
        clientes[i] = clientes[i+1];
    }
    quantidadeClientes--;
  }

  public static void criarConta()
  {
    System.out.println("preguica");
  }

  public static final void mostrarOpcoes()
  {
    System.out.println("*** Aplicação bancária ***");
    System.out.println("Operações disponíveis:");
    System.out.println("1- Criar cliente");
    System.out.println("2- Consultar cliente");
    System.out.println("3- Atualizar cliente");
    System.out.println("4- Remover cliente");
    System.out.println("5- Criar conta");
    System.out.println("6- Consultar conta");
    System.out.println("7- Atualizar conta");
    System.out.println("8- Remover conta");
    System.out.println("9- Creditar em conta");
    System.out.println("10- Debitar de conta");
    System.out.println("11- Transferir entre contas");
    System.out.println("12- Exibir os dados da conta de um determinado cliente");
    System.out.println("13- Exibir os dados de todas as contas");
    System.out.println("14- Exibir os dados de todos os clientes");
    System.out.println("15- Sair da aplicação");
    System.out.print("Favor escolher uma opção: ");
  }

  public static int receberResposta()
  {
    return input.nextInt();
  }

  public static boolean escolher(int opcao)
  {
    boolean resultado = true;

    switch (opcao)
    {
      case 1:
        criarCliente();
        break;
      case 2:
        consultarCliente();
        break;
      case 3:
        atualizarCliente();
        break;
      case 4:
        removerCliente();
        break;
      case 5:
        break;
      case 6:
        break;
      case 7:
        break;
      case 8:
        break;
      case 9:
        break;
      case 10:
        break;
      case 11:
        break;
      case 12:
        break;
      case 13:
        break;
      case 14:
        break;
      default:
        resultado = false;
    }

    return resultado;
  }

  public static final void main(String args[])
  {
    do { mostrarOpcoes();
    } while (escolher(receberResposta()));
  }
}
