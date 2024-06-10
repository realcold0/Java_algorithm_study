import java.io.*;
import java.util.*;


public class Main {
    public static class Building{
        int top;
        int index;
        public Building(int top, int index){
            this.top = top;
            this.index = index;
        }
    }
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Stack<Building> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= n ;i++){
            int buildingTop = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()){
                sb.append("0 ");
                stack.push(new Building(buildingTop, i));
            }else{
                while(true){
                    if(stack.isEmpty()){
                        sb.append("0 ");
                        stack.push(new Building(buildingTop, i));
                        break;
                    }
                    if (stack.peek().top > buildingTop){ //스택이 더크다
                        sb.append(stack.peek().index).append(" ");
                        stack.push(new Building(buildingTop, i));
                        break;
                    }
                    else{ //낵가 더크다
                        stack.pop();
                    }
                }

            }



        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }





}