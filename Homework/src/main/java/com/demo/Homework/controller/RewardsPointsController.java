package com.demo.Homework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Homework.model.CustomerRewardPointsResponse;
import com.demo.Homework.model.RequestObject;
import com.demo.Homework.service.IRewardsPointService;

@RestController
@RequestMapping("/rewardPoints")
public class RewardsPointsController {
	
	@Autowired
	private IRewardsPointService iRewardsPointService;

	@GetMapping("/getRewards")
	public List<CustomerRewardPointsResponse> getRewardsPoints(@RequestBody RequestObject requestObject) {

		return iRewardsPointService.calculateRewardPoints(requestObject.getTransactionDatas());

	}
}
