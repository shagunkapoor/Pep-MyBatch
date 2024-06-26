package AmazonQues;

import java.util.LinkedList;

public class GeeksQues {

	public static void main(String[] args) {

		// Printing brackets in Matrix Chain Multiplication Problem
		// Given an array p[] which represents the chain of matrices such
		// that the ith matrix Ai is of dimension p[i-1] x p[i]. We need to
		// write a function MatrixChainOrder() that should return the minimum
		// number of multiplications needed to multiply the chain.
		//
		// Input: p[] = {40, 20, 30, 10, 30}
		// Output: Optimal parenthesization is ((A(BC))D)
		// Optimal cost of parenthesization is 26000

		 int[] dims = { 10,20,30,40,50,60};//40, 20, 30, 10, 30 };
		 System.out.println("Min Operations:" +
		 MatrixChainMultiplication(dims, 0, 5).cost);
		 System.out.println("Order of execution:" +
		 MatrixChainMultiplication(dims, 0, 5).name);
		System.out.println("********************");

		// Count total set bits in all numbers from 1 to n
		// Given a positive integer n, count the total number of
		// set bits in binary representation of all numbers from 1 to n.
		System.out.println(CountSetbits(7));
		System.out.println("********************");

		// Number of subsequences of the form a^i b^j c^k
		// Given a string, count number of subsequences of the form aibjck,
		// i.e.,
		// it consists of i �a� characters, followed by j �b� characters,
		// followed by k �c� characters where i >= 1, j >=1 and k >= 1.
		//
		// Note: Two subsequences are considered different if the set of array
		// indexes picked for the 2 subsequences are different.
		//
		// Expected Time Complexity : O(n)
		//
		// Examples:
		//
		// Input : abbc
		// Output : 3
		// Subsequences are abc, abc and abbc

		System.out.println(numberofSubseq("cbacbaabc"));
		System.out.println("********************");

		// Replace every element with the greatest element on right side
		// Given an array of integers, replace every element with the next
		// greatest element (greatest element on the right side) in the array.
		// Since there is no element next to the last element, replace it with
		// -1. For example, if the array is {16, 17, 4, 3, 5, 2}, then it should
		// be modified to {17, 5, 5, 5, 2, -1}.

		int[] arr = { 16, 17, 4, 3, 5, 2 };
		int[] res = greatestElementonRight(arr);
		for (int i : res) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("********************");

		// Highest power of 2 less than or equal to given number
		// Given a number n, find the highest power of 2 that is smaller than or
		// equal to n.
		//
		// Examples :
		//
		// Input : n = 10
		// Output : 8
		//
		// Input : n = 19
		// Output : 16

		int num = 19;
		System.out.println(highestPowerof2(num));
		System.out.println("********************");

		// Count all possible paths from top left to bottom right of a mXn
		// matrix
		// The problem is to count all the possible paths from top left to
		// bottom right of a mXn matrix with the constraints that from each cell
		// you can either move only to right or down
		//
		// Examples :
		//
		// Input : m = 2, n = 2;
		// Output : 2
		// There are two paths
		// (0, 0) -> (0, 1) -> (1, 1)
		// (0, 0) -> (1, 0) -> (1, 1)

		int m = 3;
		int n = 3;
		System.out.println(countAllPaths(0, 0, m, n));
		System.out.println("********************");

		// Paths
		// countAllPaths2(0, 0, 3, 3, "");
		// System.out.println("********************");

		// Find a pair with maximum product in array of Integers
		// Given an array with both +ive and -ive integers, return a pair with
		// highest product.
		// Examples :
		//
		// Input: arr[] = {1, 4, 3, 6, 7, 0}
		// Output: {6,7}
		//
		// Input: arr[] = {-1, -3, -4, 2, 0, -5}
		// Output: {-4,-5}

		int[] maxarr = { -1, -3, -4, 2, 0, -5 };
		MaximumProductinArray(maxarr);
		System.out.println("********************");

		// Given a binary string, count number of substrings that start and end
		// with 1.
		// Given a binary string, count number of substrings that start and end
		// with 1. For example, if the input string is �00100101�, then there
		// are three substrings �1001�, �100101� and �101�.

		String input = "10101101";
		System.out.println(CountSubstringsBTW1AND1(input));
		System.out.println("********************");

		// Given only a pointer/reference to a node to be deleted in a singly
		// linked list,
		// how do you delete it?
		// Given a pointer to a node to be deleted, delete the node.
		// Note that we don�t have pointer to head node.

		Node o = new Node(6, null);
		Node o1 = new Node(5, o);
		Node o2 = new Node(4, o1);
		Node o3 = new Node(3, o2);
		Node o4 = new Node(2, o3);
		Node o5 = new Node(1, o4);
		root = o5;
		DeleteANode(o3);
		System.out.println("\n********************");

		// Write a Program to Find the Maximum Depth or Height of a Tree
		// Given a binary tree, find height of it. Height of empty tree is 0 and
		// height of below tree is 3.
		
		//constructing tree
		Tree t4=new Tree(4,null,null);
		Tree t5=new Tree(5,null,null);
		Tree t2=new Tree(2,t4,t5);
		Tree t8=new Tree(8,null,null);
		Tree t3=new Tree(3,t8,null);
		Tree t=new Tree(1,t2,t3);
		troot=t;
		System.out.println(DepthofATree());
		System.out.println("********************");
		
		
//		Print nodes at k distance from root
//		Given a root of a tree, and an integer k. Print all the nodes which are 
//		at k distance from root.
//		For example, in the below tree, 4, 5 & 8 are at distance 2 from root.
//		            1
//		          /   \
//		        2      3
//		      /  \    /
//		    4     5  8 
		
		KDistanceFromRoot(2);
		System.out.println("\n********************");
		
		
		
//		Difference between sums of odd level and even level nodes of a Binary Tree
//		Given a a Binary Tree, find the difference between the sum of nodes 
//		at odd level and the sum of nodes at even level. 
//		Consider root as level 1, left and right children of root as level 2 and so on.
//		For example, in the following tree, sum of nodes at odd level is (5 + 1 + 4 + 8) which is 18. And sum of nodes at even level is (2 + 6 + 3 + 7 + 9) which is 27. The output for following tree should be 18 � 27 which is -9.
//
//		      5
//		    /   \
//		   2     6
//		 /  \     \  
//		1    4     8
//		    /     / \ 
//		   3     7   9  
		
		SumofOddEvenLevelsofBT();
		
		
		
//		Construct a special tree from given preorder traversal
//		Given an array �pre[]� that represents Preorder traversal of a spacial 
//		binary tree where every node has either 0 or 2 children. 
//		One more array �preLN[]� is given which has only two possible values �L� and �N�. 
//		The value �L� in �preLN[]� indicates that the corresponding node in Binary Tree 
//		is a leaf node and value �N� indicates that the corresponding node is non-leaf 
//		node. Write a function to construct the tree from the given two arrays.
//
//
//		Example:
//
//		Input:  pre[] = {10, 30, 20, 5, 15},  preLN[] = {'N', 'N', 'L', 'L', 'L'}
//		Output: Root of following tree
//		          10
//		         /  \
//		        30   15
//		       /  \
//		      20   5
		
//		int[] pre={10,30,20,5,15};
//		char[] preLN={'N', 'N', 'L', 'L', 'L'};
//		Tree n=construct(pre, preLN);
		
	}

