# Homework

WebAPI Developer  
A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.  
  
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent between $50 and $100 in each transaction. 
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).


Service end point : http://localhost:8080/rewardPoints/getRewards

Input: Customer monthly transaction data
Output: Reward points earned for each customer per month and total reward points of customer. 

sample request:

{
    "transactionDatas":[{
           "customerName": "raj",
           "purchaseData": [{
               "month":1,
               "amount":150.00
           },
           {
               "month":1,
               "amount":300.00
           },
           {
               "month":2,
               "amount":150.00
           },
           {
               "month":2,
               "amount":200.00
           },
           {
               "month":3,
               "amount":250.00
           }]
    },
    {
           "customerName": "aman",
           "purchaseData": [{
               "month":1,
               "amount":100.00
           },
           {
               "month":1,
               "amount":250.00
           },
           {
               "month":2,
               "amount":350.00
           },
           {
               "month":2,
               "amount":150.00
           },
           {
               "month":3,
               "amount":200.00
           }]
    },
    {
           "customerName": "rahul",
           "purchaseData": [{
               "month":1,
               "amount":80.00
           },
           {
               "month":1,
               "amount":170.00
           },
           {
               "month":2,
               "amount":225.00
           },
           {
               "month":2,
               "amount":175.00
           },
           {
               "month":3,
               "amount":190.00
           }]
    }]
}



sample response:

[
    {
        "customerName": "raj",
        "rewardPoints": {
            "1": 750.0,
            "2": 550.0,
            "3": 350.0
        },
        "totalRewards": 1650.0
    },
    {
        "customerName": "aman",
        "rewardPoints": {
            "1": 550.0,
            "2": 850.0,
            "3": 250.0
        },
        "totalRewards": 1650.0
    },
    {
        "customerName": "rahul",
        "rewardPoints": {
            "1": 350.0,
            "2": 650.0,
            "3": 230.0
        },
        "totalRewards": 1230.0
    }
]
