
public class CStockPricesSpan extends Stack{

	public CStockPricesSpan(int cap){
		super(cap);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] prices={10,20,30,25,22,28,50,40,45,47,35};
		int[] spanarr=new int[prices.length];
		spanarr=spans(prices);
		for(int val:spanarr){
			System.out.print(val+" ");
		}
	}
	public static int[] spans(int[] prices){
		int[] sp=new int[prices.length];
		Stack obj=new CStockPricesSpan(prices.length);
		obj.push(0);
		sp[0]=1;
		for(int i=1;i<prices.length;i++){
			while(obj.size()>0 && prices[i]>prices[obj.top()]){ //pop
				obj.pop();
			}
			sp[i]=(obj.size()!=0? i-obj.top() : i+1); 
			
			obj.push(i);
		}
		return sp;
	}

}
