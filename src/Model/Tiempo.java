package Model;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class Tiempo extends Observable{
	
	private static Tiempo t = new Tiempo();
	private int tiempoTotalSeg;
	int seg;
	int min;
	private String tiempo = "";
	private boolean reiniciar;
	private boolean iniciar = false;
	
		
	private Tiempo() {
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				tiempo();
			}
		}, 999, 999);
	}
	
	public static Tiempo getTiempo(){
		return t;
	}
	
	private void tiempo() {
		if(iniciar){
			tiempo = "";
			if(tiempoTotalSeg == 0 || reiniciar == true){
				seg = 0;
				min = 0;
				tiempoTotalSeg = 0;
				reiniciar = false;
			}
			
			if(seg == 60){
				seg = 0;
				min++;
			}
			tiempo = String.format("%1$02d:%2$02d", min, seg);
			// Mark value as changed
			setChanged();
			// Notify observer class
			notifyObservers(tiempo);
			//System.out.println(String.format("%1$02d:%2$02d", min, seg));
			seg++;
			tiempoTotalSeg++;
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
	
	public String getElapsedTime(){
		return tiempo;
	}
	
	public void iniciarTiempo(){
		iniciar = true;
	}
}