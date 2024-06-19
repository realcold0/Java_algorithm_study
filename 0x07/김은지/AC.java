import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class AC {
    //Boj 5430
    public static void AC(String[] p,Deque<Integer> d){
        boolean reverse = false; //뒤집기 상태 : true 이면 D 명령 거꾸로 수행
        //명령문을 끝까지 돌기
        for (String s : p) {
            if (s.equals("D")) {
                if (d.isEmpty()) {
                    System.out.println("error");
                    return;
                }
                //뒤집기 상태에 따라 제거 순서 다름
                if (reverse) {
                    d.pollLast();
                } else {
                    d.pollFirst();
                }

            } else { //R : 뒤집기
                reverse = !reverse;
            }
        }

        StringBuilder st = new StringBuilder();
        st.append("[");
        while(!d.isEmpty()){
            st.append((reverse ? d.pollLast() : d.pollFirst()));
            if(!d.isEmpty()) st.append(",");
        }
        st.append("]");
        System.out.println(st);
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String[] p = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());

            Deque<Integer> d = new ArrayDeque<>();
            String readString =br.readLine();
            for(String s : readString.substring(1,readString.length()-1).split(",")){
                if(!s.isEmpty())
                    d.add(Integer.valueOf(s));
            }
            AC(p,d);
        }

    }


}