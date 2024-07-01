import models.*;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rn = new Random();
        SistemaDenuncias sistema = new SistemaDenuncias();
        Scanner scanner = new Scanner(System.in);

        sistema.adicionarServico(new Servico(1, "Buraco na rua"));
        sistema.adicionarServico(new Servico(2, "Falta de iluminação"));

        while (true) {
            System.out.println("1. Adicionar Pessoa");
            System.out.println("2. Fazer Denúncia");
            System.out.println("3. Responder Denúncia");
            System.out.println("4. Listar Denúncias");
            System.out.println("5. Listar Funcionarios e Usuarios");
            System.out.println("6. Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println("Usuario ou Funcionario?(F/U)");
                    String tipo = scanner.nextLine();
                    if (tipo.equals("U") || tipo.equals("u")) {
                        System.out.println("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.println("Email: ");
                        String email = scanner.nextLine();
                        Usuario usuario = new Usuario(sistema.getUsuarios().size() + rn.nextInt(100) , nome, email);
                        sistema.adicionarUsuario(usuario);
                        System.out.println("Seu ID é "+ usuario.getId());
                    }
                    else if (tipo.equals("F") || tipo.equals("f")) {
                        System.out.println("Nome:");
                        String nome = scanner.nextLine();
                        System.out.println("Cargo:");
                        String cargo = scanner.nextLine();
                        Funcionario funcionario = new Funcionario (sistema.getFuncionarios().size() + rn.nextInt(100) , nome,cargo);
                        sistema.adicionarFuncionario(funcionario);
                        System.out.println("Seu id é "+ funcionario.getId());
                    }
                    else {
                        System.out.println("Comando invalido, digite F ou U");
                    }
                    break;
                case 2:
                    System.out.print("ID do Usuário: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    Usuario usuarioDenuncia = null;
                    for (Usuario u : sistema.getUsuarios()) {
                        if (u.getId() == userId) {
                            usuarioDenuncia = u;
                            break;
                        }
                    }
                    if (usuarioDenuncia == null) {
                        System.out.println("Usuário não encontrado.");
                        break;
                    }

                    System.out.print("Descrição da Denúncia: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Rua: ");
                    String rua = scanner.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();
                    System.out.print("Estado: ");
                    String estado = scanner.nextLine();

                    System.out.println("Servicos:");
                    for (Servico c : sistema.getServico()) {
                        System.out.println(c.getId() + ". " + c.getNome());
                    }
                    System.out.print("ID do Servico: ");
                    int categoriaId = scanner.nextInt();
                    scanner.nextLine();
                    Servico Servico = null;
                    for (Servico c : sistema.getServico()) {
                        if (c.getId() == categoriaId) {
                            Servico = c;
                            break;
                        }
                    }
                    if (Servico == null) {
                        System.out.println("Servico não encontrada");
                        break;
                    }

                    Endereco endereco = new Endereco(rua, cidade, estado);
                    Denuncia denuncia = new Denuncia(sistema.getDenuncias().size() + rn.nextInt(10), descricao, usuarioDenuncia, endereco, Servico);
                    sistema.adicionarDenuncia(denuncia);
                    System.out.println("O ID da sua denuncia é "+ denuncia.getId());
                    break;

                case 3:
                    System.out.println("ID da Denúncia: ");
                    int denunciaId = scanner.nextInt();
                    Denuncia denunciaParaResponder = null;
                    for (Denuncia d : sistema.getDenuncias()) {
                        if (d.getId() == denunciaId) {
                            denunciaParaResponder = d;
                            break;
                        }
                    }
                    if (denunciaParaResponder == null) {
                        System.out.println("Denúncia não encontrada.");
                        break;
                    }

                    System.out.println("ID do Funcionário: ");
                    int funcId = scanner.nextInt();
                    Funcionario funcionario = null;
                    for (Funcionario f : sistema.getFuncionarios()) {
                        if (f.getId() == funcId) {
                            funcionario = f;
                            break;
                        }
                    }
                    if (funcionario == null) {
                        System.out.println("Funcionário não encontrado");
                        break;
                    }

                    System.out.println("Mensagem de Resposta: ");
                    String mensagem = scanner.nextLine();
                    Resposta resposta = new Resposta(sistema.getDenuncias().size() + rn.nextInt(10), mensagem, funcionario);
                    sistema.responderDenuncia(denunciaId, resposta);
                    break;
                case 4:
                    for (Denuncia d : sistema.getDenuncias()) {
                        System.out.println("ID: " + d.getId());
                        System.out.println("Descrição: " + d.getDescricao());
                        System.out.println("Usuário: " + d.getUsuario().getNome());
                        System.out.println("Endereço: " + d.getEndereco().getRua() + ", " + d.getEndereco().getCidade() + ", " + d.getEndereco().getEstado());
                        System.out.println("Categoria: " + d.getCategoria().getNome());
                        if (d.getResposta() != null) {
                            System.out.println("Resposta: " + d.getResposta().getMensagem());
                            System.out.println("Funcionário: " + d.getResposta().getFuncionario().getNome());
                        } else {
                            System.out.println("Resposta: Não respondida");
                        }
                        System.out.println("-----------");
                    }
                    break;
                case 5:
                    System.out.println("Funcionarios: ");
                    for (Funcionario f : sistema.getFuncionarios()) {
                        System.out.println(f.getNome());
                    }
                    System.out.println("\n ------- \n");
                    System.out.println("Usuarios: ");
                    for (Usuario u : sistema.getUsuarios()){
                        System.out.println(u.getNome() );
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
