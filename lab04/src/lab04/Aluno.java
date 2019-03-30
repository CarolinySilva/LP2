package lab04;

public class Aluno {

	/**
	 * Nome do aluno.
	 */
	private String nome;

	/**
	 * Matrícula do aluno.
	 */
	private String matricula;

	/**
	 * Curso do aluno.
	 */
	private String curso;

	/**
	 * Constrói um aluno a partir de um nome, matricula e curso.
	 * 
	 * @param nome
	 *            nome do aluno.
	 * @param matricula
	 *            matricula do aluno.
	 * @param curso
	 *            curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {	
		if(matricula == null || nome == null || curso == null)
			throw new NullPointerException("Dados inválidos.");
		if(matricula.trim().isEmpty())
			throw new IllegalArgumentException("Matrícula inválida.");
		if(nome.trim().isEmpty())
			throw new IllegalArgumentException("Nome inválido.");
		if(curso.trim().isEmpty())
			throw new IllegalArgumentException("Curso inválido.");
		
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
}
	/**
	 * Retorna o nome do aluno.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna a matrícula do aluno.
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Retorna o curso do aluno.
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * Sobrescreve o toString().
	 */
	@Override
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}

	/**
	 * Dois alunos serão iguais se suas matriculas assim forem.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
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
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

}
