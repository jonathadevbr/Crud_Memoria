package br.com.crud.application.repository;

import br.com.crud.application.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudRepository {
    Scanner entrada = new Scanner(System.in);
    public List<Usuario> ListaUsuarios = new ArrayList<>();

    public void ListarTodos() {
        for (Usuario user : ListaUsuarios)
            System.out.println(user);
    }

    public void ListarEspecifico() {
        int opcaoBusca;
        System.out.println("1. ID");
        System.out.println("2. Nome");
        System.out.println("3. Email");
        System.out.print("Digite propriedade deseja fazer como base da busca: ");
        opcaoBusca = entrada.nextInt();
        switch (opcaoBusca) {
            case 1:
                System.out.print("Digite o ID que deseja procurar: ");
                int opcaoId = entrada.nextInt();
                for (Usuario userId : ListaUsuarios) {
                    if (userId.getId() == opcaoId) {
                        System.out.println(userId);
                        break;
                    }
                }
                break;
            case 2:
                System.out.print("Digite o Nome que deseja procurar: ");
                String opcaoNome = entrada.next();
                for (Usuario userNome : ListaUsuarios) {
                    if (userNome.getNome().equals(opcaoNome)) {
                        System.out.println(userNome);
                        break;
                    }
                }
                break;
            case 3:
                System.out.print("Digite o Email que deseja procurar: ");
                String opcaoEmail = entrada.next();
                for (Usuario userEmail : ListaUsuarios) {
                    if (userEmail.getEmail().equals(opcaoEmail)) {
                        System.out.println(userEmail);
                        break;
                    }
                }
                break;
        }
    }
}

