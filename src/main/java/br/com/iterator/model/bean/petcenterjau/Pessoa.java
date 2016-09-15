package br.com.iterator.model.bean.petcenterjau;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 3152704358904824022L;
	
	@Id
	@Column(name="Codigo")
	private Integer codigo;
	@Column(name="Nome")
	private String nome;
	@Column(name="Tipo")
	private String tipo;
	@Column(name="CPF")
	private String cpf;
	@Column(name="RG")
	private String rg;
	@Column(name="Data_Nasc")
	private Date dataNasc;
	@Column(name="Usuario")
	private Integer usuario;
	@Column(name="Endereco_Nome")
	private String enderecoNome;
	@Column(name="DDD1")
	private String ddd1;
	@Column(name="Fone_Numero")
	private String foneNumero;
	@Column(name="Numero")
	private String numero;
	@Column(name="Cidade")
	private Integer cidade;
	@Column(name="Bairro")
	private String bairro;
	@Column(name="Cep")
	private String cep;
	@Column(name="Inativo")
	private String inativo;
	@Column(name="Data_Carga")
	private Date dataCarga;
	@Column(name="Data_Cadastro")
	private Date dataCadastro;
	@Column(name="Email")
	private String email;
	@Column(name="Vender_Preco_Custo")
	private String venderPrecoCusto;
	@Column(name="Bloquear_Crediario")
	private String bloquearCreadiario;
	@Column(name="Vender_Taxa_Grupo")
	private String venderTaxaGrupo;
	@Column(name="Conta_Particular")
	private String contaParticular;
	@Column(name="Duplicata")
	private String duplicata;
	@Column(name="Data_Alteracao")
	private Date dataAlteracao;
	@Column(name="Impagavel")
	private String impagavel;
	@Column(name="Bloquear_Venda_Cheque")
	private String bloquearVendaCheque;
	@Column(name="Sexo")
	private String sexo;
	@Column(name="Bloquear_Consignacao")
	private String bloquearConsignacao;
	@Column(name="Frete_Padrao")
	private Double fretePadrao;
	@Column(name="Bloquear_Vender_Orcamento")
	private String bloquearVenderOrcamento;
	@Column(name="Exibir_Observacao")
	private String exibirObservacao;
	@Column(name="Bloquear_Venda_Dinheiro")
	private String bloquearVendaDinheiro;
	@Column(name="Complemento")
	private String complemento;
	@Column(name="Bloquear_Venda_Sem_KM")
	private String bloquearVendaSemKm;
	@Column(name="Empresa_Origem")
	private Integer empresaOrigem;
	@Column(name="Bloquear_Ticket")
	private String bloquearTicekt;
	@Column(name="Bloquear_Cartao")
	private String bloquearCartao;
	@Column(name="Contribuinte_ICMS")
	private String contribuinteIcms;
	@Column(name="Emails_Promocionais")
	private String emailsPromocionais;
	@Column(name="Tipo_Conta_Corrente")
	private String tipoContaCorrente;
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public String getEnderecoNome() {
		return enderecoNome;
	}

	public void setEnderecoNome(String enderecoNome) {
		this.enderecoNome = enderecoNome;
	}

	public String getDdd1() {
		return ddd1;
	}

	public void setDdd1(String ddd1) {
		this.ddd1 = ddd1;
	}

	public String getFoneNumero() {
		return foneNumero;
	}

	public void setFoneNumero(String foneNumero) {
		this.foneNumero = foneNumero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getCidade() {
		return cidade;
	}

	public void setCidade(Integer cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getInativo() {
		return inativo;
	}

	public void setInativo(String inativo) {
		this.inativo = inativo;
	}

	public Date getDataCarga() {
		return dataCarga;
	}

	public void setDataCarga(Date dataCarga) {
		this.dataCarga = dataCarga;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVenderPrecoCusto() {
		return venderPrecoCusto;
	}

	public void setVenderPrecoCusto(String venderPrecoCusto) {
		this.venderPrecoCusto = venderPrecoCusto;
	}

	public String getBloquearCreadiario() {
		return bloquearCreadiario;
	}

	public void setBloquearCreadiario(String bloquearCreadiario) {
		this.bloquearCreadiario = bloquearCreadiario;
	}

	public String getVenderTaxaGrupo() {
		return venderTaxaGrupo;
	}

	public void setVenderTaxaGrupo(String venderTaxaGrupo) {
		this.venderTaxaGrupo = venderTaxaGrupo;
	}

	public String getContaParticular() {
		return contaParticular;
	}

	public void setContaParticular(String contaParticular) {
		this.contaParticular = contaParticular;
	}

	public String getDuplicata() {
		return duplicata;
	}

	public void setDuplicata(String duplicata) {
		this.duplicata = duplicata;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getImpagavel() {
		return impagavel;
	}

	public void setImpagavel(String impagavel) {
		this.impagavel = impagavel;
	}

	public String getBloquearVendaCheque() {
		return bloquearVendaCheque;
	}

	public void setBloquearVendaCheque(String bloquearVendaCheque) {
		this.bloquearVendaCheque = bloquearVendaCheque;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getBloquearConsignacao() {
		return bloquearConsignacao;
	}

	public void setBloquearConsignacao(String bloquearConsignacao) {
		this.bloquearConsignacao = bloquearConsignacao;
	}

	public Double getFretePadrao() {
		return fretePadrao;
	}

	public void setFretePadrao(Double fretePadrao) {
		this.fretePadrao = fretePadrao;
	}

	public String getBloquearVenderOrcamento() {
		return bloquearVenderOrcamento;
	}

	public void setBloquearVenderOrcamento(String bloquearVenderOrcamento) {
		this.bloquearVenderOrcamento = bloquearVenderOrcamento;
	}

	public String getExibirObservacao() {
		return exibirObservacao;
	}

	public void setExibirObservacao(String exibirObservacao) {
		this.exibirObservacao = exibirObservacao;
	}

	public String getBloquearVendaDinheiro() {
		return bloquearVendaDinheiro;
	}

	public void setBloquearVendaDinheiro(String bloquearVendaDinheiro) {
		this.bloquearVendaDinheiro = bloquearVendaDinheiro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBloquearVendaSemKm() {
		return bloquearVendaSemKm;
	}

	public void setBloquearVendaSemKm(String bloquearVendaSemKm) {
		this.bloquearVendaSemKm = bloquearVendaSemKm;
	}

	public Integer getEmpresaOrigem() {
		return empresaOrigem;
	}

	public void setEmpresaOrigem(Integer empresaOrigem) {
		this.empresaOrigem = empresaOrigem;
	}

	public String getBloquearTicekt() {
		return bloquearTicekt;
	}

	public void setBloquearTicekt(String bloquearTicekt) {
		this.bloquearTicekt = bloquearTicekt;
	}

	public String getBloquearCartao() {
		return bloquearCartao;
	}

	public void setBloquearCartao(String bloquearCartao) {
		this.bloquearCartao = bloquearCartao;
	}

	public String getContribuinteIcms() {
		return contribuinteIcms;
	}

	public void setContribuinteIcms(String contribuinteIcms) {
		this.contribuinteIcms = contribuinteIcms;
	}

	public String getEmailsPromocionais() {
		return emailsPromocionais;
	}

	public void setEmailsPromocionais(String emailsPromocionais) {
		this.emailsPromocionais = emailsPromocionais;
	}

	public String getTipoContaCorrente() {
		return tipoContaCorrente;
	}

	public void setTipoContaCorrente(String tipoContaCorrente) {
		this.tipoContaCorrente = tipoContaCorrente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((bloquearCartao == null) ? 0 : bloquearCartao.hashCode());
		result = prime * result + ((bloquearConsignacao == null) ? 0 : bloquearConsignacao.hashCode());
		result = prime * result + ((bloquearCreadiario == null) ? 0 : bloquearCreadiario.hashCode());
		result = prime * result + ((bloquearTicekt == null) ? 0 : bloquearTicekt.hashCode());
		result = prime * result + ((bloquearVendaCheque == null) ? 0 : bloquearVendaCheque.hashCode());
		result = prime * result + ((bloquearVendaDinheiro == null) ? 0 : bloquearVendaDinheiro.hashCode());
		result = prime * result + ((bloquearVendaSemKm == null) ? 0 : bloquearVendaSemKm.hashCode());
		result = prime * result + ((bloquearVenderOrcamento == null) ? 0 : bloquearVenderOrcamento.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((contaParticular == null) ? 0 : contaParticular.hashCode());
		result = prime * result + ((contribuinteIcms == null) ? 0 : contribuinteIcms.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataAlteracao == null) ? 0 : dataAlteracao.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((dataCarga == null) ? 0 : dataCarga.hashCode());
		result = prime * result + ((dataNasc == null) ? 0 : dataNasc.hashCode());
		result = prime * result + ((ddd1 == null) ? 0 : ddd1.hashCode());
		result = prime * result + ((duplicata == null) ? 0 : duplicata.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((emailsPromocionais == null) ? 0 : emailsPromocionais.hashCode());
		result = prime * result + ((empresaOrigem == null) ? 0 : empresaOrigem.hashCode());
		result = prime * result + ((enderecoNome == null) ? 0 : enderecoNome.hashCode());
		result = prime * result + ((exibirObservacao == null) ? 0 : exibirObservacao.hashCode());
		result = prime * result + ((foneNumero == null) ? 0 : foneNumero.hashCode());
		result = prime * result + ((fretePadrao == null) ? 0 : fretePadrao.hashCode());
		result = prime * result + ((impagavel == null) ? 0 : impagavel.hashCode());
		result = prime * result + ((inativo == null) ? 0 : inativo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((tipoContaCorrente == null) ? 0 : tipoContaCorrente.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((venderPrecoCusto == null) ? 0 : venderPrecoCusto.hashCode());
		result = prime * result + ((venderTaxaGrupo == null) ? 0 : venderTaxaGrupo.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (bloquearCartao == null) {
			if (other.bloquearCartao != null)
				return false;
		} else if (!bloquearCartao.equals(other.bloquearCartao))
			return false;
		if (bloquearConsignacao == null) {
			if (other.bloquearConsignacao != null)
				return false;
		} else if (!bloquearConsignacao.equals(other.bloquearConsignacao))
			return false;
		if (bloquearCreadiario == null) {
			if (other.bloquearCreadiario != null)
				return false;
		} else if (!bloquearCreadiario.equals(other.bloquearCreadiario))
			return false;
		if (bloquearTicekt == null) {
			if (other.bloquearTicekt != null)
				return false;
		} else if (!bloquearTicekt.equals(other.bloquearTicekt))
			return false;
		if (bloquearVendaCheque == null) {
			if (other.bloquearVendaCheque != null)
				return false;
		} else if (!bloquearVendaCheque.equals(other.bloquearVendaCheque))
			return false;
		if (bloquearVendaDinheiro == null) {
			if (other.bloquearVendaDinheiro != null)
				return false;
		} else if (!bloquearVendaDinheiro.equals(other.bloquearVendaDinheiro))
			return false;
		if (bloquearVendaSemKm == null) {
			if (other.bloquearVendaSemKm != null)
				return false;
		} else if (!bloquearVendaSemKm.equals(other.bloquearVendaSemKm))
			return false;
		if (bloquearVenderOrcamento == null) {
			if (other.bloquearVenderOrcamento != null)
				return false;
		} else if (!bloquearVenderOrcamento.equals(other.bloquearVenderOrcamento))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (contaParticular == null) {
			if (other.contaParticular != null)
				return false;
		} else if (!contaParticular.equals(other.contaParticular))
			return false;
		if (contribuinteIcms == null) {
			if (other.contribuinteIcms != null)
				return false;
		} else if (!contribuinteIcms.equals(other.contribuinteIcms))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataAlteracao == null) {
			if (other.dataAlteracao != null)
				return false;
		} else if (!dataAlteracao.equals(other.dataAlteracao))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (dataCarga == null) {
			if (other.dataCarga != null)
				return false;
		} else if (!dataCarga.equals(other.dataCarga))
			return false;
		if (dataNasc == null) {
			if (other.dataNasc != null)
				return false;
		} else if (!dataNasc.equals(other.dataNasc))
			return false;
		if (ddd1 == null) {
			if (other.ddd1 != null)
				return false;
		} else if (!ddd1.equals(other.ddd1))
			return false;
		if (duplicata == null) {
			if (other.duplicata != null)
				return false;
		} else if (!duplicata.equals(other.duplicata))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emailsPromocionais == null) {
			if (other.emailsPromocionais != null)
				return false;
		} else if (!emailsPromocionais.equals(other.emailsPromocionais))
			return false;
		if (empresaOrigem == null) {
			if (other.empresaOrigem != null)
				return false;
		} else if (!empresaOrigem.equals(other.empresaOrigem))
			return false;
		if (enderecoNome == null) {
			if (other.enderecoNome != null)
				return false;
		} else if (!enderecoNome.equals(other.enderecoNome))
			return false;
		if (exibirObservacao == null) {
			if (other.exibirObservacao != null)
				return false;
		} else if (!exibirObservacao.equals(other.exibirObservacao))
			return false;
		if (foneNumero == null) {
			if (other.foneNumero != null)
				return false;
		} else if (!foneNumero.equals(other.foneNumero))
			return false;
		if (fretePadrao == null) {
			if (other.fretePadrao != null)
				return false;
		} else if (!fretePadrao.equals(other.fretePadrao))
			return false;
		if (impagavel == null) {
			if (other.impagavel != null)
				return false;
		} else if (!impagavel.equals(other.impagavel))
			return false;
		if (inativo == null) {
			if (other.inativo != null)
				return false;
		} else if (!inativo.equals(other.inativo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (tipoContaCorrente == null) {
			if (other.tipoContaCorrente != null)
				return false;
		} else if (!tipoContaCorrente.equals(other.tipoContaCorrente))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (venderPrecoCusto == null) {
			if (other.venderPrecoCusto != null)
				return false;
		} else if (!venderPrecoCusto.equals(other.venderPrecoCusto))
			return false;
		if (venderTaxaGrupo == null) {
			if (other.venderTaxaGrupo != null)
				return false;
		} else if (!venderTaxaGrupo.equals(other.venderTaxaGrupo))
			return false;
		return true;
	}
}
