package Pruebas;

import java.time.*;

public class PruebaTiempo {
	
	public static void main(String[] args) {
		int initM = LocalDateTime.now().getMinute();
		int initS = LocalDateTime.now().getSecond();
		while(true){
			System.out.println((LocalDateTime.now().getMinute()-initM)+":"+(LocalDateTime.now().getSecond()));				
		}
	}

}
