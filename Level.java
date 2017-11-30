package makieta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*; 
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TimerTask;


/**
 * Klasa obslugujaca zdarzenia i rysowanie w oknie gry.
 */
public class Level extends JPanel implements ActionListener,KeyListener {
	 
	
	/**
	 * Obiekty klasy Image przechowujace obrazy.
	 */
	 private BufferedImage image1;
	 private BufferedImage image2;
	 private BufferedImage image3;
	 private BufferedImage image4;
	 private BufferedImage image5;
	 private BufferedImage image6;
	 private BufferedImage image7;
	 private BufferedImage image8;
	 private BufferedImage image;
	 private BufferedImage pauza;
	 
	 
	 JButton EndGame= new JButton("End Game");
	
	 JButton YouLost;
	 boolean initPosition;
	 boolean bomb;
	 boolean superbomb;
	 boolean superbombbonus=false;
	 boolean pause=false;
	 Player gracz=new Player();	
	 private Timer time;
	 private int delay=1;
	 public int numberOfBombs=0;
	 public int numberOfSuperBombs=0;
	 public int numberOfFlames=0;
	 
	 
	
	 /**
	  * Lista przechowujaca obiekty scian.
	  */
	 public ArrayList<Wall> walls;
	 
	 /**
	  * Lista przechowujaca obiekty skrzynek.
	  */
	public ArrayList<Chest> chests;
	 
	 /**
	  * Lista przechowujaca obiekty bomb.
	  */
	 public ArrayList<Bomb> bombs;
	 public ArrayList<SuperBomb> superbombs;
	 
	 public ArrayList<Flame> flames;
	 
	 /**
	  * Lista przechowujaca wszystkie pola.
	  */
	 public ArrayList<Field> fields;
	 
	
	 public ArrayList<Creep> creeps;
	 /**
	  * Konstruktor bezparametrowy.
	  */
	 
