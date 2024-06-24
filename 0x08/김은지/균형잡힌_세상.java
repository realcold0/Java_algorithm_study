import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class 균형잡힌_세상 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            char[] line = br.readLine().toCharArray();
            if(line.length ==1 && line[0] =='.'){
                bw.flush();
                bw.close();
                System.exit(0);
            }
            Deque<Character> stack = new LinkedList<>();
            boolean flag = true;
            //tmp에 현재 idx의 값을 넣은 후, 시작 괄호들을만날 때마다 stack에 쌓기
            //끝 괄호를 만나면 현재 stack에 있는 값과 비교후 처리
            for (int idx = 0; idx < line.length; idx++){
                char tmp = line[idx];
                if (tmp =='(' || tmp=='['){
                    stack.add(tmp);
                }else if(tmp ==')' || tmp==']') {
                    if(stack.isEmpty()){
                        flag = false;
                        break;
                    }else{
                        char comp = stack.peekLast();
                        if (comp == '(' && tmp == ')') {
                            stack.pollLast();
                        } else if (comp == '[' && tmp == ']') {
                            stack.pollLast();
                        } else {
                            flag = false;
                            break;
                        }
                    }

                }
            }
            if(flag && stack.isEmpty()){
                bw.write("yes\n");
            }else{
                bw.write("no\n");
            }
        }

    }
}
