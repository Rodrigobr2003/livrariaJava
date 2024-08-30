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
public final class GerenciadorUsers {

    private Gson jsonObj;
    private FileWriter fileW;
    private FileReader fileR;
    private File file;
    private String path = System.getProperty("user.home")+"\\Desktop\\users.json";
    public int ultimoID = 0;
    
    ArrayList<User> listaUsuarios = new ArrayList<>() ;

    public GerenciadorUsers() {
        jsonObj = new GsonBuilder().setPrettyPrinting().create();
        
        file = new File(path);
        
        if(file.exists()) this.getUsers();
        
        try{
            this.fileW = new FileWriter(path);
        }catch(IOException e){
            System.out.print("Erro ao criar arquivo usuarios.json");
        }
        this.fecharArquivo();
    }
    
    public void adicionarUser(User user){
        listaUsuarios.add(user);
    }
    
    private void getUsers(){
        try{
            this.fileR = new FileReader(path);
            
            Type listType = new TypeToken<ArrayList<User>>() {}.getType();
            ArrayList<User> loadedUsers = jsonObj.fromJson(fileR, listType);
            
            if (!loadedUsers.isEmpty()) {
                    ultimoID = loadedUsers.getLast().getID();
                    listaUsuarios = loadedUsers;
            }
            
            fileR.close();
            
        }catch(FileNotFoundException e){
            System.out.print("Arquivo nao encontrado");
        }catch(IOException e){
            System.out.println("Erro ao ler usuarios.json");
        }
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
