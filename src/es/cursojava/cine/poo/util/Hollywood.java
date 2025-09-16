package es.cursojava.cine.poo.util;

import java.util.List;
import java.util.Scanner;

import es.cursojava.cine.poo.modelo.Cine;
import es.cursojava.cine.poo.modelo.Pelicula;
import es.cursojava.cine.poo.modelo.SalaDeCine;
import es.cursojava.cine.poo.modelo.Usuario;

public class Hollywood {
	
	final static int numeroUsuarios = 3;
	
	public static void abrirCine() {
		
	       // --- Datos de ejemplo ---
		
		    // --- Catálogo de películas (ACTUALIZADO) ---
	        // Puedes cambiar fácilmente estos datos; las salas se crean con estas películas.
	        Pelicula p1 = new Pelicula("PX-101", "El Viaje del Fénix", 134, "13+", 7.90);
	        Pelicula p2 = new Pelicula("PX-202", "Horizonte Perdido", 118, "TP", 6.50);
	        Pelicula p3 = new Pelicula("PX-303", "Nébula 9", 102, "12+", 7.20);
	        Pelicula p4 = new Pelicula("PX-404", "El Último Acorde", 95, "TP", 6.00);
	        Pelicula p5 = new Pelicula("PX-505", "Sombras de Titanio", 110, "16+", 8.20);      
	        Pelicula p6 = new Pelicula("P-001", "La Odisea Galáctica", 128, "12+", 7.50);
	        Pelicula p7 = new Pelicula("P-002", "Sombras en la Nieve", 101, "16+", 6.90);
	        Pelicula p8 = new Pelicula("P-003", "Ritmo Urbano", 95, "TP", 6.00);
	        Pelicula p9 = new Pelicula("P-004", "Código Rojo", 112, "13+", 7.20);
	        
	        // --- Salas del cine (array, como pide el enunciado) ---
	        // --- Se proyecta una película por sala; la capacidad fija cada butaca como un índice 0..cap-1. ---
	        SalaDeCine s1 = new SalaDeCine("A1", 12, p1);
	        SalaDeCine s2 = new SalaDeCine("B1", 10, p2);
	        SalaDeCine s3 = new SalaDeCine("C1", 8,  p3);
	        SalaDeCine s4 = new SalaDeCine("D1", 14, p4);
	        SalaDeCine s5 = new SalaDeCine("E1", 16, p5);
	        SalaDeCine s6 = new SalaDeCine("A2", 12, p6);
	        SalaDeCine s7 = new SalaDeCine("B2", 10, p7);
	        SalaDeCine s8 = new SalaDeCine("C2", 8,  p8);
	        SalaDeCine s9 = new SalaDeCine("D2", 15, p5);
	        
	        Cine cine = new Cine("Cine Central Park", new SalaDeCine[]{s1, s2, s3, s4, s5});
	        //Cine cine2 = new Cine("Cine Parque Sur", new SalaDeCine[]{s6, s7, s8, s9});
	        
	        System.out.println("=========================================");
	        System.out.println("====== GESTIÓN DE CINES MULTISALAS ======");
	        System.out.println("=========================================\n");
	        
	        // --- Usuarios (3 turnos) ---
	        Scanner sc = new Scanner(System.in);
	        Consola io = new Consola(sc);
	        Usuario compradores[] = new Usuario[numeroUsuarios];
	        
	        System.out.println("=========================================");
	        System.out.println("===== Registro rápido de 3 usuarios =====");
	        System.out.println("=========================================\n");
	        
	        for (int i = 0; i < compradores.length; i++) {
	        	
	            String nombre = io.leerLineaNoVacia("Nombre del Usuario " + (i + 1) + ": ");
	            String id = io.leerLineaNoVacia("ID/DNI del Usuario " + (i + 1) + ": ");
	            compradores[i] = new Usuario(id, nombre);
	            System.out.println();
	            
	        }
	        
	        System.out.println("¡Registro completado! Comienza la compra secuencial.\n");

	        // --- Turnos secuenciales ---
	        String menu = """
			                1) Listar películas y disponibilidad
			                2) Comprar entradas
			                3) Mostrar ocupación por sala
			                4) Salir (pasar al siguiente usuario)
			              """;
	        
	        for (int turno = 0; turno < compradores.length; turno++) {
	        	
	            Usuario activo = compradores[turno];
	            
	            System.out.println("=========================================");
	            System.out.println(" Turno de " + activo + " (Usuario " + (turno + 1) + "/" + numeroUsuarios + ")");
	            System.out.println("=========================================\n");

	            boolean seguir = true;
	            
	            while (seguir) {
	            	           	
	                Consola.pintaMenu(menu.split("\n"), "");
	                
	                int op = io.leerEnteroEnRango("> Elige una opción: ", 1, 4);
	                
	                switch (op) {
	                
	                    case 1 -> listarPeliculas(cine);
	                    case 2 -> comprarEntradas(cine, activo, io);
	                    case 3 -> mostrarOcupacionPorSala(cine, io);
	                    case 4 -> {
	                    	
	                        seguir = false;
	                        System.out.println("Fin del turno de " + activo + ".\n");
	                        
	                    }
	                    
	                    default -> System.out.println("Opción no válida.");
	                    
	                }
	                
	            }
	            
	        }
	        
	        System.out.println("===== Fin de la simulación. ¡Gracias! =====");
	        
	 }

