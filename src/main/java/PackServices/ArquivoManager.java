/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PackServices;

import PackModel.Livro;
import PackModel.User;
import com.google.gson.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Rodrigo
 */
public abstract class ArquivoManager {
    
    private File file;
    private FileWriter fileW;
    private FileReader fileR;
    private final Gson jsonObj;
    private String path;
    
    public ArquivoManager(){
        this.jsonObj = new GsonBuilder().setPrettyPrinting().create();
    }
    
    //Deve ser executado em todos os filhos antes de iniciar
    private void criarArquivo(String nomeDoc){
        this.path = System.getProperty("user.home"+"\\Desktop\\"+nomeDoc);
        try{
            this.file = new File(this.path);
        }catch(Exception e){
            System.out.println("Erro ao criar arquivo...");
        }
        
    }
    
    private void escreverArquivo(){
        try{
            this.fileW = new FileWriter(this.path);
        }catch(IOException e){
            System.out.println("Erro ao escrever arquivo...");
        }
    }
    
    private void lerArquivo(){
        try{
            this.fileR = new FileReader(this.path);
        }catch(IOException e){
            System.out.println("Erro ao ler arquivo...");
        }
    }
    
    private <T> void fecharArquivo(ArrayList<T> lista){
        try{
            jsonObj.toJson(lista, fileW);
            fileW.flush();
            fileW.close();
        }catch(IOException e){
            System.out.println("Erro ao salvar arquivo...");
        }
    }
    
}
