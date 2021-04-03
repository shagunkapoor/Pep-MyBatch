

import java.awt.List;
import java.nio.file.Paths;
import java.util.ArrayList;


//No. of ways to reach dest. from src.
public class DgetBoard {

	public static void main(String[] args) {

		ArrayList<String> res = new ArrayList<>();
		res = getBoard(0, 10);
		System.out.println(res);
		int totalpaths=res.size();
		System.out.println(totalpaths);
	}

	public static ArrayList<String> getBoard(int s, int d) {

		if (s == d) { // 10 to 10
			ArrayList<String> baseres = new ArrayList<>();
			baseres.add("");
			return baseres;

		}
		// if(s>d){
		// ArrayList<String> baseres=new ArrayList<>();
		// return baseres;
		// }
		// OR

		ArrayList<String> pathsfromstod = new ArrayList<>();
		for (int dice = 1; dice <= 6; dice++) {
			int inter = s + dice;

			if(s<d){ //OR
			ArrayList<String> pathsfromintertod = new ArrayList<>();
			pathsfromintertod = getBoard(inter, d);

			for (String interpath : pathsfromintertod) {
				String srcpath = dice + interpath;
				pathsfromstod.add(srcpath);
			}
			}
		}
		return pathsfromstod;

	}

}
