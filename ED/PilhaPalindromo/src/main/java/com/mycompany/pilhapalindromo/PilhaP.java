package com.mycompany.pilhapalindromo;

public class PilhaP {

    static class Pilha {
        private char[] elementos;
        int inicio;
        int topo = -1;
        int tamanho;
        int qtdeElementos = 0;
        int fim = inicio;

        public Pilha(int capacidade) {
            elementos = new char[capacidade];
            topo = -1;
        }

        public void push(char c) {
            if (topo < elementos.length - 1) {
                elementos[++topo] = c;
            }
        }

        public char pop() {
            if (!isEmpty()) {
                return elementos[topo--];
            }
            throw new RuntimeException("Pilha vazia");
        }

        public void mostra() {
            if (!isEmpty()) {
                for (int i = 0; i < fim; i++) {
                    int numero = elementos[i];
                    System.out.println("[" + numero + "]");
                }
            } else {
                System.out.println("Lista vaziaaaa");
            }
        }

        public boolean isEmpty() {
            return topo == -1;
        }
    }

    public static boolean ehPalindromo(String palavra) {
        int tamanho = palavra.length();
        Pilha pilhaOriginal = new Pilha(tamanho);
        Pilha pilhaReversa = new Pilha(tamanho);
        Pilha pilhaAuxiliar = new Pilha(tamanho);

        // Inserir caracteres na pilha original
        for (int i = 0; i < tamanho; i++) {
            pilhaOriginal.push(palavra.charAt(i));
        }

        // Passar da original para a auxiliar e reversa
        while (!pilhaOriginal.isEmpty()) {
            char c = pilhaOriginal.pop();
            pilhaAuxiliar.push(c);   
            pilhaReversa.push(c);    
        }

        // Restaurar pilhaOriginal usando pilhaAuxiliar
        while (!pilhaAuxiliar.isEmpty()) {
            pilhaOriginal.push(pilhaAuxiliar.pop());
        }

        // Comparar pilhaOriginal e pilhaReversa
        while (!pilhaOriginal.isEmpty()) {
            if (pilhaOriginal.pop() != pilhaReversa.pop()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String palavra = "sao";
        if (ehPalindromo(palavra)) {
            System.out.println(palavra + " é um palíndromo.");
            
        } else {
            System.out.println(palavra + " não é um palíndromo.");
        }
    }
}
