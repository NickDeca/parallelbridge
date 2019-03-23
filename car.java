

import java.util.Random;

class car  extends Thread{	

	public String color;
	int id;
	private Thread t;
	private String threadName;
	gefira space;
	
	car(String color,int id, gefira space){
		this.color = color;
		this.id = id;
		this.threadName = Integer.toString(id);
		this.space = space;
	}	
	
	public void run() {
		
		//ru8mos proelefshs to n random pou vriskoume 
		
				Random rand = new Random();
				int ru8mos = rand.nextInt(10);
				ru8mos += 10;
				try {
					Thread.sleep(ru8mos);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				try {
					space.move(this);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
	}
	
	//h start kanei nhma kai kalei thn run gia na treksei to nhma car
	
	public void start() {
		if(t == null) {
			t = new Thread(this,threadName);
			t.start();
		}
	}
}
