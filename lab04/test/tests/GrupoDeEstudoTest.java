package tests;

import static org.junit.Assert.*;
import lab04.Aluno;
import lab04.GrupoDeEstudo;

import org.junit.Before;
import org.junit.Test;

public class GrupoDeEstudoTest {

	private GrupoDeEstudo g1;
	private GrupoDeEstudo g2;
	private GrupoDeEstudo g3;
	private GrupoDeEstudo g4;

	private Aluno a1;
	private Aluno a2;
	private Aluno a3;

	/**
	 * Instanciação de alguns Grupos e Alunos. todos com dados válidos.
	 */
	@Before
	public void criaGruposeAlunos() {
		g1 = new GrupoDeEstudo("Cálculo I");
		g2 = new GrupoDeEstudo("Cálculo I");
		g3 = new GrupoDeEstudo("Mecânica dos Fluídos");
		g4 = new GrupoDeEstudo("analise real");
	}

	@Before
	public void criaAlunos() {
		a1 = new Aluno("117210922", "a1", "Computação");
		a2 = new Aluno("117210923", "a2", "Computação");
		a3 = new Aluno("117210924", "a3", "Computação");

	}

	/**
	 * Criação de um Grupo com nome válido.
	 */
	@Test
	public void testGrupo() {
		GrupoDeEstudo grupo = new GrupoDeEstudo(
				"Algebra Vetorial e Geometria Analítica");
	}

	/**
	 * Adiciona um Aluno com todos os dados válidos a um grupo.
	 */

	@Test
	public void testAdicionaAluno() {
		assertEquals(0, g4.getQtdAlunos());
		g4.adicionaAluno(a1);
		assertEquals(1, g4.getQtdAlunos());
		g4.adicionaAluno(a2);
		assertEquals(2, g4.getQtdAlunos());
		g4.adicionaAluno(a3);
		assertEquals(3, g4.getQtdAlunos());
	}
	/**
	 * Testa a remoção de alunos.
	 */
	@Test
	public void testRemoveAluno() {
		g1.adicionaAluno(a1);
		g1.adicionaAluno(a2);
		g1.adicionaAluno(a3);
		assertEquals(3, g1.getQtdAlunos());
		g1.removeAluno(a1);
		assertEquals(2, g1.getQtdAlunos());
		g1.removeAluno(a2);
		assertEquals(1, g1.getQtdAlunos());
		g1.removeAluno(a3);
		assertEquals(0, g1.getQtdAlunos());

	}

	/**
	 * Criação de grupo com tema nulo.
	 */
	@Test
	public void testCriaGrupoTemaNulo() {
		assertThrows(NullPointerException.class, () -> new GrupoDeEstudo(null));
	}

	/**
	 * Criação de grupo com tema inválido.
	 */
	@Test
	public void testCriaGrupoTemaInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new GrupoDeEstudo(
				"    "));
	}

	/**
	 * Verifica se dois objeto Grupo são iguais.
	 */
	@Test
	public void testEqualsObject() {
		assertEquals(g1, g2);
		assertNotEquals(g1, g3);
	}

	@Test
	public void testToString() {
		testAdicionaAluno();
		assertEquals("Grupo: analise real\n\n" + "Alunos do grupo Listas:\n"
				+ "* 117210922 - a1 - Computação\n"
				+ "* 117210923 - a2 - Computação\n"
				+ "* 117210924 - a3 - Computação\n", g4.toString());
	}

}
