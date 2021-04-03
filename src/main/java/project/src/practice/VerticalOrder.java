package practice;


import java.util.ArrayList;
import java.util.HashMap;

public class VerticalOrder {

	public static void main(String[] args){
	HashMap<Integer,ArrayList<Integer>>hmap=new HashMap<>();
	int key=0;
	verticalorderhelper(root, hmap,key);
	
}

private void verticalorderhelper(node root, HashMap<Integer, ArrayList<Integer>> hmap, int key) {
	// TODO Auto-generated method stub
	if(root==null)
	{
		ArrayList<ArrayList<Integer>>result=new ArrayList<>();
		int store=key-1;
		while(hmap.containsKey(store))
		{
			result.add(hmap.get(store));
			store--;
			
		}
		System.out.println(result);
		
		return;
	}
	ArrayList<Integer>res=new ArrayList<>();
	if(hmap.containsKey(key))
	{
		
		res=hmap.get(key);
		res.add(root.data);
		hmap.put(key,res );
	}
	else
	{
		res.add(root.data);
		hmap.put(key,res);
	}
	verticalorderhelper(root.left, hmap, key+1);
	verticalorderhelper(root.right, hmap, key-1);

} 