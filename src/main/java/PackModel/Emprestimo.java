/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PackModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Rodrigo
 */
public class Emprestimo{
    private int ID;
    private Livro livro;
    private User usuario;
    private String dataEmprestimo;
    private String dataDevolucao;
    private boolean emprestado;
    
    public Emprestimo(){
        this.emprestado = true;
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
    
    public void setEmprestado(boolean emprestado){
        this.emprestado = emprestado;
    }
    
    public boolean getEmprestado(){
        return this.emprestado;
    }
    
    public String getEmprestimo(){
        return "Livro: " + this.livro + ", Usuario: " + this.usuario + ", Data emprestimo: " + this.dataEmprestimo + " e Data devolucao: " + this.dataDevolucao;
    }
    
    public DadosEmprestimoUser getDadosEmprestimoUser(DateTimeFormatter formatter, Emprestimo emprestimo){
        return new DadosEmprestimoUser(
                emprestimo.getID(), 
                emprestimo.livro.getTitulo(),
                LocalDate.now().format(formatter),
                LocalDate.now().plusMonths(1).format(formatter),
                true
        );
    }
    
    @Override
    public String toString(){
        return """
               
               {ID=""" + this.ID +
                ", titulo do livro='" + this.livro.getTitulo() + '\'' +
                ", nome do usuario=" + this.usuario.getNome() +
                ", data de emprestimo=" + this.dataEmprestimo +
                ", data de devolucao='" + this.dataDevolucao +
                "}";
    }
}
