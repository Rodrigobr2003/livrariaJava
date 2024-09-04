/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PackModel;

import java.util.ArrayList;

/**
 *
 * @author Rodrigo
 */
public class User {
    private int ID;
    private String nome;
    private String email;
    private String telefone;
    private ArrayList<Object> listaEmprestimos;
    
    public User(){
        listaEmprestimos = new ArrayList<>();
    }
    
    public User(String nome, String email, String telefone){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
    
    public void setID(int ID){
        this.ID = ID;
    }
    
    public int getID(){
        return this.ID;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getTelefone(){
        return this.telefone;
    }
    
    public void setListaEmprestimos(Object objeto){
        this.listaEmprestimos.add(objeto);
    }
    
    public String getUser(){
        return "Nome: " + this.nome + ", Email: " + this.email + " e Telefone: " + this.telefone;
    }
    
    @Override
    public String toString(){
        return "{" +
                ", ID =" + this.ID + '\'' +
                "nome='" + this.nome +
                ", email=" + this.email +
                ", telefone=" + this.telefone +
                '}';
    }    
}