	static String arr[] = { "A", "B", "c", "D", "E" };

	public class Stringmcm {
		int cost;
		String name;

	}

	public static Stringmcm MatrixChainMultiplication(int[] dims, int si, int ei) {
		Stringmcm[][] mcm = new Stringmcm[dims.length][dims.length];

		for (int gap = 1; gap <= dims.length - 1; gap++) {
			int i = si;
			int j = i + gap;

			while (j < dims.length) {
				if (gap== 1) {
//					mcm[i][j].cost = 0;
					mcm[i][j].name = arr[i];
				} else {

					int min = Integer.MAX_VALUE;
					for (int cp = i + 1; cp <= j - 1; cp++) {
						int fp = mcm[i][cp].cost;
						int sp = mcm[cp][j].cost;
						int pc = dims[i] * dims[cp] * dims[j];

						int totalcost = fp + sp + pc;
						if (totalcost < min) {
							mcm[i][j].cost = totalcost;
							mcm[i][j].name = "(" + mcm[i][cp].name + mcm[cp][j].name + ")";
							min=totalcost;
						}

					}
				}
				i++;
				j++;
			}
		}

		return mcm[0][dims.length - 1];
	}

	public static int CountSetbits(int n) { // nlogn
		int count = 0;
		for (int i = 1; i <= n; i++) {
			int num = i;
			while (num != 0) {
				num = num & (num - 1);
				count++;
			}
		}
		return count;
	}

