/**
 * @author carolinymbs
 */
package lab03;

import java.util.Arrays;

public class Agenda {

	/**
	 * Na linha abaixo está ocorrendo a atribuição e a criação de um array
	 * "contatos" na memória.
	 */
	private Contato[] contatos = new Contato[100];

	/**
	 * O método irá receber a posição, o nome, o sobrenome e o número e irá atribuir
	 * ao array de contatos. No entanto, foi criado um exceção: Se a posição dada
	 * não pertencer ao tamanho do array o programa irá quebrar e exibirá a mensagem
	 * "POSIÇÃO INVÁLIDA".
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String numero) {
		if (posicao > 100 && posicao < 1) {
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA!");
		}

		contatos[posicao - 1] = new Contato(nome, sobrenome, numero);
	}

	/**
	 * O método abaixo inicia-se criando uma uma string vazia que logo em seguida
	 * receberá, através do array de contatos, a posicão, o nome e o sobrenome, para
	 * assim lista-los. O @return retornará a String criada anteriormente.
	 */
	public String listarContatos() {
		String listagemContatos = "";
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				listagemContatos += (i + 1) + " - " + contatos[i].getNome() + " " + contatos[i].getsobrenome()
						+ System.lineSeparator();
			}
		}
		return listagemContatos.trim();
	}

	/**
	 * O método irá exibir o contato através da posição,dada pelo usuário.No
	 * entanto, isso ocorrerá se a posição for válida, caso contrário, o @return
	 * retornará a mensagem de erro de posição.
	 */
	public String exibeContato(int pos) {
		if (pos >= 1 && pos <= 100) {
			if (contatos[pos - 1] != null) {
				return contatos[pos - 1].toString();
			} else {
				return "POSIÇÃO INVÁLIDA!";
			}
		}
		return "POSIÇÃO INVÁLIDA!";
	}
	/**
	 * Se duas agendas serem iguais.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(contatos);
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
		Agenda other = (Agenda) obj;
		if (!Arrays.equals(contatos, other.contatos))
			return false;
		return true;
	}
}