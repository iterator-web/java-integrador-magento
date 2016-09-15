package br.com.iterator.model.bean.petcenterjau;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Orcamento")
public class Orcamento implements Serializable {

	private static final long serialVersionUID = 2934754441654695163L;
	
	@Id
	@Column(name="Codigo")
	private Double codigo;
	@Column(name="Data")
	private Date data;
	@Column(name="Codigo_Cliente")
	private Double codigoCliente;
	@Column(name="Nome_Cliente")
	private String nomeCliente;
	@Column(name="Fone_Cliente")
	private String foneCliente;
	@Column(name="Observacao")
	private String observacao;
	@Column(name="Valor_Total")
	private Double valorTotal;
	@Column(name="Venda")
	private Double venda;
	@Column(name="Vendedor")
	private Double vendedor;
	@Column(name="Desconto")
	private Double desconto;
	@Column(name="DescontoP")
	private Double descontoP;
	@Column(name="Total_Produtos")
	private Double totalProdutos;
	@Column(name="Situacao")
	private Double situacao;
	@Column(name="Data_Situacao")
	private Date dataSituacao;
	@Column(name="Operador")
	private Integer operador;
	@Column(name="Frete")
	private Double frete;
	@Column(name="Endereco_Cliente")
	private String enderecoCliente;
	@Column(name="Bairro_Cliente")
	private String bairroCliente;
	@Column(name="Cidade_Cliente")
	private Integer cidadeCliente;
	@Column(name="Conta_Corrente")
	private String contaCorrente;
	@Column(name="Empresa")
	private Integer empresa;
	@Column(name="Primeiro_Operador")
	private Integer primeiroOperador;
	
	public String getBairroCliente() {
		return bairroCliente;
	}
	
	public void setBairroCliente(String bairroCliente) {
		this.bairroCliente = bairroCliente;
	}

	public Double getCodigo() {
		return codigo;
	}

	public void setCodigo(Double codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Double codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getFoneCliente() {
		return foneCliente;
	}

	public void setFoneCliente(String foneCliente) {
		this.foneCliente = foneCliente;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getVenda() {
		return venda;
	}

	public void setVenda(Double venda) {
		this.venda = venda;
	}

	public Double getVendedor() {
		return vendedor;
	}

	public void setVendedor(Double vendedor) {
		this.vendedor = vendedor;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getDescontoP() {
		return descontoP;
	}

	public void setDescontoP(Double descontoP) {
		this.descontoP = descontoP;
	}

	public Double getTotalProdutos() {
		return totalProdutos;
	}

	public void setTotalProdutos(Double totalProdutos) {
		this.totalProdutos = totalProdutos;
	}

	public Double getSituacao() {
		return situacao;
	}

	public void setSituacao(Double situacao) {
		this.situacao = situacao;
	}

	public Date getDataSituacao() {
		return dataSituacao;
	}

	public void setDataSituacao(Date dataSituacao) {
		this.dataSituacao = dataSituacao;
	}

	public Integer getOperador() {
		return operador;
	}

	public void setOperador(Integer operador) {
		this.operador = operador;
	}

	public Double getFrete() {
		return frete;
	}

	public void setFrete(Double frete) {
		this.frete = frete;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public Integer getCidadeCliente() {
		return cidadeCliente;
	}

	public void setCidadeCliente(Integer cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}

	public String getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public Integer getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}

	public Integer getPrimeiroOperador() {
		return primeiroOperador;
	}

	public void setPrimeiroOperador(Integer primeiroOperador) {
		this.primeiroOperador = primeiroOperador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairroCliente == null) ? 0 : bairroCliente.hashCode());
		result = prime * result + ((cidadeCliente == null) ? 0 : cidadeCliente.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((codigoCliente == null) ? 0 : codigoCliente.hashCode());
		result = prime * result + ((contaCorrente == null) ? 0 : contaCorrente.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((dataSituacao == null) ? 0 : dataSituacao.hashCode());
		result = prime * result + ((desconto == null) ? 0 : desconto.hashCode());
		result = prime * result + ((descontoP == null) ? 0 : descontoP.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((enderecoCliente == null) ? 0 : enderecoCliente.hashCode());
		result = prime * result + ((foneCliente == null) ? 0 : foneCliente.hashCode());
		result = prime * result + ((frete == null) ? 0 : frete.hashCode());
		result = prime * result + ((nomeCliente == null) ? 0 : nomeCliente.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((operador == null) ? 0 : operador.hashCode());
		result = prime * result + ((primeiroOperador == null) ? 0 : primeiroOperador.hashCode());
		result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
		result = prime * result + ((totalProdutos == null) ? 0 : totalProdutos.hashCode());
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
		result = prime * result + ((venda == null) ? 0 : venda.hashCode());
		result = prime * result + ((vendedor == null) ? 0 : vendedor.hashCode());
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
		Orcamento other = (Orcamento) obj;
		if (bairroCliente == null) {
			if (other.bairroCliente != null)
				return false;
		} else if (!bairroCliente.equals(other.bairroCliente))
			return false;
		if (cidadeCliente == null) {
			if (other.cidadeCliente != null)
				return false;
		} else if (!cidadeCliente.equals(other.cidadeCliente))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (codigoCliente == null) {
			if (other.codigoCliente != null)
				return false;
		} else if (!codigoCliente.equals(other.codigoCliente))
			return false;
		if (contaCorrente == null) {
			if (other.contaCorrente != null)
				return false;
		} else if (!contaCorrente.equals(other.contaCorrente))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (dataSituacao == null) {
			if (other.dataSituacao != null)
				return false;
		} else if (!dataSituacao.equals(other.dataSituacao))
			return false;
		if (desconto == null) {
			if (other.desconto != null)
				return false;
		} else if (!desconto.equals(other.desconto))
			return false;
		if (descontoP == null) {
			if (other.descontoP != null)
				return false;
		} else if (!descontoP.equals(other.descontoP))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (enderecoCliente == null) {
			if (other.enderecoCliente != null)
				return false;
		} else if (!enderecoCliente.equals(other.enderecoCliente))
			return false;
		if (foneCliente == null) {
			if (other.foneCliente != null)
				return false;
		} else if (!foneCliente.equals(other.foneCliente))
			return false;
		if (frete == null) {
			if (other.frete != null)
				return false;
		} else if (!frete.equals(other.frete))
			return false;
		if (nomeCliente == null) {
			if (other.nomeCliente != null)
				return false;
		} else if (!nomeCliente.equals(other.nomeCliente))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (operador == null) {
			if (other.operador != null)
				return false;
		} else if (!operador.equals(other.operador))
			return false;
		if (primeiroOperador == null) {
			if (other.primeiroOperador != null)
				return false;
		} else if (!primeiroOperador.equals(other.primeiroOperador))
			return false;
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		if (totalProdutos == null) {
			if (other.totalProdutos != null)
				return false;
		} else if (!totalProdutos.equals(other.totalProdutos))
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		if (venda == null) {
			if (other.venda != null)
				return false;
		} else if (!venda.equals(other.venda))
			return false;
		if (vendedor == null) {
			if (other.vendedor != null)
				return false;
		} else if (!vendedor.equals(other.vendedor))
			return false;
		return true;
	}
}
