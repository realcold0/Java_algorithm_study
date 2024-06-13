import java.io.*;
import java.util.*;

public class Main {
    
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int[] arr = new int[10];
		for(char c : s.toCharArray()) {
			int num = c - '0';
			
			if(num==9) num=6;
			
			arr[num]++;
		}
		
		arr[6] = (arr[6]/2) + (arr[6]%2);
		Arrays.sort(arr);
		
		System.out.println(arr[9]);		
       
	}
	
	

}


