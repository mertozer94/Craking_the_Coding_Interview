package Eight_Chapter;

import java.util.Arrays;

/**
 * @author Mert Ozer
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and
pennies (1 cent), write code to calculate the number of ways of representing n cents.
 */
public class Coins_8_11 {
    public static void main(String[] args){
        int[] coins = {25,10,5,1};
        System.out.println(count(coins,10));
    }
    public static int[] tail(int[] nums){
        if (nums.length == 1)
            return null;
        return Arrays.copyOfRange(nums, 1, nums.length);
    }
    public static int count(int[] coins, int money){
        if (coins == null || money == 0)
            return 0;
        return helper(money, coins);
    }
    public static int helper(int money, int[] nums){
        if (nums == null)
            return 0;
        else if (money < 0)
            return 0;
        else if (money == 0)
            return 1;

        return helper(money-nums[0],nums) + helper(money, tail(nums));
    }
}
