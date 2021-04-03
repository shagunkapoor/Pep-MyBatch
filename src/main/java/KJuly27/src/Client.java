import java.util.Arrays;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car[] cars=new Car[5];
		cars[0]=new Car(100, 100, "A");
		cars[1]=new Car(150, 15, "B");
		cars[2]=new Car(200, 20, "C");
		cars[3]=new Car(500, 10, "D");
		cars[4]=new Car(10, 500, "E");
		
		Arrays.sort(cars);
		for(Car val:cars){
			System.out.println("Speed:"+val.speed+" Price:"+val.price+" Name:"+val.name);
		}		
	}
	
	public static class Car implements Comparable<Car>{
		int speed;
		int price;
		String name;
		
		public Car(int speed, int price, String name){
			this.speed=speed;
			this.price=price;
			this.name=name;
		}
	
		
		public void display(){
			System.out.println("Car :"+ this.name+" Price :"+this.price+" Speed :"+this.speed);
		}


		@Override
		public int compareTo(Car o) {
			// TODO Auto-generated method stub
//			return this.speed-o.speed;   //Increasing order of speed
//			return o.speed-this.speed;   //Decreasing
			return this.name.compareTo(o.name);  // Increasing order of name
			
		}
		
	}

}
