import java.io.*;
import java.util.*;


public class Main {

    public int countSushi(ArrayDeque<Integer> stack){
        Set<Integer> set = new HashSet<>();
        while(!stack.isEmpty()){
            set.add(stack.pop());
        }
        return set.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[n+k];
        Set<Integer> set = new HashSet<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n+k; i++) {
            if(i<n){
                sushi[i] = Integer.parseInt(br.readLine());
                    if(i < k){
                        set.add(sushi[i]);
                        stack.addLast(sushi[i]);
                    }
            }else{
                sushi[i] = sushi[i-n];
            }
        }
        //two - pointer
        //현재 set에 idx 0~ k-1까지 들어가있음
        int ans = -1;
        int prevcount =set.size();
        for(int i = k; i < sushi.length; i++) {
            int nowcount = prevcount;
            int first = stack.pollFirst();
            if(!stack.contains(first)){
                nowcount--;
            }
            if(!stack.contains(sushi[i])){
                nowcount++;
            }
            stack.addLast(sushi[i]);
            if(!stack.contains(c)){
                ans = Math.max(ans, nowcount+1);
            }else{
                ans = Math.max(ans, nowcount);
            }
            prevcount = nowcount;
        }


        bw.write(ans+"\n");
        bw.flush();

    }
}
