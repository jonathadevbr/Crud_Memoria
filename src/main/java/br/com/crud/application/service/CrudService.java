package br.com.crud.application.service;


import br.com.crud.application.model.Usuario;
import br.com.crud.application.repository.CrudRepository;


public class CrudService {
    CrudRepository crudRepository = new CrudRepository();

    public Usuario CriarUsuario(String nomeCriarUsuario, String emailCriarUsuario) {
        return crudRepository.addUsuario(nomeCriarUsuario, emailCriarUsuario);
    }

    public void MostrarUsuario() {
        crudRepository.listarUsurio();
    }
}
