package lab05;

public class Cliente {
	/**
	 * Atributos que compoem um cliente representados em String
	 */
	private String cpf;
	private String nome;
	private String email;
	private String localizacao;

	/**
	 * Construtor
	 * 
	 * @param cpf
	 * @param nome
	 * @param email
	 * @param localizacao
	 */
	public Cliente(String cpf, String nome, String email, String localizacao) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	/**
	 * Metodo que gera um hashCode a partir do CPF do cliente
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	/**
	 * Metodo equals que define que dois clientes são iguais se possuirem o
	 * mesmo CPF
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	/**
	 * Metodo toString que define a representacao textual da classe Cliente
	 */
	@Override
	public String toString() {
		return this.getNome() + " - " + this.getLocalizacao() + " - "
				+ this.getEmail();
	}

}