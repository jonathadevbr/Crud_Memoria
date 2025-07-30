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
                    Usuario novoUsuario = service.CriarUsuario(nome, email);
                    System.out.println("Usuário " + nome + ", seu ID é: " + novoUsuario.getId() + "\n");
                    break;
                case 2:
                    System.out.println("MOSTRAR TODOS USUÁRIO\n");
                    service.MostrarUsuario();
                    System.out.println("\n");
                    break;
//                case 3:

                case 4:
                    System.out.println("DELETAR USUÁRIO\n");
                    System.out.print("Digite o ID do usuário que deseja deletar: ");
                    int id = entrada.nextInt();
                    service.DeletarUsuario(id);
                    System.out.println("Usuário do ID " + id + " foi deletado!");
                    break;
                default:
                    System.out.println("Programa encerrado!");
            }
        }
        while (opcao != 5);
        entrada.close();
    }
}
