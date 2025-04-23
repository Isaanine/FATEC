/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dequevetor;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class DequeVetor {
    private Object[] deque;
    private int inicio;
    private int fim;
    private int tamanho;
    private int capacidade;
    
    public DequeVetor(int capacidade) {
        this.capacidade = capacidade;
        this.deque = new Object[capacidade];
        this.inicio = -1;
        this.fim = -1;
        this.tamanho = 0;
    }
    
    public void adicionaInicio(Object objeto) {
        if (cheio()) {
            throw new IllegalStateException("Deque está cheio");
        }
        if (vazio()) {
            inicio = fim = 0;
        } else {
            inicio = (inicio - 1 + capacidade) % capacidade;
        }
        deque[inicio] = objeto;
        tamanho++;
    }
    
    public void adicionaFim(Object objeto) {
        if (cheio()) {
            throw new IllegalStateException("Deque está cheio");
        }
        if (vazio()) {
            inicio = fim = 0;
        } else {
            fim = (fim + 1) % capacidade;
        }
        deque[fim] = objeto;
        tamanho++;
    }
    
    public Object removeInicio() {
        if (vazio()) {
            throw new IllegalStateException("Deque está vazio");
        }
        Object dado = deque[inicio];
        if (inicio == fim) {
            inicio = fim = -1;
        } else {
            inicio = (inicio + 1) % capacidade;
        }
        tamanho--;
        return dado;
    }
    
    public Object removeFim() {
        if (vazio()) {
            throw new IllegalStateException("Deque está vazio");
        }
        Object dado = deque[fim];
        if (inicio == fim) {
            inicio = fim = -1;
        } else {
            fim = (fim - 1 + capacidade) % capacidade;
        }
        tamanho--;
        return dado;
    }
    
    public Object getInicio() {
        if (vazio()) {
            throw new IllegalStateException("Deque está vazio");
        }
        return deque[inicio];
    }
    
    public Object getFim() {
        if (vazio()) {
            throw new IllegalStateException("Deque está vazio");
        }
        return deque[fim];
    }
    
    public int tamanho() {
        return tamanho;
    }
    
    public boolean cheio() {
        return tamanho == capacidade;
    }
    
    public boolean vazio() {
        return tamanho == 0;
    }
    public void exibir() {
        if (vazio()) {
            System.out.println("Deque está vazio");
            return;
        }
        System.out.print("Deque: ");
        for (int i = 0; i < tamanho; i++) {
            int index = (inicio + i) % capacidade;
            System.out.print(deque[index] + " ");
        }
        System.out.println();
    }
    
    
    public static void main(String[] args) {
        DequeVetor deque = new DequeVetor(10);
        
        System.out.println("Adicionando elementos no início e no fim...");
       
        deque.adicionaInicio("A");
        deque.adicionaFim("B");
        deque.adicionaInicio("C");
        deque.adicionaFim("D");
        deque.exibir();
        
        System.out.println("Primeiro elemento: " + deque.getInicio());
        System.out.println("Último elemento: " + deque.getFim());
        
        System.out.println("Removendo do início: " + deque.removeInicio());
        System.out.println("Removendo do fim: " + deque.removeFim());
        deque.exibir();
        System.out.println("Tamanho atual: " + deque.tamanho());
        System.out.println("Deque está vazio? " + deque.vazio());
    }
}