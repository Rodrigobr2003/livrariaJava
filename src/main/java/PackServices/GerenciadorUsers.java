/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PackServices;

import PackModel.User;
import java.util.*;
import com.google.gson.*;
import java.io.*;

/**
 *
 * @author Rodrigo
 */
public class GerenciadorUsers {
    
    private Gson jsonObj;
    private FileWriter fileW;
    private String path = "C:\\Users\\Rodrigo\\Desktop\\users.json";
    
    ArrayList<User> listaUsuarios = new ArrayList<>() ;

    public GerenciadorUsers() {
        this.jsonObj = new GsonBuilder().setPrettyPrinting().create();
        
        try{
            this.fileW = new FileWriter(path);
        }catch(IOException e){
            System.out.print("Erro ao criar arquivo usuarios.json");
        }
    }
    
    public void adicionarUser(User user){
        listaUsuarios.add(user);
        
        this.fecharArquivo();
    }
    
    private void fecharArquivo(){
        try{
            jsonObj.toJson(listaUsuarios, fileW);
            fileW.flush();
            fileW.close();
        }catch(IOException e){
            System.out.println("Erro ao salvar usuarios.json");
        }
        
    }
    
}
