package lab03;

import java.nio.channels.IllegalSelectorException;

/**
 * @author carolinymbs Foram criados atributos de nome, sobrenome e número.
 */
public class Contato {
	private String nome;
	private String sobrenome;
	private String numero;

	/**
	 * O construtor define cada atributo de acordo com a entrada.
	 * 
	 * @param nome      é definido através do parametro nome.
	 * @param sobrenome é definido através do parametro sobrenome.
	 * @param numero    é definido através do parametro numero.
	 */
	public Contato(String nome, String sobrenome, String numero) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.numero = numero;

		/**
		 * É criada uma exceção em que se o nome, sobrenome ou numero forrem nulo, o
		 * codigo não cadastrará o contato e irá quebrar com uma mensagem de erro.
		 */
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Não é possível cadastrar contato!");
		} else if (sobrenome == null || sobrenome.trim().equals("")) {
			throw new IllegalArgumentException("Não é possível cadastrar contato!");
		} else if (numero == null || numero.trim().equals("")) {
			throw new IllegalArgumentException("Não é possível cadastrar contato!");
		}
	}

	/**
	 * Método de saída(padronizado), será utilizado quando solicitado.
	 */
	public String toString() {
		return this.getNome() + " " + this.getsobrenome() + " - " + this.getnumero();

	}

	/**
	 * Os métodos "get" irão pegar o nome, sobrenome e o numero através do @return
	 */
	public String getNome() {
		return this.nome;
	}

	public String getsobrenome() {
		return this.sobrenome;
	}

	public String getnumero() {
		return this.numero;
	}
	/**
	 * Se dois contatos forem iguais.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}

}