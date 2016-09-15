package br.com.iterator.model.bean.magento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MagentoCustomer implements Serializable {

	private static final long serialVersionUID = 246027137930390517L;
	
	@JsonProperty("entity_id")
	private Integer entityId;
	@JsonProperty("website_id")
	private Integer websiteId;
	private String email;
	@JsonProperty("group_id")
	private Integer groupId;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("disable_auto_group_change")
	private Integer disableAutoGroupChange;
	private String firstname;
	private String lastname;
	@JsonProperty("created_in")
	private String createdIn;
	private String suffix;
	private String taxvat;
	private String ie;
	private Integer gender;
	private String dob;
	
	public String getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public Integer getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(Integer websiteId) {
		this.websiteId = websiteId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getDisableAutoGroupChange() {
		return disableAutoGroupChange;
	}

	public void setDisableAutoGroupChange(Integer disableAutoGroupChange) {
		this.disableAutoGroupChange = disableAutoGroupChange;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCreatedIn() {
		return createdIn;
	}

	public void setCreatedIn(String createdIn) {
		this.createdIn = createdIn;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getTaxvat() {
		return taxvat;
	}

	public void setTaxvat(String taxvat) {
		this.taxvat = taxvat;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((createdIn == null) ? 0 : createdIn.hashCode());
		result = prime * result + ((disableAutoGroupChange == null) ? 0 : disableAutoGroupChange.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((ie == null) ? 0 : ie.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((suffix == null) ? 0 : suffix.hashCode());
		result = prime * result + ((taxvat == null) ? 0 : taxvat.hashCode());
		result = prime * result + ((websiteId == null) ? 0 : websiteId.hashCode());
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
		MagentoCustomer other = (MagentoCustomer) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (createdIn == null) {
			if (other.createdIn != null)
				return false;
		} else if (!createdIn.equals(other.createdIn))
			return false;
		if (disableAutoGroupChange == null) {
			if (other.disableAutoGroupChange != null)
				return false;
		} else if (!disableAutoGroupChange.equals(other.disableAutoGroupChange))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (entityId == null) {
			if (other.entityId != null)
				return false;
		} else if (!entityId.equals(other.entityId))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (ie == null) {
			if (other.ie != null)
				return false;
		} else if (!ie.equals(other.ie))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (suffix == null) {
			if (other.suffix != null)
				return false;
		} else if (!suffix.equals(other.suffix))
			return false;
		if (taxvat == null) {
			if (other.taxvat != null)
				return false;
		} else if (!taxvat.equals(other.taxvat))
			return false;
		if (websiteId == null) {
			if (other.websiteId != null)
				return false;
		} else if (!websiteId.equals(other.websiteId))
			return false;
		return true;
	}
}
