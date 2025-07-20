package br.com.crud.application.service;

import br.com.crud.application.model.Usuario;
import br.com.crud.application.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudService {

    CrudRepository crudRepository = new CrudRepository();
    long proximoId = 1;
    Scanner entrada = new Scanner(System.in);

    public void CriarUsuario() {
        System.out.print("Digite o nome: ");
        String nome = entrada.next();

        System.out.print("Digite o email: ");
        String email = entrada.next();

        Usuario user = new Usuario(nome, email);
        user.setId(proximoId++);

        crudRepository.ListaUsuarios.add(user);
        System.out.println("Usuário " + user.getNome() + " + , seu id é: " + user.getId());
    }

    public void ListarUsuario() {
        int opcaoListar = 0;
        do {
            System.out.print("Digite que tipo de pesquisa deseja fazer (1 - Pesquisa geral e 2 - Pesquisa especifica: ");
            opcaoListar = entrada.nextInt();
            switch (opcaoListar) {
                case 1:
                    crudRepository.ListarTodos();
                    break;
                case 2:
                    crudRepository.ListarEspecifico();
                    break;
                default:
                    System.out.println("Opção Invalida! Coloque uma opção valida!");
            }
        }
        while (opcaoListar > 2);
    }

    public void AtualizarUsuario() {
        System.out.print("Digite o que deseja alterar (1 - Nome e 2 - Email): ");
        int opcao = entrada.nextInt();
        if (opcao == 1) {
            System.out.print("Digite o ID do usuário que deseja alterar o nome: ");
            int idUsuario = entrada.nextInt();
            idUsuario = idUsuario - 1;

            entrada.nextLine();

            System.out.print("Digite o novo nome do usuário: ");
            String newNome = entrada.nextLine();

            crudRepository.ListaUsuarios.get(idUsuario).setNome(newNome);
        } else if (opcao == 2) {
            System.out.print("Digite o ID do usuário que deseja alterar o email: ");
            int idUsuario = entrada.nextInt();
            idUsuario -= 1;

            entrada.nextLine();

            System.out.print("Digite o novo email do usuário: ");
            String newEmail = entrada.nextLine();

            crudRepository.ListaUsuarios.get(idUsuario).setEmail(newEmail);
        } else {
            System.out.println("Opção Invalida!");
        }
    }

//    public void DeletarUsuario() {
//        System.out.println("#####DELETAR USUÁRIO####");
//        ListarUsuario();
//        System.out.print("Digite o ID do usuário que deseja deletar: ");
//        int idUsuario = entrada.nextInt();
//        idUsuario -= 1;
//
//        ListaPessoa.remove(idUsuario);
//
//        ListarUsuario();
//
//    }
}
