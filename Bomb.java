package makieta;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Klasa przechowujaca wspolrzedne obiektow bomb.
 */
public class Bomb extends Field {

	Timer explosionTimer;
	Timer flamesTimer;
	boolean on_the_map;
	int collisions=0;
	ArrayList<Flame> flamess= new ArrayList<Flame>();

	Bomb(Level level)
	{
	
	}
	void checkCollisions(Level level)
	{
		for(int k=0;k<5-collisions;k++)
		{
		for(int i=0;i<level.walls.size();i++)
		{
		//	System.out.println("wspolrzedne usunietego plomienia: x:"+level.flames.get(5*(level.numberOfFlames-1)+k).getX()+"y:"+level.flames.get(5*(level.numberOfFlames-1)*k).getY());
		//	System.out.println("wspolrzedne kamienia: x:"+level.walls.get(5*(level.numberOfFlames-1)*k).getX()+"y:"+level.flames.get(5*(level.numberOfFlames-1)*k).getY());
		if(flamess.get(k).Kolizja(level.walls.get(i)))
		{
			System.out.println("wspolrzedne usunietego plomienia: x:"+flamess.get(k).getX()+"y:"+flamess.get(k).getY());
			System.out.println("usuwam plomien o indeksie: x:"+k);
		flamess.remove(k);
		collisions++;
		k=0;
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
			for(int i=0;i<5;i++)
    		{
    		flamess.add(new Flame());
    		}
    		flamess.get(0).initPosition(Bomb.this.getX()-50, Bomb.this.getY());
			flamess.get(1).initPosition(Bomb.this.getX()+50, Bomb.this.getY());
    		flamess.get(2).initPosition(Bomb.this.getX(),Bomb.this.getY()+50);
    		flamess.get(3).initPosition(Bomb.this.getX(), Bomb.this.getY()-50);
    		flamess.get(4).initPosition(Bomb.this.getX(), Bomb.this.getY());
    		System.out.println("wspbomby w srodku bomby x:"+Bomb.this.getX()+"I Y:"+Bomb.this.getY());
    		System.out.println("wspbomby w levelu x:"+level.bombs.get(0).getX()+"I Y:"+level.bombs.get(0).getY());
			checkCollisions(level);
			System.out.println("kolizje:"+collisions);
			level.flames.addAll(flamess);
			level.fields.remove(level.fields.size()-level.numberOfBombs);
			level.bombs.remove(level.bombs.get(0));
			System.out.println(level.fields.size());
			level.numberOfBombs--;
			System.out.println("bomba znikla");
			
			class FlamesTask extends TimerTask {
				public void run(){
					for(int i=0;i<5-collisions;i++)
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