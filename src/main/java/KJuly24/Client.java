package KJuly24;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int[] sa={12,30,35,37,40,50,60,67,70,75,87};
		// AVL avl=new AVL(sa);
		// avl.display();

		int[] sa = { 10, 12, 25, 37, 50, 62, 75, 87, 90 };
		AVL avl = new AVL(sa);
		avl.display();
		System.out.println("*****************");
		avl.add(5);
		avl.display();
		System.out.println("***********");
		avl.add(10);
		avl.add(5);
		avl.removeNode(12);
		avl.removeNode(37);
		avl.display();

	}

}
