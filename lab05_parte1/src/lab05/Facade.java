package lab05;

import easyaccept.EasyAccept;

public class Facade {

	private Controller controle;

	public void inicializa() {
		controle = new Controller();
	}

	public void adicionaCliente(String cpf, String nome, String email,
			String localizacao) {
		controle.adicionaCliente(cpf, nome, email, localizacao);
	}

	public String exibeCliente(String cpf) {
		return controle.exibeCliente(cpf);
	}

	public String exibindoClientes() {
		return controle.listarClientes();
	}

	public void editaCliente(String cpf, String atributo, String novoValor) {
		controle.editaCliente(cpf, atributo, novoValor);
	}

	public void removeCliente(String cpf) {
		controle.removeCliente(cpf);
	}

	public void adicionaFornecedor(String nome, String email, String telefone) {
		controle.adicionaFornecedor(nome, email, telefone);
	}

	public String exibeFornecedor(String nome) {
		return controle.exibeFornecedor(nome);
	}

	public String exibindoFornecedores() {
		return controle.listaFornecedores();
	}

	public void editaFornecedor(String nome, String atributo, String novoValor) {
		controle.editaFornecedor(nome, atributo, novoValor);
	}

	public void removeFornecedor(String nome) {
		controle.removeFornecedor(nome);
	}

}
