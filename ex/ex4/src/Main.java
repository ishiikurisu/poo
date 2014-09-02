import java.util.*;

public class Main {
  private static Scanner input = new Scanner(System.in);
  private static RepositorioContasArray repositorio = new RepositorioContasArray();
  private static Cliente clientes[] = new Cliente[100];
  private static int quantidadeClientes = 0;

  public static final void pass(){}

  static void achtung() {
    System.out.println("conta não encontrada!");
  }

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
    else {
      System.out.println("cliente encontrado: " + resultado.getNome());
    }

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
    String novoNumeroConta;
    Cliente cliente;
    Conta novaConta;

    cliente = consultarCliente();
    if (cliente != null) {
      System.out.print("digite o número da conta: ");
      novoNumeroConta = input.next();
      novaConta = new Conta(cliente, novoNumeroConta, 0);
      repositorio.inserir(novaConta);
    }
  }

  static void consultarConta()
  {
    String numeroConta;
    Conta conta;

    System.out.print("digite o numero da conta: ");
    numeroConta = input.next();

    conta = repositorio.procurar(numeroConta);
    if (conta == null) {
      System.out.println("conta não encontrada!");
    }
    else {
      System.out.println("conta encontrada:");
      System.out.println("  + número: " + conta.getNumero());
      System.out.println("  + saldo: " + conta.getSaldo() + "$");
      System.out.println("  + dono: " + conta.getDono().getNome());
      System.out.println("  + CPF: " + conta.getDono().getCpf());
    }
  }

  static void atualizarConta()
  {
    String numeroConta;
    Conta conta;

    System.out.print("digite o número da conta: ");
    numeroConta = input.next();

    conta = repositorio.procurar(numeroConta);
    if (conta == null) {
      System.out.println("conta não encontrada");
    }
    else {
      System.out.print("digite o cpf do novo dono: ");
      numeroConta = input.next();
      Cliente cliente = consultarCliente();
      if (cliente != null) {
        conta.setDono(cliente);
      }
    }
  }

  static void removerConta()
  {
    String numeroConta;
    Conta conta;

    System.out.print("digite o número da conta: ");
    numeroConta = input.next();

    repositorio.remover(numeroConta);
  }

  static void creditarEmConta()
  {
    String numeroConta;
    Conta conta;

    System.out.print("digite o numero da conta: ");
    numeroConta = input.next();
    conta = repositorio.procurar(numeroConta);

    if (conta == null) {
      achtung();
    } else {
      System.out.print("digite o valor: ");
      float credito = input.nextFloat();
      conta.creditar(credito);
    }
  }

  /*OPCAO 10 - Sacar da conta*/
  static void debitarEmConta()
  {
    String numeroConta;
    Conta conta;

    System.out.print("digite o numero da conta: ");
    numeroConta = input.next();
    conta = repositorio.procurar(numeroConta);

    if (conta == null) {
      achtung();
    } else {
      System.out.print("digite o valor: ");
      float debito = input.nextFloat();
      conta.debitar(debito);
    }
  }

  /*OPCAO 11 - Transferir entre contas*/
  static void transferirEntreContas()
  {
    String numeroContaOrigem;
    String numeroContaChegada;
    Conta origem;
    Conta chegada;
    float quantia;

    System.out.print("Digite o numero da conta de origem: ");
    numeroContaOrigem = input.next();
    System.out.print("Digite o numero da conta de chegada: ");
    numeroContaChegada = input.next();

    origem = repositorio.procurar(numeroContaOrigem);
    chegada = repositorio.procurar(numeroContaChegada);
    if (origem != null && chegada != null) {
      System.out.println("Digite o valor a ser transferido: ");
      quantia = input.nextFloat();
      origem.transferir(quantia, chegada);
    }
    else {
      System.out.println("uma das contas não existem");
    }
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
        criarConta();
        break;
      case 6:
        consultarConta();
        break;
      case 7:
        atualizarConta();
        break;
      case 8:
        removerConta();
        break;
      case 9:
        creditarEmConta();
        break;
      case 10:
        debitarEmConta();
        break;
      case 11:
        transferirEntreContas();
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
