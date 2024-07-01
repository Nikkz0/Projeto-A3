package models;

public class Denuncia {
    private int id;
    private String descricao;
    private Usuario usuario;
    private Endereco endereco;
    private Servico servico;
    private Resposta resposta;

    public Denuncia(int id, String descricao, Usuario usuario, Endereco endereco, Servico servico) {
        this.id = id;
        this.descricao = descricao;
        this.usuario = usuario;
        this.endereco = endereco;
        this.servico = servico;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Servico getCategoria() {
        return servico;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }
}

