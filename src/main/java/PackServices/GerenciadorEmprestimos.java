/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PackServices;

import PackModel.Emprestimo;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo
 */
public class GerenciadorEmprestimos extends ArquivoManager{
    
    private File file;
    private ArrayList<Emprestimo> listaEmprestimos = new ArrayList<>();
    private ArrayList<Emprestimo> loadedEmprestimos;
    public int ultimoIDEmprestimo = 0;
    
    public GerenciadorEmprestimos(){
        super();
        
        this.file = criarArquivo("emprestimos.json");
        
        if(file.exists())this.loadedEmprestimos = getDadosArquivo(Emprestimo.class, listaEmprestimos);
        
        if (loadedEmprestimos != null && !loadedEmprestimos.isEmpty()) {
            this.ultimoIDEmprestimo = loadedEmprestimos.getLast().getID();
            this.listaEmprestimos = loadedEmprestimos;
        }
        
        escreverArquivo();
    }
    
    public void cadastrarEmprestimo(Emprestimo emprestimo){
        this.listaEmprestimos.add(emprestimo);
    }
    
    public void chamarFechamento(){
        fecharArquivo(listaEmprestimos);
    }
}
