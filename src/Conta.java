public abstract class Conta implements IConta {

    private int agencia;
    private int numero;
    private double saldo;

    @Override
    public void sacar(double Valor) {

    }

    @Override
    public void depositar(double Valor) {

    }

    @Override
    public void transferir(double Valor, Conta contaDestino) {

    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

}
