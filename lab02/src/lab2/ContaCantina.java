/**
 * Laboratório de Programação II
 * @author Caroliny Mylena - 117210911
 *
 */
package lab2;

/**
 * Classe criada para controlar a conta de determinado aluno em suas refeicoes.
 */
public class ContaCantina {
	/**
	 * Atributo do nome da Cantina em forma de String.
	 */
	private String nomeDaCantina;
	/**
	 * Atributo da quantidade total de elementos consumidos.
	 */
	private int qtdTotal;
	/**
	 * Gasto total de centavos nas refeições.
	 */
	private int centavosTotal;
	/**
	 * Atributo que relaciona a quantidade que o aluno deve em determinada cantina.
	 */
	private int quantDeve;

	/**
	 * Constrói uma Conta através do nome da Cantina. A quantidade total, os
	 * centavos total e a quantidade que o aluno deve em determinada cantina sao
	 * inicializadas com zero.
	 * 
	 * @param nomeDaCantina o nome da cantina.
	 */
	public ContaCantina(String nomeDaCantina) {
		this.nomeDaCantina = nomeDaCantina;
		this.qtdTotal = 0;
		this.centavosTotal = 0;
		this.quantDeve = 0;
	}

	/**
	 * Método que cadastra um lanche atraves da quantidade de itens e o valor dos
	 * mesmos. A quantidade total, o total em centavos e quantidade que o aluno deve
	 * irá ser alterada de acordo com os paramentros passados.
	 * 
	 * @param qtdItens      a quantidade de itens consumidas
	 * @param valorCentavos o valor dos itens consumidos.
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.qtdTotal += qtdItens;
		this.centavosTotal += valorCentavos;
		this.quantDeve += valorCentavos;
	}

	/**
	 * Método que irá calcular quanto o aluno irá ficar devendo na cantina.
	 * 
	 * @param valorCentavos o valor que irá ser pago.
	 */
	public void pagaConta(int valorCentavos) {
		this.quantDeve -= valorCentavos;
	}

	/**
	 * O método get está relacionado com o encapsulamento e torna a variavel mais
	 * acessivel. Assim sendo, o metodo retorna a quantidade que o aluno deve na
	 * cantina.
	 * 
	 * @return retorna a quantidade que o aluno deve.
	 */
	public int getFaltaPagar() {
		return this.quantDeve;
	}

	/**
	 * Retorna a representacao textual do nome da cantina com a quantidade total de
	 * itens consumidos e o valor total gasto.
	 */
	public String toString() {
		return (nomeDaCantina + " " + qtdTotal + " " + centavosTotal);
	}
}
