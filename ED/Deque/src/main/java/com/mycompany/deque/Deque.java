/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.deque;

class Deque {
    private class No {
        Object item;
        No prox;
        No ant;
    }
    
    private No inicio;
    private No fim;
    
    public Deque() {
        this.inicio = this.fim = null;
    }
    
    public boolean vazia() {
        return inicio == null;
    }
    
    public void insereInicio(Object valor) {
        No novo = new No();
        novo.item = valor;
        novo.prox = inicio;
        if (inicio != null) {
            inicio.ant = novo;
        }
        inicio = novo;
        if (fim == null) {
            fim = novo;
        }
    }
    
    public void insereFim(Object valor) {
        No novo = new No();
        novo.item = valor;
        novo.ant = fim;
        if (fim != null) {
            fim.prox = novo;
        }
        fim = novo;
        if (inicio == null) {
            inicio = novo;
        }
    }
    
    public Object removeInicio() throws Exception {
        if (vazia()) {
            throw new Exception("Erro: O deque está vazio");
        }
        Object valor = inicio.item;
        inicio = inicio.prox;
        if (inicio != null) {
            inicio.ant = null;
        } else {
            fim = null;
        }
        return valor;
    }
    
    public Object removeFim() throws Exception {
        if (vazia()) {
            throw new Exception("Erro: O deque está vazio");
        }
        Object valor = fim.item;
        fim = fim.ant;
        if (fim != null) {
            fim.prox = null;
        } else {
            inicio = null;
        }
        return valor;
    }
    
    public void imprime() {
        No aux = inicio;
        while (aux != null) {
            System.out.print(aux.item.toString() + " ");
            aux = aux.prox;
        }
        System.out.println();
    }
}

