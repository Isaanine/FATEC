/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.minhaprimeiraed2;

/**
 *
 * @author nadia
 */
public class MinhaPrimeiraED2 {

 private Object[] fila = new Object[10];
    private int totalDeElementos = 0;
    private int inicio = 0;
    private int fim = 0;
    
    // Método para enfileirar um elemento
    public void enfileira(Object elemento) {
        if (cheia()) {
            redimensionaFila();
        }
        fila[fim] = elemento;
        fim = (fim + 1) % fila.length;
        totalDeElementos++;
    }
    
    // Método para desenfileirar um elemento
    public Object desenfileira() {
        if (vazia()) {
            throw new IllegalArgumentException("Fila vazia");
        }
        Object elemento = fila[inicio];
        fila[inicio] = null;
        inicio = (inicio + 1) % fila.length;
        totalDeElementos--;
        return elemento;
    }
    
    // Método para verificar o primeiro elemento da fila
    public Object primeiro() {
        if (vazia()) {
            throw new IllegalArgumentException("Fila vazia");
        }
        return fila[inicio];
    }
    
    // Verifica se a fila está cheia
    private boolean cheia() {
        return totalDeElementos == fila.length;
    }
    
    // Verifica se a fila está vazia
    public boolean vazia() {
        return totalDeElementos == 0;
    }
    
    // Retorna o tamanho atual da fila
    public int tamanho() {
        return totalDeElementos;
    }
    
    // Método para redimensionar a fila quando cheia
    private void redimensionaFila() {
        Object[] novaFila = new Object[fila.length * 2];
        for (int i = 0; i < totalDeElementos; i++) {
            novaFila[i] = fila[(inicio + i) % fila.length];
        }
        fila = novaFila;
        inicio = 0;
        fim = totalDeElementos;
    }
    
    // Método para visualizar a fila completa
    public void exibirFila() {
        if (vazia()) {
            System.out.println("Fila vazia");
            return;
        }
        System.out.print("Fila: ");
        for (int i = 0; i < totalDeElementos; i++) {
            System.out.print(fila[(inicio + i) % fila.length] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        MinhaPrimeiraED2 fila = new MinhaPrimeiraED2();

        // Teste enfileira()
        System.out.println("Enfileirando elementos...");
        fila.enfileira("A");
        fila.enfileira("B");
        fila.enfileira("C");
        
        // Exibir fila completa
        fila.exibirFila();
        
        // Teste primeiro()
        System.out.println("Primeiro elemento: " + fila.primeiro());
        
        // Teste desenfileira()
        System.out.println("Desenfileirando: " + fila.desenfileira());
        
        // Exibir fila após desenfileirar
        fila.exibirFila();
        
        System.out.println("Novo primeiro elemento: " + fila.primeiro());
        
        // Teste tamanho()
        System.out.println("Tamanho da fila: " + fila.tamanho());
        
        // Teste vazia()
        System.out.println("A fila está vazia? " + fila.vazia());
    }
}
