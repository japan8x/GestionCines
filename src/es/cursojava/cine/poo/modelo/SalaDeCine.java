package es.cursojava.cine.poo.modelo;

import java.util.Arrays;

public class SalaDeCine {
	
	// ATRIBUTOS
    private final String codigoSala;
    private final int capacidad;
    private final int numeroFilas;
    private final int numeroColumnas;
    private final int columnaPasillo;
    private Pelicula pelicula;
    private final Usuario[] butacas; // null = libre

    // CONSTRUCTORES
    // public SalaDeCine(String codigoSala, int capacidad, Pelicula pelicula) {
    public SalaDeCine(String codigoSala, int capacidad, Pelicula pelicula) {
    		 
        if (codigoSala == null || codigoSala.isBlank()) {
        	
        	throw new IllegalArgumentException("Código de sala obligatorio");
        
        }
        
        if (capacidad <= 0) {
        	
        	throw new IllegalArgumentException("Capacidad inválida");
        
        }
        
        if (pelicula == null) {
        	
        	throw new IllegalArgumentException("La sala debe proyectar una película");
        
        }
        
        this.codigoSala = codigoSala.trim();
        this.capacidad = capacidad; //numeroFilas * numeroColumnas;
        this.numeroFilas = 3;
        this.numeroColumnas = 4;
        this.columnaPasillo = 5; // (int) (numeroFilas / 2);
        this.pelicula = pelicula;
        this.butacas = new Usuario[capacidad];
        
    }

    // GETTERS & SETTERS
    public String getCodigoSala() { 
    	
    	return codigoSala; 
    	
    }
    
    public int getCapacidad() { 
    	
    	return capacidad; 
    	
    }
    
    public Pelicula getPelicula() { 
    	
    	return pelicula; 
    	
    }
    
    public void setPelicula(Pelicula pelicula) {
    	
        if (pelicula == null) { 
        	
        	throw new IllegalArgumentException("Película no puede ser nula");
        
        }
        
        Arrays.fill(butacas, null); // si cambia, reseteamos ocupación
        
        this.pelicula = pelicula;
    
    }

    // MÉTODOS NO ESTÁTICOS
    public int asientosLibres() {
    
    	int libres = 0;
        
    	for (Usuario u : butacas) { 
    		
    		if (u == null) {
    			
    			libres++;
    		
    		}
    		
    	}
        
    	return libres;
    
    }

    public boolean hayEspacio(int n) {
    	
        
    	return n > 0 && asientosLibres() >= n;
    
    }

    /** Asigna las primeras butacas libres al usuario y devuelve los índices asignados (o array vacío si no procede). */
    public int[] asignarButacas(Usuario u, int n) {
    
    	if (u == null || n <= 0 || !hayEspacio(n)) {
    		
    		return new int[0];
    	
    	}
        
    	int[] asignadas = new int[n];
        
    	int j = 0;
        
    	for (int i = 0; i < butacas.length && j < n; i++) {
    		
            if (butacas[i] == null) {
        
            	butacas[i] = u;
                asignadas[j++] = i;
            
            }
        
    	}
    	
        return asignadas;
    
    }

    /** Devuelve un string corto con título de la película y disponibilidad. */
    public String resumen() {
    
    	int libres = asientosLibres();
        
    	return " | Sala:      " + codigoSala + 
    		   " | Titulo:    " + pelicula.getTitulo() +
               " | Capacidad: " + capacidad + 
               " | Libres:    " + libres + 
               " | Ocupados:  " + (capacidad - libres) +
               " |            ";
    
    }

    /** Imprime mapa de ocupación con índices. */
    public String mapaOcupacion() {
    	
        StringBuilder sb = new StringBuilder("Sala ").append(codigoSala)
                .append(" - ").append(pelicula.getTitulo()).append("\n");
        
        for (int i = 0; i < butacas.length; i++) {
        	
            Usuario u = butacas[i];
            sb.append("[").append(i).append("] ");
            
            if (u == null) { 
            	
            	sb.append("Libre");
            
            } else {
            	
            	sb.append("Ocupado por ").append(u.toString());
            
            }
            
            if (i < butacas.length - 1) { 
            	
            	sb.append("\n");
            
            }
        
        }
        
        return sb.toString();
    
    }
    
    /** Imprime mapa de ocupación con índices. */
    public String mapaOcupacionSala() {
    	
        StringBuilder sb = new StringBuilder("Sala ").append(codigoSala)
                .append(" - ").append(pelicula.getTitulo()).append("\n");
        
       	sb.append("\n                           Columnas\n              ");
       	
       	for(int k = 1; k <= numeroColumnas; k++) {
       		
       		sb.append(" [ ").append(k).append(" ]");
       		
       	}
       	
       	sb.append("\n");
        
        for (int i = 0; i < numeroFilas; i++) {
        	
        	sb.append("Fila nº:").append(i).append(" -->  ");
        	
        	for (int j = 0; j < numeroColumnas; j++) {
        		
        		Usuario u = butacas[(i+j)];
                sb.append("[ ");
                
                if (u == null) { 
                	
                	sb.append("O");
                
                } else {
                	
                	sb.append("X");
                
                }
                
                sb.append(" ] ");
                
//                if (j < numeroColumnas) { 
//                	
//                	sb.append("\n");
//                
//                }
        		
        	}
        	
           	sb.append("\n");
        
        }
        
        return sb.toString();
    
    }

}

