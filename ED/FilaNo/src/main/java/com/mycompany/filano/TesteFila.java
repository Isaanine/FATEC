/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filano;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class TesteFila {
    public static void main(String[] args) {
        try {
            Fila fila = new Fila();
 
            System.out.println("Fila está vazia? " + fila.vazia());
 
            // Enfileirando elementos
            System.out.println("Enfileirando elementos...");
            fila.enfileira("A");
            fila.enfileira("B");
            fila.enfileira("C");
 
            // Imprimindo a fila
            System.out.print("Estado da fila: ");
            fila.imprime();
            System.out.println();
 
            // Desenfileirando um elemento
            System.out.println("Desenfileirando elemento: " + fila.desenfileira());
 
            // Imprimindo a fila 
            System.out.print("Estado da fila: ");
            fila.imprime();
            System.out.println();
 
            // Adicionando elementos
            fila.enfileira("D");
            fila.enfileira("E");
 
            // Tentativa de enfileirar em uma fila cheia
            System.out.println("Tentando enfileirar em uma fila cheia...");
            fila.enfileira("F"); 
 
        } catch (Exception e) {
            // Captura e exibe as exceções lançadas
            System.out.println(e.getMessage());
        }
    }
}
 
