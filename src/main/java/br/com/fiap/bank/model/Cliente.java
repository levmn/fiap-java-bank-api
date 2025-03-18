package br.com.fiap.bank.model;

import java.util.Random;

public class Cliente {

    private Long id;
    private String nome;
    private String cpf;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String cpf) {
        this.id = Math.abs(new Random().nextLong());
        this.nome = nome;
        this.cpf = cpf;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "{"
                + " id='" + getId() + "'"
                + ", nome='" + getNome() + "'"
                + ", cpf='" + getCpf() + "'"
                + "}";
    }

}
