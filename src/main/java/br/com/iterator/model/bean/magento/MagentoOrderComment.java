package br.com.iterator.model.bean.magento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MagentoOrderComment implements Serializable {

	private static final long serialVersionUID = -3153872988005099933L;
	
	@JsonProperty("is_customer_notified")
	private Integer isCustomerNotified;
	@JsonProperty("is_visible_on_front")
	private Integer isVisibleOnFront;
	private String comment;
	private String status;
	@JsonProperty("created_at")
	private String createdAt;
	
	public Integer getIsCustomerNotified() {
		return isCustomerNotified;
	}
	
	public void setIsCustomerNotified(Integer isCustomerNotified) {
		this.isCustomerNotified = isCustomerNotified;
	}

	public Integer getIsVisibleOnFront() {
		return isVisibleOnFront;
	}

	public void setIsVisibleOnFront(Integer isVisibleOnFront) {
		this.isVisibleOnFront = isVisibleOnFront;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((isCustomerNotified == null) ? 0 : isCustomerNotified.hashCode());
		result = prime * result + ((isVisibleOnFront == null) ? 0 : isVisibleOnFront.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		MagentoOrderComment other = (MagentoOrderComment) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (isCustomerNotified == null) {
			if (other.isCustomerNotified != null)
				return false;
		} else if (!isCustomerNotified.equals(other.isCustomerNotified))
			return false;
		if (isVisibleOnFront == null) {
			if (other.isVisibleOnFront != null)
				return false;
		} else if (!isVisibleOnFront.equals(other.isVisibleOnFront))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
}
