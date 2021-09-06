package KJuly07;

import java.util.Scanner;

public class StackQBS {
	int tos = -1;
	int[] arr;

	public StackQBS(int cap) {
		arr = new int[cap];
	}

	public int size() {
		if (tos == -1) {
			return 0;
		} else {
			return tos + 1;
		}
	}

	public void push(int data) {
		if (tos == arr.length - 1) {
			System.out.println("Stack Overflow");
			return;
		}
		tos++;
		arr[tos] = data;
	}

	public int pop() {
		if (tos == -1) {
			return -1;
		}
		int rv = arr[tos];
		tos--;
		return rv;
	}

	public void display() {
		if (tos == -1) {
			System.out.println("-1");
			return;
		} else {
			for (int i = 0; i < tos; i++) {
				System.out.println(arr[i]);
			}
		}
	}
}

	class DQueueByStack {
		
	}
	
		
	public void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number of operations");
		int n = scn.nextInt();

		Stack prev=new Stack(n);
		Stack curr=new Stack(n);

		for (int i = 0; i <= n; i++) {
			String input = scn.nextLine();
		
			char oprn = input.charAt(0);
			if (oprn == 'e') {
				int num = input.charAt(1);
				push_enqueue(n, oprn, num, prev, curr);
			} else {
				System.out.print(pop_dequeue(n, oprn, prev) + " ");
			}

//			 char oprn = scn.nextLine().charAt(0);
//			 if (oprn == 'e') {
//			 int num = scn.nextInt();
//			 push_enqueue(n, oprn, num, prev, curr);
//			 } else {
//			 System.out.print(pop_dequeue(n, oprn, prev) + " ");
//			 }
			display(prev);
		}
	}

	public void push_enqueue(int n, char oprn, int num, Stack prev, Stack curr) { // enqueue
		if (prev.size() == 0) {
			prev.push(num);
		} else {
			while (prev.size() != 0) {
				int rem = prev.pop();
				curr.push(rem);
			}
			prev.push(num);
			while (curr.size() != 0) {
				prev.push(curr.pop());
			}

		}
	}

	public int pop_dequeue(int n, char oprn, Stack prev) { // dequeue
		if (prev.size() == 0) {
			return -1;
		} else {
			return prev.pop();
		}

	}

	public void display(Stack prev) {
		prev.display();

	}
	}


	
