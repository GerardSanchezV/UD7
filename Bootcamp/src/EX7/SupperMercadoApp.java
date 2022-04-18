package EX7;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;



public class SupperMercadoApp {

	public static void main(String[] args) {
		
	
		Hashtable<String, String> diccSupermercado=new Hashtable<String, String>();
		
		diccSupermercado = crearDicc(); 
		
		consola(diccSupermercado);
		
	

	}
	
	
	public static Hashtable<String, String> crearDicc(){
		
		Hashtable<String, String> dicc=new Hashtable<String, String>();
		
		dicc.put("manzana", "2.5");
		dicc.put("pera", "2");
		dicc.put("kiwi", "1.5");
		dicc.put("plátano", "3.1");
		dicc.put("naranja", "7.5");
		dicc.put("sandía", "11");
		
		return dicc;

	}
	
	public static void mostrarDiccKey(Hashtable<String, String> dicc) { 
		System.out.println("Articulos disponibles: ");
		for (String i : dicc.keySet()) {
			System.out.print(i+", ");
		}
	}
	
	public static void consola(Hashtable<String, String> diccSupermercado) {
		Scanner sc = new Scanner(System.in);
		String articulo = "";
		String cantidad = "";
		
		Hashtable<String, String> diccCesta=new Hashtable<String, String>();
		Hashtable<String, String> diccRellenador=new Hashtable<String, String>();
	
		do {
			mostrarDiccKey(diccSupermercado); 
			System.out.println("\n\nIntroduce el articulo que quieres comprar : \n(Introduce 'X' para salir)");
			articulo = sc.nextLine();
			
			if (!articulo.equals("x")) { 
				System.out.println("Introduce la cantidad que deseas comprar de " + articulo + ":");
				cantidad = sc.nextLine();
				diccRellenador =  añadirProductoValor(diccSupermercado, cantidad, articulo);
				for (String i : diccRellenador.keySet()) {
					diccCesta.put(i, diccRellenador.get(i));
				}
			
			}
		
		}while (!articulo.equals("x"));
		System.out.println("-------------");
		
		
		for (String i : diccCesta.keySet()) {
		      System.out.println("Tienes: " + i + " - " + diccCesta.get(i) +  " unidades");
		    }
		System.out.println(diccCesta);
		finalCompra(diccSupermercado, diccCesta);
			
	}
	
	
	public static Hashtable<String, String> añadirProductoValor(Hashtable<String, String> diccSupermercado, String cantidad, String articulo) {
		Scanner sc = new Scanner(System.in);
		
		
		Hashtable<String, String> diccCesta=new Hashtable<String, String>();
	
		for (String i : diccSupermercado.keySet()) {
			if (articulo.equals(i)) {
				diccCesta.put(articulo, cantidad);
				return diccCesta;
			}	
		}
		return diccCesta;
	}
	
	public static Hashtable<String, String> finalCompra(Hashtable<String, String> diccSupermercado, Hashtable<String, String> diccCesta) {
		Scanner sc = new Scanner(System.in);
		
		double total = 0.0;
		double IVA = 21;
		double totalIva = 0.0;
		int totalCompra = 0;
		for(String i : diccCesta.keySet()) {
			for (String x : diccSupermercado.keySet()) {
				if (x.equals(i)) {
					total += Double.parseDouble(diccCesta.get(i)) * Double.parseDouble(diccSupermercado.get(i));
					totalCompra += Double.parseDouble(diccCesta.get(i));
					
				}
				
			}
			
		}
		totalIva = total + (total * IVA / 100);
		System.out.println("El precio sin IVA es : " + total + "€");
		System.out.println("El con  IVA es: " + totalIva + "€");
		System.out.println("Número total de articulos: " + totalCompra + "€");
		System.out.println("Cuanto dinero entrega el cliente? : ");
		double entregado = sc.nextDouble();
		double devolver = entregado - totalIva;
		System.out.println("A devolver al cliente : " + devolver +  "€");
		
		
		
	return diccCesta;
		
		
	}
	
}