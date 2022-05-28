package tp1;
import java.time.*;
import java.util.*;
import java.time.temporal.*;


public class Socio {
	private Scanner teclado = new Scanner(System.in);
	private String nombre;
	private String apellido;
	private int dni;
	private LocalDate fechaNacimiento;
	private String domicilio;
	private String localidad;
	private int telefono;
	private String email; 
	private String grupoSanguineo;
	private boolean enfCronica;
	private boolean medPermanente;
	private String estCategoria;
	private String resp;
		
	public Socio() {
		System.out.print("Nombre: ");
		nombre=teclado.nextLine();
		System.out.print("Apellido: ");
		apellido=teclado.nextLine();
		System.out.print("DNI: ");
		dni=teclado.nextInt();
		int dia, mes, anio;
		System.out.println("Fecha de nacimiento: ");
		System.out.print("D�a: ");
		dia=teclado.nextInt();
		System.out.print("Mes: ");
		mes=teclado.nextInt();
		System.out.print("A�o: ");
		anio=teclado.nextInt();
		fechaNacimiento = LocalDate.of(anio, mes, dia);
		teclado.nextLine();
		System.out.print("Domicilio: ");
		domicilio=teclado.nextLine();
		System.out.print("Localidad: ");
		localidad=teclado.nextLine();
		System.out.print("Tel�fono: ");
		telefono=teclado.nextInt();
		teclado.nextLine();
		System.out.print("Email: ");
		email=teclado.nextLine();
		
		int opcion;
			
		
		System.out.println("Grupo sanguineo: ");
		System.out.println("1. AB-");
		System.out.println("2. A-");
		System.out.println("3. B-");
		System.out.println("4. 0-");
		System.out.print("Opci�n: ");
		opcion=teclado.nextInt();

		switch(opcion) {	
			case 1:
				grupoSanguineo="AB-";
				break;
			case 2:
				grupoSanguineo="A-";
				break;
			case 3:
				grupoSanguineo="B-";
				break;
			case 4:
				grupoSanguineo="0-";
				break;
				
			default:
				System.out.println("La opcion no es valida");
		
		}
		
		
		
		teclado.nextLine();
		
		
		System.out.println("�Tiene una enfermedad cr�nica? (SI - NO)");
		resp=teclado.nextLine();
		if(resp.equals("SI")) {
		enfCronica=true;
		}
		else {
			if(resp.equals("NO")) {
				enfCronica=false;
			}
		}
		System.out.println("�Toma medicaci�n permanente? (SI - NO)");
		resp=teclado.nextLine();
		if(resp.equals("SI")) {
			medPermanente=true;
		}
		else {
			if(resp.equals("NO")) {
				medPermanente=false;
			}
		}
		
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public int getDni() {
		return dni;
	}
	
	public LocalDate getFachaNacimiento() {
		return fechaNacimiento;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public String getLocalidad() {
		return localidad;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}
	
	public String getEnfCronica() {
		
		String enfermedad;
		if(enfCronica) {
			enfermedad= "SI";
		}
		else enfermedad="NO";
		
		return enfermedad;
	}
	
	public String getMedPermanente() {
		
		String medicacion;
		if(medPermanente) {
			medicacion="SI";
		}
		else medicacion="NO";
		
		return medicacion;
	}
	
	public String getEstadoCategoria() {
		return estCategoria;
	}
	
	
	
	public void asigCategoria() {
		
		if(ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now())>17) {
			if(ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now())<57) {
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
			else {
				estCategoria="PASIVO";
			}	
		}
		else {
			estCategoria="PASIVO";
		}	
			
	}
	
	
	
}
