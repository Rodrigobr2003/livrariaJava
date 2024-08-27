package com.mycompany.projeto_livraria;

import java.util.*;

public class Projeto_Livraria {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
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
            System.out.println("Adicionar Usuario");
            }
        case 2 -> {
            System.out.println("Adicionar Livro");
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
        
        }
        
    }
}
