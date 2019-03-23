

import java.util.concurrent.locks.ReentrantLock;

public class gefira {

	ReentrantLock lockcar = new ReentrantLock();
	static int counterkataloipwn = 0;
	static int counter = 0;
	//ena 8ewritiko space pou mporei na einai 1 car mono kai meta mpenei to epomeno thread/car  
	car spacep ;
	
	gefira(){
		this.spacep = new car("dummy",-1,this);
	}
	
	public void move(car cartomove) throws InterruptedException {
		//prospa8eia na perasei apo thn gefura vlepei poia periptwsh einai (an ta kokkina perissoter , ta mple h isa)
				
		while(true) {			
				//elenxei an ta kokkina einai perissotera h ta mple h isa kai analoga kleidwnei 1 - 1 ta cars pou pernan kai ta emfanizei 
				if(indeed.kataloipa < 0) {
					lockcar.lock();	
					if(checker("red",cartomove) == -1) {	
						lockcar.unlock();
						break;					
					}else {
						lockcar.unlock();
					}
				}else if(indeed.kataloipa > 0) {					
					lockcar.lock();	
					if(checker("blue",cartomove) == -1) {	
						lockcar.unlock();
						break;						
					}else {
						lockcar.unlock();
					}
				}else {
					//klasikh 1:1 an einai isa ta sunola kokkina k mple
					lockcar.lock();
					if(!(cartomove.color.equals(spacep.color))) {
						
						spacep = cartomove;					
						System.out.printf("the car that is currently on the bridge has id : %d and color : %s\n",spacep.id,spacep.color);	
						lockcar.unlock();
						break;	
					}else lockcar.unlock();						
				}			
			
		}
	}
	
	public int checker(String color, car cartomove) {
		int katal = indeed.kataloipa;
		int traffic = indeed.trafficflag;
		
		if(katal < 0 ) {
			katal *= (-1);
		}
		
		if(counterkataloipwn < katal) {
			//afinei na perasoun ta extra autokinhta prin ksekinhsei na ta afinei me ratio trafficflag:1 
			//(px 3 mple 1 kokkino kai 2 extra mple)
			if(cartomove.color.equals(color) == true) {				
				counterkataloipwn = counterkataloipwn + 1;
				spacep = cartomove;					
				System.out.printf("the car that is currently on the bridge has id : %d and color : %s is part of kataloipa\n",spacep.id,spacep.color);				
				return -1;
			}
		}else {	
			//afou perasoun ta kataloipa apo ta perissotera mporoun na arxisoun na pernan me to ratio
			
			//checkarei an exoun perasei mexri trafficflag kokkina alliws afinei na perasei 1 mple kai kanei ton metrith 0 gia na perasoun
			//ta epomena trafficflag kokkina
			if(counter < traffic)	{
				//auksish metrith k perasma apo ta perissotera
				
				if(cartomove.color.equals(color) == true) {					
					counter++;
					spacep = cartomove;						
					System.out.printf("the car that is currently on the bridge has id : %d and color : %s %d of the ratio\n",spacep.id,spacep.color,counter);					
					return -1;
				}
			}else{				
				//reset metrith kai perasma 1 apo ta ligotera 				
				if(cartomove.color.equals(color) == false){					
					counter = 0;											
					System.out.printf("the car that is currently on the bridge has id : %d and color : %s counter reseted to %d\n",spacep.id,spacep.color,counter);					
					return -1;
				}
			}
		}
		
		return 0;
		
	}	
	
	
	
	
	
}
