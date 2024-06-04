import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int[] arr = new int[26]; // 개수 저장하는 배열

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-97]++;
        }

        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
