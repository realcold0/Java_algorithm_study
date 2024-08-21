import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>(); //콘센트

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            map.putIfAbsent(tmp, new LinkedList<>());
            map.get(tmp).add(i);
        }

//        System.out.println(map.toString());
        int answer = 0;

        //2 3 2 3 1 2 7
        for (int i = 0; i < k; i++) {
            int tmp = arr[i];
            if (set.contains(tmp)) {
                map.get(tmp).remove(0); //앞에 있는거 지움
                continue;
            }
            if (set.size() == n) { //콘센트 꽉참
                int next = 0; //조건 1부터라서
                for (int flug : set) {
                    //콘센트의 플러그중에 가장 나중에 쓰거나 안쓰는거
                    //체크
                    if (map.get(flug).isEmpty()) {
                        next = flug;
                        break;
                    }
                    if (next == 0 || map.get(flug).get(0) > map.get(next).get(0)) {//다음거중에 제일 큰거
                        next = flug;
                    }
                }
                set.remove(next);
                set.add(tmp);
                map.get(tmp).remove(0);
                answer++;
            } else { //자리 비어 있다면
                set.add(tmp);
                map.get(tmp).remove(0);
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
