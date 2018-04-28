package Eight_Chapter;

/**
 * @author Mert Ozer
 *
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
steps at a time. Implement a method to count how many possible ways the child can run up the
stairs.
 */
public class Triple_Step_8_1 {
    public static void main(String[] args){
        System.out.println(countSteps(3));
    }
    public static int countSteps(int num){
        if (num < 0)
            return -1;
        int[] nums = new int[num];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 2;
        if (num < 3)
            return nums[num];

        for (int i = 3; i < num; i++){
            nums[i] = nums[i-1] + nums[i-2] + nums[i-3];
        }
        return nums[num-1] + nums[num-2] + nums[num-3];
    }
}
