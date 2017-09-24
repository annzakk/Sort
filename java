import java.util.*;

public class Sort {
	public static void main(String[] args) { 
		
		int [] a  =  {65,10,0,3,4,9,6,4,2,5,4,6,8,-5,-1};
			for(int i = 0; i < a.length; i++) {
				for (int j = i + 1; j < a.length; j++) {
						            int temp = 0;
						            if (a[i] < a[j]) {
						                temp = a[i];
						                a[i] = a[j];
						                a[j] = temp;
						            }
				}
			}
						            for(int i = 0; i <a.length; i++){
						            System.out.print(" " + a[i]);
						            }
			
	}
	
}
