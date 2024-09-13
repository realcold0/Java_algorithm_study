import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //음수끼리 곱하면 양수 되니 무조건 음수는 음수 끼리
        //0은 곱하면 안됨
        int n = Integer.parseInt(br.readLine());
        List<Integer> list1 = new ArrayList<>(); //음수
        List<Integer> list2 = new ArrayList<>(); //양수
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp <= 0) list1.add(tmp);
            else list2.add(tmp);
        }

        list1.sort(Integer::compareTo);
        list2.sort(Comparator.reverseOrder());


        int answer = 0;
        for (int i = 0; i < list1.size() - 1; i += 2) {
            if (list1.get(i) == 0) {
                for (int j = i; j < list1.size(); j++) {
                    answer += list1.get(j);
                }
                break;
            }
            answer += list1.get(i) * list1.get(i + 1);

        }
        for (int i = 0; i < list2.size() - 1; i += 2) {
            int first = list2.get(i);
            int sec = list2.get(i + 1);
            if (first == 1 || sec == 1) {
                answer += first + sec;
            } else {
                answer += first * sec;
            }
        }

        if (list1.size() % 2 != 0) answer += list1.get(list1.size() - 1);
        if (list2.size() % 2 != 0) answer += list2.get(list2.size() - 1);
//        System.out.println(list1.toString());
//        System.out.println(list2.toString());
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
