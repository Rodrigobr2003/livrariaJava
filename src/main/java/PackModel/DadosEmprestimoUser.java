/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package PackModel;

/**
 *
 * @author Rodrigo
 */
public class DadosEmprestimoUser {
    
    private int ID_do_Emprestimo;
    private String titulo;
    private String dataEmprestimo;
    private String dataDevolucao;
    private boolean emprestado;

    public DadosEmprestimoUser(int ID_do_Emprestimo, String titulo, String dataEmprestimo, String dataDevolucao, boolean emprestado){
        this.ID_do_Emprestimo = ID_do_Emprestimo;
        this.titulo = titulo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.emprestado = emprestado;
    }
    
    public int getID(){
        return ID_do_Emprestimo;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public String getDataEmpresitmo(){
        return dataEmprestimo;
    }
    
    public String getDataDevolucao(){
        return dataDevolucao;
    }
    
    public boolean getEmprestimo(){
        return emprestado;
    }
    
    public void setEmprestimo(boolean emprestado){
        this.emprestado = emprestado;
    }
    
    @Override
    public String toString(){
    return "{" +
            ", ID =" + this.ID_do_Emprestimo + '\'' +
            ", titulo='" + this.titulo +
            ", emprestimo=" + this.dataEmprestimo +
            ", devolucao=" + this.dataDevolucao +
            ", emprestado=" + this.emprestado +
            '}';
    }
}
