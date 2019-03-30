package lab05;

public class Produto {
	/**
	 * Atributos que compoem um Produto representados em String
	 */
	private String preco;
	private String nome;
	private String descricao;

	/**
	 * Construtor
	 * 
	 * @param preco
	 * @param nome
	 * @param descricao
	 */
	public Produto(String preco, String nome, String descricao) {
		super();
		this.preco = preco;
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getPreco() {
		return preco;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Metodo que gera um HashCode a partir do nome e descricao do Produto
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Metodo 'equals' que define que dois produtos são iguais se possuirem o
	 * mesmo nome e descrição
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * Metodo toString que define a representacao textual da classe Produto
	 */
	@Override
	public String toString() {
		return this.getNome() + "-" + this.getDescricao() + "-"
				+ this.getPreco();
	}

}