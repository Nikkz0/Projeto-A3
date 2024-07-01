package models;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SistemaDenuncias {
    Random rn = new Random();
    private List<Denuncia> denuncias;
    private List<Usuario> usuarios;
    private List<Funcionario> funcionarios;
    private List<Servico> servicos;

    public SistemaDenuncias() {
        this.denuncias = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.servicos = new ArrayList<>();
    }

    public void adicionarDenuncia(Denuncia denuncia) {
        denuncias.add(denuncia);
    }
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void adicionarServico(Servico servico) {
        servicos.add(servico);
    }

    public List<Denuncia> getDenuncias() {
        return denuncias;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Servico> getServico() {
        return servicos;
    }

    public void responderDenuncia(int idDenuncia, Resposta resposta) {
        for (Denuncia denuncia : denuncias) {
            if (denuncia.getId() == idDenuncia) {
                denuncia.setResposta(resposta);
                break;
            }
        }
    }
}
