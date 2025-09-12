package es.cursojava.cine.poo.modelo;

public class Usuario {
	
	// ATRIBUTOS
    private final String idUsuario; // DNI/ID
    private String nombreUsuario;

    // CONSTRUCTORES
    public Usuario(String idUsuario, String nombreUsuario) {
    	
        if ( ( idUsuario == null ) || ( idUsuario.isBlank() ) ) 
        	throw new IllegalArgumentException("ID de usuario obligatorio");
        
        this.idUsuario = idUsuario.trim();
        this.nombreUsuario = (nombreUsuario == null) ? "" : nombreUsuario.trim();
    }

    // GETTERS & SETTERS
    public String getIdUsuario() {
    	
    	return idUsuario;
    	
    }
    
    public String getNombreUsuario() {
    	
    	return nombreUsuario;
    	
    }
    
    public void setNombreUsuario(String nombreUsuario) {
    	
    	this.nombreUsuario = nombreUsuario;
    	
    }

    public String toString() {
    	
        if ( ( nombreUsuario == null ) || ( nombreUsuario.isBlank() ) ) {
        	
        	return idUsuario;
        	
        }
        
        return nombreUsuario + " (" + idUsuario + ")";
        
    }
    
}