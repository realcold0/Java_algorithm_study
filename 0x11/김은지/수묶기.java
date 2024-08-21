package boj.greedy.groupnumber;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        boolean[] visited = new boolean[n];
        int minusCnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] <0) minusCnt++;
        }
        Arrays.sort(arr,Collections.reverseOrder());
        int sum = Arrays.stream(arr).mapToInt(Integer::intValue).sum();
        int multiSum = Integer.MIN_VALUE;
        int i = 0;
        while( i < n-1){
            if(arr[i] * arr[i+1] >0 || (arr[i] ==0 && arr[i+1] < 0 && (minusCnt %2 !=0))){
                if(multiSum == Integer.MIN_VALUE){
                    multiSum =0;
                }
                multiSum += arr[i]*arr[i+1];
                visited[i] = true;
                visited[i+1] = true;
                i +=2;
            }else{
                if(multiSum == Integer.MIN_VALUE){
                    multiSum =0;
                }
                multiSum += arr[i];
                visited[i] = true;
                i++;
            }
        }
        if(!visited[n - 1]){
            if(multiSum == Integer.MIN_VALUE){
                multiSum =0;
            }
            multiSum += arr[n-1];
        }

        System.out.println(Math.max(sum, multiSum));
    }
}
