package br.com.fiap.bank.model;

import java.time.LocalDate;

public class ContaPoupanca extends Conta {

    private double taxaDeJuros;

    public ContaPoupanca() {
    }

    public ContaPoupanca(Long id, String numero, String agencia, LocalDate dataAbertura, double saldoInicial,
            boolean ativa, Cliente cliente) {
        super(id, numero, agencia, dataAbertura, saldoInicial, ativa, "POUPANCA", cliente);
    }

    public boolean sacar(double valor) {
        if (valor <= getSaldoInicial() && valor > 0) {
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

    public void calcularRendimento() {
        double rendimento = getSaldoInicial() * (taxaDeJuros / 100);
        setSaldoInicial(getSaldoInicial() + rendimento);
    }

    public double getTaxaDeJuros() {
        return taxaDeJuros;
    }

    public void setTaxaDeJuros(double taxaDeJuros) {
        this.taxaDeJuros = taxaDeJuros;
    }

    @Override
    public String toString() {
        return "ContaPoupanca [taxaDeJuros=" + taxaDeJuros + "]";
    }

}
