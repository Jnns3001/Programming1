package jm.scipts;

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
    public static boolean palindromTestI(String text) {
        text = text.toLowerCase().replace(" ","");
        for (int i = 0; i < text.length()/2; i++) {
            if (text.charAt(i) != text.charAt(text.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
    public static boolean palindromTestR(String s) {
        s = s.toLowerCase().replace(" ","");
        return s.length() <= 1 || s.charAt(0) == s.charAt(s.length() - 1) && palindromTestR(s.substring(1, s.length() - 1));
    }

    public static void main(String[] args) {
        //printElements(new int[]{1,2,3,4});
        //System.out.println(max(new int[]{1,42,3,4}));
        String text = "lageruregal";
        System.out.println(palindromTestI(text));
        System.out.println(palindromTestR(text));
    }
}
