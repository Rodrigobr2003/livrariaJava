/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PackModel;

/**
 *
 * @author Rodrigo
 */
public class Livro {
    private int ID;
    private String titulo;
    private String autor;
    private int quantidade;
    private String isbn;
    private String dataPublicacao;
    
    public Livro(){
        
    }
    
    public Livro(String titulo, String autor, String isbn, String dataPublicacao){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
    }
    
    public void setID(int ID){
        this.ID = ID;
    }
    
    public int getID(){
        return this.ID;
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
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    
    public String getIsbn(){
        return this.isbn;
    }

    public void setDataPublicacao(String dataPublicacao){
//        this.dataPublicacao = LocalDate.parse(dataPublicacao);
        this.dataPublicacao = dataPublicacao;
    }
    
    public String getDataPublicacao(){
        return this.dataPublicacao;
    }
    
    @Override
    public String toString(){
        return """
               
               {ID =""" + this.ID +
                ", titulo='" + this.titulo + '\'' +
                ", autor=" + this.autor +
                ", quantidade=" + this.quantidade +
                ", ISBN='" + this.isbn +
                ", data de publicacao=" + this.dataPublicacao +
                "}";
    }
}
