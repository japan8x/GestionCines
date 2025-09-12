package es.cursojava.cine.poo.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cine {
	
	// ATRIBUTOS
    private final String nombreCine;
    private final SalaDeCine[] salas;

    // CONSTRUCTORES
    public Cine(String nombreCine, SalaDeCine[] salas) {
    	
        if (nombreCine == null || nombreCine.isBlank()) {
        	
        	throw new IllegalArgumentException("nombreCine de cine obligatorio");
        
        }
        
        if (salas == null || salas.length == 0) {
        	
        	throw new IllegalArgumentException("Debe haber al menos una sala");
        
        }
        
        this.nombreCine = nombreCine.trim();
        this.salas = salas;
    
    }

    // GETTERS & SETTERS
    public String getNombreCine() { 
    	
    	return nombreCine; 
    
    }
    
    public SalaDeCine[] getSalas() { 
    	
    	return salas; 
    	
    }

    public List<SalaDeCine> salasConDisponibilidad(int n) {
    	
        List<SalaDeCine> res = new ArrayList<>();
        
        for (SalaDeCine s : salas) {
        	
        	if (s.hayEspacio(n)) {
        		
        		res.add(s);
        	
        	}
        
        }
        
        return res;
    
    }

    public String listarEstado() {
    	
        StringBuilder sb = new StringBuilder("=== Estado del Cine: ").append(nombreCine).append(" ===\n");
        System.out.println("===================================================================");
        
        Arrays.stream(salas).forEach(s -> sb.append(s.resumen()).append("\n"));
        
        return sb.toString();
    
    }

}

