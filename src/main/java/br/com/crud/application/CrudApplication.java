package br.com.crud.application;

import br.com.crud.application.model.Usuario;
import br.com.crud.application.service.CrudService;

import java.util.Scanner;

public class CrudApplication {
    public static void main(String[] args) {
        System.out.println("CRUD NA MEMÓRIA");

        Scanner entrada = new Scanner(System.in);
        CrudService service = new CrudService();
        int opcao;

        System.out.println("Bem-vindo ao CRUD da memória! \n");
        System.lineSeparator();
        System.lineSeparator();
        System.out.println("Digite uma opção das abaixo para fazer seu crud: \n");
        do {
            System.out.println("1. Cadastrar novo usuário");
            System.out.println("2. Mostrar todos os usuário");
            System.out.println("3. Atualizar usuário");
            System.out.println("4. Deletar usuário");
            System.out.println("5. Sair\n");
            System.out.print("Escolha a opção: ");

            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("CADASTRAR NOVO USUÁRIO\n");
                    System.out.print("Digite o nome: ");
                    String nome = entrada.next();

                    System.out.print("Digite o email: ");
                    String email = entrada.next();
                    Usuario novoUsuario = service.criarUsuario(nome, email);
                    System.out.println("Usuário " + nome + ", seu ID é: " + novoUsuario.getId() + "\n");
                    break;
                case 2:
                    System.out.println("MOSTRAR TODOS USUÁRIO\n");
                    service.mostrarUsuario();
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("ATUALIZAR USUÁRIO\n");
                    System.out.print("Digite o ID do usuário que deseja alterar o nome ou email: ");
                    int idAtualizar = entrada.nextInt();

                    System.out.print("Digite 1 para mudar o nome ou 2 para mudar o email: ");
                    int opcaoNomeEmail = entrada.nextInt();

                    if (opcaoNomeEmail == 1){
                        System.out.print("Digite o novo nome do usuário: ");
                        String novoNome = entrada.next();
                        service.atualizarUsuarioNome(idAtualizar, novoNome);
                    } else if (opcaoNomeEmail == 2) {
                        System.out.print("Digite o novo email do usuário: ");
                        String novoEmail = entrada.next();
                        service.atualizarUsuarioEmail(idAtualizar, novoEmail);

                    } else {
                        System.out.print("Opção Invalida!");
                    }

                    break;
                case 4:
                    System.out.println("DELETAR USUÁRIO\n");
                    System.out.print("Digite o ID do usuário que deseja deletar: ");
                    int idDeletar = entrada.nextInt();
                    service.deletarUsuario(idDeletar);
                    System.out.println("Usuário do ID " + idDeletar + " foi deletado!");
                    break;
                case 5:
                    System.out.println("Programa encerrado");;
                    break;

                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
        while (opcao != 5);
        entrada.close();
    }
}
