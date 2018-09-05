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
			
	         FileInputStream FIS = new FileInputStream("C:\\Users\\Training\\Desktop\\Lex.txt");  //Abrimos el archivo
	         DataInputStream DIS = new DataInputStream(FIS); //se crea el objeto de entrada
	         BufferedReader buffer = new BufferedReader(new InputStreamReader(DIS)); //se crea buffer de lectura
	         String strLinea;
	         List lista = new ArrayList();
	         List listaDel = new ArrayList();
	         
	         int linea = 0;
	         Token token = new Token();
	        
	         // Leer el archivo linea por linea
	         while ((strLinea = buffer.readLine()) != null)   {
	             linea++;
	        	 String cadenaDel = "";
	             for(int i=0;i<strLinea.length();i++) { // FOR PARA LEER CADA CARACTER DE LA LINEA
	            	 
	            	if(token.isDelimitadorToken(strLinea.charAt(i)) || token.isDelimitadorNoToken(strLinea.charAt(i))) {
	            		
	            		if(token.isDelimitadorNoToken(strLinea.charAt(i))) {
	            			cadenaDel = token.imprimirLista(listaDel);
	            			listaDel.clear();
	            			if(token.isOperador(cadenaDel)) System.out.println("Operador " + token.getTipoOperador(cadenaDel) + ": " + cadenaDel + " Linea " + linea);
	            			 if(token.isSpecialCharacter(cadenaDel)) System.out.println("Caracter especial:  " + cadenaDel + " Linea " + linea);
	     	            	
	            		}else listaDel.add(strLinea.charAt(i));
	            		
	            		String cadena = token.imprimirLista(lista);
	            		//if(!lista.isEmpty()) System.out.println(token.imprimirLista(lista));
	            		if(token.isPalabraReservada(cadena)) System.out.println("Palabra reservada: " + cadena + " Linea " + linea);
	            		if(token.isNumeroEntero(cadena)) System.out.println("Numero entero:  " + cadena + " Linea " + linea);
	            		if(token.isNumeroReal(cadena)) System.out.println("Numero Real:  " + cadena + " Linea " + linea);
	            	
	            		
	            		lista.clear();
	            	} 
	            	else lista.add(strLinea.charAt(i));
	            
	             }//Cerrar for de leer caracteres
	             
	             if(!lista.isEmpty() || !listaDel.isEmpty()) {
	            	 String cadena = token.imprimirLista(lista);
	            	 String cadenaDelim = token.imprimirLista(listaDel);
	            	 if(token.isPalabraReservada(cadena)) System.out.println("Palabra reservada: " + cadena + " Linea " + linea);
	            	 if(token.isOperador(cadenaDelim)) System.out.println("Operador " + token.getTipoOperador(cadenaDelim) + ": " + cadenaDelim + " Linea " + linea);
	            	 if(token.isNumeroEntero(cadena)) System.out.println("Numero entero:  " + cadena + " Linea " + linea);
	            	 if(token.isNumeroReal(cadena)) System.out.println("Numero Real:  " + cadena + " Linea " + linea);
	            	 if(token.isSpecialCharacter(cadenaDelim)) System.out.println("Caracter especial:  " + cadenaDelim + " Linea " + linea);
	            			
	             }
	             lista.clear(); //Limpiamos la lista por el EOLN
	             listaDel.clear();//limpiamos la lista de los delimitadores por el EOLN
	       //
	         }//Cerrar while leer linea
	         DIS.close(); // Cerramos el archivo
	    
		 }catch (Exception e){ //Catch de excepciones
	         System.err.println("Ocurrio un error: " + e.getMessage());
	     }
		 
		//Terminamos de leer el archivo
	}//MAIN
}//CLASS
