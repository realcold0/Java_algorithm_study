import java.util.*;
import java.io.*;

class Solution {
    int alen;
    int blen;
    int[] a;
    int[] b;

    Solution(int alen, int blen, int[] a, int[] b) {
        this.alen = alen;
        this.blen = blen;
        this.a = a;
        this.b = b;
    }

    // B 배열에서 key보다 작은 값의 개수를 찾기 위한 이진 탐색 메소드
    public int countLessThan(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int solution() {
        int ans = 0;
        // 1. 정렬
        Arrays.sort(a);
        Arrays.sort(b);

        // 2. A를 하나씩 순회하면서 B에서 자신보다 작은 수의 개수 찾기
        for (int nowA : a) {
            ans += countLessThan(b, nowA);
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int alen = Integer.parseInt(st.nextToken());
            int blen = Integer.parseInt(st.nextToken());
            int[] a = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] b = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Solution sol = new Solution(alen, blen, a, b);
            bw.write(String.valueOf(sol.solution()));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
