package br.com.fiap.bank.model;

import java.time.LocalDate;

public class ContaSalario extends Conta {

    private String empresaVinculada;
    private Integer limiteDeSaque;
    private Integer saquesMensais;

    public ContaSalario() {
    }

    public ContaSalario(Long id, String numero, String agencia, LocalDate dataAbertura,
            double saldoInicial, boolean ativa, Cliente cliente,
            String empresaVinculada, Integer limiteDeSaque) {
        super(id, numero, agencia, dataAbertura, saldoInicial, ativa, "SALARIO", cliente);
        this.empresaVinculada = empresaVinculada;
        this.limiteDeSaque = limiteDeSaque;
        this.saquesMensais = 0;
    }

    public String getEmpresaVinculada() {
        return empresaVinculada;
    }

    public void setEmpresaVinculada(String empresaVinculada) {
        this.empresaVinculada = empresaVinculada;
    }

    public Integer getLimiteDeSaque() {
        return limiteDeSaque;
    }

    public void setLimiteDeSaque(Integer limiteDeSaque) {
        this.limiteDeSaque = limiteDeSaque;
    }

    public Integer getSaquesMensais() {
        return saquesMensais;
    }

    public void setSaquesMensais(Integer saquesMensais) {
        this.saquesMensais = saquesMensais;
    }

    public boolean sacar(double valor) {
        if (saquesMensais < limiteDeSaque && valor <= getSaldoInicial() && valor > 0) {
            setSaldoInicial(getSaldoInicial() - valor);
            saquesMensais++;
            return true;
        }
        return false;
    }

    public boolean receberSalario(double valor) {
        if (valor > 0) {
            setSaldoInicial(getSaldoInicial() + valor);
            return true;
        }
        return false;
    }

    public void resetarLimiteMensal() {
        this.saquesMensais = 0;
    }

    @Override
    public String toString() {
        return super.toString() + " ContaSalario [empresaVinculada=" + empresaVinculada
                + ", limiteDeSaque=" + limiteDeSaque + ", saquesMensais=" + saquesMensais + "]";
    }
}
