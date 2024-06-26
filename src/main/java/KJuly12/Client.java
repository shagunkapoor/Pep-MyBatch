package KJuly12;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Generalized
		 int[] arr={10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120,
		 -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
		 GenricTree gt=new GenricTree(arr);
		 gt.display();

		// Hardcoded
		// GenricTree gt=new GenricTree();
//		gt.display();

		// System.out.println("Size:");
		// System.out.println(gt.size());
		//
		// System.out.println(gt.max());
		//
		// System.out.println(gt.height());

		// System.out.println(gt.find(110));
		// gt.mirror();
		// gt.display();
		// System.out.println();
		// System.out.println("************************");

		// gt.removeLeaves();
		// gt.display();

//		 gt.linearize();
//		 gt.display();
		System.out.println("Level Order");
		gt.levelorder();
		//
		// gt.levelorderLineWise();
		System.out.println("Level Order Left Wise (Zig-Zag)");
		gt.levelorderLeftWise();

		// gt.preOrder();
		//
		 System.out.println("************************");
		// gt.postOrder();

		// gt.multisolver(90);

		// July 16

		System.out.println(gt.serialize());
//		 gt.display();
		

//		 int[] arr1={10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120,
//		 -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
//		 GenricTree gt1=new GenricTree(arr1);
//
//		 int[] arr2={100, 200, 500, -1, -1, 300, 700, -1, 800, 110, -1, 120,
//		 -1, -1, 90, -1, -1, 40, 100, -1,50,-1, -1, -1};
//		 GenricTree gt2=new GenricTree(arr2);
//		 
//		 System.out.println(gt1.isIsomorphic(gt2));
//		 System.out.println(gt1.isMirrorImage(gt2));
//		 System.out.println(gt1.isFoldable());
		 
		 
//		 gt.display();
		System.out.println("**********");
		 
		 gt.justLarger(50);
		 System.out.println(gt.kthLargest(65,3));
		
	}

}
