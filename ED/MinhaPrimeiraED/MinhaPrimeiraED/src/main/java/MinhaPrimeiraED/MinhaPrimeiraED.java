/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MinhaPrimeiraED;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class MinhaPrimeiraED {
  private Object[] objetos = new Object[10];
  public int totalDeObjetos = 0;

  // M�todo para adicionar um objeto em uma posi��o espec�fica
  public void adiciona(int posicao, Object objeto) {
    if (!posicaoValida(posicao) && posicao != totalDeObjetos) {
      throw new IllegalArgumentException("Posi��o inv�lida");
    }
    if (cheio()) {
      redimensionaVetor();
    }
    for (int i = totalDeObjetos; i > posicao; i--) {
      objetos[i+1] = objetos[i];
    }
    objetos[posicao] = objeto;
    totalDeObjetos++;
  }

  // M�todo para adicionar um objeto na pr�xima posi��o dispon�vel
  public void adiciona(Object objeto) {
    if (cheio()) {
      redimensionaVetor();
    }
    objetos[totalDeObjetos] = objeto;
    totalDeObjetos++;
  }
  
  // Verifica se uma posi��o est� ocupada
  private boolean posicaoOcupada(int posicao) {
    return posicao >= 0 && posicao < totalDeObjetos;
  }

  // Verifica se uma posi��o existe
  private boolean posicaoValida(int posicao) {
    return posicao >= 0 && posicao <= totalDeObjetos;
  }
  
  // Remove o objeto de uma posi��o espec�fica
  public void remove(int posicao) {
    if (!posicaoValida(posicao)) {
      throw new IllegalArgumentException("Posi��o inv�lida ou vazia");
    }
    for (int i = posicao; i < totalDeObjetos - 1; i++) {
      objetos[i] = objetos[i + 1];
    }
    totalDeObjetos--;
  }

  // Verifica se o objeto existe 
  public boolean contem(Object objeto) {
    for (int i = 0; i < totalDeObjetos; i++) {
      if (objetos[i].equals(objeto)) {
        return true;
      }
    }
    return false;
  }
          
  
  // Retorna o objeto de uma determinada posi��o
  public Object getObjeto(int posicao) {
    if (!posicaoOcupada(posicao)) {
      throw new IllegalArgumentException("Posi��o inv�lida");
    }
    return objetos[posicao];
  }

  // Retorna a quantidade de objetos no vetor
  public int tamanho() {
    return totalDeObjetos;
  }

  public boolean cheio() {
    return totalDeObjetos == objetos.length;
  }

  public boolean vazio() {
    return totalDeObjetos == 0;
  }
  
  // M�todo para redimensionar o vetor, dobrando sua capacidade
  private void redimensionaVetor() {
  Object[] novoVetor = new Object[objetos.length * 2];
    for(int i=0;i< objetos.length;i++)  
    {
        novoVetor[i]=objetos[i];
    }
  objetos=novoVetor;
  }

  public static void main(String[] args) {
    MinhaPrimeiraED ed = new MinhaPrimeiraED();

    // Teste adiciona(Object)
    System.out.println("Adicionando elementos...");
    ed.adiciona("A");
    ed.adiciona("B");
    ed.adiciona("C");
    
   // Exibi��o
    System.out.println("Elementos na estrutura:");
    for (int i = 0; i < ed.tamanho(); i++) {
      System.out.println("Posi��o " + i + ": " + ed.getObjeto(i));
    }
    // Teste adiciona(int, Object)
    System.out.println("Inserindo na posi��o 1...");
    ed.adiciona(1, "D");

    // Exibi��o
    System.out.println("Elementos na estrutura:");
    for (int i = 0; i < ed.tamanho(); i++) {
      System.out.println("Posi��o " + i + ": " + ed.getObjeto(i));
    }

    // Teste posicaoOcupada()
    System.out.println("Posi��o 1 est� ocupada? " + ed.posicaoOcupada(1));
    System.out.println("Posi��o 10 est� ocupada? " + ed.posicaoOcupada(10));

    // Teste posicaoValida()
    System.out.println("Posi��o 1 � v�lida? " + ed.posicaoValida(1));
    System.out.println("Posi��o 10 � v�lida? " + ed.posicaoValida(10));

    // Teste contem()
    System.out.println("Cont�m 'D'? " + ed.contem("D"));
    System.out.println("Cont�m 'Z'? " + ed.contem("Z"));

    // Teste getObjeto()
    System.out.println("Objeto na posi��o 1: " + ed.getObjeto(1));

    // Teste remove()
    System.out.println("Removendo o elemento na posi��o 1...");
    ed.remove(1);

    System.out.println("Elementos ap�s remo��o:");
    for (int i = 0; i < ed.tamanho(); i++) {
      System.out.println("Posi��o " + i + ": " + ed.getObjeto(i));
    }

    // Teste tamanho()
    System.out.println("Tamanho atual: " + ed.tamanho());

    // Teste cheio() e redimensionamento
    System.out.println("Adicionando elementos para testar redimensionamento...");
    for (int i = 0; i < 15; i++) {
      ed.adiciona("Elemento " + i);
    }
       // Exibi��o
    System.out.println("Elementos na estrutura:");
    for (int i = 0; i < ed.tamanho(); i++) {
      System.out.println("Posi��o " + i + ": " + ed.getObjeto(i));
    }
    System.out.println("Tamanho ap�s adi��es: " + ed.tamanho());

    // Teste vazio()
    System.out.println("A estrutura est� vazia? " + ed.vazio());

    // Remover todos os elementos
    for (int i = ed.tamanho() - 1; i >= 0; i--) {
      ed.remove(i);
    }

    System.out.println("A estrutura est� vazia ap�s remo��es? " + ed.vazio());
  }
}
