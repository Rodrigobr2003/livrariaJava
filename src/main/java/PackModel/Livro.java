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
public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private LocalDate dataPublicacao;
    private boolean emprestado = false;
    
    public Livro(String titulo, String autor, String isbn, LocalDate dataPublicacao){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.emprestado = false;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public void setAutor(String autor){
        this.autor = autor;
    }
    
    public String getAutor(){
        return this.autor;
    }
    
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    
    public String getIsbn(){
        return this.isbn;
    }

    public void setDataPublicacao(LocalDate dataPublicacao){
        this.dataPublicacao = dataPublicacao;
    }
    
    public LocalDate getDataPublicacao(){
        return this.dataPublicacao;
    }
    
    public void setEmprestado(boolean emprestado){
        this.emprestado = emprestado;
    }
    
    public boolean getEmprestado(){
        return this.emprestado;
    }
}
