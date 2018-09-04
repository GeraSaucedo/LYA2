package Lexico;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main (String [] krustier) {

		//Leemos el archivo
		try{
			
	         FileInputStream FIS = new FileInputStream("C:\\Users\\Jerry\\Desktop\\LEXICO.txt");  //Abrimos el archivo
	         DataInputStream DIS = new DataInputStream(FIS); //se crea el objeto de entrada
	         BufferedReader buffer = new BufferedReader(new InputStreamReader(DIS)); //se crea buffer de lectura
	         String strLinea;
	         List lista = new ArrayList();
	         int linea = 0;
	         Token token = new Token();
	        
	         // Leer el archivo linea por linea
	         while ((strLinea = buffer.readLine()) != null)   {
	             linea++;
	        	 //System.out.println (strLinea);  // Imprimimos la línea por pantalla
	             
	             for(int i=0;i<strLinea.length();i++) { // FOR PARA LEER CADA CARACTER DE LA LINEA
	            	 
	            	if(token.isDelimitador(strLinea.charAt(i))) {
	            		token.imprimirLista(lista);
	            		lista.clear();
	            	}else {
	            		lista.add(strLinea.charAt(i));
	            	}
	            	System.out.println();
	            
	             }
	       //
	         }
	         DIS.close(); // Cerramos el archivo
	    
		 }catch (Exception e){ //Catch de excepciones
	         System.err.println("Ocurrio un error: " + e.getMessage());
	     }
		 
		//Terminamos de leer el archivo
		 
		 
		 
		 
		 
		 
	
	}
}
