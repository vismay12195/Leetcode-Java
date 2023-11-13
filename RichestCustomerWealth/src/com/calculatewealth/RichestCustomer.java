package com.calculatewealth;

public class RichestCustomer {
    public static void main(String[] args) {
        int[][] wealthArray = {
                {1,5,6},
                {2,5,6},
                {6,4,7}
        };

        // person = row
        // account = column
        int maxWealth = 0;

        // looping through each customer's bank accounts and calculating each customer's total wealth
        for(int customer=0; customer < wealthArray.length; customer++){
            int wealthSum = 0;
            for(int account=0; account < wealthArray[customer].length; account++){
                wealthSum += wealthArray[customer][account];
            }

            // After having the total wealth from each customer's individual accounts looking for the max wealth holding
            // customer
            if(wealthSum > maxWealth){
                maxWealth = wealthSum;
            }
        }
        System.out.println(maxWealth);
    }
}