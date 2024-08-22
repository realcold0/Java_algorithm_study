import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        List<Integer> listP = new ArrayList<>(); // 양수
        List<Integer> listN = new ArrayList<>(); // 음수

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                listP.add(num);
            } else {
                listN.add(num);
            }
        }

        Collections.sort(listP, Collections.reverseOrder()); // 내림차순 정렬
        Collections.sort(listN);

        int idxP = 0;
        while (idxP < listP.size()) {
            if (idxP + 1 < listP.size() && listP.get(idxP) != 1 && listP.get(idxP + 1) != 1) {
                sum += listP.get(idxP) * listP.get(idxP + 1);
                idxP += 2;
            } else {
                sum += listP.get(idxP);
                idxP++;
            }
        }

        int idxN = 0;
        while (idxN < listN.size()) {
            if (idxN + 1 < listN.size()) {
                sum += listN.get(idxN) * listN.get(idxN + 1);
                idxN += 2;
            } else {
                sum += listN.get(idxN);
                idxN++;
            }
        }
        System.out.println(sum);
    }
}
