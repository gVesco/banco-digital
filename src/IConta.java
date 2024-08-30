public interface IConta {

    void sacar(double Valor);

    void depositar(double Valor);

    void transferir(double Valor, Conta contaDestino);

}
