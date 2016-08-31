package br.com.iterator.model.bean.magento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true) // Utilizado para ignorar alguns atributos não utilizados como group_price.
public class MagentoProduct implements Serializable {
	
	private static final long serialVersionUID = -3118212496807952287L;
	
	@JsonProperty("entity_id")
	private Integer entityId;
	@JsonProperty("type_id")
	private String typeId;
	@JsonProperty("attribute_set_id")
	private Integer attributeSetId;
	private String sku;
	private String name;
	@JsonProperty("meta_title")
	private String metaTitle;
	@JsonProperty("meta_description")
	private String metaDescription;
	@JsonProperty("url_key")
	private String urlKey;
	@JsonProperty("custom_design")
	private String customDesign;
	@JsonProperty("page_layout")
	private String pageLayout;
	@JsonProperty("options_container")
	private String optionsContainer;
	@JsonProperty("country_of_manufacture")
	private String countryOfManufacture;
	@JsonProperty("msrp_enabled")
	private Integer mrspEnabled;
	@JsonProperty("msrp_display_actual_price_type")
	private Integer mrspDisplayActualPriceType;
	@JsonProperty("gift_message_available")
	private Integer giftMessageAvailable;
	private Double price;
	@JsonProperty("special_price")
	private Double specialPrice;
	private Double weight;
	private String msrp;
	private Integer status;
	private Integer visibility;
	@JsonProperty("enable_googlecheckout")
	private Integer enableGooglecheckout;
	@JsonProperty("tax_class_id")
	private Integer taxClassId;
	private String description;
	@JsonProperty("short_description")
	private String shortDescription;
	@JsonProperty("meta_keyword")
	private String metaKeyword;
	@JsonProperty("custom_layout_update")
	private String customLayoutUpdate;
	@JsonProperty("special_from_date")
	private String specialFromDate;
	@JsonProperty("special_to_date")
	private String specialToDate;
	@JsonProperty("news_from_date")
	private String newsFromDate;
	@JsonProperty("news_to_date")
	private String newsToDate;
	@JsonProperty("custom_design_from")
	private String customDesignFrom;
	@JsonProperty("custom_design_to")
	private String customDesignTo;
	private String color;
	private String peso;
	private String volume;
	private String quantidade;
	private String size;
	private String saco;
	private String caixa;
	private String comprimento;
	private String voltagem;
	@JsonProperty("volume_comprimento")
	private Double volumeComprimento;
	@JsonProperty("volume_altura")
	private Double volumeAltura;
	@JsonProperty("volume_largura")
	private Double volumeLargura;
	
