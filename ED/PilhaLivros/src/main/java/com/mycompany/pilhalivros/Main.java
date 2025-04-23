/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pilhalivros;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class Main {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();
 
        Livro livro1 = new Livro("Java para Iniciantes", 2020, 150.0);
        Livro livro2 = new Livro("Estruturas de Dados", 2018, 200.0);
        Livro livro3 = new Livro("Algoritmos Avançados", 2022, 250.0);
 
        pilha.push(livro1);
        pilha.push(livro2);
        pilha.push(livro3);
 
        System.out.println("Livros na pilha:");
        pilha.mostraLivros();
 
        System.out.println("\nRemovendo o topo...");
        pilha.pop();
 
        System.out.println("\nLivros na pilha após pop:");
        pilha.mostraLivros();
    }
}


