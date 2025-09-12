package es.cursojava.cine.poo.modelo;

public class Pelicula {
	
	// ATRIBUTOS
    private final String idPelicula;
    private String titulo;
    private int duracionMinutos;
    private String clasificacionEdad; 
    private double precio;            

    // CONSTRUCTORES
    public Pelicula(String idPelicula, String titulo, int duracionMinutos) {
    	
        this(idPelicula, titulo, duracionMinutos, null, null);
        
    }

    public Pelicula(String idPelicula, String titulo, int duracionMinutos, String clasificacionEdad, Double precio) {
    	
//        if (id == null || id.isBlank()) throw new IllegalArgumentException("ID de película obligatorio");
//        if (titulo == null || titulo.isBlank()) throw new IllegalArgumentException("Título obligatorio");
//        if (duracionMinutos <= 0) throw new IllegalArgumentException("Duración inválida");
    	
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
        this.clasificacionEdad = clasificacionEdad;
        this.precio = precio;
        
    }

    // GETTERS & SETTERS
    public String getIdPelicula() {
    	
    	return idPelicula; 
    	
    }
    
    public String getTitulo() {
    	
    	return titulo; 
    	
    }
    
    public int getDuracionMinutos() { 
    	
    	return duracionMinutos; 
    	
    }
    
    public String getClasificacionEdad() { 
    
    	return clasificacionEdad; 
    	
    }
    
    public double getPrecio() { 
    	
    	return precio; 
    	
    }

    public void setTitulo(String titulo) { 
    	
    	this.titulo = titulo; 
    	
    }
    
    public void setDuracionMinutos(int duracionMinutos) { 
    	
    	this.duracionMinutos = duracionMinutos; 
    	
    }
    
    public void setClasificacionEdad(String clasificacionEdad) { 
    
    	this.clasificacionEdad = clasificacionEdad; 
    	
    }
    
    public void setPrecio(double precio) { 
    	
    	this.precio = precio; 
    	
    }

    public String toString() {
    	
        String base = "%s (%d min)".formatted(titulo, duracionMinutos);
        
        if (clasificacionEdad != null && !clasificacionEdad.isBlank()) { 
        	
        	base += " | " + clasificacionEdad;
        
        }
        
        if (precio != 0) { 
        	
        	base += " | Precio: %.2f€".formatted(precio);
        
        }
        
        return base + " [ID " + idPelicula + "]";
        
    }
    
}
