package myTank01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements KeyListener,Runnable{

	Hero hero=null;
	int x=10,y=10,z=0;
	
	Vector<bomb> bomb=new Vector<bomb>();
	//define bomb's image
	Image image1 =null;
	Image image2 =null;
	Image image3 =null;
	
	//定义一个敌人的坦克组存放敌人的坦克
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	int ensize=50;     //敌人坦克的数量
	public MyPanel(){
		hero=new Hero(x,y,z);
		//初始化敌人的坦克
		for (int i=0;i<ensize;i++){
			EnemyTank et=new EnemyTank((i+1)*50,0,1);
			et.setColor(1);
			ets.add(et);
			Thread t=new Thread(et);
			t.start();
		}
		try {
			image1=ImageIO.read(new File("image/bomb_1.gif"));//相对地址
			image2=ImageIO.read(new File("image/bomb_2.gif"));
			image3=ImageIO.read(new File("image/bomb_3.gif"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}             
		
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		this.drawTank(hero.getX(),hero.getY(),g,hero.getZ(),0);
		
		
		for(int i=0;i<hero.ss.size();i++){
			shoot s=hero.ss.get(i);
			if(s!=null&&s.isLive==true){
				g.draw3DRect(s.x,s.y,10,10,false);
			}else{
				hero.ss.remove(s);
			}
			
		}
		for(int i=0;i<ets.size();i++){
			EnemyTank en=ets.get(i);
			if(en!=null&&en.isLive==true){
				this.drawTank(en.getX(), en.getY(),g,en.getZ(), 1);
				for(int j=0;j<en.ss.size();j++){
					shoot enemyShoot = en.ss.get(j);
					if(enemyShoot.isLive){
						g.draw3DRect(enemyShoot.x,enemyShoot.y,10,10,false);
					}else{
						en.ss.remove(enemyShoot);
					}
				}
			}else{
				ets.remove(en);
			}
			
		}
		for(int i=0;i<bomb.size();i++){
			bomb b=bomb.get(i);
			if(b.life>6){
				g.drawImage(image1,b.x,b.y,30,30,this);
			}else if(b.life>3){
				g.drawImage(image2,b.x,b.y,30,30,this);
			}else
			   {g.drawImage(image3,b.x,b.y,30,30,this);
			}
			b.lifedown();
			if(b.life==0){
				bomb.remove(b);
			}
		}
		
		
	}
	
	/*
	 * use a specific function to handle the condition that player shot the tanks and make them disappear
	*/
	public void hitTank(shoot s,EnemyTank et){
		//judge the orientation of the enemy tank
		switch(et.getZ()){
		case 0:
		case 1:
			if(s.x>et.x&&s.x<(et.x+20)&&s.y>et.y&&s.y<(et.y+30)){
				s.isLive=false;
				et.isLive=false;
				bomb b=new bomb(et.x,et.y);
				bomb.add(b);
			}break;
		case 2:
		case 3:
			if(s.y>et.y&&s.y<(et.y+20)&&s.x>et.x&&s.x<(et.x+30)){
				s.isLive=false;
				et.isLive=false;
				bomb b=new bomb(et.x,et.y);
				bomb.add(b);
			}break;
		}
		
	}
	
	
	public void drawTank(int x,int y,Graphics g,int direct,int type){
		//判断坦克的类型
		switch(type){
		case 0:
			g.setColor(Color.orange);break;//自己的坦克
		case 1:
			g.setColor(Color.green);break;//敌人的坦克
		}
		switch(direct){
		case 0://up
			
			g.fill3DRect(x,y,5,30,false);
		    g.fill3DRect(x+5, y+5, 10, 20, false);
		    g.fill3DRect(x+15, y, 5, 30, false);
		    g.setColor(Color.GREEN);
		    g.fillOval(x+5,y+10,10,10);
		    g.drawLine(x+10,y+15 ,x+10 ,y);
		    break;
		case 1://down
			
			g.fill3DRect(x,y,5,30,false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.fill3DRect(x+15, y, 5, 30, false);
			g.setColor(Color.BLUE);
			g.fillOval(x+5,y+10,10,10);
			g.drawLine(x+10,y+15 ,x+10 ,y+30);
			break;
		case 2://left
			
			g.fill3DRect(x,y,30,5,false);
			g.fill3DRect(x, y+15, 30, 5, false);
			g.fill3DRect(x+5, y+5, 20, 10, false);
			g.setColor(Color.YELLOW);
			g.fillOval(x+10,y+5,10,10);
			g.drawLine(x+15,y+10 ,x,y+10);
			break;
		case 3://right
			
			g.fill3DRect(x,y,30,5,false);
			g.fill3DRect(x, y+15, 30, 5, false);
			g.fill3DRect(x+5, y+5, 20, 10, false);
			g.setColor(Color.CYAN);
			g.fillOval(x+10,y+5,10,10);
			g.drawLine(x+15,y+10 ,x+30,y+10);
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			hero.setX(x);
			hero.setY(y=y+20);
			hero.setZ(z+1);
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
				hero.setX(x);
				hero.setY(y=y-20);
				hero.setZ(z+0);
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
					hero.setX(x=x-20);
					hero.setY(y);
					hero.setZ(z+2);
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
						hero.setX(x=x+20);
						hero.setY(y);
						hero.setZ(z+3);
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			if(hero.ss.size()<=50) //限制子弹连发
			{hero.shotEnemy(hero.getX(),hero.getY(),hero.getZ());}
		}
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {//重写
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			for(int i=0;i<hero.ss.size();i++){
				shoot myShot=hero.ss.get(i);
				if(myShot.isLive==true){
					for(int j=0;j<ets.size();j++){
						EnemyTank et=ets.get(j);
						if(et.isLive){
							this.hitTank(myShot, et);
							
						}
					}
				}
			}
			this.repaint();
		}
		
	}
	
}
