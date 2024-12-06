package com.demo.Homework.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.demo.Homework.model.CustomerPurchaseData;
import com.demo.Homework.model.CustomerRewardPointsResponse;
import com.demo.Homework.model.CustomerTransactionData;

public class RewardsPointServiceImpl implements IRewardsPointService {

	@Override
	public List<CustomerRewardPointsResponse> calculateRewardPoints(List<CustomerTransactionData> transactionDatas) {

		List<CustomerRewardPointsResponse> customerRewardPointsResponses = new ArrayList<CustomerRewardPointsResponse>();

		for (CustomerTransactionData customerTransactionData : transactionDatas) {
			CustomerRewardPointsResponse customerRewardPointsResponse = new CustomerRewardPointsResponse();

			double totalRewards = 0.0;
			Map<Integer, Double> monthlyRewardPoints = new HashMap<Integer, Double>();
			Map<Integer, List<CustomerPurchaseData>> collect = customerTransactionData.getPurchaseData().stream()
					.collect(Collectors.groupingBy(CustomerPurchaseData::getMonth));
			for (Entry<Integer, List<CustomerPurchaseData>> entry : collect.entrySet()) {
				double rewards = 0.0;
				double sum = entry.getValue().stream().mapToDouble(CustomerPurchaseData::getAmount).sum();
				if (sum > 100) {
					rewards += ((sum - 100) * 2) + 50;
				} else if (sum <= 100 && sum > 50) {
					rewards += (sum - 50);
				}
				monthlyRewardPoints.put(entry.getKey(), rewards);
				totalRewards += rewards;
			}

			customerRewardPointsResponse.setCustomerName(customerTransactionData.getCustomerName());
			customerRewardPointsResponse.setTotalRewards(totalRewards);
			customerRewardPointsResponse.setRewardPoints(monthlyRewardPoints);
			customerRewardPointsResponses.add(customerRewardPointsResponse);
		}

		return customerRewardPointsResponses;
	}

}
