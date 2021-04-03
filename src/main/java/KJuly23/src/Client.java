
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr={12,30,35,37,40,50,60,67,70,75,87};
		
		BinarySearchTree bst=new BinarySearchTree(arr);
		bst.display();
		
		System.out.println("*****************");
		
//		System.out.println(bst.find(35));
//		System.out.println(bst.max());
//		bst.printInRange(30, 70);
//		bst.replaceNodesWithSum();
//		bst.display();
//		bst.addNode(65);
//		bst.display();
//		bst.add2(65);
//		bst.display();
		bst.removeLeaves(87);
		bst.display();

	}

}
