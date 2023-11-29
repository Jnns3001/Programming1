package jm;

public class RecursionTest {

    public static void printElements(int[] nums) {
        printElements(nums, 0);
    }
    private static void printElements(int[] nums, int pos) {
        if (pos < nums.length) {
            System.out.print(nums[pos] + " ");
            printElements(nums,pos +1);
        }
    }
    public static int max(int[] nums) {
        return max(nums,0);
    }
    private static int max(int[] nums, int pos) {
        if (pos == nums.length) {
            return Integer.MIN_VALUE;
        } else {
            int maxRest = max(nums, pos+1);
            return maxRest > nums[pos] ? maxRest : nums[pos];
        }
    }

    public static void main(String[] args) {
        printElements(new int[]{1,2,3,4});
        System.out.println(max(new int[]{1,42,3,4}));
    }
}
