package com.demo.Homework.service;

import java.util.List;

import com.demo.Homework.model.CustomerRewardPointsResponse;
import com.demo.Homework.model.CustomerTransactionData;

public interface IRewardsPointService {

	public List<CustomerRewardPointsResponse> calculateRewardPoints(List<CustomerTransactionData> transactionDatas);
}
