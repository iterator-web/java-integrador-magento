package br.com.iterator.model.bean.magento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MagentoAttribute implements Serializable {
	
	private static final long serialVersionUID = -1739252687897470536L;
	
	@JsonProperty("attribute_id")
	private Integer attributeId;
	@JsonProperty("attribute_code")
	private String attributeCode;
	@JsonProperty("frontend_label")
	private String frontendLabel;
	
	public Integer getAttributeId() {
		return attributeId;
	}
	
	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}
	
	public String getAttributeCode() {
		return attributeCode;
	}
	
	public void setAttributeCode(String attributeCode) {
		this.attributeCode = attributeCode;
	}
	
	public String getFrontendLabel() {
		return frontendLabel;
	}
	
	public void setFrontendLabel(String frontendLabel) {
		this.frontendLabel = frontendLabel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributeCode == null) ? 0 : attributeCode.hashCode());
		result = prime * result + ((attributeId == null) ? 0 : attributeId.hashCode());
		result = prime * result + ((frontendLabel == null) ? 0 : frontendLabel.hashCode());
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
		MagentoAttribute other = (MagentoAttribute) obj;
		if (attributeCode == null) {
			if (other.attributeCode != null)
				return false;
		} else if (!attributeCode.equals(other.attributeCode))
			return false;
		if (attributeId == null) {
			if (other.attributeId != null)
				return false;
		} else if (!attributeId.equals(other.attributeId))
			return false;
		if (frontendLabel == null) {
			if (other.frontendLabel != null)
				return false;
		} else if (!frontendLabel.equals(other.frontendLabel))
			return false;
		return true;
	}
}
