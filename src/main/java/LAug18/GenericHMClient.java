package LAug18;

public class GenericHMClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> hmap=new HashMap<>();
		
		hmap.put("India", 120);
		hmap.put("Aus", 100);
		hmap.put("US", 50);
		hmap.put("Mexico", 25);
		hmap.display();
		
		System.out.println("***************");
		hmap.put("Kenya", 10);
		hmap.put("Pak", 60);
		hmap.put("Ireland", 200);
		hmap.put("Greece", 23);
		hmap.put("France", 150);
		hmap.display();

	}

}
