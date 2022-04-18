package EX7;

import java.util.Hashtable;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ArticuloPrecioApp {

	public static void main(String[] args) {
	
		
	
		Hashtable <String, String> stockProductos = new Hashtable <String, String>();
		stockProductos = crearBaseDatos();
		opcionesConsola(stockProductos);
		
	}
	
	public static Hashtable <String, String> crearBaseDatos() { // Añadimos en el Hashtable los productos con K,V
		Hashtable <String, String> baseDatos = new Hashtable <String, String>();
		baseDatos.put("Manzana", "1.50");
		baseDatos.put("Plátano", "2.00");
		baseDatos.put("Naranja", "1.20");
		baseDatos.put("Mandarina", "1.00");
		baseDatos.put("Melocotón", "1.80");
		baseDatos.put("Kiwi", "2.20");
		baseDatos.put("Sandía", "4.80");
		baseDatos.put("Melón", "4.05");
		baseDatos.put("Fresas", "0.85");
		baseDatos.put("Cerezas", "0.60");
		
		return baseDatos;
		
		
	}
	
	public static Hashtable<String, String> afegir(Hashtable<String, String> dicc){ 
		Scanner sc = new Scanner(System.in);
		System.out.println("Que articulo quieres añadir: ");
		String producto = sc.nextLine();
		System.out.println("Añade el precio: ");
		String precio = sc.nextLine();
		
		dicc.put(producto, precio);
		
		return dicc;
	}
	
	public static void  consultar(Hashtable<String, String> hashtable){ 
		Scanner sc = new Scanner(System.in);
		System.out.println("Que producto quieres consultar: ");
		String consultado = sc.nextLine();
		for (String i: hashtable.keySet()) {
			if (consultado.equals(i)) {
				System.out.println( "Producto - " + i + "/precio - " + hashtable.get(i)); 
				
			}
			
		}
		
	}
	
	public static void listar(Hashtable<String, String> hashtable){ 
		for (String i: hashtable.keySet()) {
				System.out.println( "Producto - " + i + "/precio - " + hashtable.get(i)); 
			}
			
		}
	

	public static Hashtable opcionesConsola(Hashtable stockProductos) {
		Scanner sc = new Scanner(System.in);
		int controlador = 0;
		do {
			System.out.println(" Añadir " + " Consultar " + " Lista " + " Salir ");
			
			String eleccion = "";
			eleccion = sc.nextLine();
		switch (eleccion.toUpperCase()) {
		case "AÑADIR":
			System.out.println("Añadir producto ");
			stockProductos= afegir(stockProductos);
			System.out.println(stockProductos);
			
			break;
		case "CONSULTAR":
			System.out.println("Consultar: ");
			consultar(stockProductos);
			break;
		
		case "LISTA":
			System.out.println("Lista: ");
			listar(stockProductos);
			break;
			
		case "SALIR":
			System.out.println("Ssalir ");
			controlador = 1;
			
			break;

		default:
			System.out.println("default ");
			break;
		}
			
		}while(controlador == 0);
			
		
		
		
		
		
		return stockProductos;	
	}
	

		
		
}
	
