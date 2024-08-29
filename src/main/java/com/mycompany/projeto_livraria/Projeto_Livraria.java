package com.mycompany.projeto_livraria;

import PackModel.Livro;
import PackModel.User;
import PackServices.GerenciadorLivros;
import PackServices.GerenciadorUsers;
import java.util.*;

public class Projeto_Livraria {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        GerenciadorUsers gerenciadorUsuarios = new GerenciadorUsers();
        GerenciadorLivros gerenciadorLivros = new GerenciadorLivros();
        
        int escolha;
        int counterUser = gerenciadorUsuarios.ultimoID;
        int counterLivro = gerenciadorLivros.ultimoIDLivro;
        
        do{
        System.out.println("Sistema de Gerenciamento de Biblioteca");
        
        System.out.println("1 - Adicionar Usuario");
        System.out.println("2 - Adicionar Livro");
        System.out.println("3 - Emprestar Livro");
        System.out.println("4 - Devolver Livro");
        System.out.println("5 - Excluir Usuario");
        System.out.println("6 - Excluir Livro");
        System.out.println("7 - Historico de Emprestimos");
        System.out.println("8 - Consulta de Livros");
        System.out.println("9 - Sair");
        System.out.print("Escolha uma opcao: ");
        
        switch(scanner.nextInt()){
        case 1 -> {
            User usuario = new User();
            
            counterUser++;
            
            usuario.setID(counterUser);
            
            System.out.print("\nInsira o nome do usuario: ");
            usuario.setNome(scanner.next());
            
            System.out.print("\nInsira o email do usuario: ");
            usuario.setEmail(scanner.next());
            
            System.out.print("\nInsira o telefone do usuario: ");
            usuario.setTelefone(scanner.next());
            
            gerenciadorUsuarios.adicionarUser(usuario);
            }
        case 2 -> {
            Livro livro = new Livro();
            
            counterLivro++;
                    
            livro.setID(counterLivro);
            
            System.out.print("\nInsira o titulo do livro: ");
            livro.setTitulo(scanner.next());
            
            System.out.print("\nInsira o nome do autor do livro: ");
            livro.setAutor(scanner.next());
            
            System.out.print("\nInsira a quantidade de livros: ");
            livro.setQuantidade(scanner.nextInt());
            
            System.out.print("\nInsira o ISBN do livro: ");
            livro.setIsbn(scanner.next());
            
            System.out.print("\nInsira a data de publicacao do livro: ");
            livro.setDataPublicacao(scanner.next());
            
            gerenciadorLivros.cadastrarLivro(livro);
        }
        case 3 -> {
            System.out.println("Emprestar Livro");
            }
        case 4 -> {
            System.out.println("Devolver Livro");
        }
        case 5 -> {
            System.out.println("Excluir Usuario");
            }
        case 6 -> {
            System.out.println("Excluir Livro");
        }
        case 7 -> {
            System.out.println("Historico de Emprestimos");
            }
        case 8 -> {
            System.out.println("Consulta de Livros");
        }
        case 9 -> {
            System.exit(0);
        }
        
        }
        System.out.println("1 - Sair");
        System.out.println("2 - Voltar ao menu");
        escolha = scanner.nextInt();
        
        }while(escolha == 2);
        
        gerenciadorUsuarios.fecharArquivo();
        gerenciadorLivros.fecharArquivo();
        
    }
}
