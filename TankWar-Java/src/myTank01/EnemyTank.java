package myTank01;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{
	int color;
	boolean isLive=true;
	int speed=5;
	int move=30;
	
	int times=0;
	Vector<shoot> ss=new Vector <shoot>();
	
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public EnemyTank(int x,int y,int z){
		super(x,y,z);
	}

	@Override
	public void run() {
		while(true){
			switch(this.z){
			case 0:
				for(int i=0;i<move;i++){
					if(y>0){
						y-=speed;
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}break;
			case 1:
				for(int i=0;i<move;i++){
					if(y<850){
						y+=speed;
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}break;
			case 2:
				for(int i=0;i<move;i++){
					if(x>0){
						x-=speed;
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}break;
			case 3:
				for(int i=0;i<move;i++){
					if(x<1400){
						x+=speed;
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}break;
			}
			this.times++;
			if(times%2==0){
				if(isLive){
					if(ss.size()<10){
						shoot s=null;
						switch(z){
						case 0:s=new shoot(x+10,y,0);ss.add(s);break;             //up
						case 1:s=new shoot(x+10,y+20,1);ss.add(s);break;          //down
						case 2:s=new shoot(x,y+10,2);ss.add(s);break;             //left
						case 3:s=new shoot(x+29,y+10,3);ss.add(s);break;          //right	
						}
						//start the enemy's bullet
						Thread t=new Thread(s);                                   
						t.start();
					} 
				}
			}
				
			//give tank a randomize orientation
			this.z=(int)(Math.random()*4);
			//judge whether the enemy tank is dead
			if(this.isLive==false){
				break;//tankËÀÍöÍË³öÏß³Ì
			}
		}
		
	}
}
