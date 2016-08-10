package br.com.iterator.model.bean.petcenterjau;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Produto")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = -5031660913239968049L;
	
	@Id
	@GeneratedValue
	@Column(name="Codigo")
	private Integer codigo;
	@Column(name="Nome")
	private String nome;
	@Column(name="Preco_Produto")
	private Double precoProduto;
	@Column(name="Preco_Desconto")
	private Double precoDesconto;
	@Column(name="Preco_Custo")
	private Double precoCusto;
	@Column(name="Unidade")
	private String unidade;
	@Column(name="Referencia")
	private String referencia;
	// Não existe relacionamento no BD do ERP. Por isso não pode ser feito no Hibernate.
	@Column(name="Cor")
	private Double cor;
	@Column(name="Tamanho")
	private String tamanho;
	@Column(name="Enviar_Pocket")
	private String enviarPocket;
	@Column(name="Largura_Produto_Ecommerce")
	private Double larguraProdutoEcommerce;
	@Column(name="Altura_Produto_Ecommerce")
	private Double alturaProdutoEcommerce;
	@Column(name="Comprimento_Produto_Ecommerce")
	private Double comprimentoProdutoEcommerce;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Double getPrecoProduto() {
		return precoProduto;
	}
	
	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}
	
	public Double getPrecoDesconto() {
		return precoDesconto;
	}
	
	public void setPrecoDesconto(Double precoDesconto) {
		this.precoDesconto = precoDesconto;
	}
	
	public Double getPrecoCusto() {
		return precoCusto;
	}
	
	public void setPrecoCusto(Double precoCusto) {
		this.precoCusto = precoCusto;
	}
	
	public String getUnidade() {
		return unidade;
	}
	
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	public String getReferencia() {
		return referencia;
	}
	
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	public Double getCor() {
		return cor;
	}
	
	public void setCor(Double cor) {
		this.cor = cor;
	}
	
	public String getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	public String getEnviarPocket() {
		return enviarPocket;
	}
	
	public void setEnviarPocket(String enviarPocket) {
		this.enviarPocket = enviarPocket;
	}
	
	public Double getLarguraProdutoEcommerce() {
		return larguraProdutoEcommerce;
	}
	
	public void setLarguraProdutoEcommerce(Double larguraProdutoEcommerce) {
		this.larguraProdutoEcommerce = larguraProdutoEcommerce;
	}
	
	public Double getAlturaProdutoEcommerce() {
		return alturaProdutoEcommerce;
	}
	
	public void setAlturaProdutoEcommerce(Double alturaProdutoEcommerce) {
		this.alturaProdutoEcommerce = alturaProdutoEcommerce;
	}
	
	public Double getComprimentoProdutoEcommerce() {
		return comprimentoProdutoEcommerce;
	}
	
	public void setComprimentoProdutoEcommerce(Double comprimentoProdutoEcommerce) {
		this.comprimentoProdutoEcommerce = comprimentoProdutoEcommerce;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alturaProdutoEcommerce == null) ? 0 : alturaProdutoEcommerce.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((comprimentoProdutoEcommerce == null) ? 0 : comprimentoProdutoEcommerce.hashCode());
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((enviarPocket == null) ? 0 : enviarPocket.hashCode());
		result = prime * result + ((larguraProdutoEcommerce == null) ? 0 : larguraProdutoEcommerce.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((precoCusto == null) ? 0 : precoCusto.hashCode());
		result = prime * result + ((precoDesconto == null) ? 0 : precoDesconto.hashCode());
		result = prime * result + ((precoProduto == null) ? 0 : precoProduto.hashCode());
		result = prime * result + ((referencia == null) ? 0 : referencia.hashCode());
		result = prime * result + ((tamanho == null) ? 0 : tamanho.hashCode());
		result = prime * result + ((unidade == null) ? 0 : unidade.hashCode());
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
		Produto other = (Produto) obj;
		if (alturaProdutoEcommerce == null) {
			if (other.alturaProdutoEcommerce != null)
				return false;
		} else if (!alturaProdutoEcommerce.equals(other.alturaProdutoEcommerce))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (comprimentoProdutoEcommerce == null) {
			if (other.comprimentoProdutoEcommerce != null)
				return false;
		} else if (!comprimentoProdutoEcommerce.equals(other.comprimentoProdutoEcommerce))
			return false;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (enviarPocket == null) {
			if (other.enviarPocket != null)
				return false;
		} else if (!enviarPocket.equals(other.enviarPocket))
			return false;
		if (larguraProdutoEcommerce == null) {
			if (other.larguraProdutoEcommerce != null)
				return false;
		} else if (!larguraProdutoEcommerce.equals(other.larguraProdutoEcommerce))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (precoCusto == null) {
			if (other.precoCusto != null)
				return false;
		} else if (!precoCusto.equals(other.precoCusto))
			return false;
		if (precoDesconto == null) {
			if (other.precoDesconto != null)
				return false;
		} else if (!precoDesconto.equals(other.precoDesconto))
			return false;
		if (precoProduto == null) {
			if (other.precoProduto != null)
				return false;
		} else if (!precoProduto.equals(other.precoProduto))
			return false;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		if (tamanho == null) {
			if (other.tamanho != null)
				return false;
		} else if (!tamanho.equals(other.tamanho))
			return false;
		if (unidade == null) {
			if (other.unidade != null)
				return false;
		} else if (!unidade.equals(other.unidade))
			return false;
		return true;
	}
}
