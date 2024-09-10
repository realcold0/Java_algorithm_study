package boj.greedy.stock;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] days = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                days[j] = Integer.parseInt(st.nextToken());
            }

            long money = 0; // 누적 금액이 클 수 있으므로 long으로 수정
            int max = days[n - 1];

            for (int day = n - 2; day >= 0; day--) {
                if (days[day] <= max) {
                    money += max - days[day];
                } else {
                    max = days[day];
                }
            }

            bw.write(money + "\n");
        }
        bw.flush();
        bw.close();
    }
}
