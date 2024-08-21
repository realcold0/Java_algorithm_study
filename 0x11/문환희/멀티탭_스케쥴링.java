import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 멀티탭_스케쥴링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[101];
        int ans = 0;

        int[] list = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[num]++;
            list[i] = num;
        }

        HashSet<Integer> work = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < k; i++) {
            int now = list[i];
            if(work.contains(now)) {
                arr[now]--;
                continue;
            }

            if(work.size() < n) {
                work.add(now);
                stack.push(now);
                arr[now]--;
            }
            else {
                int deviceToUnplug = -1;
                int lastUsage = -1;

                for (int m : work) {
                    int nextUsage = 0;
                    for (int j = i + 1; j < k; j++) {
                        if (list[j] == m) {
                            nextUsage = j;
                            break;
                        }
                    }

                    if (nextUsage > lastUsage) { // 꽂혀있는 기기 중 가장 마지막으로 사용될 기기
                        lastUsage = nextUsage;
                        deviceToUnplug = m;
                    }

                    if (nextUsage == 0) { // 앞으로도 사용되지 않을 기기이므로 제거
                        deviceToUnplug = m;
                        break;
                    }
                }

                work.remove(deviceToUnplug);
                work.add(now);
                arr[now] --;
                ans++;
            }
        }
        System.out.println(ans);

        br.close();
    }
}