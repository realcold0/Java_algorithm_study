import java.io.*;
import java.util.*;

public class Solution {
    
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] number = new int[N];
		int count =0; 
		
		HashSet<Integer> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
			set.add(number[i]);
 		}
		
		int X = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			if(set.contains(X-number[i])) count++;
		}
		
		System.out.print(count/2);
       
	}
	
	

}


