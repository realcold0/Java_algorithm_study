import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int[] arr = new int[9]; // 6과 9는 하나로 합침

        for (int i = 0 ; i < N.length(); i++) {
            int idx = N.charAt(i)-'0';
            if (idx == 9) {
                arr[6]++;
            } else {
                arr[idx]++;
            }
        }
        arr[6] = (arr[6] / 2) + (arr[6] % 2);
        Arrays.sort(arr);
        System.out.println(arr[8]);
    }
}