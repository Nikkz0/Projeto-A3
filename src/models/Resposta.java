package models;

public class Resposta {
    private int id;
    private String mensagem;
    private Funcionario funcionario;

    public Resposta(int id, String mensagem, Funcionario funcionario) {
        this.id = id;
        this.mensagem = mensagem;
        this.funcionario = funcionario;
    }

    public int getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
}
