package makieta;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Klasa przechowujaca wspolrzedne obiektow bomb.
 */
public class SuperBomb extends Field {

	Timer explosionTimer;
	Timer flamesTimer;
	boolean on_the_map;
	int collisions=0;
	ArrayList<Flame> flamessleft= new ArrayList<Flame>();
	ArrayList<Flame> flamessright= new ArrayList<Flame>();
	ArrayList<Flame> flamessup= new ArrayList<Flame>();
	ArrayList<Flame> flamessdown=new ArrayList<Flame>();

	SuperBomb(Level level)
	{
	
	}
	void checkCollisions(Level level, ArrayList<Flame> flamess)
	{
		for(int k=0;k<3;k++)
		{
		for(int i=0;i<level.walls.size();i++)
		{
		if(flamess.get(k).Kolizja(level.walls.get(i)))
		{
		if(k==0)
		{
			flamess.remove(2);
			flamess.remove(1);
			collisions+=2;
		}
		else if(k==1)
			{flamess.remove(2);collisions+=1;}
		flamess.remove(k);
		collisions++;
		}
		}
		for(int i=0;i<level.chests.size();i++)
		{
		if(flamess.get(k).Kolizja(level.chests.get(i)))
		{
		for(int p=0;p<level.fields.size();p++)
		{
		if(level.chests.get(i).getX()==level.fields.get(p).getX()&&level.chests.get(i).getY()==level.fields.get(p).getY())
		{
			System.out.println("chuj");
			level.fields.remove(p);
		}
		}
		level.chests.remove(i);
		
		}
		}
		for(int i=0;i<level.creeps.size();i++)
		{
		if(flamess.get(k).Kolizja(level.creeps.get(i)))
		{
		level.creeps.remove(i);
		}
		}
		}
	}
	
void elo(Level level)
{
	class ExplodeTask extends TimerTask {
		public void run() {
			level.numberOfFlames++;
			Flame middleflame=new Flame();
			for(int i=0;i<3;i++)
    		{
    		flamessleft.add(new Flame());
    		}
			for(int i=0;i<3;i++)
    		{
    		flamessright.add(new Flame());
    		}
			for(int i=0;i<3;i++)
    		{
    		flamessup.add(new Flame());
    		}
			for(int i=0;i<3;i++)
    		{
    		flamessdown.add(new Flame());
    		}
			middleflame.initPosition(SuperBomb.this.getX(), SuperBomb.this.getY());
    		flamessleft.get(0).initPosition(SuperBomb.this.getX()-50, SuperBomb.this.getY());
    		flamessleft.get(1).initPosition(SuperBomb.this.getX()-100, SuperBomb.this.getY());
    		flamessleft.get(2).initPosition(SuperBomb.this.getX()-150, SuperBomb.this.getY());
    		flamessright.get(0).initPosition(SuperBomb.this.getX()+50, SuperBomb.this.getY());
    		flamessright.get(1).initPosition(SuperBomb.this.getX()+100, SuperBomb.this.getY());
			flamessright.get(2).initPosition(SuperBomb.this.getX()+150, SuperBomb.this.getY());
    		flamessup.get(0).initPosition(SuperBomb.this.getX(),SuperBomb.this.getY()+50);
    		flamessup.get(1).initPosition(SuperBomb.this.getX(),SuperBomb.this.getY()+100);
    		flamessup.get(2).initPosition(SuperBomb.this.getX(),SuperBomb.this.getY()+150);
     		flamessdown.get(0).initPosition(SuperBomb.this.getX(), SuperBomb.this.getY()-50);
    		flamessdown.get(1).initPosition(SuperBomb.this.getX(), SuperBomb.this.getY()-100);
    		flamessdown.get(2).initPosition(SuperBomb.this.getX(), SuperBomb.this.getY()-150);
  
			checkCollisions(level,flamessleft);
			checkCollisions(level,flamessright);
			checkCollisions(level,flamessup);
			checkCollisions(level,flamessdown);
			System.out.println("kolizje:"+collisions);
			level.flames.add(middleflame);
			level.flames.addAll(flamessleft);
			level.flames.addAll(flamessright);
			level.flames.addAll(flamessup);
			level.flames.addAll(flamessdown);
			level.fields.remove(level.fields.size()-level.numberOfSuperBombs);
			level.superbombs.remove(level.superbombs.get(0));
			System.out.println(level.fields.size());
			level.numberOfSuperBombs--;
			System.out.println("bomba znikla");
			
			class FlamesTask extends TimerTask {
				public void run(){
					for(int i=0;i<13-collisions;i++)
					{
						System.out.println("usuwam plomyczek o x:"+level.flames.get(0).getX()+"i y:"+level.flames.get(0).getY());
						level.flames.remove(0);
						
					}
					level.numberOfFlames--;
					collisions=0;
				}
			}
	
		flamesTimer = new Timer();
		flamesTimer.schedule(new FlamesTask(), 1000);
		System.out.println("number of collisions:"+collisions);
		level.repaint();
		}
	}
	
	
explosionTimer = new Timer();
explosionTimer.schedule(new ExplodeTask(), 3000);
}
	
	
}
