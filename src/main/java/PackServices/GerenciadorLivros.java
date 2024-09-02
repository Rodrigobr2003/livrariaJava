/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PackServices;
import PackModel.Livro;
import java.io.*;
import java.util.*;

/**
 *
 * @author Rodrigo
 */
public final class GerenciadorLivros extends ArquivoManager{

    private File file;
    private ArrayList<Livro> listaLivros = new ArrayList<>();
    private ArrayList<Livro> loadedLivros;
    public int ultimoIDLivro = 0;
    
    public GerenciadorLivros(){
        super();
        
        this.file = criarArquivo("livros.json");
        
        if(file.exists())this.loadedLivros = getDadosArquivo(Livro.class, listaLivros);
        
        if (loadedLivros != null && !loadedLivros.isEmpty()) {
            this.ultimoIDLivro = loadedLivros.getLast().getID();
            this.listaLivros = loadedLivros;
        }
        
        escreverArquivo();
    }
    
    public void cadastrarLivro(Livro livro){
        this.listaLivros.add(livro);

    }
    
    public void chamarFechamento(){
        fecharArquivo(listaLivros);
    }
}
