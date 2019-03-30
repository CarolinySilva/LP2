package lab05;

public class Fornecedor {
	/**
	 * Atributos que compoem um Fornecedor.
	 */
	private String nome;
	private String email;
	private String telefone;

	public Fornecedor(String nome, String email, String telefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;

	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Metodo que gera um HashCode a partir do nome do fornecedor
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Metodo 'equals' que define que dois fornecedores são iguais se possuirem
	 * o mesmo nome
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * Metodo toString que define a representacao textual.
	 */
	@Override
	public String toString() {
		return this.getNome() + " - " + this.getEmail() + " - "
				+ this.getTelefone();
	}

}