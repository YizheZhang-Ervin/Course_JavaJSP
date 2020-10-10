package myTank01;

public class bomb {
//define the location of the bomb
	int x,y;
	int life=9;
	boolean isLive =true;
	public bomb(int x,int y){
		this.x=x;
		this.y=y;
	}
	//reduce the life of the bomb
	public void lifedown(){
	if(life>0){
		life--;
	}else{
		this.isLive=false;
	}
	}
}
	
