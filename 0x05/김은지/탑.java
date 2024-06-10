import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {
    private static Stack<int[]> tower = new Stack<>(); //탑 정보를 저장하는 Stack(idx, 높이)
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        /*
        StringTokenizer 객체
        : 문자열을 구분자를 이용하여 분리
            1. haseMoreTokens() 메소드 : 남아있는 토큰 여부 return boolean
            2. nextToken() 메소드 : 다음 토큰을 문자열로 반환 (가장 많이 사용)
            3. countTokens() 메소드 : 사용하지 않고 남아있는 토큰의 개수 반환
         */
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        for(int i = 1; i <= N; i++){
            int curr = Integer.parseInt(st.nextToken());
            while(!tower.isEmpty()){
                if (tower.peek()[1] < curr){ //왼쪽이 더 짧으면 닿지 않음
                    tower.pop();
                }else{
                    sb.append(tower.peek()[0] + " "); //탑의 높이 출력
                    break;
                }
                }
                if (tower.isEmpty()){
                    sb.append("0 ");
                }
                tower.add(new int[]{i, curr});
            }
        bw.write(String.valueOf(sb));
        bw.close();
    }
}
