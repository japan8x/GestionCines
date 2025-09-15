package es.cursojava.cine.poo.util;

import java.util.Scanner;

public class Consola {
	
    private final Scanner sc;

    public Consola(Scanner sc) {
    	
        this.sc = sc;
        
    }
    
	public static void pintaMenu (String[] opciones) {
		
		pintaMenu(opciones,"Introduce una opción");
		
	}
	
	public static void pintaMenu (String[] opciones, String texto) {

		for (String opcion : opciones) {
			
			System.out.println(opcion);
			
		}
		
		System.out.println(texto);
		
	}

    public String leerLineaNoVacia(String prompt) {
    	
        while (true) {
        	
            System.out.print(prompt);
            String s = sc.nextLine();
            
            if (s != null && !s.trim().isBlank()) {
            	
            	return s.trim();
            }
            
            System.out.println("Entrada vacía. Intente de nuevo.");
        
        }
        
    }

    public int leerEnteroEnRango(String prompt, int min, int max) {
    	
        while (true) {
        	
            System.out.print(prompt);
            String s = sc.nextLine();
            
            try {
            	
                int v = Integer.parseInt(s.trim());
                
                if (v < min || v > max) {
                	
                    System.out.println("Debe estar entre " + min + " y " + max + ".");
                    
                } else {
                	
                	return v;
                
                }
            
            } catch (NumberFormatException e) {
                
            	System.out.println("Debe ser un número entero.");
            
            }
        
        }
    
    }

    public int leerEnteroMin(String prompt, int min) {
    	
        while (true) {
            
        	System.out.print(prompt);
            
        	String s = sc.nextLine();
            
        	try {
                
        		int v = Integer.parseInt(s.trim());
                
        		if (v < min) {
        			
        			System.out.println("Debe ser ≥ " + min + ".");
        		
        		} else {
        			
        			return v;
        		
        		}
            
        	} catch (NumberFormatException e) {
                
        		System.out.println("Debe ser un número entero.");
            
        	}
        	
        }
        
    }
    
    
    
}

