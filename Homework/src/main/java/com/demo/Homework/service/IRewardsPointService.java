package com.demo.Homework.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.Homework.model.CustomerRewardPointsResponse;
import com.demo.Homework.model.CustomerTransactionData;

@Service
public interface IRewardsPointService {

	public List<CustomerRewardPointsResponse> calculateRewardPoints(List<CustomerTransactionData> transactionDatas);
}
