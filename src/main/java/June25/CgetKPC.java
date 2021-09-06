package June25;//KeyPadCode

import java.util.ArrayList;

public class CgetKPC {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "245";
        ArrayList<String> res = new ArrayList<>();
        res = getKPC(s);
        System.out.println(res);
    }

    static String[] codes = {".;", "abc", "def", "gh", "ijkl", "mn", "opq", "rstu", "v", "wxyz"};

    public static ArrayList<String> getKPC(String str) {

        if (str.equals("")) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        int num1 = ch - '0';
        String code = codes[num1];

        String rem = str.substring(1);

        ArrayList<String> list = getKPC(rem);
        ArrayList<String> result = new ArrayList<>();

        for (String s : list) {
            for (int c = 0; c < code.length(); c++) {
                result.add(code.charAt(c) + s);
            }
        }

        return result;
    }

}
