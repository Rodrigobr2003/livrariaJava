/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PackModel;

/**
 *
 * @author Rodrigo
 */
public class Emprestimo {
    private int ID;
    private Livro livro;
    private User usuario;
    private String dataEmprestimo;
    private String dataDevolucao;
    
    public Emprestimo(){
        
    }
    
    public Emprestimo(Livro livro, User usuario, String dataEmprestimo, String dataDevolucao){
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }
    
    public void setID(int ID){
        this.ID = ID;
    }
    
    public int getID(){
        return this.ID;
    }
    
    public void setLivro(Livro livro){
        this.livro = livro;
    }
    
    public Livro getLivro(){
        return this.livro;
    }
    
    public void setUsario(User usuario){
        this.usuario = usuario;
    }
    
    public User getUsuario(){
        return this.usuario;
    }
    
    public void setDataEmprestimo(String dataEmprestimo){
        this.dataEmprestimo = dataEmprestimo;
    }
    
    public String getDataEmprestimo(){
        return this.dataEmprestimo;
    }
    
    public void setDataDevolucao(String dataDevolucao){
        this.dataDevolucao = dataDevolucao;
    }
    
    public String getDataDevolucao(){
        return this.dataDevolucao;
    }
    
    public String getEmprestimo(){
        return "Livro: " + this.livro + ", Usuario: " + this.usuario + ", Data emprestimo: " + this.dataEmprestimo + " e Data devolucao: " + this.dataDevolucao;
    }
}
