package Model;

<<<<<<< HEAD
import java.time.Duration;
import java.time.LocalDateTime;
=======
>>>>>>> markel
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
<<<<<<< HEAD
	private LocalDateTime start;
=======
	private boolean iniciar = false;
>>>>>>> markel
	
		
	private Tiempo() {
		Timer timer = new Timer();
		start = LocalDateTime.now();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
<<<<<<< HEAD
				// TODO Auto-generated method stub
				
				LocalDateTime actual = LocalDateTime.now();
				Duration segundos = Duration.between(start, actual);
				/*
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
				//}*/
				
=======
				tiempo();
>>>>>>> markel
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