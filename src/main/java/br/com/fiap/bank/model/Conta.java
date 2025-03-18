package br.com.fiap.bank.model;

import java.util.Random;

public abstract class Conta {

    private Long id;
    private String numeroConta;
    private String agencia;
    private double saldo;
    private Cliente cliente;

    public Conta() {
    }

    public Conta(Long id, String numeroConta, String agencia, double saldo, Cliente cliente) {
        this.id = Math.abs(new Random().nextLong());
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = 0;
        this.cliente = cliente;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public String sacar(double valor) {
        double saldoAtual = this.saldo;

        if (saldoAtual >= valor) {
            this.saldo -= valor;
            return "Saque de R$" + valor + " realizado com sucesso!";
        } else {
            return "Saldo insuficiente!";
        }
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroConta() {
        return this.numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "{"
                + " id='" + getId() + "'"
                + ", numeroConta='" + getNumeroConta() + "'"
                + ", agencia='" + getAgencia() + "'"
                + ", saldo='" + getSaldo() + "'"
                + ", cliente='" + getCliente() + "'"
                + "}";
    }

}
