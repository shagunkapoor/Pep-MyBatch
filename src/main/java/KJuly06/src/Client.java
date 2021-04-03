
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Runtime Polymorphism
//		Stack obj=new DynamicStack(2);
//		obj.push(10);
//		obj.push(20);
//		obj.push(30);
//		obj.display();
//		
//		obj.pop();
//		obj.display();
//		obj.pop();
//		obj.display();
		
		
		Queue obj=new DynamicQueue(5);
		obj.enqueue(10);
		obj.enqueue(20);
		obj.enqueue(30);
		obj.enqueue(40);
		obj.enqueue(50);

		//obj.enqueue(190);
		obj.display();
		obj.deque();
		obj.display();
		obj.deque();
		//obj.deque();
		obj.display();
		obj.enqueue(90);
		obj.display();
		obj.enqueue(100);
		obj.enqueue(120);
		obj.display();
	}

}
