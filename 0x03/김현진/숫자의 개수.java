import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int[] arr = new int[10];

        int n = A * B * C;
        String N = Integer.toString(n);

        for (int i = 0; i < N.length(); i++) {
            arr[N.charAt(i)-'0']++;
        }
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
