/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MinhaPrimeiraED;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class Principal {
    
    public static void main(String [] args){
        Pizza p1 =new Pizza("Mussarela", 50.00);
        Pizza p2 =new Pizza("Marguerita", 60.00);
        Pizza p3 =new Pizza("Portuguesa", 70.00);
        Pizza p4 =new Pizza("Napolitana", 80.00);
        Pizza p5 =new Pizza("Calabresa", 30.00);
        
        Bebida b1=new Bebida("Coca-Cola", 12.00);
        Bebida b2=new Bebida("Sprite", 10.00);
        
        CarrinhoDeCompras c1=new CarrinhoDeCompras();
        
        c1.adicionaBebida(b1);
        c1.adicionaBebida(b2);
        c1.adicionaPizza(p1);
        c1.adicionaPizza(p2);
        c1.adicionaPizza(p3);
        c1.adicionaPizza(p4);
        c1.adicionaPizza(p5);
        System.out.println("Total a pagar = "+c1.getTotalPagar());


        

    }
    
}
