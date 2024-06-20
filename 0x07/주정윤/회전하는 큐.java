import java.io.*;
import java.util.*;

public class Solution {
    
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        LinkedList<Integer> deque = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N, M 값 입력받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for(int i=1; i<=N; i++) {
        	deque.add(i);
        }
        
        // 횟수 count 변수 선언, 입력 값을 저장할 배열 선
        int count = 0;
        int[] arr = new int[M];
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        
        for(int i=0; i<M; i++) {
        	arr[i] = Integer.parseInt(st1.nextToken());      	
        }
        
        for(int i=0; i<M; i++) {
        	int target = deque.indexOf(arr[i]);
        	int middle;
        	
        	if(deque.size() % 2 == 0) {
        		middle = deque.size() / 2 -1;
        	}
        	else {
        		middle = deque.size() / 2;
        	}
        	
        	// 중간 지점 보다 원소의 위치가 앞에 있는 경우는 2번 순환 
        	if(target <= middle) {
        		for(int j=0; j< target; j++) {
        			int temp = deque.pollFirst();
        			deque.offerLast(temp);
        			count++;
        		}
        	}
        	else {
        		// 중간 지점보다 원소의 위치가 뒤에 있는 경우는 3번 순환 
        		for(int j=0; j<deque.size()-target; j++) {
        			int temp = deque.pollLast();
            		deque.offerFirst(temp);
            		count++;
        		}
        	}
        	
        	deque.pollFirst();
        }
        
        sb.append(count);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
		
	}
	
	

}


