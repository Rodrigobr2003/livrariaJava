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
    private ArrayList<Livro> resultadoPesquisa  = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    
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
    
    public String pesquisarLivro(String titulo){
        String varEnvio;
        
        for(Livro livro : listaLivros){
            if(livro.getTitulo().equals(titulo)){
                resultadoPesquisa.add(livro);
            }
        }
        
        varEnvio = resultadoPesquisa.toString();
        resultadoPesquisa.clear();
        
        return varEnvio;
    }
    
    public Livro pesquisarLivro(int ID){
        
        Optional<Livro> livroSelecionado = listaLivros.stream()
                .filter(li -> li.getID() == ID)
                .findFirst();
        
        if(livroSelecionado.isPresent()){
            return livroSelecionado.get();
        }else{
            return null;
        }
        
    }
    
    public String getLivros(){
        
        String varEnvio;
        
        for(Livro livro : listaLivros){
            resultadoPesquisa.add(livro);
        }
        
        varEnvio = resultadoPesquisa.toString();
        resultadoPesquisa.clear();
        
        return varEnvio;
    }
    
        public void excluirLivro(int ID){
        listaLivros.removeIf(us -> us.getID() == ID);
    }
        
    public Livro escolherLivro(){
        
        String resultadoLivro;
        
        //Do-while para selecionar livro
            do{

                System.out.print("\nPesquisar livro pelo titulo: ");

                //Resultado da pesquisa do nome do livro
                resultadoLivro = pesquisarLivro(scanner.next());
                
                if(resultadoLivro == null  || resultadoLivro.contains("[]")) System.out.print("\nLivro nao encontrado...\n");
                
            }while(resultadoLivro == null || resultadoLivro.contains("[]"));
            
                System.out.print("\nResultados: ");
                System.out.println(resultadoLivro);
                
                System.out.print("\nEscolha um livro pelo ID: ");
                
                return this.pesquisarLivro(scanner.nextInt());
    }
}
