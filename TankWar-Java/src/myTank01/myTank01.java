package myTank01;

import java.awt.Color;

import javax.swing.JFrame;

public class myTank01 extends JFrame{

	MyPanel mp=null;
	
	public myTank01(){
	
		mp=new MyPanel();
		mp.setBackground(Color.BLACK);
		this.add(mp);
		this.addKeyListener(mp);
		
		Thread t=new Thread(mp);
		t.start();
		
		this.setTitle("Ì¹¿Ë´óÕ½02");
		this.setSize(1440, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		myTank01 t1=new myTank01();
		

	}

}
