import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class 파도반_수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int max = Integer.MIN_VALUE;
        int[] arr = new int[n];
        long[] tmp1 = new long [101];
        long[] tmp2 = {1,1,1,2,2,3,4,5,7,9};
        long[] dp = LongStream.concat(Arrays.stream(tmp2), Arrays.stream(tmp1)).toArray();

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
            max = Math.max(max, arr[i]);
        }

        if(max > 9) {
            for(int i = 10; i < max; i++) {
                dp[i] = dp[i - 1] + dp[i - 5];
            }
        }
        for(int i: arr) {
            System.out.println(dp[i - 1]);
        }
    }
}
