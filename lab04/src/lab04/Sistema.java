package lab04;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe principal do Sistema de Controle de Alunos.
 *
 */
public class Sistema {
	
	/**
	 * Alunos cadastrados.
	 */
	private HashMap<String, Aluno> alunos;

	/**
	 * Grupos de estudo cadastrados.
	 */
	private HashMap<String, GrupoDeEstudo> gruposDeEstudo;

	/**
	 * Lista com os alunos que responderam questões no quadro.
	 */
	private ArrayList<Aluno> alunosQueResponderam;

	/**
	 * Constrói um sistema de controle de alunos.
	 */
	public Sistema() {
		this.alunos = new HashMap<>();
		this.gruposDeEstudo = new HashMap<>();
		this.alunosQueResponderam = new ArrayList<>();
	}

	/**
	 * Cadastra um aluno no sistema.
	 * 
	 * @param nome do aluno.
	 * @param matricula do aluno.
	 * @param curso do aluno.
	 * @return true se a operação for bem sucedida.
	 */
	public boolean cadastraAluno(String nome, String matricula, String curso) {
		if (!alunoCadastrado(matricula)) {
			Aluno aluno = new Aluno(nome, matricula, curso);
			this.alunos.put(matricula, aluno);
			return true;
		}
		return false;
	}

	/**
	 * Método público que verifica se um aluno está cadastrado no sistema.
	 * 
	 * @param matricula do aluno.
	 * @return true se está cadastrado.
	 */
	public boolean alunoCadastrado(String matricula) {
		return this.alunos.containsKey(matricula);
	}

	/**
	 * Método que retorna uma String com os dados do aluno, se este estiver
	 * cadastrado no sistema.
	 * 
	 * @param matricula do aluno.
	 * @return String com os dados do aluno.
	 */
	public String consultaAluno(String matricula) {
		if (this.alunos.containsKey(matricula)) {
			return "Aluno: " + this.alunos.get(matricula).toString();
		}
		return "Aluno não cadastrado.";
	}

	/**
	 * Cadastra um Grupo de estudos no sistemas, caso este ainda não tenha sido
	 * cadastrado.
	 * 
	 * @param tema do grupo de estudos.
	 * @return true se a operação foi bem sucedida.
	 */
	public boolean cadastraGrupoEstudo(String tema) {
		if (tema == null) {
			throw new NullPointerException("tema nulo");
		}
		if (tema.trim().isEmpty()) {
			throw new IllegalArgumentException("tema inválido");
		}
		if (!grupoCadastrado(tema)) {
			GrupoDeEstudo grupo = new GrupoDeEstudo(tema);
			this.gruposDeEstudo.put(tema.toLowerCase(), grupo);
			return true;
		}
		return false;
	}

	/**
	 * Método que verifica se um grupo de estudos com o mesmo tema já foi cadastrado
	 * no sistema.
	 * 
	 * @param tema do grupo de estudos.
	 * @return true se já foi cadastrado.
	 */ 
	private boolean grupoCadastrado(String tema) {
		return this.gruposDeEstudo.containsKey(tema.toLowerCase());
	}

	/**
	 * Aloca um aluno em um grupo de estudos a partir de sua matricula e tema do
	 * grupo.
	 * 
	 * @param matricula do aluno.
	 * @param grupoDeEstudos grupo de estudos.
	 * @return String com o status da operação.
	 */
	public String alocaAluno(String matricula, String temaGrupo) {
		if (!this.alunos.containsKey(matricula)) {
			return "Aluno não cadastrado.";
		}
		if (!this.gruposDeEstudo.containsKey(temaGrupo.toLowerCase())) {
			return "Grupo não cadastrado.";
		}
		this.gruposDeEstudo.get(temaGrupo.toLowerCase()).adicionaAluno(this.alunos.get(matricula));
		return "ALUNO ALOCADO!";
	}

	/**
	 * Retorna uma String com uma lista dos integrantes do grupo de estudos
	 * 
	 * @param tema  do grupo de estudos.
	 * @return 
	 */
	public String imprimeGrupo(String temaGrupo) {
		if (grupoCadastrado(temaGrupo.toLowerCase())) {
			return this.gruposDeEstudo.get(temaGrupo.toLowerCase()).toString();
		}
		return "Grupo não cadastrado.";
	}

	/**
	 * Cadastra um aluno que respondeu uma questão no quadro.
	 * 
	 * @param matricula do aluno.
	 * @return String com o status da operação.
	 */
	public String cadastraAlunoQueRespondeu(String matricula) {
		if (alunoCadastrado(matricula)) {
			this.alunosQueResponderam.add(alunos.get(matricula));
			return "ALUNO REGISTRADO!";
		}
		return "Aluno não cadastrado.";
	}

	/**
	 * Retorna uma String com todos os alunos que resolveram questões no quadro.
	 */
	public String listaAlunosQueResponderam() {
		String msg = "Alunos:" + System.lineSeparator();
		for (int i = 0; i < this.alunosQueResponderam.size(); i++) {
			msg += (i + 1) + ". " + this.alunosQueResponderam.get(i).toString() + System.lineSeparator();
		}
		return msg;
	}

}