import java.io.*;
import java.util.*;

public class 파티 {

    static class Edge {
        int to;
        long time;  // time을 long으로 변경
        Edge(int to, long time) {
            this.to = to;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new ArrayList[N + 1];
        List<Edge>[] reverseGraph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long time = Long.parseLong(st.nextToken());
            graph[from].add(new Edge(to, time));
            reverseGraph[to].add(new Edge(from, time));
        }

        long[] distFromX = dijkstra(graph, X, N);
        long[] distToX = dijkstra(reverseGraph, X, N);

        long maxTime = 0;
        for (int i = 1; i <= N; i++) {
            if (i != X) {
                long totalTime = distFromX[i] + distToX[i];
                maxTime = Math.max(maxTime, totalTime);
            }
        }

        System.out.println(maxTime);
    }

    public static long[] dijkstra(List<Edge>[] graph, int start, int n) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingLong(e -> e.time));
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.to;

            for (Edge edge : graph[currentNode]) {
                if (dist[currentNode] + edge.time < dist[edge.to]) {
                    dist[edge.to] = dist[currentNode] + edge.time;
                    pq.offer(new Edge(edge.to, dist[edge.to]));
                }
            }
        }

        return dist;
    }
}
