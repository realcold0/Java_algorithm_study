import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class 두수의_합 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = Arrays.stream(sc.nextLine()
                        .split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();


        Arrays.sort(nums);
        int x = sc.nextInt();
        int left = 0;
        int right = n - 1;
        int result = 0;
        boolean flag = false;

        while (left < right) {
            int tmp = nums[left] + nums[right];
            //System.out.println(nums[left] + nums[right]);
            if(tmp == x) {
                result++;
            }
            if(tmp < x){
                left++;
            }
            else {
                right--;
            }
        }
        System.out.println(result);
    }
}
