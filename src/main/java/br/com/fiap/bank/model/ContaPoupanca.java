package br.com.fiap.bank.model;

public class ContaPoupanca extends Conta {

    private double taxaJuros;

    public ContaPoupanca() {
        super();
    }

    public ContaPoupanca(Long id, String numeroConta, String agencia, double saldo, Cliente cliente, double taxaJuros) {
        super(id, numeroConta, agencia, saldo, cliente);
        this.taxaJuros = taxaJuros;
    }

    public double getTaxaJuros() {
        return this.taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

}
