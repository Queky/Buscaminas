package Test;



import static org.junit.Assert.*;

import org.junit.Test;

import Model.Usuario;

public class UsuarioTest {
	Usuario S = new Usuario("Raul");

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
