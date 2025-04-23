/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deque;

class FilaCircular {
    private Object[] vetor;
    private int inicio, fim, tamanho;
    
    public FilaCircular(int capacidade) {
        this.vetor = new Object[capacidade];
        this.inicio = 0;
        this.fim = 0;
        this.tamanho = 0;
    }
    
    public boolean vazia() {
        return tamanho == 0;
    }
    
    public boolean cheia() {
        return tamanho == vetor.length;
    }
    
    public void enfileira(Object valor) throws Exception {
        if (cheia()) {
            throw new Exception("Erro: A fila circular está cheia");
        }
        vetor[fim] = valor;
        fim = (fim + 1) % vetor.length;
        tamanho++;
    }
    
    public Object desenfileira() throws Exception {
        if (vazia()) {
            throw new Exception("Erro: A fila circular está vazia");
        }
        Object valor = vetor[inicio];
        inicio = (inicio + 1) % vetor.length;
        tamanho--;
        return valor;
    }
    
    public void imprime() {
        int i = inicio;
        for (int c = 0; c < tamanho; c++) {
            System.out.print(vetor[i].toString() + " ");
            i = (i + 1) % vetor.length;
        }
        System.out.println();
    }
}