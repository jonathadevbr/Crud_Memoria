package br.com.crud.application.repository;

import br.com.crud.application.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudRepository {
    long proximoId = 0;
    private List<Usuario> ListaUsuarios = new ArrayList<>();

    public void addUsuario(String nomeAddUsuario, String emailAddUsuario) {
        Usuario user = new Usuario(nomeAddUsuario, emailAddUsuario);
        user.setId(++proximoId);
        ListaUsuarios.add(user);
    }

    public void listarUsurio() {
        for (Usuario user : ListaUsuarios)
            System.out.println(user);
    }
}

