package lab2;

/**
 * Laboratório de Programação II
 * @author Caroliny Mylena - 117210911
 *
 */
import java.util.Arrays;

/**
 * Classe criada para controlar o desempenho dos alunos nas disciplinas.
 *
 */
public class Disciplina {
	/**
	 * Atributo do nome da disciplina.
	 */
	private String nomeDisciplina;
	/**
	 * Atributo das horas trabalhadas.
	 */
	private int horasTrabalhadas;
	/**
	 * Array das notas na disciplina.
	 */
	private double[] notas;

	/**
	 * Constroi a disciplina de acordo com o nome. As horas trabalhadas são
	 * inicializadas com zero e é determinado o tamanho do array como 4.
	 * 
	 * @param nomeDisciplina o nome da disciplina.
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.horasTrabalhadas = 0;
		this.notas = new double[4];
	}

	/**
	 * O método cadastra horas trabalhadas através da parametrizacao de horas.
	 * 
	 * @param horas as horas trabalhadas.
	 */
	public void cadastraHoras(int horas) {
		this.horasTrabalhadas += horas;
	}

	/**
	 * Cadastra as notas no array.
	 * 
	 * @param nota      o array.
	 * @param valorNota nota tirada pelo aluno na disciplina.
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] += valorNota;
	}

	/**
	 * O método calcula a media de acordo com as notas dos alunos.
	 * 
	 * @return a media.
	 */
	private double calculaMedia() {
		double soma = 0;
		for (int i = 0; i < notas.length; i++) {
			soma += notas[i];
		}
		return soma / notas.length;
	}

	/**
	 * O método verifica se o aluno foi aprovado ou não através da média.
	 * 
	 * @return um boolean.
	 */
	public boolean aprovado() {
		if (calculaMedia() >= 7.0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Retorna uma representação textual com o nome da disciplina, as horas
	 * trabalhadas, o valor da media e o array de notas.
	 */
	public String toString() {
		return (nomeDisciplina + " " + horasTrabalhadas + " " + calculaMedia() + " " + Arrays.toString(notas));
	}
}
