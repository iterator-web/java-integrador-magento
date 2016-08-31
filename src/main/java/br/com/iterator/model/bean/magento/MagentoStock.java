package br.com.iterator.model.bean.magento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = {"notify_stock_qty"})
public class MagentoStock implements Serializable {

	private static final long serialVersionUID = -2861401196791826243L;
	
	@JsonProperty("item_id")
	private Integer itemId;
	@JsonProperty("product_id")
	private Integer productId;
	@JsonProperty("stock_id")
	private Integer stockId;
	private String qty;
	@JsonProperty("min_qty")
	private String minQty;
	@JsonProperty("use_config_min_qty")
	private Integer useConfigMinQty;
	@JsonProperty("is_qty_decimal")
	private Integer isQtyDecimal;
	private Integer backorders;
	@JsonProperty("use_config_backorders")
	private Integer useConfigBackorders;
	@JsonProperty("min_sale_qty")
	private String minSaleQty;
	@JsonProperty("use_config_min_sale_qty")
	private Integer useConfigMinSaleQty;
	@JsonProperty("max_sale_qty")
	private String maxSaleQty;
	@JsonProperty("use_config_max_sale_qty")
	private Integer useConfigMaxSaleQty;
	@JsonProperty("is_in_stock")
	private Integer isInStock;
	@JsonProperty("low_stock_date")
	private String lowStockDate;
	@JsonProperty("notify_stock_qty")
	private String notifyStockQty;
	@JsonProperty("use_config_notify_stock_qty")
	private Integer useConfigNotifyStockQty;
	@JsonProperty("manage_stock")
	private Integer manageStock;
	@JsonProperty("use_config_manage_stock")
	private Integer useConfigManageStock;
	@JsonProperty("stock_status_changed_auto")
	private Integer stockStatusChangedAuto;
	@JsonProperty("use_config_qty_increments")
	private Integer useConfigQtyIncrements;
	@JsonProperty("qty_increments")
	private String qtyIncrements;
	@JsonProperty("use_config_enable_qty_inc")
	private Integer useConfigEnableQtyInc;
	@JsonProperty("enable_qty_increments")
	private Integer enableQtyIncrements;
	@JsonProperty("is_decimal_divided")
	private Integer isDecimalDivided;
	
