package br.com.fiap.bank.model;

import java.time.LocalDate;

public abstract class Conta {

    private Long id;
    private String numero;
    private String agencia;
    private LocalDate dataAbertura;
    private double saldoInicial;
    private boolean ativa;
    private String tipoConta;
    private Cliente cliente;

    public Conta() {
    }

    public Conta(Long id, String numero, String agencia, LocalDate dataAbertura, double saldoInicial, boolean ativa,
            String tipoConta, Cliente cliente) {
        this.id = id;
        this.numero = numero;
        this.agencia = agencia;
        this.dataAbertura = dataAbertura;
        this.saldoInicial = saldoInicial;
        this.ativa = ativa;
        this.tipoConta = tipoConta;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Conta [id=" + id + ", numero=" + numero + ", agencia=" + agencia + ", dataAbertura=" + dataAbertura
                + ", saldoInicial=" + saldoInicial + ", ativa=" + ativa + ", tipoConta=" + tipoConta + ", cliente="
                + cliente + "]";
    }

}
