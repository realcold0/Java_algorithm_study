package boj.greedy.linelength;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //start, end
        int[][] map= new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map, (a,b)->{
            return (a[0]-b[0] ==0)? a[1]-b[1] : a[0]-b[0];});
        List<int[]> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            boolean checked = false;
             if(!arr.isEmpty()) {
                for(int j = 0; j < arr.size();j++){
                    if(arr.get(j)[0] <= map[i][0] && map[i][0] <=arr.get(j)[1] ){
                        checked = true;
                        if(arr.get(j)[1]<map[i][1]){
                            arr.get(j)[1] = map[i][1];
                        }
                        break;
                    }
                }
            }
             if(!checked){
                arr.add(new int[]{map[i][0],map[i][1]});

             }

        }
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            int[] now = arr.get(i);
            sum += now[1]-now[0];
        }
        System.out.println(sum);

    }
}
