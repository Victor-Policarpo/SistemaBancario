package br.victorpolicarpo.sistemabancario.app;
import br.victorpolicarpo.sistemabancario.model.ContaBancaria;
import java.util.Scanner;
public class BancoApp {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria();
        Scanner input = new Scanner(System.in);
        boolean valido = false;
        while(!valido){
            System.out.println("Digite o seu Nome: ");
            String nome = input.nextLine();
            System.out.println("Digite o seu CPF: ");
            String cpf  =  input.nextLine();
            if (conta.init(nome, cpf)){
                System.out.println("Conta criada com sucesso!");
                System.out.println("Saldo atual: R$: "+conta.getSaldo());
                valido = true;

            } else {
                System.out.println("Nome do usuario ou CPF invalido! Tente novamente.");
                continue;
            }
        }

        while(true){
            System.out.println("----- Banco -----");
            System.out.println("Funcionalidades do Banco:\n[1] Deposito\n[2] Saque\n[3] Exibir saldo" +
                    "\n[4]Exibir titular\n[5] Exibir CPF titular\n[6] Finalizar programa");
            int opcao = input.nextInt();
            input.nextLine();
            switch(opcao) {
                case 1:
                    System.out.println("----- Deposito -----");
                    System.out.println("Digite o valor a ser depositado: ");
                    double valor = input.nextDouble();
                    input.nextLine();
                    if (conta.depositar(valor)) {
                        System.out.println("Transacao realiada com sucesso! \nSaldo atual: R$: " + conta.getSaldo());
                    } else {
                        System.out.println("O valor informado R$: " + valor + " nao pode ser depositado.");

                    }
                    break;
                case 2:
                    System.out.println("----- Saque -----");
                    System.out.println("Digite o valor a ser sacado: ");
                    double valorSaque = input.nextDouble();
                    input.nextLine();
                    if (conta.sacar(valorSaque)) {
                        System.out.println("Transacao realiada com sucesso! \nSaldo atual: R$: " + conta.getSaldo());
                    } else {
                        System.out.println("Transacao recusada! Valor atual de saque e abaixo do saldo atual" +
                                "\nSaldo atual: R$: " + conta.getSaldo());

                    }
                    break;
                case 3:
                    System.out.println("----- Exibir saldo -----");
                    System.out.println("Saldo atual R$: " + conta.getSaldo());
                    break;

                case 4:
                    System.out.println("----- Exibir titular -----");
                    System.out.println("Titular: " + conta.getTitular());
                    break;
                case 5:
                    System.out.println("----- Exibir CPF -----");
                    System.out.println("CPF: " + conta.getCpf());
                    break;
                case 6:
                    System.out.println("Finalizando programa...");
                    return;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
                    continue;
            }
        }

    }
}
