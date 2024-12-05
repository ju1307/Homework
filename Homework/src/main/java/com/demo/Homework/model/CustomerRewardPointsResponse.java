package com.demo.Homework.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRewardPointsResponse {

	private String customerName;
	
	private Map<Integer, Double> rewardPoints;
	
	private Double totalRewards;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Map<Integer, Double> getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(Map<Integer, Double> rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public Double getTotalRewards() {
		return totalRewards;
	}

	public void setTotalRewards(Double totalRewards) {
		this.totalRewards = totalRewards;
	}
	
}
