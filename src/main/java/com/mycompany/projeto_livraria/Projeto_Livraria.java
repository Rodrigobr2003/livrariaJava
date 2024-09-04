    package com.mycompany.projeto_livraria;

import PackModel.Emprestimo;
import PackModel.Livro;
import PackModel.User;
import PackServices.GerenciadorEmprestimos;
import PackServices.GerenciadorLivros;
import PackServices.GerenciadorUsers;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Projeto_Livraria {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        GerenciadorUsers gerenciadorUsuarios = new GerenciadorUsers();
        GerenciadorLivros gerenciadorLivros = new GerenciadorLivros();
        GerenciadorEmprestimos gerenciadorEmprestimos = new GerenciadorEmprestimos();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        int escolha;
        int counterUser = gerenciadorUsuarios.ultimoIDUser;
        int counterLivro = gerenciadorLivros.ultimoIDLivro;
        int counterEmprestimo = gerenciadorEmprestimos.ultimoIDEmprestimo;
        
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
            
            gerenciadorUsuarios.cadastrarUsuario(usuario);
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
            Emprestimo emprestimo = new Emprestimo();
            
            counterEmprestimo++;
            
            emprestimo.setID(counterEmprestimo);
            
            User userSelecionado;
            Livro livroSelecionado;
            String resultadoUser;
            String resultadoLivro;
            
            //AQUI NÃO É POSSIVEL PESQUISAR POR NOMES QUE CONTENHAM ESPAÇO OU
            //LETRAS MINUSCULAS OU MAIUSCULAS --> CORRIGIR DPS
            
            //Do-while para selecionar user
            do{
                System.out.print("\nEscolha o usuario que deseja adicionar o emprestimo");
                System.out.print("\nPesquisar usuario por nome: ");

                //Resultado da pesquisa do nome do user
                resultadoUser = gerenciadorUsuarios.pesquisarUser(scanner.next());
                
                if(resultadoUser == null || resultadoUser.contains("[]")) System.out.print("\nUsuario nao encontrado...\n");
                
            }while(resultadoUser == null  || resultadoUser.contains("[]"));
                System.out.print("\nResultados: ");
                System.out.println(resultadoUser);
                System.out.print("\nEscolha um usuario pelo ID para emprestar: ");

                //Aqui aloca dentro da instancia emprestimo o usuario escolhido
                userSelecionado = gerenciadorUsuarios.pesquisarUser(scanner.nextInt());
                emprestimo.setUsario(userSelecionado);
            
            //Do-while para selecionar livro
            do{
                System.out.print("\nEscolha o livro que deseja emprestar");
                System.out.print("\nPesquisar livro por nome: ");

                //Resultado da pesquisa do nome do livro
                resultadoLivro = gerenciadorLivros.pesquisarLivro(scanner.next());
                
                if(resultadoLivro == null  || resultadoLivro.contains("[]")) System.out.print("\nLivro nao encontrado...\n");
                
            }while(resultadoLivro == null || resultadoLivro.contains("[]"));
            
                System.out.print("\nResultados: ");
                System.out.println(resultadoLivro);
                System.out.print("\nEscolha um livro pelo ID para emprestar: ");

                //Aqui aloca dentro da instancia emprestimo o livro escolhido
                livroSelecionado = gerenciadorLivros.pesquisarLivro(scanner.nextInt());
                
                emprestimo.setLivro(livroSelecionado);
                
            //Aqui aloca dentro da instancia emprestimo a data escolhida
            emprestimo.setDataEmprestimo(LocalDate.now().format(formatter));
            
            //Aqui aloca dentro da instancia emprestimo a data de devolução
            emprestimo.setDataDevolucao(LocalDate.now().plusMonths(1).format(formatter));
            
            //Adiciona conteudo no arquivo
            gerenciadorEmprestimos.cadastrarEmprestimo(emprestimo);
            
            System.out.println("\nLivro emprestado com sucesso!");
            
            }
        case 4 -> {
            System.out.println("Devolver Livro");
        }
        case 5 -> {
            String resultadoUser;
            
            //Do-while para selecionar user
            do{
                System.out.print("\nEscolha o usuario que deseja procurar");
                System.out.print("\nPesquisar usuario por nome: ");

                //Resultado da pesquisa do nome do user
                resultadoUser = gerenciadorUsuarios.pesquisarUser(scanner.next());
                
                if(resultadoUser == null || resultadoUser.contains("[]")) System.out.print("\nUsuario nao encontrado...\n");
                
            }while(resultadoUser == null  || resultadoUser.contains("[]"));
            
            System.out.print("\nResultados: ");
            System.out.println(resultadoUser);
            
            System.out.print("\nEscolha o ID do usuario para exclui-lo: ");
            gerenciadorUsuarios.excluirUser(scanner.nextInt());
            }
        case 6 -> {
            String resultadoLivro;
            
            //Do-while para selecionar user
            do{
                System.out.print("\nEscolha o livro que deseja procurar");
                System.out.print("\nPesquisar livro por nome: ");

                //Resultado da pesquisa do nome do user
                resultadoLivro = gerenciadorLivros.pesquisarLivro(scanner.next());
                
                if(resultadoLivro == null || resultadoLivro.contains("[]")) System.out.print("\nUsuario nao encontrado...\n");
                
            }while(resultadoLivro == null  || resultadoLivro.contains("[]"));
            
            System.out.print("\nResultados: ");
            System.out.println(resultadoLivro);
            
            System.out.print("\nEscolha o ID do livro para exclui-lo: ");
            gerenciadorLivros.excluirLivro(scanner.nextInt());
        }
        case 7 -> {
            System.out.println("Historico de Emprestimos");
        }
        case 8 -> {
            
            System.out.println("Todos os livros: ");
            
            System.out.println(gerenciadorLivros.getLivros());
        }
        case 9 -> {
            System.exit(0);
        }
        
        }
        System.out.println("1 - Sair");
        System.out.println("2 - Voltar ao menu");
        escolha = scanner.nextInt();
        
        }while(escolha == 2);
        
        gerenciadorUsuarios.chamarFechamento();
        gerenciadorLivros.chamarFechamento();
        gerenciadorEmprestimos.chamarFechamento();
        
    }
}
