import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp < x) {
                arr[i] = tmp;
            }
        }

        // 정렬을 한뒤에
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        int count = 0;
        while (start < end) {
            if (arr[start] + arr[end] == x) {
                count++;
                start++;
            } else if (arr[start] + arr[end] < x) {
                start++;
            } else {
                end--;
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}
