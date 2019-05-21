package paq;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCerradura {

	private cerradura cerradura;
	
	
	@Before
	public void iniciarTest() {
		cerradura = new cerradura();
	}
	
	@After
	public void finalizarTest() {
		cerradura=null;
		
	}
	@Test
	public void combinacionTest() {
		cerradura.CerraduraConCombinacion(123);
		assertEquals(123, cerradura.combinacion);
	}

}
