package makieta;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Flame extends Field
{
	public Timer FlameTimer;
	public ArrayList<Flame> flames=new ArrayList<Flame>();
		public Flame()
	{

	}

public boolean Kolizja(Field field)
	{
		if((this.getY()== field.getY()) && ((this.getX()==field.getX()))) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}


