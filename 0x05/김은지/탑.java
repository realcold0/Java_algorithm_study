import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {
    private static Stack<Integer> tower = new Stack<>(); //탑 정보를 저장하는 Stack
    private static Stack<Integer> tmp = new Stack<>(); //비교과정을 담는 Stack
    private static Stack<Integer> answer = new Stack<>(); //답 Stack

    public static int compare_rasor(int sign){
        if(!tower.isEmpty()){
            int cmp = tower.pop();
            tmp.add(cmp);
            if (sign < cmp){
                return tower.size() + 1;
            }else{
                return compare_rasor(sign);
            }
        }else{
            return 0;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /*
        StringTokenizer 객체
        : 문자열을 구분자를 이용하여 분리
            1. haseMoreTokens() 메소드 : 남아있는 토큰 여부 return boolean
            2. nextToken() 메소드 : 다음 토큰을 문자열로 반환 (가장 많이 사용)
            3. countTokens() 메소드 : 사용하지 않고 남아있는 토큰의 개수 반환
         */
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        for(int i = 0; i < N; i++){
            tower.add(Integer.parseInt(st.nextToken()));
        }
        int sign;//비교하는 주체
        while(!tower.isEmpty()){
            sign = tower.pop();
            answer.add(compare_rasor(sign));
            while(!tmp.isEmpty()){
                tower.add(tmp.pop());
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!answer.isEmpty()){
            sb.append(answer.pop()).append(" ");
        }
        bw.write(String.valueOf(sb));
        bw.close();
    }
}
