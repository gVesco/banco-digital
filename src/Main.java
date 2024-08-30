public class Main {
    public static void main(String[] args) {
        Cliente rodolfo = new Cliente();
        rodolfo.setNome("Rodolfo");

        Conta contaCorrente = new ContaCorrente(rodolfo);
        Conta contaPoupanca = new ContaPoupanca(rodolfo);

        contaCorrente.depositar(100);
        contaCorrente.transferir(70, contaPoupanca);
        contaPoupanca.transferir(10, contaCorrente);

        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();
    }
}
