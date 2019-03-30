/**
 * @author carolinymbs
 */
package lab03;

import java.util.Scanner;

/**
 * 
 * @author carolinymbs
 *
 */
public class Menu {
	public static void main(String[] args) {
		/**
		 * Criação de uma agenda do tipo "Agenda".
		 */
		Agenda agenda = new Agenda();
		/**
		 * Um laço que mostrará o menu da agenda e pedirá a opção desejada.
		 */
		while (true) {

			System.out.println("(C)adastrar Contato");
			System.out.println("(L)istar Contatos");
			System.out.println("(E)xibir Contato");
			System.out.println("(S)air");
			Scanner sc = new Scanner(System.in);
			System.out.print("Opção> ");
			String opcao = sc.nextLine();
			/**
			 * Dependendo da opção, desejada pelo usuário, ele irá para os métodos criados
			 * nas demais classes e irá realizar as funções e retornará a opção realizada.
			 */
			if (opcao.equals("C") || opcao.equals("c")) {
				cadastraContato(agenda);
			} else if (opcao.equals("L") || opcao.equals("l")) {
				System.out.println(agenda.listarContatos());
			} else if (opcao.equals("E") || opcao.equals("e")) {
				System.out.print("Contato> ");
				int pos = sc.nextInt();
				System.out.println(agenda.exibeContato(pos));

			} else if (opcao.equals("S") || opcao.equals("s")) {
				break;

			} else {
				System.out.println("OPÇÃO INVÁLIDA!");
			}
		}
	}

	/**
	 * Recebe as entradas esperadas pelos métodos das demais classes.
	 * 
	 * @param agenda
	 */
	private static void cadastraContato(Agenda agenda) {
		Scanner sc = new Scanner(System.in);
		System.out.print("posicao: ");
		int pos = sc.nextInt();
		sc.nextLine();
		/**
		 * Só será valida a opção que estiver dentro do tamanho do array criado.
		 */
		if (pos <= 0 || pos > 100) {
			System.out.println("OPÇÃO INVÁLIDA!");
			return;
		}

		System.out.print("nome: ");
		String nome = sc.nextLine();

		System.out.print("sobrenome: ");
		String sobrenome = sc.nextLine();

		System.out.print("numero: ");
		String numero = sc.nextLine();
		/**
		 * O try/ catch irá realizar a exceção criada no método, realizando a quebra do
		 * código e o aparecimento da mensagem estabelecida.
		 */
		try {
			agenda.cadastraContato(pos, nome, sobrenome, numero);
			System.out.println("CADASTRO REALIZADO!");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

	}

}