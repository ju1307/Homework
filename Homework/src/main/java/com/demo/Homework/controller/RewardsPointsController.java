package com.demo.Homework.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Homework.model.CustomerPurchaseData;
import com.demo.Homework.model.CustomerRewardPointsResponse;
import com.demo.Homework.model.CustomerTransactionData;
import com.demo.Homework.model.RequestObject;

@RestController
@RequestMapping("/rewardPoints")
public class RewardsPointsController {

	@GetMapping("/getRewards")
	public List<CustomerRewardPointsResponse> getRewardsPoints(@RequestBody RequestObject requestObject) {

		List<CustomerRewardPointsResponse> customerRewardPointsResponses = new ArrayList<CustomerRewardPointsResponse>();
		for (CustomerTransactionData customerTransactionData : requestObject.getTransactionDatas()) {
			CustomerRewardPointsResponse customerRewardPointsResponse =  new CustomerRewardPointsResponse();

			Map<Integer, Double> monthlyRewardPoints = new HashMap<Integer, Double>();
			Map<Integer, List<CustomerPurchaseData>> collect = customerTransactionData.getPurchaseData().stream()
					.collect(Collectors.groupingBy(CustomerPurchaseData::getMonth));
			for (Entry<Integer, List<CustomerPurchaseData>> entry : collect.entrySet()) {
				double rewards=0.0;
				double sum = entry.getValue().stream().mapToDouble(CustomerPurchaseData::getAmount).sum();
				if(sum>100) {
					rewards+=((sum-100)*2)+50;
				}else if(sum<=100 && sum>50) {
					rewards+=(sum-50);
				}
				monthlyRewardPoints.put(entry.getKey(), rewards);
			}
			double totalRewards = monthlyRewardPoints.values().stream().mapToDouble(Double::doubleValue).sum();
			
			customerRewardPointsResponse.setCustomerName(customerTransactionData.getCustomerName());
			customerRewardPointsResponse.setTotalRewards(totalRewards);
			customerRewardPointsResponse.setRewardPoints(monthlyRewardPoints);
			customerRewardPointsResponses.add(customerRewardPointsResponse);
		}
		
		return customerRewardPointsResponses;

	}
}
