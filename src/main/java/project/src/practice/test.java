package practice;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		getWinning(19);

		calandar("13.20.10.10.10");
	}

//	public static void getWinning(int n) {
//		StringBuilder strsf = new StringBuilder();
//		int sumsf = 0;
//		int lastdig = 0;
//
//		for (int i = 1; i < n / 2; i++) {
//			for (int j = 1; j < i; j++) {
//				if (n - (3 * i) <= 5 * j) {
//					lastdig = 5 * j;
//				}
//			}
//		}
//		int newnum = n - lastdig;
//		for (int i = 0; i < newnum; i++) {
//			strsf.append("5");
//		}
//		for (int i = 0; i < lastdig; i++) {
//			strsf.append("3");
//
//		}
//		System.out.println(strsf);
//	}

	
	
	public static void calandar(String input){
		String[] mayancomp=input.split("\\.");
		
		System.out.println(mayancomp);
		 try {
	          if (mayancomp.length != 5)
	               throw new Exception("Expecting 5 numbers separated by dots");
	          int b = Integer.valueOf(mayancomp[0]);
	          int kat = Integer.valueOf(mayancomp[1]);
	          int t = Integer.valueOf(mayancomp[2]);
	          int u = Integer.valueOf(mayancomp[3]);
	          int kin = Integer.valueOf(mayancomp[4]);
	          set (b, kat, t, u, kin);
	     } catch (Throwable e) {
	          throw new IllegalArgumentException("Invalid long count date format: " 
	          + e.getMessage());
	     }
	}

	private static void set(int b, int kat, int t, int u, int kin) {
		// TODO Auto-generated method stub
		assert MayaTimeUnit.Kin.toDays (1) == 1;
	     daysSinceGreatCycle =
	          MayaTimeUnit.Baktun.toDays (baktuns) +
	          MayaTimeUnit.Katun.toDays(katuns) +
	          MayaTimeUnit.Tun.toDays(tuns) +
	          MayaTimeUnit.Winal.toDays(uinals) +
	          kins;
	}
	

	/** @return day name number in Tzolk'in calendar, e.g. it returns 0 (Ajaw) for the day "4 Ajaw" */
	public Tzolkin toTzolkinDayName () {
	     // The Tzolk'in date is counted forward from 4 Ajaw.
	     return Tzolkin.DAYS[(daysSinceGreatCycle + 19) % 20]; // relative to Ajaw
	}

	/** @return day number in Tzolk'in calendar, e.g. it returns 4 for the day "4 Ajaw" */
	public int toTzolkinDayNumber () {
	     // The Tzolk'in date is counted forward from 4 Ajaw.
	     return (daysSinceGreatCycle + 4) % 13;
	}
	[...]  

	/** @return day name number in Haab calendar, e.g. it returns Yaxkin (5) for the day "14 Yaxk'in" */
	public Haab toHaabDayName () {
	     int d = (daysSinceGreatCycle + 349) % 365;
	     return Haab.DAYS[d / 20];
	}

	/** @return day number in Haab calendar, e.g. it returns 14 for the day "14 Yaxk'in" */
	public int toHaabDayNumber () {
	     int d = (daysSinceGreatCycle + 349) % 365;
	     return d % 20 - 1;
	}
	[...]  

	/** @return Gregorian calendar representation of currently set date  */
	public String toGregorianString () {
	     Calendar c = toGregorianDate ();
	     return format.format(c.getTime());
	}

	/** @return Converts currently defined date into Gregorian calendar */
	public Calendar toGregorianDate () {
	     Calendar c = (Calendar)greatCycleStartDate.clone();
	     c.add(Calendar.DAY_OF_YEAR, daysSinceGreatCycle);
	     return c;
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
