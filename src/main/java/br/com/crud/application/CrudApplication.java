package br.com.crud.application;

import br.com.crud.application.model.Usuario;
import br.com.crud.application.service.CrudService;

import java.util.InputMismatchException;
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

            try {
                opcao = entrada.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Erro: Por favor, digite uma das opções: ");
                entrada.nextLine();
                opcao = 0;
                continue;
            }

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
                    int idAtualizar;
                    do {
                        System.out.print("Digite o ID do usuário que deseja alterar o nome ou email: ");
                        try {
                            idAtualizar = entrada.nextInt();
                        } catch (InputMismatchException e){
                            System.out.print("Erro: Por favor, digite um ID válido: ");
                            entrada.nextLine();
                            idAtualizar = 0;
                        }
                    }git
                    while (!service.verificarIdUsuario(idAtualizar));
                    if (service.verificarIdUsuario(idAtualizar)){
                        System.out.print("Digite 1 para mudar o NOME ou 2 para mudar o EMAIL: ");
                        int opcaoNomeEmail;
                        do {
                            try {
                                opcaoNomeEmail = entrada.nextInt();

                                if (opcaoNomeEmail != 1 && opcaoNomeEmail != 2){
                                    System.out.print("Erro: Por favor, digite somente 1 ou 2: ");
                                }
                            } catch (InputMismatchException e){
                                System.out.print("Erro: Por favor, digite uma das opções: ");
                                entrada.nextLine();
                                opcaoNomeEmail = 0;
                            }
                        }
                        while (opcaoNomeEmail != 1 && opcaoNomeEmail != 2);

                        entrada.nextLine();

                        if (opcaoNomeEmail == 1){
                            System.out.print("Digite o novo nome do usuário: ");
                            String novoNome = entrada.nextLine();
                            service.atualizarUsuarioNome(idAtualizar, novoNome);
                        } else {
                            System.out.print("Digite o novo email do usuário: ");
                            String novoEmail = entrada.nextLine();
                            service.atualizarUsuarioEmail(idAtualizar, novoEmail);

                        }
                    } else {
                        System.out.println("Erro: Usuário com ID " + idAtualizar + " não foi encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("DELETAR USUÁRIO\n");
                    int idDeletar;
                    do {
                        System.out.print("Digite o ID do usuário que deseja deletar: ");
                        try {
                            idDeletar = entrada.nextInt();
                        } catch (InputMismatchException e){
                            System.out.println("Erro: Por favor, digite um ID válido: ");
                            entrada.nextLine();
                            idDeletar = 0;
                        }
                    }
                    while (idDeletar <= 0);
                    if (service.verificarIdUsuario(idDeletar)){
                        service.deletarUsuario(idDeletar);
                        System.out.println("Usuário do ID " + idDeletar + " foi deletado!");
                    } else {
                        System.out.println("Erro: Usuário com ID " + idDeletar + " não foi encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Programa encerrado");
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
