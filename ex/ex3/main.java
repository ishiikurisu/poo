public class main {
  public static void puts(String input) {
    System.out.println(input);
  }

  public static final void main(String args[]) {
    Cliente joe = new Cliente("Joe", 666);
    Cliente igor = new Cliente("Igor", 24);
    Conta conta1 = new Conta(joe, 1, 24);
    Conta conta2 = new Conta(igor, 2, 24);
    Conta conta3 = new Conta();

    conta3.escreverSaldo();
    puts(" ");

    puts("Exercicio 1.11:");
    conta1.setSaldo(0);
    conta2.setSaldo(100);
    conta1.escreverSaldo();
    conta2.escreverSaldo();
    puts(" ");

    puts("Exercicio 1.12:");
    conta1.creditar(25);
    conta2.debitar(24);
    conta1.escreverSaldo();
    conta2.escreverSaldo();
    puts(" ");

    puts("Exercicio 2.1:");
    conta1.transferir(conta2, 12);
    conta1.escreverSaldo();
    conta2.escreverSaldo();
    puts(" ");

    puts("Exercicio 3.1:");
    conta1.debitar(100);
    conta1.escreverSaldo();
    puts(" ");
  }
}
