package project.practice;

import java.util.LinkedList;

public class Practice {

	public static void main(String[] args) {
		String str = "765028321";
		int n = 5;
		// String str="4325043";
		// int n=3;
		// String str="121198";
		// int n=2;

		String res = buildLowest(str, n);
		System.out.println(res);
		
		
		System.out.println(isPower(49));
	}

	private static String buildLowest(String str, int n) {

		LinkedList<Character> queue = new LinkedList<>();
		String res = "";

		int len = str.length();
		int k = len - n; // remaining digits in o/p string

		int i;
		// selecting 1st digit from len-(k-1) digits
		for (i = 0; i <= len - k; i++) {

			insertInNonDecOrder(queue, str.charAt(i));
		}

		while (i < len) {
			res += queue.removeFirst();

			insertInNonDecOrder(queue, str.charAt(i));
			i++;
		}

		res += queue.removeFirst(); // last elt in queue
		return res;
	}

	private static void insertInNonDecOrder(LinkedList<Character> queue, char ch) {

		if (queue.isEmpty()) {
			queue.addLast(ch);
		} else {

			char temp = queue.peek();
			while (temp > ch && !queue.isEmpty()) {
				queue.removeFirst();

				if (!queue.isEmpty()) {
					temp = queue.peek();
				}
			}

			queue.addLast(ch);
		}

		return;
	}
	
	private static boolean isPower(int n) {
		if(n==1)
			return true;
        // Find Log n in different 
        // bases and check if the  
        // value is an integer 
        for (int x = 2; x <=  
               (int)Math.sqrt(n); x++)  
        { 
            double f = Math.log(n) /  
                      Math.log(x); 
                        
            if ((f - (int)f) ==0.0)//< 0.00000001)  
                return true;      
        } 
        return false; 
    } 

}
