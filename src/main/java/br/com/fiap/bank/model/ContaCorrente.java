package br.com.fiap.bank.model;

public class ContaCorrente extends Conta {

    private double limite;

    public ContaCorrente() {
        super();
    }

    public ContaCorrente(Long id, String numeroConta, String agencia, double saldo, Cliente cliente, double limite) {
        super(id, numeroConta, agencia, saldo, cliente);
        this.limite = limite;
    }

    @Override
    public String sacar(double valor) {
        double saldoAtual = this.getSaldo();

        if (saldoAtual + this.limite >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            return "Saque de R$" + valor + " realizado com sucesso!";
        } else {
            return "Saldo insuficiente!";
        }
    }

    public double getLimite() {
        return this.limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

}
