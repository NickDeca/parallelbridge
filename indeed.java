

import java.util.ArrayList;

public class indeed {	

	   static int bluecap;
	   static int redcap;
	   static int trafficflag;
	   public static int kataloipa;

	public static void main(String[] args) throws InterruptedException {
				
		final int plh8oscar = 11;		
		
		//exoume 2 listes pou exoun ola ta autokinhta pou 8eloun na perasoun(red-aristera & blue-deksia)
		ArrayList<car> redcars = new ArrayList<car>();
		ArrayList<car> bluecars = new ArrayList<car>();	
		
		gefira space = new gefira();
		
		for(int i = 1; i <= plh8oscar;i++) {

			int k = (int)(Math.random() * 10 + 1);
			k += 1 ;
			if(k%2==0) {
				bluecars.add(new car("blue",i,space));
			}else {
				redcars.add(new car("red",i,space));
			}			
		}
		redcap = redcars.size();
		bluecap = bluecars.size();
		trafficflag = checktraffic(redcap,bluecap);			
		
		for(int i = 0; i < redcars.size();i++) {
			redcars.get(i).start();
		}	 
		
		for(int i = 0; i < bluecars.size();i++) {
			bluecars.get(i).start();
		}
	}
	   
	   //checkaroume an xreiazete prosamogh dld an mia pleura einai megaluterh apo thn allh na afinei ena ratio:1 px
	   //elenxoume an einai 2plasia h mia meria opote pernan 2 pros 1 , an 0 pernan austhra . Oti apomeinei pernaei meta
	   public static int  checktraffic(int redcars, int bluecars) {
		   int max,min,ratio;
		   
		   if(bluecars > redcars) {
			   max = bluecars;
			   min = redcars;
		   }else if(redcars > bluecars) {
			   max = redcars;
			   min = bluecars;
		   }else {
			   System.out.printf("Reds equals Blues \n");
			   return 0;
		   }

		   ratio = max/min;
		   kataloipa = max%min;
		   
		   if(redcars > bluecars) {
			   kataloipa = kataloipa*(-1);
			   System.out.printf("the ratio is %d:1 in favor of red, red %d , blue %d with kataloipa : %d\n",ratio,redcars,bluecars,kataloipa);
			   return ratio;
		   }else {
			   System.out.printf("the ratio is %d:1 in favor of blue. red %d , blue %d with kataloipa : %d\n",ratio,redcars,bluecars,kataloipa);
			   return ratio;
		   }	   
	   } 
}