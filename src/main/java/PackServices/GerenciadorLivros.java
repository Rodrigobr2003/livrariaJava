/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PackServices;
import PackModel.Livro;
import com.google.gson.*;
import java.io.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.*;

/**
 *
 * @author Rodrigo
 */
public class GerenciadorLivros {
    
    private File file;
    private FileWriter fileW;
    private FileReader fileR;
    private Gson jsonObj;
    private String path = "C:\\Users\\Rodrigo\\Desktop\\livros.json";
    private ArrayList<Livro> listaLivros = new ArrayList<>();
    public int ultimoIDLivro;
    
    public GerenciadorLivros(){
        this.jsonObj = new GsonBuilder().setPrettyPrinting().create();
        
        this.file = new File(path);
        
        if(file.exists()) this.getLivros();
        
        try{
            fileW = new FileWriter(path);
        }catch(IOException e){
            System.out.println("Erro ao criar o arquivo...");
        }

    }
    
    public void cadastrarLivro(Livro livro){
        this.listaLivros.add(livro);
    }
    
    private void getLivros(){
        try{
            fileR = new FileReader(path);
            
            Type type = new TypeToken<ArrayList<Livro>>(){}.getType();
            ArrayList<Livro> loadedLivros = jsonObj.fromJson(fileR, type);
        
            if(!loadedLivros.isEmpty()){
                this.ultimoIDLivro = loadedLivros.getLast().getID();
                listaLivros = loadedLivros;
            }
            
            fileR.close();
        }catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado...");
        }catch(IOException e){
            System.out.println("Erro ao ler usuarios.json...");
        }  
    }
    
    public void fecharArquivo(){
        try{
            jsonObj.toJson(listaLivros, fileW);
            fileW.flush();
            fileW.close();
        }catch(IOException e){
            System.out.println("Erro ao fechar arquivo...");
        }
        
    }
}
