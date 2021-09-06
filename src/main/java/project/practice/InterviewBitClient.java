package project.practice;

public class InterviewBitClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InterviewBit ib=new InterviewBit();
		
		int[] arr={ 50, 25, 12, -1, 10, -1, -1, 37, 30, -1, 20, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87,
			-1, 90, -1 - 1, -1 };
		
		ib.construct(arr);
		
//		ib.verticalTraversal();
		
		ib.inorderTraversal();
		
	}

}
