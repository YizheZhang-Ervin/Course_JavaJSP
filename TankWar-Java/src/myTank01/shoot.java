package myTank01;

public class shoot implements Runnable{
int x;
int y;
int direct;
int speed=30;
boolean isLive=true;

public shoot(int x,int y,int direct){
	this.x=x;
	this.y=y;
	this.direct=direct;
}
@Override
public void run() {
	while(true){
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch(direct){
		case 0:y-=speed;break;
		case 1:y+=speed;break;
		case 2:x-=speed;break;
		case 3:x+=speed;break;
		}
		System.out.println("bullet location:"+x+" - "+y);
		if(x<0||y<0||x>1440||y>900){
			isLive=false;
			break;
		}
		
	}
	
}
}
