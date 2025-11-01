package br.victorpolicarpo.sistemabancario.model;

public class ContaBancaria {
    private String titular;
    private double saldo;
    private String cpf;

    public boolean init(String titular, String cpf){
        if (titular == null){
            return false;
        }
        this.titular = titular;
        this.cpf = cpf;
        return true;
    }

    public String getTitular(){
        return this.titular;
    }

    public String getCpf(){
        return this.cpf;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public boolean depositar(double valor){
        if (valor <= 0){
            return false;
        }
        this.saldo += valor;
        return true;
    }
    public boolean sacar(double valor){
        if (valor <= 0 || valor > this.saldo){
            return false;
        }
        this.saldo -= valor;
        return true;
    }
}