	public Integer getItemId() {
		return itemId;
	}
	
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	public Integer getProductId() {
		return productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Integer getStockId() {
		return stockId;
	}
	
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
	
	public String getQty() {
		return qty;
	}
	
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	public String getMinQty() {
		return minQty;
	}
	
	public void setMinQty(String minQty) {
		this.minQty = minQty;
	}
	
	public Integer getUseConfigMinQty() {
		return useConfigMinQty;
	}
	
	public void setUseConfigMinQty(Integer useConfigMinQty) {
		this.useConfigMinQty = useConfigMinQty;
	}
	
	public Integer getIsQtyDecimal() {
		return isQtyDecimal;
	}
	
	public void setIsQtyDecimal(Integer isQtyDecimal) {
		this.isQtyDecimal = isQtyDecimal;
	}
	
	public Integer getBackorders() {
		return backorders;
	}
	
	public void setBackorders(Integer backorders) {
		this.backorders = backorders;
	}
	
	public Integer getUseConfigBackorders() {
		return useConfigBackorders;
	}
	
	public void setUseConfigBackorders(Integer useConfigBackorders) {
		this.useConfigBackorders = useConfigBackorders;
	}
	
	public String getMinSaleQty() {
		return minSaleQty;
	}
	
	public void setMinSaleQty(String minSaleQty) {
		this.minSaleQty = minSaleQty;
	}
	
	public Integer getUseConfigMinSaleQty() {
		return useConfigMinSaleQty;
	}
	
	public void setUseConfigMinSaleQty(Integer useConfigMinSaleQty) {
		this.useConfigMinSaleQty = useConfigMinSaleQty;
	}
	
	public String getMaxSaleQty() {
		return maxSaleQty;
	}
	
	public void setMaxSaleQty(String maxSaleQty) {
		this.maxSaleQty = maxSaleQty;
	}
	
	public Integer getUseConfigMaxSaleQty() {
		return useConfigMaxSaleQty;
	}
	
	public void setUseConfigMaxSaleQty(Integer useConfigMaxSaleQty) {
		this.useConfigMaxSaleQty = useConfigMaxSaleQty;
	}
	
	public Integer getIsInStock() {
		return isInStock;
	}
	
	public void setIsInStock(Integer isInStock) {
		this.isInStock = isInStock;
	}
	
	public String getLowStockDate() {
		return lowStockDate;
	}
	
	public void setLowStockDate(String lowStockDate) {
		this.lowStockDate = lowStockDate;
	}
	
	public String getNotifyStockQty() {
		return notifyStockQty;
	}
	
	public void setNotifyStockQty(String notifyStockQty) {
		this.notifyStockQty = notifyStockQty;
	}
	
	public Integer getUseConfigNotifyStockQty() {
		return useConfigNotifyStockQty;
	}
	
	public void setUseConfigNotifyStockQty(Integer useConfigNotifyStockQty) {
		this.useConfigNotifyStockQty = useConfigNotifyStockQty;
	}
	
	public Integer getManageStock() {
		return manageStock;
	}
	
	public void setManageStock(Integer manageStock) {
		this.manageStock = manageStock;
	}
	
	public Integer getUseConfigManageStock() {
		return useConfigManageStock;
	}
	
	public void setUseConfigManageStock(Integer useConfigManageStock) {
		this.useConfigManageStock = useConfigManageStock;
	}
	
	public Integer getStockStatusChangedAuto() {
		return stockStatusChangedAuto;
	}
	
	public void setStockStatusChangedAuto(Integer stockStatusChangedAuto) {
		this.stockStatusChangedAuto = stockStatusChangedAuto;
	}
	
	public Integer getUseConfigQtyIncrements() {
		return useConfigQtyIncrements;
	}
	
	public void setUseConfigQtyIncrements(Integer useConfigQtyIncrements) {
		this.useConfigQtyIncrements = useConfigQtyIncrements;
	}
	
	public String getQtyIncrements() {
		return qtyIncrements;
	}
	
	public void setQtyIncrements(String qtyIncrements) {
		this.qtyIncrements = qtyIncrements;
	}
	
	public Integer getUseConfigEnableQtyInc() {
		return useConfigEnableQtyInc;
	}
	
	public void setUseConfigEnableQtyInc(Integer useConfigEnableQtyInc) {
		this.useConfigEnableQtyInc = useConfigEnableQtyInc;
	}
	
	public Integer getEnableQtyIncrements() {
		return enableQtyIncrements;
	}
	
	public void setEnableQtyIncrements(Integer enableQtyIncrements) {
		this.enableQtyIncrements = enableQtyIncrements;
	}
	
	public Integer getIsDecimalDivided() {
		return isDecimalDivided;
	}
	
	public void setIsDecimalDivided(Integer isDecimalDivided) {
		this.isDecimalDivided = isDecimalDivided;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backorders == null) ? 0 : backorders.hashCode());
		result = prime * result + ((enableQtyIncrements == null) ? 0 : enableQtyIncrements.hashCode());
		result = prime * result + ((isDecimalDivided == null) ? 0 : isDecimalDivided.hashCode());
		result = prime * result + ((isInStock == null) ? 0 : isInStock.hashCode());
		result = prime * result + ((isQtyDecimal == null) ? 0 : isQtyDecimal.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((lowStockDate == null) ? 0 : lowStockDate.hashCode());
		result = prime * result + ((manageStock == null) ? 0 : manageStock.hashCode());
		result = prime * result + ((maxSaleQty == null) ? 0 : maxSaleQty.hashCode());
		result = prime * result + ((minQty == null) ? 0 : minQty.hashCode());
		result = prime * result + ((minSaleQty == null) ? 0 : minSaleQty.hashCode());
		result = prime * result + ((notifyStockQty == null) ? 0 : notifyStockQty.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((qty == null) ? 0 : qty.hashCode());
		result = prime * result + ((qtyIncrements == null) ? 0 : qtyIncrements.hashCode());
		result = prime * result + ((stockId == null) ? 0 : stockId.hashCode());
		result = prime * result + ((stockStatusChangedAuto == null) ? 0 : stockStatusChangedAuto.hashCode());
		result = prime * result + ((useConfigBackorders == null) ? 0 : useConfigBackorders.hashCode());
		result = prime * result + ((useConfigEnableQtyInc == null) ? 0 : useConfigEnableQtyInc.hashCode());
		result = prime * result + ((useConfigManageStock == null) ? 0 : useConfigManageStock.hashCode());
		result = prime * result + ((useConfigMaxSaleQty == null) ? 0 : useConfigMaxSaleQty.hashCode());
		result = prime * result + ((useConfigMinQty == null) ? 0 : useConfigMinQty.hashCode());
		result = prime * result + ((useConfigMinSaleQty == null) ? 0 : useConfigMinSaleQty.hashCode());
		result = prime * result + ((useConfigNotifyStockQty == null) ? 0 : useConfigNotifyStockQty.hashCode());
		result = prime * result + ((useConfigQtyIncrements == null) ? 0 : useConfigQtyIncrements.hashCode());
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
		MagentoStock other = (MagentoStock) obj;
		if (backorders == null) {
			if (other.backorders != null)
				return false;
		} else if (!backorders.equals(other.backorders))
			return false;
		if (enableQtyIncrements == null) {
			if (other.enableQtyIncrements != null)
				return false;
		} else if (!enableQtyIncrements.equals(other.enableQtyIncrements))
			return false;
		if (isDecimalDivided == null) {
			if (other.isDecimalDivided != null)
				return false;
		} else if (!isDecimalDivided.equals(other.isDecimalDivided))
			return false;
		if (isInStock == null) {
			if (other.isInStock != null)
				return false;
		} else if (!isInStock.equals(other.isInStock))
			return false;
		if (isQtyDecimal == null) {
			if (other.isQtyDecimal != null)
				return false;
		} else if (!isQtyDecimal.equals(other.isQtyDecimal))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (lowStockDate == null) {
			if (other.lowStockDate != null)
				return false;
		} else if (!lowStockDate.equals(other.lowStockDate))
			return false;
		if (manageStock == null) {
			if (other.manageStock != null)
				return false;
		} else if (!manageStock.equals(other.manageStock))
			return false;
		if (maxSaleQty == null) {
			if (other.maxSaleQty != null)
				return false;
		} else if (!maxSaleQty.equals(other.maxSaleQty))
			return false;
		if (minQty == null) {
			if (other.minQty != null)
				return false;
		} else if (!minQty.equals(other.minQty))
			return false;
		if (minSaleQty == null) {
			if (other.minSaleQty != null)
				return false;
		} else if (!minSaleQty.equals(other.minSaleQty))
			return false;
		if (notifyStockQty == null) {
			if (other.notifyStockQty != null)
				return false;
		} else if (!notifyStockQty.equals(other.notifyStockQty))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (qty == null) {
			if (other.qty != null)
				return false;
		} else if (!qty.equals(other.qty))
			return false;
		if (qtyIncrements == null) {
			if (other.qtyIncrements != null)
				return false;
		} else if (!qtyIncrements.equals(other.qtyIncrements))
			return false;
		if (stockId == null) {
			if (other.stockId != null)
				return false;
		} else if (!stockId.equals(other.stockId))
			return false;
		if (stockStatusChangedAuto == null) {
			if (other.stockStatusChangedAuto != null)
				return false;
		} else if (!stockStatusChangedAuto.equals(other.stockStatusChangedAuto))
			return false;
		if (useConfigBackorders == null) {
			if (other.useConfigBackorders != null)
				return false;
		} else if (!useConfigBackorders.equals(other.useConfigBackorders))
			return false;
		if (useConfigEnableQtyInc == null) {
			if (other.useConfigEnableQtyInc != null)
				return false;
		} else if (!useConfigEnableQtyInc.equals(other.useConfigEnableQtyInc))
			return false;
		if (useConfigManageStock == null) {
			if (other.useConfigManageStock != null)
				return false;
		} else if (!useConfigManageStock.equals(other.useConfigManageStock))
			return false;
		if (useConfigMaxSaleQty == null) {
			if (other.useConfigMaxSaleQty != null)
				return false;
		} else if (!useConfigMaxSaleQty.equals(other.useConfigMaxSaleQty))
			return false;
		if (useConfigMinQty == null) {
			if (other.useConfigMinQty != null)
				return false;
		} else if (!useConfigMinQty.equals(other.useConfigMinQty))
			return false;
		if (useConfigMinSaleQty == null) {
			if (other.useConfigMinSaleQty != null)
				return false;
		} else if (!useConfigMinSaleQty.equals(other.useConfigMinSaleQty))
			return false;
		if (useConfigNotifyStockQty == null) {
			if (other.useConfigNotifyStockQty != null)
				return false;
		} else if (!useConfigNotifyStockQty.equals(other.useConfigNotifyStockQty))
			return false;
		if (useConfigQtyIncrements == null) {
			if (other.useConfigQtyIncrements != null)
				return false;
		} else if (!useConfigQtyIncrements.equals(other.useConfigQtyIncrements))
			return false;
		return true;
	}
}
