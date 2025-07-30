package br.com.crud.application.service;


import br.com.crud.application.model.Usuario;
import br.com.crud.application.repository.CrudRepository;


public class CrudService {
    CrudRepository crudRepository = new CrudRepository();

    public CrudService(){
        crudRepository.testeUsuarios();
    }

    public Usuario CriarUsuario(String nomeCriarUsuario, String emailCriarUsuario) {
        return crudRepository.addUsuario(nomeCriarUsuario, emailCriarUsuario);
    }

    public void MostrarUsuario() {
        crudRepository.listarUsuario();
    }

    public void DeletarUsuario(int idDeletarUsuario) {
        crudRepository.deletUsuario(idDeletarUsuario);
    }
}
