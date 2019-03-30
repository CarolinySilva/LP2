package tests;

import static org.junit.Assert.*;
import lab04.Sistema;

import org.junit.Before;
import org.junit.Test;

public class SistemaTest {

	/**
	 * Sistema.
	 */
	private Sistema sistema;

	@Before
	public void criaSistema() {
		sistema = new Sistema();
	}

	/**
	 * Cadastra alunos no sistema.
	 */
	public void cadastraAlunos() {
		sistema.cadastraAluno("Carol", "00000000", "CC");
		sistema.cadastraAluno("Felipe", "11111111", "CC");
	}

	/**
	 * Cadastra grupos de estudos.
	 */
	public void cadastraGrupos() {
		sistema.cadastraGrupoEstudo("icc");
		sistema.cadastraGrupoEstudo("p2");
	}

	/**
	 * Testa o método CadastraAluno
	 */
	@Test
	public void testCadastraAluno() {
		assertEquals(true, sistema.cadastraAluno("Carol", "00000000", "CC"));
		assertEquals(false, sistema.cadastraAluno("Carol", "00000000", "CC"));
	}

	/**
	 * Testa o método consultaAluno,
	 */
	@Test
	public void testConsultaAlunoComAlunoCadastrado() {
		cadastraAlunos();
		assertEquals("Aluno: 00000000 - Carol - CC",
				sistema.consultaAluno("00000000"));
		assertEquals("Aluno: 11111111 - Felipe - CC",
				sistema.consultaAluno("11111111"));
	}

	/**
	 * Testa o método consultaAluno com matriculas que não estão cadastrados,
	 */
	@Test
	public void testConsultaAlunoComAlunoNaoCadastrado() {
		cadastraAlunos();
		assertEquals("Aluno não cadastrado.", sistema.consultaAluno(""));
		assertEquals("Aluno não cadastrado.",
				sistema.consultaAluno("matriculaInvalida"));
	}

	/**
	 * Testa o método cadastraGrupoEstudo.
	 */
	@Test
	public void testCadastraGrupoEstudo() {
		assertTrue(sistema.cadastraGrupoEstudo("Calculo"));
		assertTrue(sistema.cadastraGrupoEstudo("Linear"));

	}

	/**
	 * Testa o método cadastraGrupoEstudo com temas já cadastrados.
	 */
	@Test
	public void testCadastraGrupoEstudoComTemaIndisponivel() {
		testCadastraGrupoEstudo();
		assertFalse(sistema.cadastraGrupoEstudo("Calculo"));
		assertFalse(sistema.cadastraGrupoEstudo("calculo"));
		assertFalse(sistema.cadastraGrupoEstudo("Linear"));
		assertFalse(sistema.cadastraGrupoEstudo("linear"));

	}

	/**
	 * Testa o método cadastraGrupoEstudo com um tema nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraGrupoEstudoTemaNulo() {
		sistema.cadastraGrupoEstudo(null);
	}

	/**
	 * Testa o método cadastraGrupoEstudo com um tema inválido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraGrupoEstudoTemaInvalido() {
		sistema.cadastraGrupoEstudo("");
	}

	/**
	 * Testando o método alocaAluno com matriculas de alunos e temas existentes.
	 */
	@Test
	public void testAlocaAlunoComAlunoExistente() {
		cadastraAlunos();
		cadastraGrupos();
		assertEquals("ALUNO ALOCADO!", sistema.alocaAluno("00000000", "p2"));
		assertEquals("ALUNO ALOCADO!", sistema.alocaAluno("11111111", "p2"));
	}

	/**
	 * Testando o método alocaAluno com matricula de um aluno não cadastrado.
	 */
	@Test
	public void testAlocaAlunoComAlunoNaoCadastrado() {
		cadastraAlunos();
		cadastraGrupos();
		assertEquals("Aluno não cadastrado.",
				sistema.alocaAluno("12345678", "P2"));
	}

	/**
	 * Testando o método alocaAluno com um grupo não cadastrado.
	 */
	@Test
	public void testAlocaAlunoComGrupoNaoCadastrado() {
		cadastraAlunos();
		cadastraGrupos();
		assertEquals("Grupo não cadastrado.",
				sistema.alocaAluno("00000000", "Informatica e Sociedade"));
	}

	/**
	 * Testa o método imprimeGrupo.
	 */
	@Test
	public void testImprimeGrupo() {
		testAlocaAlunoComAlunoExistente();
		assertEquals(
				"Grupo: p2\n\nAlunos do grupo Listas:\n* 00000000 - Carol - CC\n",
				sistema.imprimeGrupo("p2"));
	}

	/**
	 * Testa o método cadastraAlunoQueRespondeu
	 */
	@Test
	public void testCadastraAlunoQueRespondeuComAlunoExistente() {
		cadastraAlunos();
		assertEquals("ALUNO REGISTRADO!",
				sistema.cadastraAlunoQueRespondeu("00000000"));
		assertEquals("ALUNO REGISTRADO!",
				sistema.cadastraAlunoQueRespondeu("11111111"));
	}

	/**
	 * Testa o método cadastraAlunoQueRespondeu com matrículas não cadastradas.
	 */
	@Test
	public void testCadastraAlunoQueRespondeuComAlunoInexistente() {
		cadastraAlunos();
		assertEquals("Aluno não cadastrado.",
				sistema.cadastraAlunoQueRespondeu("invalida"));
		assertEquals("Aluno não cadastrado.",
				sistema.cadastraAlunoQueRespondeu(""));
	}

	/**
	 * Testa o método listaAlunosQueResponderam.
	 */
	@Test
	public void testListaAlunosQueResponderam() {
		testCadastraAlunoQueRespondeuComAlunoExistente();
		assertEquals("Alunos:\n" + "1. 00000000 - Carol - CC\n"
				+ "2. 11111111 - Felipe - CC\n",
				sistema.listaAlunosQueResponderam());
	}

}