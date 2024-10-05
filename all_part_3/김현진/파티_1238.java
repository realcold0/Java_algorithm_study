import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        Map<Integer, List<Edge>> graph = new HashMap<>();
        Map<Integer, List<Edge>> reverseGraph = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
            reverseGraph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
            reverseGraph.get(v).add(new Edge(u, w));
        }

        int[] times = Dijkstra(graph);
        int[] reverseTimes = Dijkstra(reverseGraph);

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, times[i]+reverseTimes[i]);
        }

        System.out.println(maxTime);
    }

    static int[] Dijkstra(Map<Integer, List<Edge>> graph) {
        int[] times = new int[N + 1];
        Arrays.fill(times, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(X, 0));
        times[X] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (times[cur.node] < cur.time) continue;

            for (Edge next : graph.get(cur.node)) {
                int nextTime = next.time + times[cur.node];
                if (times[next.node] > nextTime) {
                    pq.offer(new Edge(next.node, nextTime));
                    times[next.node] = nextTime;
                }
            }
        }
        return times;
    }
}

class Edge implements Comparable<Edge> {
    int node, time;

    public Edge(int node, int time) {
        this.node = node;
        this.time = time;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.time, o.time);
    }
}
