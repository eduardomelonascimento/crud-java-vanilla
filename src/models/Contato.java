package models;

import java.util.Date;

public class Contato {
    private int id;
    private String nome;
    private int idade;
    private Date created_At;

    public Contato(String nome, int idade, Date created_At) {
        this.nome = nome;
        this.idade = idade;
        this.created_At = created_At;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

}
