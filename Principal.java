package tp1;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		ArrayList<Socio> list_socios = new ArrayList<Socio>();
		ArrayList<Donacion> list_donacion = new ArrayList<Donacion>();
		ArrayList<Socio> list_donadores = new ArrayList<Socio>();

		
		int opcion;
		
		boolean salir = false;
		//mientras que yo no le diga salir que siga funcionando
		while(!salir) {
		
		System.out.println("-----Men�-----");
		System.out.println("1. Registrarse");
		System.out.println("2. Registar donacion");
		System.out.println("3. Mostrar datos");
		System.out.println("4. Pedido donadores");
		System.out.println("5. Salir");
		System.out.print("Opci�n: ");
		opcion=teclado.nextInt();
		
			switch(opcion){
				case 1:
					teclado.nextLine();
					String factor;
					System.out.print("Factor: ");
					factor=teclado.nextLine();
					if(factor.equals("RH Negativo")) {
						Socio socio=new Socio();
						Donacion donacion = new Donacion();
						socio.asigCategoria();
						list_socios.add(socio);
						list_donacion.add(donacion);
					}
					
					else System.out.println("Usted no puede registrarse");
					break;
			
				case 2: 
					int id, ban=0, bandera=0;
					System.out.print("DNI: ");
					
					id=teclado.nextInt();
					
					
					for(int l=0;l<=list_socios.size()-1;l++) {
						if(id==list_socios.get(l).getDni()) {
							
							if(list_socios.get(l).getEstadoCategoria()=="ACTIVO") {
							
								System.out.println("Fecha Donacion: ");
								System.out.print("D�a: ");
								int k=teclado.nextInt();
								System.out.print("Mes: ");
								int j=teclado.nextInt();
								System.out.print("A�o: ");
								int i=teclado.nextInt();
								list_donacion.get(l).registrarDonacion(i, j, k);
								list_donacion.get(l).actualizarEstadoDonacion();
								bandera=1;
								
							}
							
							else ban=1;
							
						}
						
						else ban=2;

					}
					
					if(ban==1) System.out.println("Error: El DNI corresponde a una persona con categor�a PASIVO");
					if(ban==2&&bandera==1) System.out.println("Error: El DNI no corresponde al de una persona asociada");
					
					break;
			
				case 3:
					
					
					for(int j=0;j<=list_socios.size()-1;j++) {
						System.out.println("----Datos personales:---- ");
						System.out.println("Nombre: "+list_socios.get(j).getNombre());
						System.out.println("Apellido: "+list_socios.get(j).getApellido());
						System.out.println("DNI: "+list_socios.get(j).getDni());
						System.out.println("Fecha nacimiento: "+list_socios.get(j).getFachaNacimiento());
						System.out.println("Domicilio: "+list_socios.get(j).getDomicilio());
						System.out.println("Localidad: "+list_socios.get(j).getLocalidad());
						System.out.println("Tel�fono: "+list_socios.get(j).getTelefono());
						System.out.println("Email: "+list_socios.get(j).getEmail());
						System.out.println("----Datos medicos:---- ");
						System.out.println("Grupo sanguineo: "+list_socios.get(j).getGrupoSanguineo());
						System.out.println("Factor: RH Negativo");
						System.out.println("Enfermedad cronica: "+list_socios.get(j).getEnfCronica());
						System.out.println("Medicacion permanente: "+list_socios.get(j).getMedPermanente());
						System.out.println(" Categoria: "+list_socios.get(j).getEstadoCategoria());
						System.out.println(" Estado Donacion: "+list_donacion.get(j).getDono());
						System.out.print("Fecha Donacion: ");
						if(list_donacion.get(j).getDono()=="Dono") {
							System.out.println(list_donacion.get(j).getFechaDonacion());
						}
						
						else System.out.println("No realizo ninguna donacion");
						
					}
					
					
					break;
				
				case 4:
					
					
					String grupo;
					
					
					
					teclado.nextLine();
					
					System.out.print("Grupo sanguineo: ");
					grupo=teclado.nextLine();
					
					
					int i;
						System.out.print("Cantidad de donadores: ");
						i=teclado.nextInt();
					int j=0;
					while(i!=0) {	
						
							if(list_socios.get(j).getGrupoSanguineo().equals(grupo)) {
								if(list_socios.get(j).getEstadoCategoria().equals("ACTIVO") || 
										list_donacion.get(j).getDono().equals("No dono")) {
									list_donadores.add(list_socios.get(j));
									i--;
									
								}
							}
							
							j++;
					}
					
					
					System.out.println("----Donadores----");
					for(int l=0;l<list_donadores.size();l++) {
						System.out.println("Nombre: "+list_donadores.get(l).getNombre()+" DNI: "
								+list_donadores.get(l).getDni());
					}
					
					
					break;
					
				case 5:
					salir=true;
					break;
			
				default:
					System.out.println("La opcion no es valida");
			}
		
		
		}
		

	}

}