	public static int numberofSubseq(String str) {
		int aCount = 0;
		int bCount = 0;
		int cCount = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				aCount = 1 + (2 * aCount);
			} else if (str.charAt(i) == 'b') {
				bCount = aCount + (2 * bCount);
			} else {
				cCount = bCount + (2 * cCount);
			}
		}

		return cCount;

	}

	public static int[] greatestElementonRight(int[] arr) {
		int[] res = new int[arr.length];
		int max = -1;
		for (int i = arr.length - 1; i >= 0; i--) {
			// if(i==arr.length-1){
			// res[i]=-1;
			// max=Math.max(max, arr[i]);
			// }else{
			res[i] = max;
			max = Math.max(max, arr[i]);
			// }
		}

		return res;
	}

	public static int highestPowerof2(int n) {

		for (int i = n; i >= 1; i--) {
			if ((i & (i - 1)) == 0) {
				return i;
			}
		}
		return 0;
	}

	public static int countAllPaths(int sr, int sc, int dr, int dc) { // O(mn)
		int[][] arr = new int[dr][dc];

		for (int i = dr - 1; i >= sr; i--) {
			for (int j = dc - 1; j >= sc; j--) {
				if (i == dr - 1 || j == dc - 1) {
					arr[i][j] = 1;
				} else {
					arr[i][j] = arr[i][j + 1] + arr[i + 1][j];
				}
			}
		}

		return arr[0][0];
	}

	// Paths
	// static int countofPaths=0;
	// public static void countAllPaths2(int sr, int sc, int dr, int dc, String
	// psf){ //o(2^mn)
	//
	// if(sr==dr-1 && sc==dc-1){
	// countofPaths++;
	// System.out.println(countofPaths);
	// System.out.println(psf);
	// return;
	// }
	//
	// if(sr>dr-1 || sc>dc-1){
	// return;
	// }
	// countAllPaths2(sr, sc+1, dr, dc, psf+"("+sr+","+sc+")");
	// countAllPaths2(sr+1, sc, dr, dc, psf+"("+sr+","+sc+")");
	// }

	public static void MaximumProductinArray(int[] arr) { // on

		int maxp = Integer.MIN_VALUE;
		int secmaxp = Integer.MIN_VALUE;

		int maxn = Integer.MAX_VALUE;
		int secmaxn = Integer.MAX_VALUE;

		for (int i : arr) {
			if (i >= 0) { // positive
				if (i > maxp) {
					secmaxp = maxp;
					maxp = i;
				} else if (i > secmaxp) {
					secmaxp = i;
				}
			} else {
				if (i < maxn) {
					secmaxn = maxn;
					maxn = i;
				} else if (i < secmaxn) {
					secmaxn = i;
				}
			}
		}

		int res1 = maxp * secmaxp;
		int res2 = maxn * secmaxn;

		if (res1 > res2) {
			System.out.println(maxp + "," + secmaxp);
		} else {
			System.out.println(maxn + "," + secmaxn);
		}
	}

	public static int CountSubstringsBTW1AND1(String str) {
		int m = 0;
		for (char c : str.toCharArray()) {
			if (c == '1') {
				m++;
			}
		}
		return m * (m - 1) / 2;
	}

	public static class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	static Node root;

	public static void DeleteANode(Node del) {

		if(del.next==null){
			del=null;
		}
		Node nextNode = del.next;
		del.data = nextNode.data;
		del.next = nextNode.next;
		nextNode=null;

		for (Node r = root; r != null; r = r.next) {
			System.out.print(r.data + "->");
		}
	}
	
	public static class Tree{
		int data;
		Tree left;
		Tree right;

		public Tree(int data, Tree left, Tree right) {
			this.data=data;
			this.left=left;
			this.right=right;
		
		}
	}
	static Tree troot;
	
	public static int DepthofATree(){
		
		int d=Depth(troot);
		return d;
	}
	
	private static int Depth(Tree troot){
		if(troot==null){
			return 0;
		}
		
		int leftheight=Depth(troot.left);
		int rightheight=Depth(troot.right);
		
		return Math.max(leftheight, rightheight)+1;
	}
	
	
	public static void KDistanceFromRoot(int k){
		KDistanceFromRoot(troot,k);
	}
	private static void KDistanceFromRoot(Tree root, int k){
		if(k==0){
			System.out.print(root.data+" ");
			return;
		}
		
		if(root.left!=null){
			KDistanceFromRoot(root.left, k-1);
		}
		if(root.right!=null){
			KDistanceFromRoot(root.right, k-1);
		}
		
	}
	
	public static void SumofOddEvenLevelsofBT(){
		System.out.println(SumofOddEvenLevelsofBT(troot));
	}
	
	private static String SumofOddEvenLevelsofBT(Tree root){
	
		String str="";
		LinkedList<Tree> queue=new LinkedList<>();
		LinkedList<Tree> nqueue=new LinkedList<>();
		
		queue.addLast(root);
		int sumo=0,sume=0, level=1;
		while(queue.size()>0){
			Tree rem=queue.removeFirst();
			if(level%2==0){
				sume+=rem.data;
			}else{
				sumo+=rem.data;
			}
			
			if(rem.left!=null){
				nqueue.addLast(rem.left);
			}
			if(rem.right!=null){
				nqueue.addLast(rem.right);
			}
			
			if(queue.size()==0){
				queue=nqueue;
				nqueue=new LinkedList<>();
				level++;
			}
			
		}
		
		str="Sum Odd:"+sumo+"Sum Even:"+sume;
		
		return str;
	}
	
//	public static Tree construct(int[] pre, int[] preLN){
//		
//	}
}
