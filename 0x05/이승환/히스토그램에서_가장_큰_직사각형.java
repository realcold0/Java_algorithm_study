import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());

            if( n == 0){
                bw.write(sb.toString());
                bw.flush();
                bw.close();
                return;
            }
            Integer arr[] = new Integer[n];
            Stack<Integer> stack = new Stack<>();
            int max =Integer.MIN_VALUE;
            //값들 다 배열에 넣기
            for(int i = 0; i< n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            //거꾸로 진행
            for(int i = n-1; i >=0; i--){
                if(stack.isEmpty()){
                    stack.push(arr[i]);
                }else{
                    if(stack.peek() >= arr[i]){
                        stack.push(arr[i]);
                    }else{ //이전거보다 큰값
                        int count = stack.size();
                        while(!stack.isEmpty()){
                            int tmp = stack.pop() * count--;
                            if(tmp > max){
                                max = tmp;
                            }
                        }
                        if(stack.isEmpty()){
                            stack.push(arr[i]);
                        }
                    }
                }
            }

            //다끝나고 남은
            if(!stack.isEmpty()){
                int count = stack.size();
                while(!stack.isEmpty()){
                    int tmp = stack.pop() * count--;
                    if(tmp > max){
                        max = tmp;
                    }
                }
            }
            sb.append(max).append("\n");

        }

    }


}