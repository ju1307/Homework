package com.demo.Homework.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestObject {

	private List<CustomerTransactionData> transactionDatas;

	public List<CustomerTransactionData> getTransactionDatas() {
		return transactionDatas;
	}

	public void setTransactionDatas(List<CustomerTransactionData> transactionDatas) {
		this.transactionDatas = transactionDatas;
	}

	
}
