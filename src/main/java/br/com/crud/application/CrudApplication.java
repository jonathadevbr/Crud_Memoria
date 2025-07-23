package br.com.crud.application;

import br.com.crud.application.repository.CrudRepository;
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
            System.out.println("3. Mostrar usuário por atributo");
            System.out.println("4. Atualizar usuário");
            System.out.println("5. Deletar usuário");
            System.out.println("6. Sair\n");
            System.out.print("Escolha a opção: ");

            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("CADASTRAR NOVO USUÁRIO\n");
                    System.out.print("Digite o nome: ");
                    String nome = entrada.next();

                    System.out.print("Digite o email: ");
                    String email = entrada.next();
                    service.CriarUsuario(nome, email);
                    System.out.println("Usuário " + nome + ", seu email é: " + email + "\n");
                    break;
                case 2:
                    System.out.println("MOSTRAR TODOS USUÁRIO\n");
                    service.MostrarUsuario();
                    System.out.println("\n");
                    break;
//                case 3:
//                  MOSTRAR USUARIO POR ATRIBUTO
//                case 4:
//                  ATUALIZAR
//                case 5:
//                  DELETAR
                default:
                    System.out.println("Programa encerrado!");
            }
        }
        while (opcao != 5);
        entrada.close();
    }
}
