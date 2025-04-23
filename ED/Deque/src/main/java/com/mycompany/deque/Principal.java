/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deque;

public class Principal {
    public static void main(String[] args) {
        try {
            System.out.println("Deque Teste:");
            Deque deque = new Deque();
            deque.insereInicio("A");
            deque.insereFim("B");
            deque.insereInicio("C");
            deque.insereFim("D");
            deque.imprime();
            
            System.out.println("Remove do início: " + deque.removeInicio());
            System.out.println("Remove do fim: " + deque.removeFim());
            deque.imprime();
            
            System.out.println("\nFila Circular Teste:");
            FilaCircular fila = new FilaCircular(5);
            fila.enfileira("1");
            fila.enfileira("2");
            fila.enfileira("3");
            fila.enfileira("4");
            fila.enfileira("5");
            fila.imprime();
            
            System.out.println("Desenfileirou: " + fila.desenfileira());
            fila.enfileira("6");
            fila.imprime();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

