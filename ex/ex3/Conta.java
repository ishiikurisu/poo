public class Conta {
  private Cliente dono;
  private int numero = 0;
  private float saldo = 0;

  public Conta() {
    dono = new Cliente();
    numero = 0;
    saldo = 0;
  }

  public Conta(Cliente seuDono, int meuNumero, float meuSaldo) {
    dono = seuDono;
    numero = meuNumero;
    saldo = meuSaldo;
  }

  // Funcoes de usuario
  public Cliente getDono() {
    return dono;
  }
  public Cliente setDono(Cliente novoDono) {
    dono = novoDono;
    return dono;
  }

  // Funcoes de identificao
  public int getNumero() {
    return numero;
  }
  public int setNumero(int novoNumero) {
    numero = novoNumero;
    return numero;
  }

  // Funcoes de saldo
  public float getSaldo() {
    return saldo;
  }
  public float setSaldo(float novoSaldo) {
    saldo = novoSaldo;
    return saldo;
  }

  public float creditar(float credito) {
    saldo += credito;
    return saldo;
  }

  public float debitar(float debito) {
    if (saldo - debito < 0)
      System.out.println("saldo insuficiente!");
    else
      saldo -= debito;

    return saldo;
  }

  public void escreverSaldo() {
    System.out.println(this.getDono().getNome() + " possui " + this.getSaldo() + "$");
  }

  /** transfere uma quantia da conta this para a conta 2 */
  public void transferir(Conta conta, float quantia) {
    this.debitar(quantia);
    conta.creditar(quantia);
  }
}
