package br.com.fiap.bank.model;

import java.time.LocalDate;

public class ContaCorrente extends Conta {

    private double limite;

    public ContaCorrente() {
    }

    public ContaCorrente(Long id, String numero, String agencia, LocalDate dataAbertura, double saldoInicial,
            boolean ativa, Cliente cliente) {
        super(id, numero, agencia, dataAbertura, saldoInicial, ativa, "CORRENTE", cliente);
    }

    public boolean sacar(double valor) {
        double saldoDisponivel = getSaldoInicial() + limite;
        if (valor <= saldoDisponivel && valor > 0) {
            setSaldoInicial(getSaldoInicial() - valor);
            return true;
        }
        return false;
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            setSaldoInicial(getSaldoInicial() + valor);
            return true;
        }
        return false;
    }

    public boolean transferir(Conta destino, double valor) {
        if (sacar(valor)) {
            destino.setSaldoInicial(destino.getSaldoInicial() + valor);
            return true;
        }
        return false;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return "ContaCorrente [limite=" + limite + "]";
    }

}
