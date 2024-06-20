import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        class Element{
            int index;
            int value;
            public Element(int index, int value){
                this.index = index;
                this.value = value;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        int[] answer = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        Deque<Element> deque = new LinkedList<>();
        deque.add(new Element(0, arr[0]));
        sb.append(deque.peekFirst().value).append(" ");
        //문자열 지나면서 정답 배열 만들기
        for(int i = 1; i < n; i++) {
            int out = i - l;
            //덱에 넣기
            //덱에 넣을때 삽입 정렬?
            //덱의 의미가 없어짐....

            //나가야 되는 인덱스면 나가게
            if( out >= 0 && deque.peekFirst().index == out ){
                deque.removeFirst();
            }

            //최솟값이 나오도록 최솟값 저장
            while(!deque.isEmpty()){
                if(deque.peekLast().value > arr[i]){
                    deque.removeLast();
                }else{
                    break;
                }
            }

            deque.addLast(new Element(i, arr[i]));
            sb.append(deque.peekFirst().value).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}