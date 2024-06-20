import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        test:
        for(int i = 0;i<T;i++){
            String commend = br.readLine();
            int  n = Integer.parseInt(br.readLine());
            boolean start = true;
            //앞뒤에 [] 제거
            String beforeArr = br.readLine().replace("[","").replace("]", "");
            //배열 비어 있다면 error
//            if(beforeArr.equals("")){
//                sb.append("error\n");
//                continue test;
//            }
            LinkedList<Integer> deque = new LinkedList<>();
            //배열 데크에 넣기
            if(beforeArr.length() != 0){
                String[] stringArr = beforeArr.split(",");
                int[] arr = Arrays.stream(stringArr).mapToInt(Integer::parseInt).toArray();

                for(int k : arr){
                    deque.add(k);
                }
            }


            //커맨드 문자열에서 각 index로 가져오기
            commend:
            for(int j =0; j< commend.length(); j++){
                char commendEach = commend.charAt(j);
                if(commendEach == 'D') {
                    if(!deque.isEmpty()){
                        //왼쪽에서 하고 있다면
                        if(start){
                            deque.removeFirst();
                        }else{ //오른쪽에서 부터 하고 잇다면
                            deque.removeLast();
                        }
                    }else{
                        sb.append("error").append('\n');
                        continue test;
                    }

                }
                else if(commendEach == 'R'){
                    start = !start;
                }
            }
            //왼쪽에서 갈때
            if(start){
                sb.append(deque.stream()
                        .map(num ->  num.toString())
                        .collect(Collectors.joining(",", "[", "]"))).append("\n");
            }else{ //오른쪽에서 갈때
                if(deque.isEmpty()){
                    sb.append("[]");
                }
                else{
                    sb.append("[");
                    for(int j = deque.size() -1 ;j >= 0;j--){
                        sb.append(Integer.toString(deque.get(j)));
                        if(j==0){
                            sb.append("]");
                        }else{
                            sb.append(",");
                        }
                    }
                }

                sb.append("\n");

            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}