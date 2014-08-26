import java.util.*;

public class Main {
  Scanner input = new Scanner(System.in);

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

  public static final int receberResposta()
  {
    return input.nextInt();
  }

  public static final void escolher(int opcao)
  {
    boolean resultado;

    switch (opcao)
    {
      case 1:
        break;
      case 2:
        break;
      case 3:
        break;
      case 4:
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
        resposta = true;
    }

    return resultado;
  }

  public static final void main(String args[])
  {
    do { mostrarOpcoes();
    } while (escolher(receberResposta()));
  }
}
