package tp1;

import java.util.*;
import java.time.*;

public class Donacion {
	private LocalDate fechaDonacion;
	private Scanner teclado;
	private boolean dono=false;
	
	public Donacion() {
		fechaDonacion = LocalDate.now();
		dono=false;
	}
	
	
	public LocalDate getFechaDonacion() {
		
		return fechaDonacion;
	}
	
	public String getDono() {
		String estadoDonacion;
		
		if(dono) {
			estadoDonacion="Dono";
		}
		else estadoDonacion="No dono";
		
		return estadoDonacion;
	}
	
	
	
	public void registrarDonacion(int anio, int mes, int dia) {

		
		fechaDonacion=LocalDate.of(anio, mes, dia);
		
		
				
	}
	
	public void actualizarEstadoDonacion() {
		
		dono=true;
		
	}
	
	
}
