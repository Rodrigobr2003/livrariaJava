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
            
            //AQUI NÃO É POSSIVEL PESQUISAR POR NOMES QUE CONTENHAM ESPAÇO OU
            //LETRAS MINUSCULAS OU MAIUSCULAS --> CORRIGIR DPS

            System.out.print("\nEscolha o usuario que deseja adicionar o emprestimo");
            userSelecionado = gerenciadorUsuarios.escolherUser();
            
            emprestimo.setUsario(gerenciadorUsuarios
                .objetoUserSemHistorico(userSelecionado));
                
            System.out.print("\nEscolha o livro que deseja emprestar");
            emprestimo.setLivro(gerenciadorLivros.escolherLivro());
                
            //Aqui aloca dentro da instancia emprestimo a data escolhida
            emprestimo.setDataEmprestimo(LocalDate.now().format(formatter));
            
            //Aqui aloca dentro da instancia emprestimo a data de devolução
            emprestimo.setDataDevolucao(LocalDate.now().plusMonths(1).format(formatter));
            
            //Adiciona conteudo no arquivo
            gerenciadorEmprestimos.cadastrarEmprestimo(emprestimo);
            
            //Insere infos do emprestimo dentro do historico de emprestimos do user
            userSelecionado.setListaEmprestimos(emprestimo.getDadosEmprestimoUser(formatter, emprestimo));
            
            System.out.println("\nLivro emprestado com sucesso!");
            
            }
        case 4 -> {
            
            System.out.print("\nEscolha o usuario que deseja devolver o emprestimo");
            User userSelecionado = gerenciadorUsuarios.escolherUser();

            System.out.print("\nEmprestimos do " + userSelecionado.getNome() + " :");
            //Mostra todos os emprestimos do user
            System.out.println("\n" + gerenciadorUsuarios.getHistoricoEmprestimos(userSelecionado));
            
            System.out.print("\nEscolha o emprestimo que deseja encerrar: ");
            int escolhaEncerramento = scanner.nextInt();
            
            //Define o emprestimo no objeto user como false
            gerenciadorUsuarios.devolverLivro(userSelecionado, escolhaEncerramento);
            
            //Define o emprestimo no objeto emprestimo como false
            gerenciadorEmprestimos.devolverLivro(escolhaEncerramento);
            
            System.out.println("\nEmprestimo encerrado!");
            
        }
        case 5 -> {
            
            System.out.print("\nEscolha o usuario que deseja procurar para excluir");

            gerenciadorUsuarios.excluirUser(gerenciadorUsuarios.escolherUser().getID());
            }
        case 6 -> {
                        
            System.out.print("\nEscolha o livro que deseja excluir");

            gerenciadorLivros.excluirLivro(gerenciadorLivros.escolherLivro().getID());
        }
        case 7 -> {
            
            User userSelecionado;
            
            userSelecionado = gerenciadorUsuarios.escolherUser();
                
            System.out.print("\nEmprestimos do " + userSelecionado.getNome() + " :");
                
            System.out.println("\n" + gerenciadorUsuarios.getHistoricoEmprestimos(userSelecionado));
        }
        case 8 -> {
            
            System.out.println("Todos os livros: ");
            
            System.out.println(gerenciadorLivros.getLivros());
        }
        case 9 -> {
            gerenciadorUsuarios.chamarFechamento();
            gerenciadorLivros.chamarFechamento();
            gerenciadorEmprestimos.chamarFechamento();
            
            System.exit(0);
        }
        
        }
        System.out.println("\n1 - Sair");
        System.out.println("2 - Voltar ao menu");
        escolha = scanner.nextInt();
        
        }while(escolha == 2);
        
        gerenciadorUsuarios.chamarFechamento();
        gerenciadorLivros.chamarFechamento();
        gerenciadorEmprestimos.chamarFechamento();
        
    }
}
