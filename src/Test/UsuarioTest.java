package Test;



import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Model.Usuario;

public class UsuarioTest {
	Usuario S = new Usuario("Raul", "Llano", 800);
	
	

	@Test
	public void testUsuario() {
		assertNotNull(new Usuario("Iñaki", "Sanchez", 500));
	}

	@Test
	public void testGetNombre() {
		
		assertEquals("Raul", S.getNombre());
	}

	@Test
	public void testSetNombre() {
		S.setNombre("Javi");
		assertEquals("Javi", S.getNombre());
	}

	@Test
	public void testGetPass() {
		assertEquals("Llano", S.getPass());
	}

	@Test
	public void testSetPass() {
		S.setPass("perez");
		assertEquals("perez", S.getPass());
	}

	@Test
	public void testGetPuntuacionMaxima() {
		assertEquals(800, S.getPuntuacionMaxima());
	}

	@Test
	public void testSetPuntuacionMaxima() {
		S.setPuntuacionMaxima(500);
		assertEquals(500, S.getPuntuacionMaxima());
	}

	@Test
	public void testGetUltimoTablero() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUltimoTablero() {
		fail("Not yet implemented");
	}

}
