package June15;

public class AChecktheBit {

	public static void main(String[] args) {
		int n=117;
		int k=3;
		
		System.out.println(Integer.toBinaryString(n));
		

		int mask=1<<k;
		int test=n&mask;
		if(test==mask){
			System.out.println("bit is on");
		}else
			System.out.println("bit is off");
	}
	
	
}
