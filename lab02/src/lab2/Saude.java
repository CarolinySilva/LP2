/**
 * Laboratório de Programação II
 * @author Caroliny Mylena - 117210911
 */
package lab2;

/**
 * Classe criada para tratar da saude mental e fisica do aluno.
 *
 */
public class Saude {
	/**
	 * Atributo da saúde mental do aluno.
	 */
	private String saudeMental;
	/**
	 * Atributo da saúde fisica do aluno.
	 */
	private String saudeFisica;

	/**
	 * Constroi a saúde, atribuindo a String "boa" como condicao.
	 */
	public Saude() {
		this.saudeMental = "boa";
		this.saudeFisica = "boa";
	}

	/**
	 * O metodo irá definir a saude de acordo com o parametro passado.
	 * 
	 * @param valor o valor da saude mental.
	 */
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor;
	}

	/**
	 * O método define a saude fisica de acordo com o paramentro.
	 * 
	 * @param valor o valor da saude fisica do aluno.
	 */
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor;
	}

	/**
	 * O getStatusGeral define como está a saúde mental e fisica, retornando uma
	 * String como definicao.
	 * 
	 * @return retorna a condicao da saude do aluno.
	 */
	public String getStatusGeral() {
		if (saudeFisica.equals("fraca") && saudeMental.equals("fraca")) {
			return "fraca";
		} else if (saudeFisica.equalsIgnoreCase("boa") && saudeMental.equalsIgnoreCase("boa")) {
			return "boa";
		} else {
			return "ok";
		}
	}
}
