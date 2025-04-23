/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dequeencadeado;
package com.mycompany.minhaprimeiraed;

class No {
    Object dado;
    No anterior;
    No proximo;
    
    public No(Object dado) {
        this.dado = dado;
        this.anterior = null;
        this.proximo = null;
    }
}

public class DequeEncadeado {
    private No primeiro;
    private No ultimo;
    private int tamanho;
    
    public DequeEncadeado() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }
    
    public void adicionaInicio(Object objeto) {
        No novoNo = new No(objeto);
        if (vazio()) {
            primeiro = ultimo = novoNo;
        } else {
            novoNo.proximo = primeiro;
            primeiro.anterior = novoNo;
            primeiro = novoNo;
        }
        tamanho++;
    }
    
    public void adicionaFim(Object objeto) {
        No novoNo = new No(objeto);
        if (vazio()) {
            primeiro = ultimo = novoNo;
        } else {
            ultimo.proximo = novoNo;
            novoNo.anterior = ultimo;
            ultimo = novoNo;
        }
        tamanho++;
    }
    
    public Object removeInicio() {
        if (vazio()) {
            throw new IllegalStateException("Deque está vazio");
        }
        Object dado = primeiro.dado;
        primeiro = primeiro.proximo;
        if (primeiro != null) {
            primeiro.anterior = null;
        } else {
            ultimo = null;
        }
        tamanho--;
        return dado;
    }
    
    public Object removeFim() {
        if (vazio()) {
            throw new IllegalStateException("Deque está vazio");
        }
        Object dado = ultimo.dado;
        ultimo = ultimo.anterior;
        if (ultimo != null) {
            ultimo.proximo = null;
        } else {
            primeiro = null;
        }
        tamanho--;
        return dado;
    }
    
    public Object getInicio() {
        if (vazio()) {
            throw new IllegalStateException("Deque está vazio");
        }
        return primeiro.dado;
    }
    
    public Object getFim() {
        if (vazio()) {
            throw new IllegalStateException("Deque está vazio");
        }
        return ultimo.dado;
    }
    
    public int tamanho() {
        return tamanho;
    }
    
    public boolean vazio() {
        return tamanho == 0;
    }
    
    public static void main(String[] args) {
        DequeEncadeado deque = new DequeEncadeado();
        
        System.out.println("Adicionando elementos no início e no fim...");
        deque.adicionaInicio("A");
        deque.adicionaFim("B");
        deque.adicionaInicio("C");
        deque.adicionaFim("D");
        
        System.out.println("Primeiro elemento: " + deque.getInicio());
        System.out.println("Último elemento: " + deque.getFim());
        
        System.out.println("Removendo do início: " + deque.removeInicio());
        System.out.println("Removendo do fim: " + deque.removeFim());
        
        System.out.println("Tamanho atual: " + deque.tamanho());
        System.out.println("Deque está vazio? " + deque.vazio());
    }
}
