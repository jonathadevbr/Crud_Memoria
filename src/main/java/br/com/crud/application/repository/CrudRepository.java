package br.com.crud.application.repository;

import br.com.crud.application.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class CrudRepository {
    long proximoId = 0;
    private final List<Usuario> ListaUsuarios = new ArrayList<>();

    public Usuario addUsuario(String nomeAddUsuario, String emailAddUsuario) {
        Usuario user = new Usuario(nomeAddUsuario, emailAddUsuario);
        user.setId(++proximoId);
        ListaUsuarios.add(user);
        return user;
    }

    public void listarUsuario() {
        for (Usuario user : ListaUsuarios)
            System.out.println(user);
    }

    public void deletUsuario(int idDeleteUsuario){
        ListaUsuarios.removeIf(usuario -> usuario.getId() == idDeleteUsuario);
    }

    public void testeUsuarios(){
        addUsuario("Jonatha", "jonatha@gmail.com");
        addUsuario("Pedro", "pedro@gmail.com");
        addUsuario("Maria", "maria@gmail.com");

    }
}
