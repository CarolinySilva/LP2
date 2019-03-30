package lab05;

import java.util.HashMap;
import java.util.Map;

public class Controller {
	private Map<String, Fornecedor> fornecedores;
	private Map<Fornecedor, Produto> produtoDosFornecedores;
	private Map<String, Cliente> clientes;

	public Controller() {
		this.clientes = new HashMap<>();
		this.fornecedores = new HashMap<>();
		this.produtoDosFornecedores = new HashMap<>();
	}

	/**
	 * Metodo booleano que verifica se o mapa possui tal CPF
	 * 
	 * @param cpf
	 *            em String
	 * @return booleano
	 */
	public boolean existeCliente(String cpf) {
		return this.clientes.containsKey(cpf);
	}

	/**
	 * Metodo que valida se o CPF possui 11 digitos
	 * 
	 * @param cpf
	 * @return
	 */
	public boolean validaCpf(String cpf) {
		if (cpf.length() > 11 || cpf.length() < 11) {
			return false;
		}
		return true;
	}

	/**
	 * Metodo que após verificar existencia do cliente cadastra o mesmo no mapa
	 * 
	 * @param cpf
	 * @param nome
	 * @param email
	 * @param localizacao
	 */
	public void adicionaCliente(String cpf, String nome, String email,
			String localizacao) {
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastro do cliente: nome nao pode ser vazio ou nulo");
		}
		if (email == null || email.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
		if (localizacao == null || localizacao.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
		if (this.existeCliente(cpf)) {
			throw new IllegalArgumentException(
					"Erro no cadastro do cliente: cliente ja existe.");
		}
		if (!this.validaCpf(cpf)) {
			throw new IllegalArgumentException(
					"Erro no cadastro do cliente: cpf invalido.");
		}
		if (!this.existeCliente(cpf)) {
			Cliente c = new Cliente(cpf, nome, email, localizacao);
			this.clientes.put(cpf, c);
		}
	}

	/**
	 * Metodo que retorna um cliente pelo seu cpf
	 * 
	 * @param cpf
	 * @return toString to cliente escolhido
	 */
	public String exibeCliente(String cpf) {
		if (!this.existeCliente(cpf)) {
			throw new IllegalArgumentException(
					"Erro na exibicao do cliente: cliente nao existe.");
		} else {
			return this.clientes.get(cpf).toString();
		}
	}

	/**
	 * Metodo que varre os valores do mapa e adicionam todos os clientes em uma
	 * lista
	 * 
	 * @return String contendo uma lista de clientes
	 */
	public String listarClientes() {
		String lista = "";
		for (Cliente c : this.clientes.values()) {
			lista += c.toString() + " | ";
		}
		return lista;
	}

	/**
	 * Metodo que verifica se o cpf existe para depois editar o atributo
	 * escolhido
	 * 
	 * @param cpf
	 * @param atributo
	 * @param novoValor
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		if (!this.existeCliente(cpf)) {
			throw new IllegalArgumentException(
					"Erro na edicao do cliente: cliente nao existe.");
		}
		if (this.existeCliente(cpf)) {
			if (atributo.equals("nome")) {
				clientes.get(cpf).setNome(novoValor);
			} else if (atributo.equals("email")) {
				clientes.get(cpf).setEmail(novoValor);
			} else if (atributo.equals("localizacao")) {
				clientes.get(cpf).setLocalizacao(novoValor);
			}
		}
	}

	/**
	 * Metodo que remove um cliente do mapa a partir do seu CPF
	 * 
	 * @param cpf
	 * @return
	 */
	public Cliente removeCliente(String cpf) {
		if (!this.existeCliente(cpf)) {
			throw new IllegalArgumentException(
					"Erro na exibicao do cliente: cliente nao existe.");
		} else {
			return this.clientes.remove(cpf);
		}
	}

	/**
	 * Metodo booleano que verifica existencia de um fornecedor
	 * 
	 * @param nome
	 * @return
	 */
	public boolean existeFornecedor(String nome) {
		return this.fornecedores.containsKey(nome);
	}

	/**
	 * Metodo que cadastra um fornecedor no mapa de fornecedores(se esse
	 * fornecedor não existir)
	 * 
	 * @param nome
	 * @param email
	 * @param telefone
	 */
	public void adicionaFornecedor(String nome, String email, String telefone) {
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if (email == null || email.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		if (this.existeFornecedor(nome)) {
			throw new IllegalArgumentException(
					"Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
		if (!this.existeFornecedor(nome)) {
			Fornecedor f = new Fornecedor(nome, email, telefone);
			this.fornecedores.put(nome, f);
		}
	}

	/**
	 * Metodo que pesquisa um fornecedor pelo seu nome e exibe sua representacao
	 * texutal
	 * 
	 * @param nome
	 * @return
	 */
	public String exibeFornecedor(String nome) {
		if (!this.existeFornecedor(nome)) {
			throw new IllegalArgumentException(
					"Erro na exibicao do fornecedor: fornecedor nao existe.");
		} else {
			return this.fornecedores.get(nome).toString();
		}
	}

	/**
	 * Metodo que lista todos os fornecedores do mapa
	 * 
	 * @return
	 */
	public String listaFornecedores() {
		String lista = "";
		for (Fornecedor f : this.fornecedores.values()) {
			lista += f.toString() + " | ";
		}
		return lista;
	}

	/**
	 * Metodo que verifica se o fornecedor existe e recebe um atributo para ser
	 * editado em um novo valor
	 * 
	 * @param nome
	 * @param atributo
	 * @param novoValor
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		if (this.existeFornecedor(nome)) {
			if (atributo.equals("nome")) {
				throw new IllegalArgumentException(
						"Erro na edicao do fornecedor: nome nao pode ser editado.");
			} else if (atributo.equals("email")) {
				fornecedores.get(nome).setEmail(novoValor);
			} else if (atributo.equals("telefone")) {
				fornecedores.get(nome).setTelefone(novoValor);
			}
		}

	}

	/**
	 * Metodo que remove um fornecedor do mapa a partir do seu nome
	 * 
	 * @param nome
	 * @return
	 */
	public Fornecedor removeFornecedor(String nome) {
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		}
		if (!this.existeFornecedor(nome)) {
			throw new IllegalArgumentException(
					"Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
		return this.fornecedores.remove(nome);
	}

	/**
	 * Metodo que verifica a existencia de um fornecedor de tal produto
	 * 
	 * @param fornecedor
	 * @return
	 */
	public boolean existefornecedorDoProduto(Fornecedor fornecedor) {
		return this.produtoDosFornecedores.containsKey(fornecedor);
	}

	/**
	 * Metodo que cadastra um produto em um fornecedor
	 * 
	 * @param fornecedor
	 * @param preco
	 * @param nome
	 * @param descricao
	 */
	public void adicionafornecedorDoProduto(Fornecedor fornecedor,
			String preco, String nome, String descricao) {
		if (this.existefornecedorDoProduto(fornecedor)) {
			Produto p = new Produto(preco, nome, descricao);
			this.produtoDosFornecedores.put(fornecedor, p);
		}
	}

	/**
	 * Metodo que retorna a representacao textual de um produto.
	 * 
	 * @param fornecedor
	 * @return
	 */
	public String exibeProdutoDeFornecedor(Fornecedor fornecedor) {
		return this.produtoDosFornecedores.get(fornecedor).toString();
	}

	/**
	 * Metodo que remove um produto do mapa a partir do seu fornecedor
	 * 
	 * @param fornecedor
	 * @return
	 */
	public Produto removerProdutoDoFornecedor(Fornecedor fornecedor) {
		return this.produtoDosFornecedores.remove(fornecedor);
	}

}
