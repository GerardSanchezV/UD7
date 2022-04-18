package EX7;

import java.util.Hashtable;
import java.util.Scanner;
public class MediadelaClaseApp {

	public static void main(String[] args) {
		Hashtable<String,Double> listaAlumno=new Hashtable<String,Double>();
	     Scanner sc = new Scanner(System.in);
	        int numAlum, i;
	        double suma = 0, media;
	        int alumnos = 5;

	    
	       while (alumnos> 0) {
	    	   
	    	   
	    	   System.out.println("Nombre de el alumno: ");
	           String alumno = sc.next();
	    		System.out.print("Examenes realizados: ");
	            numAlum = sc.nextInt();	     
	    	 	double[] notas = new double[numAlum];
	    
	         for (i = 0; i < notas.length; i++) {
	            System.out.print("Examen " + (i + 1) + " nota: ");
	            notas[i] = sc.nextDouble();
	            numAlum--;
	        }	    
	        for (i = 0; i < notas.length; i++) {
	            suma = suma + notas[i];
	        }
	   
	        media = suma / notas.length;
	       listaAlumno.put(alumno, media);

	        System.out.printf("Nota media del curso: %.2f %n", media);
	        suma=0;
	        media=0;
	        alumnos--;
	        
	        
	       }System.out.println(listaAlumno.toString());
	       
	       
	         
	       
	}
}
	       