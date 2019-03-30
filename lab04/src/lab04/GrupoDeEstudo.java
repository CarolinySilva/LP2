package lab04;

import java.util.HashSet;


public class GrupoDeEstudo {

	/**
	 * Tema do grupo de estudos.
	 */
	private String tema;

	/**
	 * Conjunto com os alunos do grupo.
	 */
	private HashSet<Aluno> alunos;

	/**
	 * Constrói um grupo de estudos a partir de um tema.
	 * 
	 * @param tema
	 *            assunto abordado no grupo de estudos.
	 */
	public GrupoDeEstudo(String tema) {
		if (tema == null) {
			throw new NullPointerException("tema nulo.");
		}
		if (tema.trim().isEmpty()) {
			throw new IllegalArgumentException("tema inválido");
		}
		this.tema = tema;
		this.alunos = new HashSet<>();
	}

	
	/**
	 * Adiciona um aluno no conjunto.
	 * 
	 * @param aluno novato no grupo.
	 */
	public void adicionaAluno(Aluno aluno) {
		alunos.add(aluno);
	}

	/**
	 * Remove um aluno no conjunto.
	 * 
	 * @param aluno veterano no grupo.
	 */
	public void removeAluno(Aluno aluno) {
		alunos.remove(aluno);
	}

	/**
	 * Retorna a quantidade de alunos do grupo.
	 * 
	 */
	public int getQtdAlunos() {
		return this.alunos.size();
	}

	/**
	 * Retorna o tema do grupo.
	 */
	public String getTema() {
		return tema;
	}

	/**
	 * Método toString que lista todos os integrantes do grupo.
	 * 
	 * @return uma String dos integrantes.
	 */
	@Override
	public String toString() {
		String integrantes = "Grupo: " + this.tema + "\n\nAlunos do grupo Listas:\n";
		for (Aluno aluno : this.alunos) {
			integrantes += "* " + aluno.toString() + System.lineSeparator();
		}
		return integrantes;
	}

	/**
	 * Sobrescrevendo o hashCode de Object.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tema == null) ? 0 : tema.hashCode());
		return result;
	}

	/**
	 * Sobrescrevendo o equals de Object. Grupos de estudos iguais tem o mesmo tema.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoDeEstudo other = (GrupoDeEstudo) obj;
		if (tema == null) {
			if (other.tema != null)
				return false;
		} else if (!tema.equalsIgnoreCase(other.tema))
			return false;
		return true;
	}

}