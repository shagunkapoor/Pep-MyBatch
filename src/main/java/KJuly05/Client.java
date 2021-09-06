package KJuly05;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		BStackOperations r1=new BStackOperations(5);
//		
//		r1.push(10);
//		r1.push(20);
//		r1.push(30);
//		r1.display();
//		
//		r1.pop();
//		r1.display();
//		r1.pop();
//		r1.display();
//		
//		System.out.println(r1.size());
//		System.out.println(r1.isEmpty());
//		
		System.out.println();
		System.out.println("***************************************");
		
		
		CQueueOperations r2=new CQueueOperations(5);
		r2.enqueue(10);
		r2.enqueue(20);
		r2.enqueue(30);
		r2.enqueue(40);
		r2.enqueue(50);
		r2.display();
		r2.deque();
		r2.display();
		r2.deque();
		r2.display();
		r2.enqueue(90);
		r2.display();
		r2.enqueue(100);
		r2.display();
		
		System.out.println(r2.isEmpty());
		System.out.println(r2.size());
	}

}
