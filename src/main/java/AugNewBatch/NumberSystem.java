
public class NumberSystem {

	public static void main(String[] args) {
		// Dec to Bin
		// int dec=57;
		// int bin=0;
		// int rem=0;
		// int pow=1;
		// System.out.println(Integer.toBinaryString(dec));
		// while(dec!=0){
		// rem=dec%2;
		// dec=dec/2;
		// bin=bin+rem*pow;
		// pow*=2;
		// }
		//
		// System.out.println(bin);

		// Bin to Dec
		// int bin = 111001;
		// int dec = 0;
		// int rem = 0;
		// int pow = 1;
		// while (bin != 0) {
		// rem = bin % 10;
		// bin = bin / 10;
		// dec = dec + rem * pow;
		// pow *= 2;
		// }
		// System.out.println(dec);

		// Binary Addition
		// int bin1=110011;
		// int bin2=111001;
		// int sum=0;
		// int carry=0;
		// int pow=1;
		// while(bin1!=0){
		// int n1=bin1%10;
		// int n2=bin2%10;
		// bin1/=10;
		// bin2/=10;
		// int dig=n1+n2+carry;
		// sum=sum+dig%2*pow;
		// carry=dig/2;
		// pow*=10;
		//
		// }
		//
		// sum+=carry*pow;
		// System.out.println(sum);

		// Octal Addition
		// int oct1=7567;
		// int oct2=7577;
		// int pow=1;
		// int carry=0;
		// int octsum=0;
		// while(oct1!=0 || oct2!=0){
		// int n1=oct1!=0?oct1%10:0;
		// int n2=oct2!=0?oct2%10:0;
		//
		// oct1/=10;
		// oct2/=10;
		// int dig=n1+n2+carry;
		// octsum+=dig%8*pow;
		// carry=dig/8;
		// pow*=10;
		// }
		// octsum+=carry*pow;
		// System.out.println(octsum);

		// Octal Subtraction
		// int oct1=7357;
		// int oct2=757;
		// int borrow=0;
		// int diff=0;
		// int pow=1;
		// int dig=0;
		// while(oct1!=0){
		// int n1=oct1!=0?oct1%10:0;
		// int n2=oct2!=0?oct2%10:0;
		//
		// oct1/=10;
		// oct2/=10;
		// if(n1<n2){
		// n1+=8;
		// dig=n1-n2+borrow;
		// borrow=-1;
		// }else{
		// dig=n1-n2+borrow;
		// borrow=dig/8;
		// }
		//
		//
		// diff+=dig%8*pow;
		// pow*=10;
		// }
		//
		// System.out.println(diff);

		// Octal Multiplication
		// int oct1 = 757;
		// int oct2 = 57;
		// int octmult = 0;
		// int pow = 1;
		//
		// while (oct2 != 0) {
		// int i = oct2 % 10;
		// oct2 /= 10;
		// int tempoct1 = oct1;
		// int internalpow = 1;
		// int carry = 0;
		// int sum = 0;
		//
		// while (tempoct1 != 0) {
		// int n1 = tempoct1 % 10;
		// tempoct1 /= 10;
		// int dig = (n1 * i) + carry;
		// carry = dig / 8;
		// sum += dig % 8 * internalpow;
		// internalpow *= 10;
		//
		// }
		// sum += carry * internalpow;
		// octmult += sum * pow;
		// pow *= 10;
		// }
		//
		// System.out.println(octmult);

		// Octal to Binary
		// int oct=642;
		// int bin=0;
		// int rem=0;
		// int pow=1;
		// while(oct!=0){
		// int n=oct%10;
		// oct/=10;
		// switch(n){
		// case 0: rem=0;
		// break;
		// case 1: rem=1;
		// break;
		// case 2: rem=10; // on writing 010, it will store a (010)'s octal
		// representation, which is 8
		// break;
		// case 3: rem=11;
		// break;
		// case 4: rem=100;
		// break;
		// case 5: rem=101;
		// break;
		// case 6: rem=110;
		// break;
		// case 7: rem=111;
		// break;
		// }
		// bin=bin+rem*pow;
		// pow*=1000;
		//
		//
		// }
		// System.out.println(bin);

		// Binary to Octal
		// int bin=110100010;
		// int oct=0;
		// int rem=0;
		// int pow=1;
		// while(bin!=0){
		// int n=bin%1000;
		// bin/=1000;
		//
		// switch(n){
		// case 0: rem=0;
		// break;
		// case 1: rem=1;
		// break;
		// case 10: rem=2;
		// break;
		// case 11: rem=3;
		// break;
		// case 100: rem=4;
		// break;
		// case 101: rem=5;
		// break;
		// case 110: rem=6;
		// break;
		// case 111: rem=7;
		// break;
		// }
		//
		// oct+=rem*pow;
		// pow*=10;
		// }
		// System.out.println(oct);

		// Number Rotation
		// int num=58746;
		// int r=2;
		// int tempnum=num;
		// int size=0;
		// while(tempnum!=0){
		//
		// }
		//
		//
		// int rot=r%size;
		//
		//
		//

		// int num = 58746;
		// int r = -2;
		// int numcount = num;
		// int cnt = 0;
		// while (numcount != 0) {
		// numcount /= 10;
		// cnt++;
		// }
		// int rot = Math.abs(r) % cnt;
		// int pow = 10;
		// while (cnt > 2) {
		// pow *= 10;
		// cnt--;
		// }
		// if (r > 0) {
		// while (rot > 0) {
		//
		// int n = num % 10;
		// num = num / 10;
		//
		// num = num + n * pow;
		//
		// rot--;
		// }
		// System.out.println(num);
		//
		// } else {
		// while(rot>0){
		// int n=num/pow;
		// num=num%pow;
		// num=(num*10)+n;
		// rot--;
		// }
		// System.out.println(num);
		// }

		// Inverse

		int num = 461235;
		int inv = 0;

		int val = 1;
		while (num != 0) {
			int pow = 1;
			int n = num % 10;
			num = num / 10;
			int cnt = 1;
			while (cnt < n) {
				pow *= 10;
				cnt++;
			}
			inv += val * pow;
			val++;
		}
		System.out.println(inv);

	}

}
