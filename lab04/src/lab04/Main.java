package lab04;

import java.util.Scanner;

/**
 * @author Caroliny Mylena Bezerra e Silva.
 *
 */
public class Main {

	private static Scanner scan = new Scanner(System.in);
	private static Sistema sistema = new Sistema();

	/**
	 * Constantes com as funcionalidades do menu principal.
	 */
	private static final String CADASTRAR_ALUNO = "c";
	private static final String EXIBIR_ALUNO = "e";
	private static final String NOVO_GRUPO = "n";
	private static final String ALOCAR_ALUNO_E_IMPRIMIR_GRUPOS = "a";
	private static final String REGISTAR_ALUNO_QUE_RESPONDEU = "r";
	private static final String IMPRIMIR_ALUNOS_QUE_RESPONDERAM = "i";
	private static final String FECHAR = "o";

	/**
	 * Menu principal.
	 */
	public static void main(String[] args) {
		String opcao;
		boolean sair = false;
		while (!sair) {
			opcao = mostraMenu();
			if (opcao.equals(CADASTRAR_ALUNO)) {
				System.out.println(cadastraAluno());
			} else if (opcao.equals(EXIBIR_ALUNO)) {
				System.out.println(exibeAluno());
			} else if (opcao.equals(NOVO_GRUPO)) {
				System.out.println(cadastraGrupo());
			} else if (opcao.equals(ALOCAR_ALUNO_E_IMPRIMIR_GRUPOS)) {
				System.out.println("(A)locar Aluno");
				System.out.println("(I)mprimir Grupo");
				String subOpcao = scan.nextLine();
				if (subOpcao.equalsIgnoreCase("A")) {
					System.out.println(alocaAluno());
				} else if (subOpcao.equalsIgnoreCase("I")) {
					System.out.println(imprimeGrupo());
				} else {
					System.out.println("Comando inválido.");
				}
			} else if (opcao.equals(REGISTAR_ALUNO_QUE_RESPONDEU)) {
				System.out.println(registraAlunoQueRespondeu());
			} else if (opcao.equals(IMPRIMIR_ALUNOS_QUE_RESPONDERAM)) {
				System.out.println(sistema.listaAlunosQueResponderam());
			} else if (opcao.equals(FECHAR)) {
				sair = true;
			} else {
				System.out.println("Comando inválido.");
			}
		}
		scan.close();
	}

	/**
	 * Imprime o menu principal na tela e retorna a opção escolhida,
	 * 
	 * @return opção escolhida pelo usuario.
	 */
	private static String mostraMenu() {
		System.out.println();
		System.out.println("(C)adastrar Aluno");
		System.out.println("(E)xibir Aluno");
		System.out.println("(N)ovo Grupo");
		System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
		System.out.println("(R)egistrar Aluno que Respondeu");
		System.out.println("(I)mprimir Alunos que Responderam");
		System.out.println("(O)ra, vamos fechar o programa!"
				+ System.lineSeparator());
		System.out.println("Opção>");
		return scan.nextLine().toLowerCase();
	}

	/**
	 * Recebe os dados e cadastra no sistema se possível.
	 * 
	 * @return o Status da operação(entradas inválidas, operação bem ou operação
	 *         mal sucedida).
	 */
	private static String cadastraAluno() {
		System.out.println("Nome:");
		String nome = scan.nextLine();
		if (nome.trim().isEmpty()) {
			return "Nome inválido";
		}
		System.out.println("Matricula:");
		String matricula = scan.nextLine();
		if (matricula.trim().isEmpty()) {
			return "Matrícula inválida";
		}
		System.out.println("Curso:");
		String curso = scan.nextLine();
		if (curso.trim().isEmpty()) {
			return "Nome de curso inválido";
		}
		if (sistema.cadastraAluno(nome, matricula, curso)) {
			return "CADASTRO REALIZADO!";
		} else {
			return "MATRÍCULA JÁ CADASTRADA!";
		}
	}

	/**
	 * Recebe a matricula do aluno e retorna informações sobre ele,se estiver
	 * cadastrado.
	 * 
	 * @return o Status da operação,
	 */
	private static String exibeAluno() {
		System.out.println("Matricula:");
		String matricula = scan.nextLine();
		if (matricula.trim().isEmpty()) {
			return "Matrícula inválida";
		}
		return sistema.consultaAluno(matricula);
	}

	/**
	 * Recebe um tema de um grupo de estudos e, se for válido, cadastra no
	 * sistema.
	 * 
	 * @return o Status da operação.
	 */
	private static String cadastraGrupo() {
		System.out.println("Tema:");
		String tema = scan.nextLine();
		if (tema.trim().isEmpty()) {
			return "Tema inválido";
		}
		if (sistema.cadastraGrupoEstudo(tema)) {
			return "CADASTRO REALIZADO!";
		} else {
			return "GRUPO JÁ CADASTRADO!";
		}
	}

	/**
	 * Recebe a matrícula de um aluno, um tema de um grupo de estudos e cadastra
	 * o aluno nesse grupo se possível.
	 * 
	 * @return o Status da operação
	 */
	private static String alocaAluno() {
		System.out.println("Matricula:");
		String matricula = scan.nextLine();
		if (matricula.trim().isEmpty()) {
			return "Matrícula inválida";
		}
		if (!sistema.alunoCadastrado(matricula)) {
			return "Aluno não cadastrado";
		}
		System.out.println("Tema do Grupo:");
		String tema = scan.nextLine();
		if (tema.trim().isEmpty()) {
			return "Tema inválido";
		}
		return sistema.alocaAluno(matricula, tema);
	}

	/**
	 * Recebe o nome de um grupo e o imprime, caso o mesmo esteja cadastrado no
	 * sistema.
	 * 
	 * @return o Status da operação.
	 */
	private static String imprimeGrupo() {
		System.out.println("Tema do Grupo:");
		String tema = scan.nextLine();
		if (tema.trim().isEmpty()) {
			return "Tema inválido";
		}
		return sistema.imprimeGrupo(tema);
	}

	/**
	 * Recebe a matrícula de um aluno e registra na lista de alunos que
	 * responderam questões no quadro.
	 * 
	 * @return o Status da operação.
	 */
	private static String registraAlunoQueRespondeu() {
		System.out.println("Matricula:");
		String matricula = scan.nextLine();
		return sistema.cadastraAlunoQueRespondeu(matricula);
	}
}