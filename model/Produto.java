
package sistema.model;

public class Produto {
	private int codigo;
	private String nome;
	private String marca;
	private double preco;
	private int quantidade;

	// Repositorio eh responsavel por controlar o codigo
	// private static int geraCodigo;

	// construtor de copia
	public Produto(Produto outro) {
		codigo = outro.codigo;
		nome = outro.nome;
		marca = outro.marca;
		preco = outro.preco;
		quantidade = outro.quantidade;
	}

	private Produto(String nome, String marca, double preco, int quantidade) {
		this.nome = nome;
		this.marca = marca;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public static Produto getInstance(String nome, String marca, double preco,
			int quantidade) {
		if (nome != null && marca != null && preco > 0 && quantidade >= 0)
			return new Produto(nome, marca, preco, quantidade);
		else
			return null;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if (codigo > 0)
			this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null)
			this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
