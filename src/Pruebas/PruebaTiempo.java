package Pruebas;

import java.time.*;

public class PruebaTiempo {
	
	public static void main(String[] args) {
		int actualS = LocalDateTime.now().getSecond();
		int postS = LocalDateTime.now().getSecond() + 1;
		
		int seg = 0;
		int min = 0;
		
		String tiempo = "";
		
		boolean actualizar = false;
		
		while(true){
			if(actualS==postS)
				actualizar = true;
				
			if(actualizar){
				if(seg == 59){
					min ++;
					seg = -1;
				}
				
				if(min < 10)
					tiempo += "0" + min + ":";
				else
					tiempo += min + ":";
				
				seg++;
				if(seg < 10){
					tiempo += "0" + seg;
				}
				else
					tiempo += seg;
				if(LocalDateTime.now().getSecond() < 59)
					postS = LocalDateTime.now().getSecond() + 1;
				else
					postS = 1;
				actualizar = true;
				
				if(actualizar){
					System.out.println(tiempo);
					actualizar = false;
					tiempo = "";
				}
			}
			actualS = LocalDateTime.now().getSecond();
		}
	}

}
