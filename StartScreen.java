package makieta;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Klasa tworzaca okno startowe.
 */
public class StartScreen extends JFrame implements ActionListener, KeyListener
{
	
	JButton NewGame=new JButton("New Game");
	JButton HowToPlay= new JButton("How to play");
	JButton HighScores= new JButton("High Scores");
	JButton Exit= new JButton("Exit");
	JPanel panel=new JPanel();
	
	/**
	 * Zmienna przechowujaca pozycje startowa gracza w poziomie.
	 */
	public StartScreen()
	{
		setLayout(null);
		add(NewGame);
		add(HowToPlay);
		add(HighScores);
		add(Exit);
		NewGame.setBounds(Properties.NewGameButtonVerticalPosition, Properties.NewGameButtonHorizontalPosition, Properties.StartScreenButtonsWidth, Properties.StartScreenButtonsHeight);
		HowToPlay.setBounds(Properties.HowToPlayButtonVerticalPosition, Properties.HowToPlayButtonHorizontalPosition, Properties.StartScreenButtonsWidth, Properties.StartScreenButtonsHeight);
		HighScores.setBounds(Properties.HighScoresButtonVerticalPosition, Properties.HighScoresButtonHorizontalPosition, Properties.StartScreenButtonsWidth, Properties.StartScreenButtonsHeight);
		Exit.setBounds(Properties.ExitButtonVerticalPosition, Properties.ExitButtonHorizontalPosition, Properties.StartScreenButtonsWidth, Properties.StartScreenButtonsHeight);
		setSize(Properties.StartScreenFrameWidth, Properties.StartScreenFrameHeight);
		setTitle(Properties.FrameTitle);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		NewGame.addActionListener(this);
		
}

	
	public void actionPerformed(ActionEvent e)
	{
	Object Source=e.getSource();
	if(Source==NewGame)
	{
	dispose();
	JFrame frame = new JFrame();
	frame.setLayout(new GridLayout(1,1));
//	frame.setSize(Properties.StartScreenFrameWidth, Properties.StartScreenFrameHeight);
	frame.setTitle(Properties.FrameTitle);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	
	frame.setMinimumSize(new Dimension(Properties.StartScreenFrameWidth, Properties.StartScreenFrameHeight-75));
	frame.setPreferredSize(new Dimension(Properties.StartScreenFrameWidth, Properties.StartScreenFrameHeight));
	frame.setMaximumSize(new Dimension(Properties.StartScreenFrameWidth, Properties.StartScreenFrameHeight));
	
	
	Level level = new Level();
	frame.add(level, 0);
	frame.setVisible(true);
	}
	
	
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	}


