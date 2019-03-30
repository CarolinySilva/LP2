package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab03.Agenda;

public class AgendaTest {

	private Agenda agenda;

	@Before
	public void setUp() {
		agenda = new Agenda();
		agenda.cadastraContato(1, "Carol", "Mylena", "(83)9146-0685");
		agenda.cadastraContato(2, "Carla", "M", "(83)9145-0685");
		agenda.cadastraContato(2, "Ramon", "Garoto", "(83)99148-5879");
		agenda.cadastraContato(100, "Barbara", "Maia", "(83)99129-1702");
	}

	@Test(expected = RuntimeException.class)
	public void testCadastraContatoExcepcion() {
		agenda.cadastraContato(-109, "Carol", "Mylena", "(83)9146-0685");
		fail("Não execute essa linha");
	}
	@Test(expected = RuntimeException.class)
	public void testCadastraContatoExcepcion2() {
		agenda.cadastraContato(0, "Ramon", "Garoto", "(83)99148-5879");
		fail("Não execute essa linha");
	}
	@Test(expected = RuntimeException.class)
	public void testCadastraContatoExcepcion3() {
		agenda.cadastraContato(101, "Carla", "M", "(83)9145-0685");
		fail("Não execute essa linha");
	}
	@Test
	public void testListarContatos() {
		assertEquals("1 - Carol Mylena\n2 - Ramon Garoto\n100 - Barbara Maia", agenda.listarContatos());

	}

	@Test
	public void testExibeContato() {
		assertEquals("Carol Mylena - (83)9146-0685", agenda.exibeContato(1));
		assertEquals("Ramon Garoto - (83)99148-5879", agenda.exibeContato(2));
		assertEquals("Barbara Maia - (83)99129-1702", agenda.exibeContato(100));

	}

	@Test
	public void testListarVazio() {
		Agenda agenda2 = new Agenda();
		assertEquals("", agenda2.listarContatos());
	}
}