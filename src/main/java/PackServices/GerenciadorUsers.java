/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PackServices;

import PackModel.User;
import java.util.*;
import java.io.*;
/**
 *
 * @author Rodrigo
 */
public final class GerenciadorUsers extends ArquivoManager{
    
    private File file;
    private ArrayList<User> listaUsers = new ArrayList<>();
    private ArrayList<User> loadedUsers;
    public int ultimoIDUser = 0;
    private ArrayList<User> resultadoPesquisa;

    public GerenciadorUsers() {
        super();
        
        this.file = criarArquivo("users.json");
        
        if(file.exists())this.loadedUsers = getDadosArquivo(User.class, listaUsers);
        
        if (loadedUsers != null && !loadedUsers.isEmpty()) {
            this.ultimoIDUser = loadedUsers.getLast().getID();
            this.listaUsers = loadedUsers;
        }
        
        escreverArquivo();
    }
    
    public void cadastrarUsuario(User user){
        this.listaUsers.add(user);
    }
    
    public void chamarFechamento(){
        fecharArquivo(this.listaUsers);
    }
    
        public String pesquisarUser(String nome){
        
        resultadoPesquisa = new ArrayList<>();
        
        for(User user : listaUsers){
            if(user.getNome().equals(nome)){
                resultadoPesquisa.add(user);
            }
        }
        
        return resultadoPesquisa.toString();
        
    }
    
    public User pesquisarUser(int ID){
        Optional<User> userSelecionado = listaUsers.stream()
                .filter(us -> us.getID() == ID)
                .findFirst();
        
        if(userSelecionado.isPresent()){
            return userSelecionado.get();
        }
        else{
            return null;
        }
        
    }
}
