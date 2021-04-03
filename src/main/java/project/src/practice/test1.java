package practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al=new ArrayList<>();
		
		int[] l={ -4, 7, 5, 3, 5, -4, 2, -1, -9, -8, -3, 0, 9, -7, -4, -10, -4, 2, 6, 1, -2, -3, -1, -8, 0, -8, -7, -3, 5, -1, -8, -8, 8, -1, -3, 3, 6, 1, -8, -1, 3, -9, 9, -6, 7, 8, -6, 5, 0, 3, -4, 1, -10, 6, 3, -8, 0, 6, -9, -5, -5, -6, -3, 6, -5, -4, -1, 3, 7, -6, 5, -8, -5, 4, -3, 4, -6, -7, 0, -3, -2, 6, 8, -2, -6, -7, 1, 4, 9, 2, -10, 6, -2, 9, 2, -4, -4, 4, 9, 5, 0, 4, 8, -3, -9, 7, -8, 7, 2, 2, 6, -9, -10, -4, -9, -5, -1, -6, 9, -10, -1, 1, 7, 7, 1, -9, 5, -1, -3, -3, 6, 7, 3, -4, -5, -4, -7, 9, -6, -2, 1, 2, -1, -7, 9, 0, -2, -2, 5, -10, -1, 6, -7, 8, -5, -4, 1, -9, 5, 9, -2, -6, -2, -9, 0, 3, -10, 4, -6, -6, 4, -3, 6, -7, 1, -3, -5, 9, 6, 2, 1, 7, -2, 5 };
//		al.add(1);
//		al.add(12);
//		al.get(0);
//		al.add(0);
		for(int i=0;i<l.length;i++)
		al.add(l[i]);
		Collections.sort(al);
		System.out.println(al);
//		al.size();
		
	}
}
//	
//		public static void getWinning(int input){
//			StringBuilder sb=new StringBuilder();
//		int div=input/3;
//		int rem=input%3;
//		
//		if(rem==0){
//			for(int i=0;i<input;i++){
//				sb.append("5");
//			}
//		}else if(rem==1 && div>=3){
//			for(int i=0;i<input-5;i++){
//				sb.append("5");
//			}
//			for(int i=0;i<5;i++){
//				sb.append("3");
//			}
//		}else if(rem==2 && div>=1){
//			for(int i=0;i<input-5;i++){
//				sb.append("5");
//			}
//			for(int i=0;i<5;i++){
//				sb.append("3");
//			}
//		}
//		
//	}
//		
//		StringBuilder strsf = new StringBuilder();
//        if(input==3){
//            for(int i=0;i<input;i++)
//                strsf.append("5");
//            return strsf.toString();
//        }else if(input==5){
//             for(int i=0;i<input;i++)
//                strsf.append("3");
//            return strsf.toString();
//        }else if(input<3){
//            return "0";
//        }
//        int lastdig = 0;
//
//        for (int i = 1; i < input / 2; i++) {
//            for (int j = 1; j < i; j++) {
//                if (input - (3 * i) <= 5 * j) {
//                    lastdig = 5 * j;
//                }
//            }
//        }
//        int newnum = input - lastdig;
//        for (int i = 0; i < newnum; i++) {
//            strsf.append("5");
//        }
//        for (int i = 0; i < lastdig; i++) {
//            strsf.append("3");
//
//        }
//
//}
