package Pruebas;

import java.time.*;
import java.util.Timer;
import java.util.TimerTask;

public class PruebaTiempo {
	
	private int tiempoTotalSeg;
	private String tiempo = "";
	private boolean reiniciar;
	
	public PruebaTiempo() {
		
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				
				int actualS = LocalDateTime.now().getSecond();
				int postS = LocalDateTime.now().getSecond() + 1;
				
				int seg = 0;
				int min = 0;
				tiempoTotalSeg = 0;
				
				boolean actualizar = false;
				
				//while(true){
					if(actualS==postS)
						actualizar = true;
					
					if(reiniciar){
						seg = 0;
						min = 0;
						tiempoTotalSeg = 0;
						tiempo = "";
						reiniciar = false;
					}
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
						tiempoTotalSeg++;
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
				//}
				
			}
		}, 999, 999);
		
		tiempo();
	}
	
	private void tiempo() {
		int actualS = LocalDateTime.now().getSecond();
		int postS = LocalDateTime.now().getSecond() + 1;
		
		int seg = 0;
		int min = 0;
		tiempoTotalSeg = 0;
		
		boolean actualizar = false;
		
		while(true){
			if(actualS==postS)
				actualizar = true;
			
			if(reiniciar){
				seg = 0;
				min = 0;
				tiempoTotalSeg = 0;
				tiempo = "";
				reiniciar = false;
			}
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
				tiempoTotalSeg++;
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
	/*
	 * Reiniciar el contador de tiempo
	 */
	public void reiniciar(){
		reiniciar = true;
	}
	
	/*
	 * Devuelve el tiempo en segundos
	 */
	public int getTiempoSeg(){
		return tiempoTotalSeg; 
	}
	
	public String getTiempoString(){
		return tiempo;
	}
	
	public static void main(String[] args) {
		PruebaTiempo r = new PruebaTiempo();
	}

}
