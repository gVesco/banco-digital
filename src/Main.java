import models.Cliente;
import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cliente rodolfo = new Cliente();
        rodolfo.setNome("Rodolfo");
        Conta contaCorrente = new ContaCorrente(rodolfo);
        Conta contaPoupanca = new ContaPoupanca(rodolfo);
        int op0;

        do {
            System.out.println("Bem vindo, informe a opção desejada e pressione Enter:");
            System.out.println("1- Imprimir extrato");
            System.out.println("2- Depositar");
            System.out.println("3- Sacar");
            System.out.println("4- Transferir");
            System.out.println("0- Sair");

            op0 = sc.nextInt();

            switch (op0) {
                case 0:
                    System.out.println("Encerrando sessão...");
                    break;
                case 1:
                    int op1;
                    do {
                        System.out.println("Informe o tipo da conta que deseja imprimir o extrato:");
                        System.out.println("1- Conta Corrente");
                        System.out.println("2- Conta Poupança");
                        System.out.println("3- Ambos");
                        System.out.println("0- Voltar");
                        op1 = sc.nextInt();
                        switch (op1) {
                            case 0:
                                break;
                            case 1:
                                contaCorrente.imprimirExtrato();
                                op1 = 0;
                                break;
                            case 2:
                                contaPoupanca.imprimirExtrato();
                                op1 = 0;
                                break;
                            case 3:
                                contaCorrente.imprimirExtrato();
                                contaPoupanca.imprimirExtrato();
                                op1 = 0;
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente.");
                        }
                    } while (op1 != 0);
                    break;
                case 2:
                    int op2;
                    System.out.println("Informe o valor que deseja depositar:");
                    double valorDeposito = sc.nextDouble();
                    do {
                        System.out.println("Informe a conta que deseja depositar:");
                        System.out.println("1- Conta Corrente");
                        System.out.println("2- Conta Poupança");
                        System.out.println("0- Voltar");
                        op2 = sc.nextInt();

                        switch (op2) {
                            case 0:
                                break;
                            case 1:
                                contaCorrente.depositar(valorDeposito);
                                op2 = 0;
                                break;
                            case 2:
                                contaPoupanca.depositar(valorDeposito);
                                op2 = 0;
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente.");
                        }
                    } while (op2 != 0);
                    break;
                case 3:
                    int op3;
                    System.out.println("Informe o valor que deseja sacar:");
                    double valorSaque = sc.nextDouble();
                    do {
                        System.out.println("Informe a conta que deseja sacar:");
                        System.out.println("1- Conta Corrente");
                        System.out.println("2- Conta Poupança");
                        System.out.println("0- Voltar");
                        op3 = sc.nextInt();

                        switch (op3) {
                            case 0:
                                break;
                            case 1:
                                contaCorrente.sacar(valorSaque);
                                op3 = 0;
                                break;
                            case 2:
                                contaPoupanca.sacar(valorSaque);
                                op3 = 0;
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente.");
                        }
                    } while (op3 != 0);
                    break;
                case 4:
                    int op4;
                    do {
                        System.out.println("Informe a conta origem da transferência:");
                        System.out.println("1- Conta Corrente -> Conta Poupança");
                        System.out.println("2- Conta Poupança -> Conta Corrente");
                        System.out.println("0- Voltar");
                        op4 = sc.nextInt();
                        if (op4 != 0) {
                            System.out.println("Informe o valor da conta que deseja transferir:");
                            double valorTranferencia = sc.nextDouble();
                            if (op4 == 1) {
                                contaCorrente.transferir(valorTranferencia, contaPoupanca);
                            } else if (op4 == 2) {
                                contaPoupanca.transferir(valorTranferencia, contaCorrente);
                            } else {
                                System.out.println("Opção inválida, tente novamente.");
                            }
                        }
                    } while (op4 != 0);
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (op0 != 0);

        sc.close();
    }
}
