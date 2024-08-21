package boj.greedy.groupnumber;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        int ones = 0;
        int zeros = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                positives.add(num);
            } else if (num == 1) {
                ones++;
            } else if (num == 0) {
                zeros++;
            } else {
                negatives.add(num);
            }
        }

        positives.sort(Collections.reverseOrder());
        Collections.sort(negatives);

        long result = 0;

        // 큰 양수끼리 묶어서 곱한다.
        for (int i = 0; i < positives.size(); i += 2) {
            if (i + 1 < positives.size()) {
                result += (long) positives.get(i) * positives.get(i + 1);
            } else {
                result += positives.get(i);
            }
        }

        // 작은 음수끼리 묶어서 곱한다.
        for (int i = 0; i < negatives.size(); i += 2) {
            if (i + 1 < negatives.size()) {
                result += (long) negatives.get(i) * negatives.get(i + 1);
            } else if (zeros == 0) {
                result += negatives.get(i);
            }
        }

        // 1은 곱하기보다는 더하는 것이 유리하다.
        result += ones;

        System.out.println(result);
    }
}
