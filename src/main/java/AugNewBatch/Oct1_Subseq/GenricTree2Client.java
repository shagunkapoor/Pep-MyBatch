package AugNewBatch.Oct1_Subseq;

public class GenricTree2Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120,
				 -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

		int[] arr2={10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120,
				 -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
		
				 GenricTree2 gt=new GenricTree2(arr);
//				 gt.display();
//				 
//				 gt.Linearize2();
//				 gt.display();
				 
				 
				 GenricTree2 gt2=new GenricTree2(arr2);
				 System.out.println(GenricTree2.haveSimilarStructure(gt, gt2));
				 System.out.println(GenricTree2.haveMirrorStructure(gt, gt2));
				 
				 System.out.println(gt.size());
				 System.out.println(gt2.size());
				 
				 
	}

}
