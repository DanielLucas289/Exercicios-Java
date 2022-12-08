/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package num.pkg1;
import java.io.*;
import java.util.Scanner;

 /*
   @author Dani Lucas
 */
public class Num1 {

    
    public static void main(String[] args) {
        
      File arq = new File (?C:\\temp\\teste.txt?); 
      Scanner entrada, teclado = new Scanner(System.in);
      FileWriter saida;
      
      String nomeArq, frase; 
      StringBuilder novaFrase;
      
      try
      {
       System.out.println("Digite o nome do arquivo de entrada: ");
       nomeArq = teclado.nextLine();
       arq = new File(nomeArq);
       entrada = new Scanner(arq);
       
       System.out.println("Digite nome do arquivo de saída: ");
       nomeArq = teclado.nextLine();
       saida = new FileWriter(nomeArq);
       
       frase = entrada.nextLine();
       novaFrase = new StringBuilder();
       
       for(int i = 0; i < frase.length(); i++)
       {
         novaFrase.append(frase.charAt(i));
         novaFrase.append(frase.charAt(i));
       }
       
       saida.write(novaFrase.toString());
       
       entrada.close();
       saida.close();
       teclado.close();
      }
      
      catch(IOException iex)
      {
       System.out.println(iex.getMessage());
      }
    }
    
}
