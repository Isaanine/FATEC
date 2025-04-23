/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pilhalivros;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class Pilha {

    private Livro topo, anterior;

    public void push(Livro livro) { //empilhar
        if (anterior == null) {
            anterior = livro;
        } else {
            topo = livro;
            topo.setAnterior(anterior);
            anterior = topo;
        }
    }

    public void pop() {
        topo = topo.getAnterior();
        anterior = topo;
    }

    public Livro top() {
        return topo;
    }

    public void mostraLivros() {
        Livro aux = topo;

        while (aux != null) {
            System.out.println(aux.toString());
            aux = aux.getAnterior();
        }
    }
}
