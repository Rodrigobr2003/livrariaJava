/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PackModel;

import java.time.LocalDate;

/**
 *
 * @author Rodrigo
 */
public class Emprestimo {
    private Livro livro;
    private User usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    
    public Emprestimo(Livro livro, User usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao){
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
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
    
    public void setDataEmprestimo(LocalDate dataEmprestimo){
        this.dataEmprestimo = dataEmprestimo;
    }
    
    public LocalDate getDataEmprestimo(){
        return this.dataEmprestimo;
    }
    
    public void setDataDevolucao(LocalDate dataDevolucao){
        this.dataDevolucao = dataDevolucao;
    }
    
    public LocalDate getDataDevolucao(){
        return this.dataDevolucao;
    }
    
    public String getEmprestimo(){
        return "Livro: " + this.livro + ", Usuario: " + this.usuario + ", Data emprestimo: " + this.dataEmprestimo + " e Data devolucao: " + this.dataDevolucao;
    }
}
