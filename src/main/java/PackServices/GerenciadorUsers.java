/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PackServices;

import PackModel.User;
import java.util.*;
import com.google.gson.*;
import java.io.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

/**
 *
 * @author Rodrigo
 */
public class GerenciadorUsers {
    
    private Gson jsonObj;
    private FileWriter fileW;
    private FileReader fileR;
    private String path = "C:\\Users\\Rodrigo\\Desktop\\users.json";
    
    ArrayList<User> listaUsuarios = new ArrayList<>() ;

    public GerenciadorUsers() {
        this.jsonObj = new GsonBuilder().setPrettyPrinting().create();
        
        try{
            this.fileW = new FileWriter(path);
        }catch(IOException e){
            System.out.print("Erro ao criar arquivo usuarios.json");
        }
        
        try{
            this.fileR = new FileReader(path);
        }catch(FileNotFoundException e){
            System.out.print("Erro ao achar arquivo usuarios.json");
        }
        
        this.getUsers();
    }
    
    public void adicionarUser(User user){
        listaUsuarios.add(user);
    }
    
    private ArrayList<User> getUsers(){
        try{
            Type listType = new TypeToken<ArrayList<User>>(){}.getType();
            ArrayList<User> loadedUsers = jsonObj.fromJson(fileR, listType);
        
            if (loadedUsers != null) {
                    listaUsuarios = loadedUsers;
            }
        
            fileR.close();
            
        }catch(IOException e){
            System.out.println("Erro ao ler usuarios.json");
        }
        
        
        return listaUsuarios;
    }
    
    public void fecharArquivo(){
        try{
            jsonObj.toJson(listaUsuarios, fileW);
            fileW.flush();
            fileW.close();
        }catch(IOException e){
            System.out.println("Erro ao salvar usuarios.json");
        }
        
    }
    
}
