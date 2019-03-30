package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.channels.IllegalSelectorException;

import org.junit.*;
import org.junit.Test;

import lab03.Contato;

public class ContatoTest {

	private Contato contato;

	@Before
	public void setUp() {
		contato = new Contato("nome", "sobrenome", "numero");
	}

	@Test
	public void testToString() {
		assertEquals("nome sobrenome - numero", contato.toString());
	}

	@Test
	public void testContatoNomeNull() {
		assertThrows(IllegalArgumentException.class,  () -> new Contato(null, "sobrenome", "numero"));
	}

	@Test
	public void testContatoSobrenomeNull() {
		assertThrows(IllegalArgumentException.class, () -> new Contato("nome", null, "numero"));
	}

	@Test
	public void testContatoNumeroNull() {
		assertThrows(IllegalArgumentException.class, () -> new Contato("nome", "sobrenome", null));
	}

	@Test
	public void testContatoNomeVazio() {
		assertThrows(IllegalArgumentException.class, () -> new Contato("", "sobrenome", "numero"));
	}

	@Test
	public void testContatoSobrenomeVazio() {
		assertThrows(IllegalArgumentException.class, () -> new Contato("nome", "", "numero"));

	}

	@Test
	
	public void testContatoNumeroVazio() {
		assertThrows(IllegalArgumentException.class, () -> new Contato("nome", "sobrenome", ""));
	}

	@Test
	public void testContatoNomeException() {
		assertThrows(IllegalArgumentException.class, () -> new Contato("       ", "sobrenome", "numero"));
	}

	@Test
	public void testContatoSobrenomeException() {
		assertThrows(IllegalArgumentException.class, () -> new Contato("nome", "       ", "numero"));
	}

	@Test
	public void testContatoNumeroException() {
		assertThrows(IllegalArgumentException.class, () -> new Contato("nome", "sobrenome", "     "));
	}

	@Test
	public void testContatoExceptionTodos() {
		assertThrows(IllegalArgumentException.class, () -> new Contato("    ", "     ", "    "));

	}

	@Test
	public void testContatoExcepcionTodosNUll() {
		assertThrows(IllegalArgumentException.class, () -> new Contato(null, null, null));

	}

	@Test
	public void testContatoExcepcionTodosVazio() {
		assertThrows(IllegalArgumentException.class, () -> new Contato("", "", ""));
	}

}