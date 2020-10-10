package myTank01;

import java.util.Vector;

public class Hero extends Tank{

	Vector<shoot> ss=new Vector<shoot>();
	shoot s=null;
	public Hero(int x,int y,int z){
		super(x,y,z);
	}
	public void shotEnemy(int x,int y,int direct){
		switch(z){
		case 0:
			s=new shoot(x+10,y,0);ss.add(s);break;
		case 1:
			s=new shoot(x+10,y+30,1);ss.add(s);break;
		case 2:
			s=new shoot(x,y+10,2);ss.add(s);break;
		case 3:
			s=new shoot(x+30,y+10,3);ss.add(s);break;
		}
		Thread t=new Thread(s);
		t.start();
	}
}
