package KJuly07;

import java.util.Scanner;

//{[(a+b)+(c+d)]} ->true
public class ABalancedParenthesis extends Stack {

    public ABalancedParenthesis(int cap) {
        super(cap);
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the string");
        String s = scn.nextLine();
        checkbalanced(s);
    }

    public static void checkbalanced(String s) {
//        int res = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(')
//                res += 1;
//            else if (s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')')
//                res -= 1;
//            else
//                continue;
//        }
//        if (res == 0)
//            System.out.println(true);
//        else
//            System.out.println(false);

        //OR
        Stack stack = new Stack(s.length());

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')') {
                if (stack.size() == 0) {
                    System.out.println(false);
                    return;
                } else if (s.charAt(i) == '}' && stack.top() == '{') {
                    stack.pop();
                } else if (s.charAt(i) == ']' && stack.top() == '[') {
                    stack.pop();
                } else if (s.charAt(i) == ')' && stack.top() == '(') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

}
