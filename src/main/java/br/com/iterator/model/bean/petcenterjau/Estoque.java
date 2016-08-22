package br.com.iterator.model.bean.petcenterjau;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Estoque")
public class Estoque implements Serializable {

	private static final long serialVersionUID = -4704621415629079826L;
	
	@Column(name="Deposito")
	private Integer deposito;
	@Column(name="Produto")
	private Integer produto;
	@Column(name="Qtde")
	private Double qtde;
	@Column(name="Data_Carga")
	private Date dataCarga;
	@Column(name="Roteador_Puxou")
	private String roteadorPuxou;
	@Column(name="Roteador_Enviou")
	private String roteadorEnvou;
	@Column(name="Assinatura_Digital_Registro")
	private String assinaturaDigitalRegistro;
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	public Integer getDeposito() {
		return deposito;
	}
	
	public void setDeposito(Integer deposito) {
		this.deposito = deposito;
	}
	
	public Integer getProduto() {
		return produto;
	}
	
	public void setProduto(Integer produto) {
		this.produto = produto;
	}
	
	public Double getQtde() {
		return qtde;
	}
	
	public void setQtde(Double qtde) {
		this.qtde = qtde;
	}
	
	public Date getDataCarga() {
		return dataCarga;
	}
	
	public void setDataCarga(Date dataCarga) {
		this.dataCarga = dataCarga;
	}
	
	public String getRoteadorPuxou() {
		return roteadorPuxou;
	}
	
	public void setRoteadorPuxou(String roteadorPuxou) {
		this.roteadorPuxou = roteadorPuxou;
	}
	
	public String getRoteadorEnvou() {
		return roteadorEnvou;
	}
	
	public void setRoteadorEnvou(String roteadorEnvou) {
		this.roteadorEnvou = roteadorEnvou;
	}
	
	public String getAssinaturaDigitalRegistro() {
		return assinaturaDigitalRegistro;
	}
	
	public void setAssinaturaDigitalRegistro(String assinaturaDigitalRegistro) {
		this.assinaturaDigitalRegistro = assinaturaDigitalRegistro;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assinaturaDigitalRegistro == null) ? 0 : assinaturaDigitalRegistro.hashCode());
		result = prime * result + ((dataCarga == null) ? 0 : dataCarga.hashCode());
		result = prime * result + ((deposito == null) ? 0 : deposito.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((qtde == null) ? 0 : qtde.hashCode());
		result = prime * result + ((roteadorEnvou == null) ? 0 : roteadorEnvou.hashCode());
		result = prime * result + ((roteadorPuxou == null) ? 0 : roteadorPuxou.hashCode());
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
		Estoque other = (Estoque) obj;
		if (assinaturaDigitalRegistro == null) {
			if (other.assinaturaDigitalRegistro != null)
				return false;
		} else if (!assinaturaDigitalRegistro.equals(other.assinaturaDigitalRegistro))
			return false;
		if (dataCarga == null) {
			if (other.dataCarga != null)
				return false;
		} else if (!dataCarga.equals(other.dataCarga))
			return false;
		if (deposito == null) {
			if (other.deposito != null)
				return false;
		} else if (!deposito.equals(other.deposito))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (qtde == null) {
			if (other.qtde != null)
				return false;
		} else if (!qtde.equals(other.qtde))
			return false;
		if (roteadorEnvou == null) {
			if (other.roteadorEnvou != null)
				return false;
		} else if (!roteadorEnvou.equals(other.roteadorEnvou))
			return false;
		if (roteadorPuxou == null) {
			if (other.roteadorPuxou != null)
				return false;
		} else if (!roteadorPuxou.equals(other.roteadorPuxou))
			return false;
		return true;
	}
}
