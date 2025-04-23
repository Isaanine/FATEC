/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pilha;

import javax.swing.JOptionPane;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class Pilha {
    int topo;
    int fim;
    int tamanho;
    int qtdeElementos =0;
    int p[];
    
    
    public Pilha(){
        topo = fim =-1;
        tamanho=10;
        p= new int[tamanho];qtdeElementos =0;
    }
    
    public boolean estaVazia(){
        if(qtdeElementos ==0){
            return true;
        }
        return false;
    }
    
    public boolean estaCheia(){
        if(qtdeElementos == tamanho){
            return true;
        }
        return false;
    }
    
    public void empilha(int e){
        if (!estaCheia()){
            if (topo == -1){
                topo =0;
            }
            topo++;
            p[topo]= e;
            qtdeElementos++;
        }
    }
    
    public int desempilha(){
        if (!estaVazia()){
            int x = p[topo];
            topo--;
            qtdeElementos --;
           }
        return x;
    }
    
    public void mostrar(){
        String elementos ="";
        for(int i=topo;i>=0;i--){
            elementos += p[i]+ " - ";
        }
        JOptionPane.showMessageDialog(null, elementos);
    }
    
    public static void main (String[] args){
        
    }
    
}
