package makieta;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
	
	/**
     * Zmienna przechowujaca layout pozwalajacy na podmienianie paneli
     */
	static CardLayout mainLayout = new CardLayout();

	/**
     * Zmienna przechowujaca panel, ktory przechowuje wszystkie okna gry.
     */
    static JPanel panels = new JPanel();

    /**
     * Zmienna przechowujaca okno menu glownego.
     */
    static StartScreen startScreen;
    
    /**
     * Zmienna przechowujaca okno planszy gry.
     */
    static Level gameScreen;
    
    /**
     * Zmienna przechowujaca wysokosc okna.
     */
    static int screenHeight;

    /**
     * Zmienna przechowujaca szerokosc okna.
     */
    static int screenWidth;
    
    public MainWindow()
    {
    	InitWindow();
    }
    
    private void InitWindow()
    {
    	setTitle("Bomberman on the flow");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setMinimumSize(new Dimension(Properties.FrameWidth,Properties.FrameHeight));
    	setLocationRelativeTo(null);
    	
    	startScreen = new StartScreen();
    	gameScreen = new Level();
    	
//    	startScreen.setSize(this.getWidth(),this.getHeight());
//    	gameScreen.setSize(this.getWidth(),this.getHeight());
    	
        panels = new JPanel();
        panels.setLayout(mainLayout);
        
        panels.add(startScreen, "1");
        panels.add(gameScreen, "2");

        mainLayout.show(panels, "1");
        add(panels);
  
        setVisible(true);
    }
}
