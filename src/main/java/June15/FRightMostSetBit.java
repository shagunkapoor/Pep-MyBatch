package June15;

public class FRightMostSetBit {

    public static void main(String[] args) {


        //AND with 2's Complement
        int n = 56;
        int mask = (~n) + 1;  //2's complement
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(mask));
        int val = n & mask;
        System.out.println(Integer.toBinaryString(val));


        int x = mask;
        System.out.println(Integer.toBinaryString(x));
        int yy=x>>>3;
        System.out.println(Integer.toBinaryString(yy));
    }

}
