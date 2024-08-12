import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class 좋은_단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        while(n-->0){
            char[] line = br.readLine().toCharArray();
            Deque<Character> stack = new LinkedList<>();
            boolean flag = true;
            for (int idx = 0; idx < line.length; idx++){
                if(stack.isEmpty()){
                    stack.add(line[idx]);
                }else{
                    char tmp = line[idx];
                    char top = stack.peekLast();
                    if(tmp == top){
                        stack.pollLast();
                    }else{
                        stack.add(tmp);
                    }
                }

            }
            if(stack.isEmpty()){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
