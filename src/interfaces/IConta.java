package interfaces;

public interface IConta {

    void sacar(double Valor);

    void depositar(double Valor);

    void transferir(double Valor, IConta contaDestino);

    void imprimirExtrato();

    double checaSaldo(double valor);
}
