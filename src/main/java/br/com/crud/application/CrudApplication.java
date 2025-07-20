package br.com.crud.application;

import br.com.crud.application.service.CrudService;

import java.util.Scanner;

public class CrudApplication {
    public static void main(String[] args) {
        System.out.println("CRUD NA MEMÓRIA");

        Scanner entrada = new Scanner(System.in);
        CrudService service = new CrudService();
        int opcao = 0;

        System.out.println("Bem-vindo ao CRUD da memória!");
        System.out.println("Digite uma opção das abaixo para fazer seu crud: ");
        //do serve para eu repitir varias vezes (com base no while) determinado comando de código
        do {
            System.out.println("1. Cadastrar novo usuário");
            System.out.println("2. Mostrar usuário");
            System.out.println("3. Atualizar usuário");
            System.out.println("4. Deletar usuário");
            System.out.println("5. Sair");
            System.out.print("Escolha a opção: ");

            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("CADASTRAR NOVO USUÁRIO");
                    service.CriarUsuario();
                    break;
                case 2:
                    System.out.println("MOSTRAR USUÁRIO");
                    service.ListarUsuario();
                    break;
//                case 3:
//                    System.out.println("ATUALIZAR USUÁRIO");
//                    service.ListarUsuario();
//                    //service.AtualizarUsuario();
//                    break;
//                case 4:
//                    //service.DeletarUsuario();
//                    break;
                default:
                    System.out.println("Programa encerrado!");
            }
        }
        while (opcao != 5);
        entrada.close();
    }
}
