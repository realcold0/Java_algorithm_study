package boj.greedy.scheduling;

import java.io.*;
import java.util.*;

class Task implements Comparable<Task>{
    int start;
    int end;
    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Task o) {
        //종료 시간이 빠른 순서대로
        //종료 시간이 같다면 시작 시간이 빠른 순서대로
        int firstCon = this.end - o.end;
        if(firstCon == 0) {
            return this.start - o.start;
        }
        return firstCon;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Task[] tasks = new Task[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tasks[i] = new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(tasks);
        int ans = 0;
        int now =0;
        for(int i = 0; i < n; i++) {
            Task nowTask = tasks[i];
            if(now <= nowTask.start ){
                now = nowTask.end;
                ans++;
            }
        }
        System.out.println(ans);

    }
}
