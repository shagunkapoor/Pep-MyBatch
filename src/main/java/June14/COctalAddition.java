package June14;

import java.util.Scanner;

public class COctalAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the no.");
		int oct1 = scn.nextInt();
		int oct2 = scn.nextInt();
		int sum = 0;
		int carry = 0;
		int n1 = 0;
		int n2 = 0;
		int octsum = 0;
		int pow = 1;
		// while((oct1!=0)||(oct2!=0)){
		// n1=oct1%10;
		// n2=oct2%10;
		// oct1/=10;
		// oct2/=10;
		// sum=n1+n2+carry;
		// if(sum<8){
		// carry=0;
		// //CORRECT
		// }else{
		// carry=sum/8;
		// sum=sum%8;
		// }
		// octsum+=sum*pow;
		// pow*=10;
		// }
		// octsum+=(carry*pow);
		// System.out.println(octsum);
		//
		//
		//

		while (oct1 != 0 || oct2 != 0) {
			n1 = oct1 % 10;
			n2 = oct2 % 10;
			oct1 /= 10;
			oct2 /= 10;
			sum = n1 + n2 + carry;
			carry = sum / 8;
			sum %= 8;
			octsum = octsum + sum * pow;
			pow *= 10;
		}
		octsum += carry * pow;
		System.out.println(octsum);

	}

}