	public Integer getEntityId() {
		return entityId;
	}
	
	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}
	
	public String getTypeId() {
		return typeId;
	}
	
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	
	public Integer getAttributeSetId() {
		return attributeSetId;
	}
	
	public void setAttributeSetId(Integer attributeSetId) {
		this.attributeSetId = attributeSetId;
	}
	
	public String getSku() {
		return sku;
	}
	
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMetaTitle() {
		return metaTitle;
	}
	
	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}
	
	public String getMetaDescription() {
		return metaDescription;
	}
	
	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}
	
	public String getUrlKey() {
		return urlKey;
	}
	
	public void setUrlKey(String urlKey) {
		this.urlKey = urlKey;
	}
	
	public String getCustomDesign() {
		return customDesign;
	}
	
	public void setCustomDesign(String customDesign) {
		this.customDesign = customDesign;
	}
	
	public String getPageLayout() {
		return pageLayout;
	}
	
	public void setPageLayout(String pageLayout) {
		this.pageLayout = pageLayout;
	}
	
	public String getOptionsContainer() {
		return optionsContainer;
	}
	
	public void setOptionsContainer(String optionsContainer) {
		this.optionsContainer = optionsContainer;
	}
	
	public String getCountryOfManufacture() {
		return countryOfManufacture;
	}
	
	public void setCountryOfManufacture(String countryOfManufacture) {
		this.countryOfManufacture = countryOfManufacture;
	}
	
	public Integer getMrspEnabled() {
		return mrspEnabled;
	}
	
	public void setMrspEnabled(Integer mrspEnabled) {
		this.mrspEnabled = mrspEnabled;
	}
	
	public Integer getMrspDisplayActualPriceType() {
		return mrspDisplayActualPriceType;
	}
	
	public void setMrspDisplayActualPriceType(Integer mrspDisplayActualPriceType) {
		this.mrspDisplayActualPriceType = mrspDisplayActualPriceType;
	}
	
	public Integer getGiftMessageAvailable() {
		return giftMessageAvailable;
	}
	
	public void setGiftMessageAvailable(Integer giftMessageAvailable) {
		this.giftMessageAvailable = giftMessageAvailable;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getSpecialPrice() {
		return specialPrice;
	}
	
	public void setSpecialPrice(Double specialPrice) {
		this.specialPrice = specialPrice;
	}
	
	public Double getWeight() {
		return weight;
	}
	
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	public String getMsrp() {
		return msrp;
	}
	
	public void setMsrp(String msrp) {
		this.msrp = msrp;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getVisibility() {
		return visibility;
	}
	
	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}
	
	public Integer getEnableGooglecheckout() {
		return enableGooglecheckout;
	}
	
	public void setEnableGooglecheckout(Integer enableGooglecheckout) {
		this.enableGooglecheckout = enableGooglecheckout;
	}
	
	public Integer getTaxClassId() {
		return taxClassId;
	}
	
	public void setTaxClassId(Integer taxClassId) {
		this.taxClassId = taxClassId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getShortDescription() {
		return shortDescription;
	}
	
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	public String getMetaKeyword() {
		return metaKeyword;
	}
	
	public void setMetaKeyword(String metaKeyword) {
		this.metaKeyword = metaKeyword;
	}
	
	public String getCustomLayoutUpdate() {
		return customLayoutUpdate;
	}
	
	public void setCustomLayoutUpdate(String customLayoutUpdate) {
		this.customLayoutUpdate = customLayoutUpdate;
	}
	
	public String getSpecialFromDate() {
		return specialFromDate;
	}
	
	public void setSpecialFromDate(String specialFromDate) {
		this.specialFromDate = specialFromDate;
	}
	
	public String getSpecialToDate() {
		return specialToDate;
	}
	
	public void setSpecialToDate(String specialToDate) {
		this.specialToDate = specialToDate;
	}
	
	public String getNewsFromDate() {
		return newsFromDate;
	}
	
	public void setNewsFromDate(String newsFromDate) {
		this.newsFromDate = newsFromDate;
	}
	
	public String getNewsToDate() {
		return newsToDate;
	}
	
	public void setNewsToDate(String newsToDate) {
		this.newsToDate = newsToDate;
	}
	
	public String getCustomDesignFrom() {
		return customDesignFrom;
	}
	
	public void setCustomDesignFrom(String customDesignFrom) {
		this.customDesignFrom = customDesignFrom;
	}
	
	public String getCustomDesignTo() {
		return customDesignTo;
	}
	
	public void setCustomDesignTo(String customDesignTo) {
		this.customDesignTo = customDesignTo;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getPeso() {
		return peso;
	}
	
	public void setPeso(String peso) {
		this.peso = peso;
	}
	
	public String getVolume() {
		return volume;
	}
	
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	public String getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public String getSaco() {
		return saco;
	}
	
	public void setSaco(String saco) {
		this.saco = saco;
	}
	
	public String getCaixa() {
		return caixa;
	}
	
	public void setCaixa(String caixa) {
		this.caixa = caixa;
	}
	
	public String getComprimento() {
		return comprimento;
	}
	
	public void setComprimento(String comprimento) {
		this.comprimento = comprimento;
	}
	
	public String getVoltagem() {
		return voltagem;
	}
	
	public void setVoltagem(String voltagem) {
		this.voltagem = voltagem;
	}
	
	public Double getVolumeComprimento() {
		return volumeComprimento;
	}
	
	public void setVolumeComprimento(Double volumeComprimento) {
		this.volumeComprimento = volumeComprimento;
	}
	
	public Double getVolumeAltura() {
		return volumeAltura;
	}
	
	public void setVolumeAltura(Double volumeAltura) {
		this.volumeAltura = volumeAltura;
	}
	
	public Double getVolumeLargura() {
		return volumeLargura;
	}
	
	public void setVolumeLargura(Double volumeLargura) {
		this.volumeLargura = volumeLargura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributeSetId == null) ? 0 : attributeSetId.hashCode());
		result = prime * result + ((caixa == null) ? 0 : caixa.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((comprimento == null) ? 0 : comprimento.hashCode());
		result = prime * result + ((countryOfManufacture == null) ? 0 : countryOfManufacture.hashCode());
		result = prime * result + ((customDesign == null) ? 0 : customDesign.hashCode());
		result = prime * result + ((customDesignFrom == null) ? 0 : customDesignFrom.hashCode());
		result = prime * result + ((customDesignTo == null) ? 0 : customDesignTo.hashCode());
		result = prime * result + ((customLayoutUpdate == null) ? 0 : customLayoutUpdate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((enableGooglecheckout == null) ? 0 : enableGooglecheckout.hashCode());
		result = prime * result + ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result + ((giftMessageAvailable == null) ? 0 : giftMessageAvailable.hashCode());
		result = prime * result + ((metaDescription == null) ? 0 : metaDescription.hashCode());
		result = prime * result + ((metaKeyword == null) ? 0 : metaKeyword.hashCode());
		result = prime * result + ((metaTitle == null) ? 0 : metaTitle.hashCode());
		result = prime * result + ((mrspDisplayActualPriceType == null) ? 0 : mrspDisplayActualPriceType.hashCode());
		result = prime * result + ((mrspEnabled == null) ? 0 : mrspEnabled.hashCode());
		result = prime * result + ((msrp == null) ? 0 : msrp.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((newsFromDate == null) ? 0 : newsFromDate.hashCode());
		result = prime * result + ((newsToDate == null) ? 0 : newsToDate.hashCode());
		result = prime * result + ((optionsContainer == null) ? 0 : optionsContainer.hashCode());
		result = prime * result + ((pageLayout == null) ? 0 : pageLayout.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((saco == null) ? 0 : saco.hashCode());
		result = prime * result + ((shortDescription == null) ? 0 : shortDescription.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		result = prime * result + ((specialFromDate == null) ? 0 : specialFromDate.hashCode());
		result = prime * result + ((specialPrice == null) ? 0 : specialPrice.hashCode());
		result = prime * result + ((specialToDate == null) ? 0 : specialToDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((taxClassId == null) ? 0 : taxClassId.hashCode());
		result = prime * result + ((typeId == null) ? 0 : typeId.hashCode());
		result = prime * result + ((urlKey == null) ? 0 : urlKey.hashCode());
		result = prime * result + ((visibility == null) ? 0 : visibility.hashCode());
		result = prime * result + ((voltagem == null) ? 0 : voltagem.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
		result = prime * result + ((volumeAltura == null) ? 0 : volumeAltura.hashCode());
		result = prime * result + ((volumeComprimento == null) ? 0 : volumeComprimento.hashCode());
		result = prime * result + ((volumeLargura == null) ? 0 : volumeLargura.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		MagentoProduct other = (MagentoProduct) obj;
		if (attributeSetId == null) {
			if (other.attributeSetId != null)
				return false;
		} else if (!attributeSetId.equals(other.attributeSetId))
			return false;
		if (caixa == null) {
			if (other.caixa != null)
				return false;
		} else if (!caixa.equals(other.caixa))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (comprimento == null) {
			if (other.comprimento != null)
				return false;
		} else if (!comprimento.equals(other.comprimento))
			return false;
		if (countryOfManufacture == null) {
			if (other.countryOfManufacture != null)
				return false;
		} else if (!countryOfManufacture.equals(other.countryOfManufacture))
			return false;
		if (customDesign == null) {
			if (other.customDesign != null)
				return false;
		} else if (!customDesign.equals(other.customDesign))
			return false;
		if (customDesignFrom == null) {
			if (other.customDesignFrom != null)
				return false;
		} else if (!customDesignFrom.equals(other.customDesignFrom))
			return false;
		if (customDesignTo == null) {
			if (other.customDesignTo != null)
				return false;
		} else if (!customDesignTo.equals(other.customDesignTo))
			return false;
		if (customLayoutUpdate == null) {
			if (other.customLayoutUpdate != null)
				return false;
		} else if (!customLayoutUpdate.equals(other.customLayoutUpdate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (enableGooglecheckout == null) {
			if (other.enableGooglecheckout != null)
				return false;
		} else if (!enableGooglecheckout.equals(other.enableGooglecheckout))
			return false;
		if (entityId == null) {
			if (other.entityId != null)
				return false;
		} else if (!entityId.equals(other.entityId))
			return false;
		if (giftMessageAvailable == null) {
			if (other.giftMessageAvailable != null)
				return false;
		} else if (!giftMessageAvailable.equals(other.giftMessageAvailable))
			return false;
		if (metaDescription == null) {
			if (other.metaDescription != null)
				return false;
		} else if (!metaDescription.equals(other.metaDescription))
			return false;
		if (metaKeyword == null) {
			if (other.metaKeyword != null)
				return false;
		} else if (!metaKeyword.equals(other.metaKeyword))
			return false;
		if (metaTitle == null) {
			if (other.metaTitle != null)
				return false;
		} else if (!metaTitle.equals(other.metaTitle))
			return false;
		if (mrspDisplayActualPriceType == null) {
			if (other.mrspDisplayActualPriceType != null)
				return false;
		} else if (!mrspDisplayActualPriceType.equals(other.mrspDisplayActualPriceType))
			return false;
		if (mrspEnabled == null) {
			if (other.mrspEnabled != null)
				return false;
		} else if (!mrspEnabled.equals(other.mrspEnabled))
			return false;
		if (msrp == null) {
			if (other.msrp != null)
				return false;
		} else if (!msrp.equals(other.msrp))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (newsFromDate == null) {
			if (other.newsFromDate != null)
				return false;
		} else if (!newsFromDate.equals(other.newsFromDate))
			return false;
		if (newsToDate == null) {
			if (other.newsToDate != null)
				return false;
		} else if (!newsToDate.equals(other.newsToDate))
			return false;
		if (optionsContainer == null) {
			if (other.optionsContainer != null)
				return false;
		} else if (!optionsContainer.equals(other.optionsContainer))
			return false;
		if (pageLayout == null) {
			if (other.pageLayout != null)
				return false;
		} else if (!pageLayout.equals(other.pageLayout))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (saco == null) {
			if (other.saco != null)
				return false;
		} else if (!saco.equals(other.saco))
			return false;
		if (shortDescription == null) {
			if (other.shortDescription != null)
				return false;
		} else if (!shortDescription.equals(other.shortDescription))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		if (specialFromDate == null) {
			if (other.specialFromDate != null)
				return false;
		} else if (!specialFromDate.equals(other.specialFromDate))
			return false;
		if (specialPrice == null) {
			if (other.specialPrice != null)
				return false;
		} else if (!specialPrice.equals(other.specialPrice))
			return false;
		if (specialToDate == null) {
			if (other.specialToDate != null)
				return false;
		} else if (!specialToDate.equals(other.specialToDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (taxClassId == null) {
			if (other.taxClassId != null)
				return false;
		} else if (!taxClassId.equals(other.taxClassId))
			return false;
		if (typeId == null) {
			if (other.typeId != null)
				return false;
		} else if (!typeId.equals(other.typeId))
			return false;
		if (urlKey == null) {
			if (other.urlKey != null)
				return false;
		} else if (!urlKey.equals(other.urlKey))
			return false;
		if (visibility == null) {
			if (other.visibility != null)
				return false;
		} else if (!visibility.equals(other.visibility))
			return false;
		if (voltagem == null) {
			if (other.voltagem != null)
				return false;
		} else if (!voltagem.equals(other.voltagem))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		if (volumeAltura == null) {
			if (other.volumeAltura != null)
				return false;
		} else if (!volumeAltura.equals(other.volumeAltura))
			return false;
		if (volumeComprimento == null) {
			if (other.volumeComprimento != null)
				return false;
		} else if (!volumeComprimento.equals(other.volumeComprimento))
			return false;
		if (volumeLargura == null) {
			if (other.volumeLargura != null)
				return false;
		} else if (!volumeLargura.equals(other.volumeLargura))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
}