	 private static void listarPeliculas(Cine cine) {
	 	
	     System.out.println(cine.listarEstado());
	     
	 }
	
	 private static void comprarEntradas(Cine cine, Usuario activo, Consola io) {
	 	
	     int n = io.leerEnteroMin("¿Cuántas entradas desea (n ≥ 1)? ", 1);
	
	     List<SalaDeCine> opciones = cine.salasConDisponibilidad(n);
	     
	     if (opciones.isEmpty()) {
	     	
	         System.out.println("⚠ No hay salas con suficientes asientos libres para " + n + " entradas.");
	         return;
	         
	     }
	
	     System.out.println("\nOpciones disponibles (suficiente espacio):");
	     
	     for (int i = 0; i < opciones.size(); i++) {
	     	
	         SalaDeCine s = opciones.get(i);
	         System.out.printf("%d) %s | %s | Libres: %d%n",
	                 i + 1, s.getCodigoSala(), s.getPelicula().getTitulo(), s.asientosLibres());
	         
	     }
	
	     int sel = io.leerEnteroEnRango("Seleccione opción (1-" + opciones.size() + "): ", 1, opciones.size());
	     SalaDeCine salaElegida = opciones.get(sel - 1);
	
	     int[] butacas = salaElegida.asignarButacas(activo, n);
	     
	     if (butacas.length == 0) {
	     	
	         // condición de carrera improbable porque ya filtramos, pero validamos
	         System.out.println("⚠ No se pudo completar la asignación. Inténtelo de nuevo.");
	         
	         return;
	         
	     }
	
	     System.out.println("\n✅ Compra realizada con éxito:");
	     System.out.println("Usuario: " + activo);
	     System.out.println("Película: " + salaElegida.getPelicula());
	     System.out.println("Sala: " + salaElegida.getCodigoSala());
	     System.out.print("Butacas asignadas (" + butacas.length + "): ");
	     
	     for (int i = 0; i < butacas.length; i++) {
	     	
	         System.out.print("#" + butacas[i]);
	         
	         if (i < butacas.length - 1) { 
	         	
	         	System.out.print(", ");
	         
	         }
	     
	     }
	     
	     System.out.println();
	 
	 }
	
	 private static void mostrarOcupacionPorSala(Cine cine, Consola io) {
	     
	 	SalaDeCine[] salas = cine.getSalas();
	     System.out.println("Salas disponibles:");
	     
	     for (int i = 0; i < salas.length; i++) {
	     	
	         System.out.printf("%d) %s - %s%n", i + 1, salas[i].getCodigoSala(), salas[i].getPelicula().getTitulo());
	     
	     }
	
	     int sel = io.leerEnteroEnRango("Seleccione sala (1-" + salas.length + "): ", 1, salas.length);
	     
	     SalaDeCine s = salas[sel - 1];
	     //System.out.println("\n" + s.mapaOcupacionSala() + "\n");
	     System.out.println("\n" + s.mapaOcupacion() + "\n");
	     
	}

}
