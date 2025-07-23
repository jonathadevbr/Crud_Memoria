package br.com.crud.application.service;

import br.com.crud.application.model.Usuario;
import br.com.crud.application.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudService {
    CrudRepository crudRepository = new CrudRepository();
    Scanner entrada = new Scanner(System.in);

    public void CriarUsuario(String nomeCriarUsuario, String emailCriarUsuario) {
        crudRepository.addUsuario(nomeCriarUsuario, emailCriarUsuario);
    }

    public void MostrarUsuario() {
        crudRepository.listarUsurio();
    }
}
