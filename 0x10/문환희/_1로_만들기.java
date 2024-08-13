import java.util.Scanner;

public class _1로_만들기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        dp[n - 1] = 1;
        for(int i = n - 2; i > 0; i--){
            int val_2 = Integer.MAX_VALUE;
            int val_3 = Integer.MAX_VALUE;
            if(i * 3 <= n) {
                if((i * 3) % 3 == 0) {
                    val_3 = dp[i * 3] + 1;
                }
            }
            if(i * 2 <= n) {
                if((i * 2) % 2 == 0) {
                    val_2 = dp[i * 2] + 1;
                }
            }
            dp[i] = Math.min(dp[i + 1] + 1, Math.min(val_2, val_3));

        }
        System.out.println(dp[1]);
    }
}
