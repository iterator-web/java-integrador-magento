package br.com.iterator.model.bean.magento;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MagentoOrder implements Serializable {

	private static final long serialVersionUID = 524773454075307902L;
	
	@JsonProperty("entity_id")
	private Integer entityId;
	private String status;
	@JsonProperty("coupon_code")
	private String couponCode;
	@JsonProperty("shipping_description")
	private String shippingDescription;
	@JsonProperty("customer_id")
	private Integer customerId;
	@JsonProperty("base_discount_amount")
	private Double baseDiscountAmount;
	@JsonProperty("base_grand_total")
	private Double baseGrandTotal;
	@JsonProperty("base_shipping_amount")
	private Double baseShippingAmount;
	@JsonProperty("base_shipping_tax_amount")
	private Double baseShippingTaxAmount;
	@JsonProperty("base_subtotal")
	private Double baseSubtotal;
	@JsonProperty("base_tax_amount")
	private Double baseTaxAmount;
	@JsonProperty("base_total_paid")
	private Double baseTotalPaid;
	@JsonProperty("base_total_refunded")
	private Double baseTotalRefunded;
	@JsonProperty("discount_amount")
	private Double discountAmount;
	@JsonProperty("grand_total")
	private Double grandTotal;
	@JsonProperty("shipping_amount")
	private Double shippingAmount;
	@JsonProperty("shipping_tax_amount")
	private Double shippingTaxAmount;
	@JsonProperty("store_to_order_rate")
	private Double storeToOrderRate;
	private Double subtotal;
	@JsonProperty("tax_amount")
	private Double taxAmount;
	@JsonProperty("total_paid")
	private Double totalPaid;
	@JsonProperty("total_refunded")
	private Double totalRefunded;
	@JsonProperty("base_shipping_discount_amount")
	private Double baseShippingDiscountAmount;
	@JsonProperty("base_subtotal_incl_tax")
	private Double baseSubtotalInclTax;
	@JsonProperty("base_total_due")
	private Double baseTotalDue;
	@JsonProperty("shipping_discount_amount")
	private Double shippingDiscountAmount;
	@JsonProperty("subtotal_incl_tax")
	private Double subtotalInclTax;
	@JsonProperty("total_due")
	private Double totalDue;
	@JsonProperty("increment_id")
	private String incrementId;
	@JsonProperty("base_currency_code")
	private String baseCurrencyCode;
	@JsonProperty("discount_description")
	private String discountDescription;
	@JsonProperty("ext_order_id")
	private String extOrderId;
	@JsonProperty("remote_ip")
	private String remoteIp;
	@JsonProperty("store_currency_code")
	private String storeCurrencyCode;
	@JsonProperty("store_name")
	private String storeName;
	@JsonProperty("customer_note")
	private String customerNote;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("shipping_incl_tax")
	private Double shippingInclTax;
	@JsonProperty("payment_method")
	private String paymentMethod;
	@JsonProperty("gift_message_from")
	private String giftMessageFrom;
	@JsonProperty("gift_message_to")
	private String giftMessageTo;
	@JsonProperty("gift_message_body")
	private String giftMessageBody;
	@JsonProperty("tax_name")
	private String taxName;
	@JsonProperty("tax_rate")
	private String taxRate;
	private List<MagentoOrderAddress> addresses;
	@JsonProperty("order_items")
	private List<MagentoOrderItem> orderItems;
	@JsonProperty("order_comments")
	private List<MagentoOrderComment> orderComments;
	
	public List<MagentoOrderAddress> getAddresses() {
		return addresses;
	}
	
	public void setAddresses(List<MagentoOrderAddress> addresses) {
		this.addresses = addresses;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getShippingDescription() {
		return shippingDescription;
	}

	public void setShippingDescription(String shippingDescription) {
		this.shippingDescription = shippingDescription;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Double getBaseDiscountAmount() {
		return baseDiscountAmount;
	}

	public void setBaseDiscountAmount(Double baseDiscountAmount) {
		this.baseDiscountAmount = baseDiscountAmount;
	}

	public Double getBaseGrandTotal() {
		return baseGrandTotal;
	}

	public void setBaseGrandTotal(Double baseGrandTotal) {
		this.baseGrandTotal = baseGrandTotal;
	}

	public Double getBaseShippingAmount() {
		return baseShippingAmount;
	}

	public void setBaseShippingAmount(Double baseShippingAmount) {
		this.baseShippingAmount = baseShippingAmount;
	}

	public Double getBaseShippingTaxAmount() {
		return baseShippingTaxAmount;
	}

	public void setBaseShippingTaxAmount(Double baseShippingTaxAmount) {
		this.baseShippingTaxAmount = baseShippingTaxAmount;
	}

	public Double getBaseSubtotal() {
		return baseSubtotal;
	}

	public void setBaseSubtotal(Double baseSubtotal) {
		this.baseSubtotal = baseSubtotal;
	}

	public Double getBaseTaxAmount() {
		return baseTaxAmount;
	}

	public void setBaseTaxAmount(Double baseTaxAmount) {
		this.baseTaxAmount = baseTaxAmount;
	}

	public Double getBaseTotalPaid() {
		return baseTotalPaid;
	}

	public void setBaseTotalPaid(Double baseTotalPaid) {
		this.baseTotalPaid = baseTotalPaid;
	}

	public Double getBaseTotalRefunded() {
		return baseTotalRefunded;
	}

	public void setBaseTotalRefunded(Double baseTotalRefunded) {
		this.baseTotalRefunded = baseTotalRefunded;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Double getShippingAmount() {
		return shippingAmount;
	}

	public void setShippingAmount(Double shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	public Double getShippingTaxAmount() {
		return shippingTaxAmount;
	}

	public void setShippingTaxAmount(Double shippingTaxAmount) {
		this.shippingTaxAmount = shippingTaxAmount;
	}

	public Double getStoreToOrderRate() {
		return storeToOrderRate;
	}

	public void setStoreToOrderRate(Double storeToOrderRate) {
		this.storeToOrderRate = storeToOrderRate;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Double getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(Double totalPaid) {
		this.totalPaid = totalPaid;
	}

	public Double getTotalRefunded() {
		return totalRefunded;
	}

	public void setTotalRefunded(Double totalRefunded) {
		this.totalRefunded = totalRefunded;
	}

	public Double getBaseShippingDiscountAmount() {
		return baseShippingDiscountAmount;
	}

	public void setBaseShippingDiscountAmount(Double baseShippingDiscountAmount) {
		this.baseShippingDiscountAmount = baseShippingDiscountAmount;
	}

	public Double getBaseSubtotalInclTax() {
		return baseSubtotalInclTax;
	}

	public void setBaseSubtotalInclTax(Double baseSubtotalInclTax) {
		this.baseSubtotalInclTax = baseSubtotalInclTax;
	}

	public Double getBaseTotalDue() {
		return baseTotalDue;
	}

	public void setBaseTotalDue(Double baseTotalDue) {
		this.baseTotalDue = baseTotalDue;
	}

	public Double getShippingDiscountAmount() {
		return shippingDiscountAmount;
	}

	public void setShippingDiscountAmount(Double shippingDiscountAmount) {
		this.shippingDiscountAmount = shippingDiscountAmount;
	}

	public Double getSubtotalInclTax() {
		return subtotalInclTax;
	}

	public void setSubtotalInclTax(Double subtotalInclTax) {
		this.subtotalInclTax = subtotalInclTax;
	}

	public Double getTotalDue() {
		return totalDue;
	}

	public void setTotalDue(Double totalDue) {
		this.totalDue = totalDue;
	}

	public String getIncrementId() {
		return incrementId;
	}

	public void setIncrementId(String incrementId) {
		this.incrementId = incrementId;
	}

	public String getBaseCurrencyCode() {
		return baseCurrencyCode;
	}

	public void setBaseCurrencyCode(String baseCurrencyCode) {
		this.baseCurrencyCode = baseCurrencyCode;
	}

	public String getDiscountDescription() {
		return discountDescription;
	}

	public void setDiscountDescription(String discountDescription) {
		this.discountDescription = discountDescription;
	}

	public String getExtOrderId() {
		return extOrderId;
	}

	public void setExtOrderId(String extOrderId) {
		this.extOrderId = extOrderId;
	}

	public String getRemoteIp() {
		return remoteIp;
	}

	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}

	public String getStoreCurrencyCode() {
		return storeCurrencyCode;
	}

	public void setStoreCurrencyCode(String storeCurrencyCode) {
		this.storeCurrencyCode = storeCurrencyCode;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getCustomerNote() {
		return customerNote;
	}

	public void setCustomerNote(String customerNote) {
		this.customerNote = customerNote;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Double getShippingInclTax() {
		return shippingInclTax;
	}

	public void setShippingInclTax(Double shippingInclTax) {
		this.shippingInclTax = shippingInclTax;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getGiftMessageFrom() {
		return giftMessageFrom;
	}

	public void setGiftMessageFrom(String giftMessageFrom) {
		this.giftMessageFrom = giftMessageFrom;
	}

	public String getGiftMessageTo() {
		return giftMessageTo;
	}

	public void setGiftMessageTo(String giftMessageTo) {
		this.giftMessageTo = giftMessageTo;
	}

	public String getGiftMessageBody() {
		return giftMessageBody;
	}

	public void setGiftMessageBody(String giftMessageBody) {
		this.giftMessageBody = giftMessageBody;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public List<MagentoOrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<MagentoOrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public List<MagentoOrderComment> getOrderComments() {
		return orderComments;
	}

	public void setOrderComments(List<MagentoOrderComment> orderComments) {
		this.orderComments = orderComments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result + ((baseCurrencyCode == null) ? 0 : baseCurrencyCode.hashCode());
		result = prime * result + ((baseDiscountAmount == null) ? 0 : baseDiscountAmount.hashCode());
		result = prime * result + ((baseGrandTotal == null) ? 0 : baseGrandTotal.hashCode());
		result = prime * result + ((baseShippingAmount == null) ? 0 : baseShippingAmount.hashCode());
		result = prime * result + ((baseShippingDiscountAmount == null) ? 0 : baseShippingDiscountAmount.hashCode());
		result = prime * result + ((baseShippingTaxAmount == null) ? 0 : baseShippingTaxAmount.hashCode());
		result = prime * result + ((baseSubtotal == null) ? 0 : baseSubtotal.hashCode());
		result = prime * result + ((baseSubtotalInclTax == null) ? 0 : baseSubtotalInclTax.hashCode());
		result = prime * result + ((baseTaxAmount == null) ? 0 : baseTaxAmount.hashCode());
		result = prime * result + ((baseTotalDue == null) ? 0 : baseTotalDue.hashCode());
		result = prime * result + ((baseTotalPaid == null) ? 0 : baseTotalPaid.hashCode());
		result = prime * result + ((baseTotalRefunded == null) ? 0 : baseTotalRefunded.hashCode());
		result = prime * result + ((couponCode == null) ? 0 : couponCode.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((customerNote == null) ? 0 : customerNote.hashCode());
		result = prime * result + ((discountAmount == null) ? 0 : discountAmount.hashCode());
		result = prime * result + ((discountDescription == null) ? 0 : discountDescription.hashCode());
		result = prime * result + ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result + ((extOrderId == null) ? 0 : extOrderId.hashCode());
		result = prime * result + ((giftMessageBody == null) ? 0 : giftMessageBody.hashCode());
		result = prime * result + ((giftMessageFrom == null) ? 0 : giftMessageFrom.hashCode());
		result = prime * result + ((giftMessageTo == null) ? 0 : giftMessageTo.hashCode());
		result = prime * result + ((grandTotal == null) ? 0 : grandTotal.hashCode());
		result = prime * result + ((incrementId == null) ? 0 : incrementId.hashCode());
		result = prime * result + ((orderComments == null) ? 0 : orderComments.hashCode());
		result = prime * result + ((orderItems == null) ? 0 : orderItems.hashCode());
		result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
		result = prime * result + ((remoteIp == null) ? 0 : remoteIp.hashCode());
		result = prime * result + ((shippingAmount == null) ? 0 : shippingAmount.hashCode());
		result = prime * result + ((shippingDescription == null) ? 0 : shippingDescription.hashCode());
		result = prime * result + ((shippingDiscountAmount == null) ? 0 : shippingDiscountAmount.hashCode());
		result = prime * result + ((shippingInclTax == null) ? 0 : shippingInclTax.hashCode());
		result = prime * result + ((shippingTaxAmount == null) ? 0 : shippingTaxAmount.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((storeCurrencyCode == null) ? 0 : storeCurrencyCode.hashCode());
		result = prime * result + ((storeName == null) ? 0 : storeName.hashCode());
		result = prime * result + ((storeToOrderRate == null) ? 0 : storeToOrderRate.hashCode());
		result = prime * result + ((subtotal == null) ? 0 : subtotal.hashCode());
		result = prime * result + ((subtotalInclTax == null) ? 0 : subtotalInclTax.hashCode());
		result = prime * result + ((taxAmount == null) ? 0 : taxAmount.hashCode());
		result = prime * result + ((taxName == null) ? 0 : taxName.hashCode());
		result = prime * result + ((taxRate == null) ? 0 : taxRate.hashCode());
		result = prime * result + ((totalDue == null) ? 0 : totalDue.hashCode());
		result = prime * result + ((totalPaid == null) ? 0 : totalPaid.hashCode());
		result = prime * result + ((totalRefunded == null) ? 0 : totalRefunded.hashCode());
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
		MagentoOrder other = (MagentoOrder) obj;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (baseCurrencyCode == null) {
			if (other.baseCurrencyCode != null)
				return false;
		} else if (!baseCurrencyCode.equals(other.baseCurrencyCode))
			return false;
		if (baseDiscountAmount == null) {
			if (other.baseDiscountAmount != null)
				return false;
		} else if (!baseDiscountAmount.equals(other.baseDiscountAmount))
			return false;
		if (baseGrandTotal == null) {
			if (other.baseGrandTotal != null)
				return false;
		} else if (!baseGrandTotal.equals(other.baseGrandTotal))
			return false;
		if (baseShippingAmount == null) {
			if (other.baseShippingAmount != null)
				return false;
		} else if (!baseShippingAmount.equals(other.baseShippingAmount))
			return false;
		if (baseShippingDiscountAmount == null) {
			if (other.baseShippingDiscountAmount != null)
				return false;
		} else if (!baseShippingDiscountAmount.equals(other.baseShippingDiscountAmount))
			return false;
		if (baseShippingTaxAmount == null) {
			if (other.baseShippingTaxAmount != null)
				return false;
		} else if (!baseShippingTaxAmount.equals(other.baseShippingTaxAmount))
			return false;
		if (baseSubtotal == null) {
			if (other.baseSubtotal != null)
				return false;
		} else if (!baseSubtotal.equals(other.baseSubtotal))
			return false;
		if (baseSubtotalInclTax == null) {
			if (other.baseSubtotalInclTax != null)
				return false;
		} else if (!baseSubtotalInclTax.equals(other.baseSubtotalInclTax))
			return false;
		if (baseTaxAmount == null) {
			if (other.baseTaxAmount != null)
				return false;
		} else if (!baseTaxAmount.equals(other.baseTaxAmount))
			return false;
		if (baseTotalDue == null) {
			if (other.baseTotalDue != null)
				return false;
		} else if (!baseTotalDue.equals(other.baseTotalDue))
			return false;
		if (baseTotalPaid == null) {
			if (other.baseTotalPaid != null)
				return false;
		} else if (!baseTotalPaid.equals(other.baseTotalPaid))
			return false;
		if (baseTotalRefunded == null) {
			if (other.baseTotalRefunded != null)
				return false;
		} else if (!baseTotalRefunded.equals(other.baseTotalRefunded))
			return false;
		if (couponCode == null) {
			if (other.couponCode != null)
				return false;
		} else if (!couponCode.equals(other.couponCode))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerNote == null) {
			if (other.customerNote != null)
				return false;
		} else if (!customerNote.equals(other.customerNote))
			return false;
		if (discountAmount == null) {
			if (other.discountAmount != null)
				return false;
		} else if (!discountAmount.equals(other.discountAmount))
			return false;
		if (discountDescription == null) {
			if (other.discountDescription != null)
				return false;
		} else if (!discountDescription.equals(other.discountDescription))
			return false;
		if (entityId == null) {
			if (other.entityId != null)
				return false;
		} else if (!entityId.equals(other.entityId))
			return false;
		if (extOrderId == null) {
			if (other.extOrderId != null)
				return false;
		} else if (!extOrderId.equals(other.extOrderId))
			return false;
		if (giftMessageBody == null) {
			if (other.giftMessageBody != null)
				return false;
		} else if (!giftMessageBody.equals(other.giftMessageBody))
			return false;
		if (giftMessageFrom == null) {
			if (other.giftMessageFrom != null)
				return false;
		} else if (!giftMessageFrom.equals(other.giftMessageFrom))
			return false;
		if (giftMessageTo == null) {
			if (other.giftMessageTo != null)
				return false;
		} else if (!giftMessageTo.equals(other.giftMessageTo))
			return false;
		if (grandTotal == null) {
			if (other.grandTotal != null)
				return false;
		} else if (!grandTotal.equals(other.grandTotal))
			return false;
		if (incrementId == null) {
			if (other.incrementId != null)
				return false;
		} else if (!incrementId.equals(other.incrementId))
			return false;
		if (orderComments == null) {
			if (other.orderComments != null)
				return false;
		} else if (!orderComments.equals(other.orderComments))
			return false;
		if (orderItems == null) {
			if (other.orderItems != null)
				return false;
		} else if (!orderItems.equals(other.orderItems))
			return false;
		if (paymentMethod == null) {
			if (other.paymentMethod != null)
				return false;
		} else if (!paymentMethod.equals(other.paymentMethod))
			return false;
		if (remoteIp == null) {
			if (other.remoteIp != null)
				return false;
		} else if (!remoteIp.equals(other.remoteIp))
			return false;
		if (shippingAmount == null) {
			if (other.shippingAmount != null)
				return false;
		} else if (!shippingAmount.equals(other.shippingAmount))
			return false;
		if (shippingDescription == null) {
			if (other.shippingDescription != null)
				return false;
		} else if (!shippingDescription.equals(other.shippingDescription))
			return false;
		if (shippingDiscountAmount == null) {
			if (other.shippingDiscountAmount != null)
				return false;
		} else if (!shippingDiscountAmount.equals(other.shippingDiscountAmount))
			return false;
		if (shippingInclTax == null) {
			if (other.shippingInclTax != null)
				return false;
		} else if (!shippingInclTax.equals(other.shippingInclTax))
			return false;
		if (shippingTaxAmount == null) {
			if (other.shippingTaxAmount != null)
				return false;
		} else if (!shippingTaxAmount.equals(other.shippingTaxAmount))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (storeCurrencyCode == null) {
			if (other.storeCurrencyCode != null)
				return false;
		} else if (!storeCurrencyCode.equals(other.storeCurrencyCode))
			return false;
		if (storeName == null) {
			if (other.storeName != null)
				return false;
		} else if (!storeName.equals(other.storeName))
			return false;
		if (storeToOrderRate == null) {
			if (other.storeToOrderRate != null)
				return false;
		} else if (!storeToOrderRate.equals(other.storeToOrderRate))
			return false;
		if (subtotal == null) {
			if (other.subtotal != null)
				return false;
		} else if (!subtotal.equals(other.subtotal))
			return false;
		if (subtotalInclTax == null) {
			if (other.subtotalInclTax != null)
				return false;
		} else if (!subtotalInclTax.equals(other.subtotalInclTax))
			return false;
		if (taxAmount == null) {
			if (other.taxAmount != null)
				return false;
		} else if (!taxAmount.equals(other.taxAmount))
			return false;
		if (taxName == null) {
			if (other.taxName != null)
				return false;
		} else if (!taxName.equals(other.taxName))
			return false;
		if (taxRate == null) {
			if (other.taxRate != null)
				return false;
		} else if (!taxRate.equals(other.taxRate))
			return false;
		if (totalDue == null) {
			if (other.totalDue != null)
				return false;
		} else if (!totalDue.equals(other.totalDue))
			return false;
		if (totalPaid == null) {
			if (other.totalPaid != null)
				return false;
		} else if (!totalPaid.equals(other.totalPaid))
			return false;
		if (totalRefunded == null) {
			if (other.totalRefunded != null)
				return false;
		} else if (!totalRefunded.equals(other.totalRefunded))
			return false;
		return true;
	}
}
