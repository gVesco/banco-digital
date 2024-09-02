package models;

import interfaces.IConta;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected double chequeEspecial;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    protected void imprimirInfosComuns() {
        System.out.printf("Nome do Cliente %s%n", this.cliente.getNome());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Conta: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public double checaSaldo(double valor) {
        if (valor <= saldo) {
            this.saldo -= valor;
            return this.saldo;
        } else if (valor <= (saldo + chequeEspecial)) {
            chequeEspecial -= (valor - saldo);
            this.saldo = 0.00;
            return this.saldo;
        } else {
            System.out.println("Saldo insuficiente, revise o valor e tente novamente.");
            return this.saldo;
        }
    }

    @Override
    public void sacar(double valor) {
        checaSaldo(valor);
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
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
