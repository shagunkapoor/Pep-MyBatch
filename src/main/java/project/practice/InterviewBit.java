package project.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class InterviewBit {

	public class Node{
		int val;
		Node left;
		Node right;
		
		public Node(int data){
			this.val=data;
		}
	}
	
	Node root;

    
	public void construct(int[] arr){
		LinkedList<Node> stack = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			Node n = new Node(arr[i]);
			if (arr[i] == -1) {
				Node top = stack.removeFirst();
				if (stack.size() == 0) {
					root = top;
				} else {
					if (stack.getFirst().left == null) {
						stack.getFirst().left = top;
					} else {
						stack.getFirst().right = top;
					}
				}
			} else {
				stack.addFirst(n);
			}
		}
		}
    
	public void verticalTraversal(){
		ArrayList<ArrayList<Integer>>res=verticalOrderTraversal(root);
		System.out.println(res);
	}
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(Node A) {
        
        HashMap<Integer, ArrayList<Integer>> hm=calc(A,0);
        
        ArrayList<Integer> al=new ArrayList<>(hm.keySet());
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(Integer i:al){
            min=Math.min(i,min);
            max=Math.max(i,max);
        }
        
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        for(int i=min;i<=max;i++){
            res.add(hm.get(i));
        }
        
        return res;
        
    }
    
    public HashMap<Integer, ArrayList<Integer>> calc(Node node, int cnt){
        HashMap<Integer, ArrayList<Integer>> hmap=new HashMap<>();
        
        if(node==null){
            return hmap;
        }
        
        if(hmap.containsKey(cnt)){
            ArrayList<Integer> al=hmap.get(cnt);
            al.add(node.val);
            hmap.put(cnt,al);
        }else{
            ArrayList<Integer> alr=new ArrayList<>();
            alr.add(node.val);
            hmap.put(cnt,alr);
        }
        
        if(node.left!=null)
        calc(node.left, cnt-1);
        
        if(node.right!=null)
        calc(node.right, cnt+1);
        
        return hmap;
    }
    
    public void inorderTraversal(){
    	ArrayList<Integer> res=inorderTraversal(root);
    	System.out.println(res);
    }
private ArrayList<Integer> inorderTraversal(Node A) {
        
        if(A.left==null && A.right==null){
            ArrayList<Integer> base=new ArrayList<>();
            base.add(A.val);
            return base;
        }
        
        ArrayList<Integer> res=new ArrayList<>();
        if(A.left!=null){
        ArrayList<Integer> l=inorderTraversal(A.left);
        int i=0;
        while(i<l.size()){
            res.add(l.get(i));
            i++;
        }
        }
        res.add(A.val);
        if(A.right!=null){
        ArrayList<Integer> r=inorderTraversal(A.right);
        int j=0;
        while(j<r.size()){
            res.add(r.get(j));
            j++;
        }
        }
        
       return res;
    }
}



