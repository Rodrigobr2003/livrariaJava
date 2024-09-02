/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PackServices;

import com.google.gson.*;
import java.io.*;
import java.util.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

/**
 *
 * @author Rodrigo
 */
public abstract class ArquivoManager {
    
    protected File fileAM;
    private FileWriter fileW;
    private FileReader fileR;
    private final Gson jsonObj;
    protected String path;

    protected ArquivoManager(){
        this.jsonObj = new GsonBuilder().setPrettyPrinting().create();
    }
    
    //Deve ser executado em todos os filhos antes de iniciar
    protected File criarArquivo(String nomeDoc){
        
        this.path = System.getProperty("user.home") + "\\Desktop\\" + nomeDoc;
        try{
            this.fileAM = new File(this.path);
           
            //So esta criando o aqrv por conta disso
            this.fileAM.createNewFile();
        }catch(IOException e){
            System.out.println("Erro ao criar arquivo...");
        }
        return fileAM;
    }
    
    protected void escreverArquivo(){
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
    
    //T age como um valor x, podendo ser User, Livro ou emprestimo
     protected <T> void fecharArquivo(ArrayList<T> lista){
        try{
            jsonObj.toJson(lista, fileW);
            fileW.flush();
            fileW.close();
        }catch(IOException e){
            System.out.println("Erro ao salvar arquivo...");
        }
    }
    
    protected <T> ArrayList<T> getDadosArquivo(Class<T> classe, ArrayList<T> lista){
        this.lerArquivo();  
        
        //cria um Type que corresponde a um ArrayList parametrizado pelo tipo passado por "classe"
        Type tipoVariavel = TypeToken.getParameterized(ArrayList.class, classe).getType();
        ArrayList<T> listaLoaded = jsonObj.fromJson(fileR, tipoVariavel);
        
        try{
            this.fileR.close();    
        }catch(IOException e){
            System.out.println("Erro ao encerrar leitura...");
        }
        return listaLoaded;        
    }
}
