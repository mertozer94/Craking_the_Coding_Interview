package Eight_Chapter;

/**
 * @author Mert Ozer
 */
public class Magic_Index_8_3 {
    public static void main(String[] args){
        int[] nums = {0,26,27,45,46};
        System.out.println(findMagixIndex(nums));

        int[] nums1 = {-3,-2,-1,0,4};
        System.out.println(findMagixIndex(nums1));
    }
    public static int findMagixIndex(int[] nums){
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;
            if (mid == nums[mid])
                return mid;
            else if (mid < nums[mid]){
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
