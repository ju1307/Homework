package com.demo.Homework.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerTransactionData {

	private String customerName;
	
	private List<CustomerPurchaseData> purchaseData;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<CustomerPurchaseData> getPurchaseData() {
		return purchaseData;
	}

	public void setPurchaseData(List<CustomerPurchaseData> purchaseData) {
		this.purchaseData = purchaseData;
	}
	
}
