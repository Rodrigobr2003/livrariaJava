/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PackServices;

import PackModel.DadosEmprestimoUser;
import PackModel.User;
import java.util.*;
import java.io.*;
/**
 *
 * @author Rodrigo
 */
public final class GerenciadorUsers extends ArquivoManager{
    
    private File file;
    private ArrayList<User> listaUsers = new ArrayList<>();
    private ArrayList<User> loadedUsers;
    public int ultimoIDUser = 0;
    private ArrayList<User> resultadoPesquisa = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public GerenciadorUsers() {
        super();
        
        this.file = criarArquivo("users.json");
        
        if(file.exists())this.loadedUsers = getDadosArquivo(User.class, listaUsers);
        
        if (loadedUsers != null && !loadedUsers.isEmpty()) {
            this.ultimoIDUser = loadedUsers.getLast().getID();
            this.listaUsers = loadedUsers;
        }
        
        escreverArquivo();
    }
    
    public void cadastrarUsuario(User user){
        this.listaUsers.add(user);
    }
    
    public void chamarFechamento(){
        fecharArquivo(this.listaUsers);
    }
    
    public String pesquisarUser(String nome){
        
        String varEnvio;
        
        for(User user : listaUsers){
            String nomeUsuarioTratado = user.getNome().toLowerCase().replace(" ", "");
            String nomeEnviadoTratado = nome.toLowerCase().replace(" ", "");
            
            if(nomeUsuarioTratado.equals(nomeEnviadoTratado)){
                resultadoPesquisa.add(user);
            }
        }
        
        varEnvio = resultadoPesquisa.toString();
        resultadoPesquisa.clear();
        
        return varEnvio;
        
    }
    
    public User pesquisarUser(int ID){
        Optional<User> userSelecionado = listaUsers.stream()
                .filter(us -> us.getID() == ID)
                .findFirst();
        
        if(userSelecionado.isPresent()){
            return userSelecionado.get();
        }
        else{
            return null;
        }
        
    }
    
    public void excluirUser(int ID){
        listaUsers.removeIf(us -> us.getID() == ID);
    }
    
    public void devolverLivro(User user, int ID){
        Optional<DadosEmprestimoUser> optionalReturn = user.getListaEmprestimos().stream()
                .filter(em -> em.getID() == ID)
                .findFirst();
        
        if(optionalReturn.isPresent()){
            DadosEmprestimoUser emprestimoUser = optionalReturn.get();
            emprestimoUser.setEmprestimo(false);
        }
    }
    
    public User objetoUserSemHistorico(User user){
        return new User(user.getID(), user.getNome(), user.getEmail(), user.getTelefone());
    }
    
    public String getHistoricoEmprestimos(User user){
        String varEnvio;
        ArrayList<DadosEmprestimoUser> pesquisa = new ArrayList<>();
        
        for(DadosEmprestimoUser emp : user.getListaEmprestimos()){
            pesquisa.add(emp);
        }
        
        return pesquisa.toString();
    }
    
    public User escolherUser(){
        
        String resultadoUser;
        
        //Do-while para selecionar user
        do{
                System.out.print("\nPesquisar usuario pelo nome: ");

                //Resultado da pesquisa do nome do user
                resultadoUser = this.pesquisarUser(scanner.nextLine());
                
                if(resultadoUser == null || resultadoUser.contains("[]")) System.out.print("\nUsuario nao encontrado...\n");
                
            }while(resultadoUser == null  || resultadoUser.contains("[]"));
        
        System.out.print("\nResultados: ");
        System.out.println(resultadoUser);
        
        System.out.print("\nEscolha um usuario pelo ID: ");
        return this.pesquisarUser(scanner.nextInt());

    }
}
