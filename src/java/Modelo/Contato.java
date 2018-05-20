package Modelo;

import java.util.List;


public class Contato {
    private int id;
    private String nome;
    private List<Contato> telefones;

    public Contato() {
    }

    public Contato(int id, String nome, List<Contato> telefones) {
        this.id = id;
        this.nome = nome;
        this.telefones = telefones;
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

    public List<Contato> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Contato> telefones) {
        this.telefones = telefones;
    }
    
    



}