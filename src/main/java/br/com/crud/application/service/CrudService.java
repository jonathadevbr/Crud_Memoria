package br.com.crud.application.service;


import br.com.crud.application.model.Usuario;
import br.com.crud.application.repository.CrudRepository;


public class CrudService {
    CrudRepository crudRepository = new CrudRepository();

    public CrudService(){
        crudRepository.testeUsuarios();
    }

    public Usuario criarUsuario(String nomeCriarUsuario, String emailCriarUsuario) {
        return crudRepository.addUsuario(nomeCriarUsuario, emailCriarUsuario);
    }

    public void mostrarUsuario() {
        crudRepository.listarUsuario();
    }

    public void atualizarUsuarioNome(int idAtualizarNome, String novoNome){
        crudRepository.updateUsuarioNome(idAtualizarNome, novoNome);
    }

    public void atualizarUsuarioEmail(int idAtualizarNome, String novoEmail){
        crudRepository.updateUsuarioEmail(idAtualizarNome, novoEmail);
    }

    public void deletarUsuario(int idDeletarUsuario) {
        crudRepository.deletUsuario(idDeletarUsuario);
    }
}
