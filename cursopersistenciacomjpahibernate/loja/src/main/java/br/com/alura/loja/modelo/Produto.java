package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
@NamedQuery(name = "Produto.produtosPorCategoria", 
query = "SELECT produto FROM Produto produto WHERE produto.categoria.id.nome = :nome")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	//@Column(name = "desc") caso nome da coluna no database fosse diferente da usada como boa prática no JAVA.
	private String descricao;
	private BigDecimal preco;
	private LocalDate  dataCadastro = LocalDate.now();
	//@Enumerated(EnumType.STRING) anotação para relacionar um coluna varchar no banco de dados
	@ManyToOne(fetch = FetchType.LAZY) //cardinalidade muitos produtos estão vinculados a uma única categoria
	private Categoria categoria; //um produto tem uma categoria e uma categoria tem vários produtos
	
	public Produto() {
		
	}
	
	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}	
}
