/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pilhalivros;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class Livro {
    String nome;
    int ano;
    double preco;
    Livro anterior;
   
    public Livro(String nome, int ano, double preco){
     this.nome = nome;
     this.ano = ano;
     this.preco = preco;
    }
    
    public Livro getAnterior() {
        return anterior;
    }
public void setAnterior(Livro anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " Ano: " + ano + " Preço: " + preco;
    }
}