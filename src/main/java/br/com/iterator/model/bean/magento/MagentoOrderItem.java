package br.com.iterator.model.bean.magento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MagentoOrderItem implements Serializable {

	private static final long serialVersionUID = -6978141785082003589L;
	
	@JsonProperty("item_id")
	private Integer itemId;
	@JsonProperty("order_id")
	private Integer orderId;
	@JsonProperty("parent_item_id")
	private Integer parentItemId;
	private String sku;
	private String name;
	@JsonProperty("qty_canceled")
	private Double qtyCanceled;
	@JsonProperty("qty_invoiced")
	private Double qtyInvoiced;
	@JsonProperty("qty_ordered")
	private Double qtyOrdered;
	@JsonProperty("qty_refunded")
	private Double qtyRefunded;
	@JsonProperty("qty_shipped")
	private Double qtyShipped;
	private Double price;
	@JsonProperty("base_price")
	private Double basePrice;
	@JsonProperty("original_price")
	private Double originalPrice;
	@JsonProperty("base_original_price")
	private Double baseOriginalPrice;
	@JsonProperty("tax_percent")
	private Double taxPercent;
	@JsonProperty("tax_amount")
	private Double taxAmount;
	@JsonProperty("base_tax_amount")
	private Double baseTaxAmount;
	@JsonProperty("discount_amount")
	private Double discountAmount;
	@JsonProperty("base_discount_amount")
	private Double baseDiscountAmount;
	@JsonProperty("row_total")
	private Double rowTotal;
	@JsonProperty("base_row_total")
	private Double baseRowTotal;
	@JsonProperty("price_incl_tax")
	private Double priceInclTax;
	@JsonProperty("base_price_incl_tax")
	private Double basePriceInclTax;
	@JsonProperty("row_total_incl_tax")
	private Double rowTotalInclTax;
	@JsonProperty("base_row_total_incl_tax")
	private Double baseRowTotalInclTax;
	
	public Integer getItemId() {
		return itemId;
	}
	
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getParentItemId() {
		return parentItemId;
	}
	
	public void setParentItemId(Integer parentItemId) {
		this.parentItemId = parentItemId;
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
	
	public Double getQtyCanceled() {
		return qtyCanceled;
	}
	
	public void setQtyCanceled(Double qtyCanceled) {
		this.qtyCanceled = qtyCanceled;
	}
	
	public Double getQtyInvoiced() {
		return qtyInvoiced;
	}
	
	public void setQtyInvoiced(Double qtyInvoiced) {
		this.qtyInvoiced = qtyInvoiced;
	}
	
	public Double getQtyOrdered() {
		return qtyOrdered;
	}
	
	public void setQtyOrdered(Double qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	
	public Double getQtyRefunded() {
		return qtyRefunded;
	}
	
	public void setQtyRefunded(Double qtyRefunded) {
		this.qtyRefunded = qtyRefunded;
	}
	
	public Double getQtyShipped() {
		return qtyShipped;
	}
	
	public void setQtyShipped(Double qtyShipped) {
		this.qtyShipped = qtyShipped;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getBasePrice() {
		return basePrice;
	}
	
	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}
	
	public Double getOriginalPrice() {
		return originalPrice;
	}
	
	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}
	
	public Double getBaseOriginalPrice() {
		return baseOriginalPrice;
	}
	
	public void setBaseOriginalPrice(Double baseOriginalPrice) {
		this.baseOriginalPrice = baseOriginalPrice;
	}
	
	public Double getTaxPercent() {
		return taxPercent;
	}
	
	public void setTaxPercent(Double taxPercent) {
		this.taxPercent = taxPercent;
	}
	
	public Double getTaxAmount() {
		return taxAmount;
	}
	
	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}
	
	public Double getBaseTaxAmount() {
		return baseTaxAmount;
	}
	
	public void setBaseTaxAmount(Double baseTaxAmount) {
		this.baseTaxAmount = baseTaxAmount;
	}
	
	public Double getDiscountAmount() {
		return discountAmount;
	}
	
	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}
	
	public Double getBaseDiscountAmount() {
		return baseDiscountAmount;
	}
	
	public void setBaseDiscountAmount(Double baseDiscountAmount) {
		this.baseDiscountAmount = baseDiscountAmount;
	}
	
	public Double getRowTotal() {
		return rowTotal;
	}
	
	public void setRowTotal(Double rowTotal) {
		this.rowTotal = rowTotal;
	}
	
	public Double getBaseRowTotal() {
		return baseRowTotal;
	}
	
	public void setBaseRowTotal(Double baseRowTotal) {
		this.baseRowTotal = baseRowTotal;
	}
	
	public Double getPriceInclTax() {
		return priceInclTax;
	}
	
	public void setPriceInclTax(Double priceInclTax) {
		this.priceInclTax = priceInclTax;
	}
	
	public Double getBasePriceInclTax() {
		return basePriceInclTax;
	}
	
	public void setBasePriceInclTax(Double basePriceInclTax) {
		this.basePriceInclTax = basePriceInclTax;
	}
	
	public Double getRowTotalInclTax() {
		return rowTotalInclTax;
	}
	
	public void setRowTotalInclTax(Double rowTotalInclTax) {
		this.rowTotalInclTax = rowTotalInclTax;
	}
	
	public Double getBaseRowTotalInclTax() {
		return baseRowTotalInclTax;
	}
	
	public void setBaseRowTotalInclTax(Double baseRowTotalInclTax) {
		this.baseRowTotalInclTax = baseRowTotalInclTax;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseDiscountAmount == null) ? 0 : baseDiscountAmount.hashCode());
		result = prime * result + ((baseOriginalPrice == null) ? 0 : baseOriginalPrice.hashCode());
		result = prime * result + ((basePrice == null) ? 0 : basePrice.hashCode());
		result = prime * result + ((basePriceInclTax == null) ? 0 : basePriceInclTax.hashCode());
		result = prime * result + ((baseRowTotal == null) ? 0 : baseRowTotal.hashCode());
		result = prime * result + ((baseRowTotalInclTax == null) ? 0 : baseRowTotalInclTax.hashCode());
		result = prime * result + ((baseTaxAmount == null) ? 0 : baseTaxAmount.hashCode());
		result = prime * result + ((discountAmount == null) ? 0 : discountAmount.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((originalPrice == null) ? 0 : originalPrice.hashCode());
		result = prime * result + ((parentItemId == null) ? 0 : parentItemId.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((priceInclTax == null) ? 0 : priceInclTax.hashCode());
		result = prime * result + ((qtyCanceled == null) ? 0 : qtyCanceled.hashCode());
		result = prime * result + ((qtyInvoiced == null) ? 0 : qtyInvoiced.hashCode());
		result = prime * result + ((qtyOrdered == null) ? 0 : qtyOrdered.hashCode());
		result = prime * result + ((qtyRefunded == null) ? 0 : qtyRefunded.hashCode());
		result = prime * result + ((qtyShipped == null) ? 0 : qtyShipped.hashCode());
		result = prime * result + ((rowTotal == null) ? 0 : rowTotal.hashCode());
		result = prime * result + ((rowTotalInclTax == null) ? 0 : rowTotalInclTax.hashCode());
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		result = prime * result + ((taxAmount == null) ? 0 : taxAmount.hashCode());
		result = prime * result + ((taxPercent == null) ? 0 : taxPercent.hashCode());
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
		MagentoOrderItem other = (MagentoOrderItem) obj;
		if (baseDiscountAmount == null) {
			if (other.baseDiscountAmount != null)
				return false;
		} else if (!baseDiscountAmount.equals(other.baseDiscountAmount))
			return false;
		if (baseOriginalPrice == null) {
			if (other.baseOriginalPrice != null)
				return false;
		} else if (!baseOriginalPrice.equals(other.baseOriginalPrice))
			return false;
		if (basePrice == null) {
			if (other.basePrice != null)
				return false;
		} else if (!basePrice.equals(other.basePrice))
			return false;
		if (basePriceInclTax == null) {
			if (other.basePriceInclTax != null)
				return false;
		} else if (!basePriceInclTax.equals(other.basePriceInclTax))
			return false;
		if (baseRowTotal == null) {
			if (other.baseRowTotal != null)
				return false;
		} else if (!baseRowTotal.equals(other.baseRowTotal))
			return false;
		if (baseRowTotalInclTax == null) {
			if (other.baseRowTotalInclTax != null)
				return false;
		} else if (!baseRowTotalInclTax.equals(other.baseRowTotalInclTax))
			return false;
		if (baseTaxAmount == null) {
			if (other.baseTaxAmount != null)
				return false;
		} else if (!baseTaxAmount.equals(other.baseTaxAmount))
			return false;
		if (discountAmount == null) {
			if (other.discountAmount != null)
				return false;
		} else if (!discountAmount.equals(other.discountAmount))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (originalPrice == null) {
			if (other.originalPrice != null)
				return false;
		} else if (!originalPrice.equals(other.originalPrice))
			return false;
		if (parentItemId == null) {
			if (other.parentItemId != null)
				return false;
		} else if (!parentItemId.equals(other.parentItemId))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (priceInclTax == null) {
			if (other.priceInclTax != null)
				return false;
		} else if (!priceInclTax.equals(other.priceInclTax))
			return false;
		if (qtyCanceled == null) {
			if (other.qtyCanceled != null)
				return false;
		} else if (!qtyCanceled.equals(other.qtyCanceled))
			return false;
		if (qtyInvoiced == null) {
			if (other.qtyInvoiced != null)
				return false;
		} else if (!qtyInvoiced.equals(other.qtyInvoiced))
			return false;
		if (qtyOrdered == null) {
			if (other.qtyOrdered != null)
				return false;
		} else if (!qtyOrdered.equals(other.qtyOrdered))
			return false;
		if (qtyRefunded == null) {
			if (other.qtyRefunded != null)
				return false;
		} else if (!qtyRefunded.equals(other.qtyRefunded))
			return false;
		if (qtyShipped == null) {
			if (other.qtyShipped != null)
				return false;
		} else if (!qtyShipped.equals(other.qtyShipped))
			return false;
		if (rowTotal == null) {
			if (other.rowTotal != null)
				return false;
		} else if (!rowTotal.equals(other.rowTotal))
			return false;
		if (rowTotalInclTax == null) {
			if (other.rowTotalInclTax != null)
				return false;
		} else if (!rowTotalInclTax.equals(other.rowTotalInclTax))
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		if (taxAmount == null) {
			if (other.taxAmount != null)
				return false;
		} else if (!taxAmount.equals(other.taxAmount))
			return false;
		if (taxPercent == null) {
			if (other.taxPercent != null)
				return false;
		} else if (!taxPercent.equals(other.taxPercent))
			return false;
		return true;
	}
}
