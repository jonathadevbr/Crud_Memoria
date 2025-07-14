package br.com.crud.application.service;

import br.com.crud.application.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudService {

    //Criando a Lista que vai "substituir" o banco de dados
    //List<Pessoa> -> So podem entrar dados do tipo de objeto "Pessoa"
    private List<Usuario> ListaPessoa = new ArrayList<>();
    private long proximoId = 1;
    private Scanner entrada = new Scanner(System.in);

    public void CriarUsuario() {
        System.out.println("#####CADASTRAR NOVO USUÁRIO####");
        System.out.print("Digite o nome: ");
        String nome = entrada.nextLine();

        System.out.print("Digite o email: ");
        String email = entrada.nextLine();

        //Criar objeto usando o construtor que fizemos no "Usuario.java"
        Usuario user = new Usuario(nome, email);
        //Aumenta em 1 a mais a cada Usuario que é criado
        user.setId(proximoId++);

        //Adicionar na lista/"banco de dados"
        ListaPessoa.add(user);
        System.out.println("Usuário adicionado, seu id é: " + user.getId()
        );
    }

    public void MostrarUsuario(){
        System.out.println("#####MOSTRAR USUÁRIO####");
        for (Usuario user : ListaPessoa) System.out.println(user);
    }
}
