/**
 * Laboratório de Programação II
 * @author Caroliny Mylena - 117210911
 *
 */
package lab2;

/**
 * Classe criada para se responsabilizar em controlar os espaços de
 * armazenamento de cada aluno;
 *
 */
public class ContaLaboratorio {
	/**
	 * Atributo do nome do laboratorio
	 */
	private String nomeLaboratorio;
	/**
	 * Atributo do espaco de armazenamento de determinado laboratório.
	 */
	private int espaco;
	/**
	 * Atributo da cota que determinado aluno terá no armazamento no laboratório.
	 */
	private int cota;

	/**
	 * Constrói um laboratório a partir de seu nome. A cota do aluno é de 2000.
	 * 
	 * @param nomeLaboratorio o nome do laboratório.
	 */
	public ContaLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = 2000;
	}

	/**
	 * Constroi um laboratório a partir do nome e da cota que irá ser recebida pelo
	 * usuário.
	 * 
	 * @param nomeLaboratorio o nome do laboratorio.
	 * @param cota            a cota do usuário.
	 */
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = cota;
	}

	/**
	 * Método que irá calcular o espaco que está sendo consumido a partir da
	 * utilizacao dos mbytes.
	 * 
	 * @param mbytes os mbytes que estap sendo consumidos.
	 */
	public void consomeEspaco(int mbytes) {
		this.espaco += mbytes;
	}

	/**
	 * Método que calcula a liberacao do espaco, através dos mbytes.
	 * 
	 * @param mbytes os mbytes que irao liberar o espaco.
	 */
	public void liberaEspaco(int mbytes) {
		this.espaco -= mbytes;
	}

	/**
	 * Método que irá calcular se o aluno atingiu a cota do laboratorio, retornando
	 * assim um booleano.
	 * 
	 * @return um booleano;
	 */
	public boolean atingiuCota() {
		if (espaco >= cota) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Método que retorna a String/Representacao textual que representa o
	 * laboratório, o espaco e a cota.
	 */
	public String toString() {
		return nomeLaboratorio + " " + espaco + "/" + cota;
	}
}
