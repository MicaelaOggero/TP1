import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.temporal.*;

public class Socio {
	private Scanner teclado;
	private String nombreyApellido;
	private int dni;
	private LocalDate fechaNacimiento;
	private String domicilio;
	private String localidad;
	private int telefono;
	private String email; 
	private String grupoSanguineo;
	private String factor;
	private boolean enfCronica;
	private boolean medPermanente;
	private String estCategoria;
	private String resp;
	public static List<Socio> list_socios =new ArrayList<>();
	
		
	
	public void nuevoSocio() {
		
		teclado =new Scanner (System.in);
		System.out.print("Ingrese nombre y apellido: ");
		nombreyApellido=teclado.nextLine();
		System.out.print("Ingrese DNI: ");
		dni=teclado.nextInt();
		int i, j, k;
		System.out.println("Ingrese fecha de nacimiento: ");
		System.out.print("Día: ");
		k=teclado.nextInt();
		System.out.print("Mes: ");
		j=teclado.nextInt();
		System.out.print("Año: ");
		i=teclado.nextInt();
		fechaNacimiento = LocalDate.of(i, j, k);
		teclado.nextLine();
		System.out.print("Domicilio: ");
		domicilio=teclado.nextLine();
		System.out.print("Localidad: ");
		localidad=teclado.nextLine();
		System.out.print("Teléfono: ");
		telefono=teclado.nextInt();
		teclado.nextLine();
		System.out.print("Email: ");
		email=teclado.nextLine();
		System.out.print("Grupo Sanguineo: ");
		grupoSanguineo=teclado.nextLine();
		System.out.print("Factor: ");
		factor=teclado.nextLine();
		System.out.println("¿Tiene una enfermedad crónica? (SI - NO)");
		resp=teclado.nextLine();
		if(resp.equals("SI")) {
			enfCronica=true;
		}
		else {
			enfCronica=false;
		}
		System.out.println("¿Toma medicación permanente? (SI - NO)");
		resp=teclado.nextLine();
		if(resp.equals("SI")) {
			medPermanente=true;
		}
		else {
			medPermanente=false;
		}
		
		
	}
	
	
	public void asigCategoria() {
		
		if(ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now())>19) {
			
			if(ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now())<57) {
				
				if(factor.equals("RH Negativo")) {
					
					if(medPermanente==false) {
						
						if(enfCronica==false) {
							
							estCategoria= "ACTIVO";
						}
							else {
								estCategoria="PASIVO";
							}
					}
					else {
						estCategoria="PASIVO";
					}
				}
			}
			else {
				estCategoria="PASIVO";
			}
		}
		else {
			estCategoria="PASIVO";
		}	
			
	}
	
	public static void main (String[] ar) {
		
		
		Socio socio1=new Socio();
		socio1.nuevoSocio();
		socio1.asigCategoria();
		list_socios.add(socio1);
		
		
		Socio socio2=new Socio();
		socio2.nuevoSocio();
		socio2.asigCategoria();
		list_socios.add(socio2);
		
		System.out.println("Datos: ");
		for(int i=0;i<=1;i++) {
			System.out.println("Nombre: "+list_socios.get(i).nombreyApellido+"	Categoria: "+
					list_socios.get(i).estCategoria);
			System.out.println();
			
		}
		
		
	}
}