package models;

public class Servico {
    private int id;
    private String nome;

    public Servico(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
