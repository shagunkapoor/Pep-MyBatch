package Z_Interviews;

public class TW_ElectricityProblem {

	public static void main(String[] args) {
		Bill();
	}

	public static class Appliance {
		String name;
		int units;
		int qty;
		int hrs;

		public Appliance(String name, int units, int qty, int hrs) {
			this.name = name;
			this.units = units;
			this.qty = qty;
			this.hrs = hrs;
		}

		public int powerConsumption() {
			return units * qty * hrs;
		}

	}

	public static class BillingSlab {
		int price;
		int lo;
		int hi;

		BillingSlab(int price, int lo, int hi) {
			this.price = price;
			this.lo = lo;
			this.hi = hi;
		}

		public int bill(int units) {
			if (units < this.lo) {
				return 0;
			}
			int amnt = units - this.lo;
			if (amnt >= this.hi) {
				return (this.hi - this.lo) * price;
			} else {
				return amnt * price;
			}
		}
	}

	public static void Bill() {

		int units_pd = 0, units_pm = 0;

		Appliance fan = new Appliance("fan", 4, 2, 4);
		units_pd += fan.powerConsumption();

		Appliance light = new Appliance("light", 2, 3, 6);
		units_pd += light.powerConsumption();

		Appliance ac = new Appliance("ac", 10, 1, 12);
		units_pd += ac.powerConsumption();

		Appliance fridge = new Appliance("fridge", 7, 1, 16);
		units_pd += fridge.powerConsumption();

		units_pm = units_pd * 30;

		System.out.println("Units per Month:"+units_pm);

		int total_amnt = 0;

		BillingSlab s1 = new BillingSlab(20, 0, 1000);
		total_amnt += s1.bill(units_pm);
		BillingSlab s2 = new BillingSlab(30, 1000, 3000);
		total_amnt += s2.bill(units_pm);
		BillingSlab s3 = new BillingSlab(40, 3000, 6000);
		total_amnt += s3.bill(units_pm);
		BillingSlab s4 = new BillingSlab(50, 6000, Integer.MAX_VALUE);
		total_amnt += s4.bill(units_pm);

		System.out.println("Total Bill:" + total_amnt);
	}

}
