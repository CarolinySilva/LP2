package tests;

import static org.junit.Assert.*;
import lab04.Aluno;

import org.junit.Before;
import org.junit.Test;

public class AlunoTest {

	/**
	 * Alunos para teste.
	 */
	private Aluno aluno1;
	private Aluno aluno2;
	private Aluno aluno3;

	@Before
	public void criaAluno() {
		aluno1 = new Aluno("vinicius", "117210708", "Computação");
		aluno2 = new Aluno("pedro", "00000000", "Engenharia Civil");
		aluno3 = new Aluno("v", "117210708", "CC");
	}

	/**
	 * Testa o construtor com os parametros válidos.
	 */
	@Test
	public void testAluno() {
		new Aluno("fulano", "44444444", "Historia");
	}

	/**
	 * Testa o construtor com o nome nulo.
	 */
	@Test
	public void testConstrutorNomeNulo() {
		assertThrows(NullPointerException.class, () -> new Aluno(null, "44444444", "Historia"));
	}

	/**
	 * Testa o construtor com a matrícula nula.
	 */
	@Test
	public void testConstrutorMensagemNulo() {
		assertThrows(NullPointerException.class, () -> new Aluno("vinicius", null, "Historia"));
	}

	/**
	 * Testa o construtor com o curso nulo.
	 */
	@Test
	public void testConstrutorCursoNulo() {
		assertThrows(NullPointerException.class, () -> new Aluno("vinicius", "44444444", null));
	}

	/**
	 * Testa o construtor com o nome inválido.
	 */
	@Test
	public void testConstrutorNomeInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Aluno("  ", "44444444", "Historia"));
	}

	/**
	 * Testa o construtor com o matrícula inválido.
	 */
	@Test
	public void testConstrutorMatriculaInvalida() {
		assertThrows(IllegalArgumentException.class, () -> new Aluno("matheuis", "", "Historia"));
	}

	/**
	 * Testa o construtor com o curso inválido.
	 */
	@Test
	public void testConstrutorCursoInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Aluno("livia", "44444444", " "));
	}

	/**
	 * Testa o método equals.
	 */
	@Test
	public void testEqualsObject() {
		assertEquals(aluno1, aluno3);
		assertNotEquals(aluno1, aluno2);
		assertNotEquals(aluno2, aluno3);
	}

}