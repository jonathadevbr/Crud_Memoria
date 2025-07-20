package br.com.crud.application.model;

public class Usuario {

    //Criando meus atributos
    private long id;
    private String nome;
    private String email;

    public Usuario(String nome, String email) {

        //Dando valor chamado pelo this dos atributos
        this.nome = nome;
        this.email = email;
    }

    //Getters e Setters
    //Retorna o valor de ID
    public long getId(){
        return id;
    }

    //Atribui o valor de ID
    public void setId(long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString(){
        return "ID " + id + ", NOME: " + nome + ", EMAIL: " + email;
    }
}