	 public Level()
	 {
		 initPosition=true;
		 bomb=false;
		 createMap();
		 time=new Timer(delay,this);
		 time.start();
		 add(EndGame);
		 EndGame.setBounds(Properties.EndGameButtonVerticalPosition, Properties.EndGameButtonHorizontalPosition, Properties.GameScreenButtonsWidth, Properties.GameScreenButtonsHeight);
		 EndGame.addActionListener(this);
		 setFocusable(true);
		 requestFocusInWindow();
		 addKeyListener(this);
	
	try {
		image = ImageIO.read(new File("front_side.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		image1 = ImageIO.read(new File("front_side.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		image2 = ImageIO.read(new File("back_side.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		image3 = ImageIO.read(new File("left_side.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		image4 = ImageIO.read(new File("right_side.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		image5 = ImageIO.read(new File("bomb.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		image6 = ImageIO.read(new File("wall.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		image7 = ImageIO.read(new File("wood.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	try {
		image8 = ImageIO.read(new File("flame.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		pauza = ImageIO.read(new File("pauza.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}
	 
	public void paintComponent(Graphics g)
	{
		
	    Graphics2D g2 = (Graphics2D) g;
	    for(int k=0;k<11;k++)
	    {
	    for (int i=0;i<11;i++)
	    {
	  //  if(Character.getNumericValue(Properties.mapa[k].charAt(i))==0||Character.getNumericValue(Properties.mapa[k].charAt(i))==3)
	    	g2.setPaint(Color.green);
	    	g2.fill(new Rectangle2D.Double(50*i,50*k,50,50));
	    } 
	    }
	    
	   	for(int i=0;i<fields.size();i++)
	   	{
	   		if (fields.get(i) instanceof Wall)
	    		g.drawImage(image6, fields.get(i).getX(), fields.get(i).getY(), this);
	   		else if (fields.get(i) instanceof Chest)
	    		g.drawImage(image7, fields.get(i).getX(), fields.get(i).getY(), this);
	    }
	    
	    if(initPosition){
	    	g.drawImage(image1, Properties.PlayerStartPositionX, Properties.PlayerStartPositionY, this);
	    	initPosition=false;
	    }
	    
	   
	    
	    if(bomb==true)
	    {
	    	for(int i=0; i<fields.size(); i++)
	    		if(fields.get(i) instanceof Bomb)
	    			g.drawImage(image5, fields.get(i).getX(),fields.get(i).getY() , this);
	    }
	    if(superbomb==true)
	    {
	    	for(int i=0; i<fields.size(); i++)
	    		if(fields.get(i) instanceof SuperBomb)
	    			g.drawImage(image5, fields.get(i).getX(),fields.get(i).getY() , this);
	    }
	  
	   	for(int i=0;i<flames.size();i++)
	   	{
	    		g.drawImage(image8, flames.get(i).getX(), flames.get(i).getY(), this);
	    }
	    g.drawImage(image ,gracz.getX(),gracz.getY(),this);
	
		for(int i=0;i<creeps.size();i++)
    	{
			g.drawImage(image, creeps.get(i).getX(), creeps.get(i).getY(), this);
    	}
		
	}
	
	
	
    @Override
    public void actionPerformed(ActionEvent e)
    {
    	time.start();
    	repaint();
    }

    public void changeImage(int i)
    {
    	switch(i)
    	{
    	case 1:
    	{
    		image=image1;
    		break;
    	}
    	case 2:
    	{
    		image=image2;
    		break;
    	}
    	case 3:
    	{
    		image=image3;
    		break;
    	}
    	case 4:
    	{
    		image=image4;
    		break;
    	}
    	}
    	repaint();
    }


    @Override
    public void keyPressed(KeyEvent e) {
    	if(e.getKeyCode()==KeyEvent.VK_RIGHT)
    	{
    		changeImage(4);
    		boolean brak_kolizji=true;
    		for(int i=0;i<fields.size();i++)
    		{
    			if(gracz.prawaKolizja(fields.get(i))==true)
    			{
    				gracz.x=gracz.x;
    				brak_kolizji=false;
    		
    			}
    		}
    		for(int i=0;i<flames.size();i++)
    		{
    			if(gracz.prawaKolizja(flames.get(i))==true)
    			{
    				gracz.x=gracz.x;
    				brak_kolizji=false;
    				YouLost=new JButton("Przegrales kurwo");
    				YouLost.setBounds(700,500,500,100);
    				this.add(YouLost);
    			}
    		}
    		if(brak_kolizji)
    			gracz.x+=50;
    		/*	for(int i=0;i<50;i++)
    			{
    			gracz.x+=1;
    			repaint();
    			try {
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			
    			}*/
    	}


    	else if(e.getKeyCode()==KeyEvent.VK_LEFT)
    	{
    		changeImage(3);
    		boolean brak_kolizji=true;
    		for(int i=0;i<fields.size();i++)
    		{
    			if(gracz.lewaKolizja(fields.get(i))==true)
    			{
    				gracz.x=gracz.x;
    				brak_kolizji=false;
    			}
    		}
    		for(int i=0;i<flames.size();i++)
    		{
    			if(gracz.lewaKolizja(flames.get(i))==true)
    			{
    				gracz.x=gracz.x;
    				brak_kolizji=false;
    				YouLost=new JButton("Przegrales kurwo");
    				YouLost.setBounds(700,500,500,100);
    				this.add(YouLost);
    			}
    		}
    		if(brak_kolizji)
    			gracz.x-=50;

    	}
		
    	else if(e.getKeyCode()==KeyEvent.VK_UP)
    	{
    		changeImage(2);
	
    		boolean brak_kolizji=true;
    		for(int i=0;i<fields.size();i++)
    		{
    			if(gracz.gornaKolizja(fields.get(i))==true)
    			{
    				gracz.y=gracz.y;
    				brak_kolizji=false;
    			}
    		}
    		for(int i=0;i<flames.size();i++)
    		{
    			if(gracz.gornaKolizja(flames.get(i))==true)
    			{
    				gracz.x=gracz.x;
    				brak_kolizji=false;
    				YouLost=new JButton("Przegrales kurwo");
    				YouLost.setBounds(700,500,500,100);
    				this.add(YouLost);
    			}
    		}
    		if(brak_kolizji)
    			gracz.y-=50;

    	}
    	else if (e.getKeyCode()==KeyEvent.VK_DOWN)
    	{
    		changeImage(1);
    		boolean brak_kolizji=true;
    		for(int i=0;i<fields.size();i++)
    		{
    			if(gracz.dolnaKolizja(fields.get(i))==true)
    			{
    				gracz.y=gracz.y;
    				brak_kolizji=false;
    			}
    		}
    		for(int i=0;i<flames.size();i++)
    		{
    			if(gracz.dolnaKolizja(flames.get(i))==true)
    			{
    				gracz.x=gracz.x;
    				brak_kolizji=false;
    				YouLost=new JButton("Przegrales kurwo");
    				YouLost.setBounds(700,500,500,100);
    				this.add(YouLost);
    			}
    		}
    		if(brak_kolizji)
    			gracz.y+=50;

    	}
    	else if(e.getKeyCode()==KeyEvent.VK_P)
    	{
    		pause=!pause;
    	}
    	else if (e.getKeyCode()==KeyEvent.VK_SPACE)
    	{
    		if(superbombbonus)
    		{
    			numberOfSuperBombs++;
        		SuperBomb newBomb=new SuperBomb(this);
        		newBomb.initPosition(gracz.getX(), gracz.getY());
        		
        		if (superbombs.size()==0){
        			superbomb=true;
            		superbombs.add(newBomb);
        			fields.addAll(superbombs);
        			System.out.println("nowa bomba");
    				superbombs.get(0).elo(this);
        		}	
        		else{	
        			if((Math.abs(gracz.getX()-superbombs.get(bombs.size()-1).getX())<50) && (Math.abs(gracz.getY()-superbombs.get(superbombs.size()-1).getY())<50))
        			{
        				numberOfSuperBombs--;
        			}
        			else{
        				superbomb=true;
        				superbombs.add(newBomb);
        				System.out.println("nowa bomba");
        				fields.add(superbombs.get(superbombs.size()-1));
        				superbombs.get(superbombs.size()-1).elo(this);
        				
        			}
        		}
    		}
    		else{
    		numberOfBombs++;
    		Bomb newBomb=new Bomb(this);
    		newBomb.initPosition(gracz.getX(), gracz.getY());
    		
    		if (bombs.size()==0){
    			bomb=true;
        		bombs.add(newBomb);
    			fields.addAll(bombs);
    			System.out.println("nowa bomba");
				bombs.get(0).elo(this);
    		}	
    		else{	
    			if((Math.abs(gracz.getX()-bombs.get(bombs.size()-1).getX())<50) && (Math.abs(gracz.getY()-bombs.get(bombs.size()-1).getY())<50))
    			{
    				numberOfBombs--;
    			}
    			else{
    				bomb=true;
    				bombs.add(newBomb);
    				System.out.println("nowa bomba");
    				fields.add(bombs.get(bombs.size()-1));
    				bombs.get(bombs.size()-1).elo(this);
    				
    			}
    		}
    	}
    	}
    }
 
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    public void createMap()
    {	
    	int w=0;
    	int c=0;
    	int cr=0;
	
    	walls = new ArrayList<Wall>();
    	chests = new ArrayList<Chest>();
    	bombs = new ArrayList<Bomb>();
    	superbombs= new ArrayList<SuperBomb>();
    	flames= new ArrayList<Flame>();
    	fields=new ArrayList<Field>();
    	creeps = new ArrayList<Creep>();
    	for(int k=0;k<11;k++)
    	{
    	
    		for (int i=0;i<11;i++)
    		{
    			if(Character.getNumericValue(Properties.mapa[k].charAt(i))==1)
    			{
    				walls.add(new Wall());
    				walls.get(w).initPosition(50*i,50*k);
    				w++;
    			}
    			if(Character.getNumericValue(Properties.mapa[k].charAt(i))==2)
    			{
    				chests.add(new Chest());
    				chests.get(c).initPosition(50*i,50*k);
    				c++;
    			}
    			if(Character.getNumericValue(Properties.mapa[k].charAt(i))==3)
    			{
    				creeps.add(new Creep(this));
    				creeps.get(cr).initPosition(50*i,50*k);
    				cr++;
    			}
    		}
    	}
    	fields.addAll(walls);
    	fields.addAll(chests);
    	fields.add(gracz);
    	
    }
    

	}