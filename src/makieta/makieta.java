package makieta;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

/**
 * Glowna klasa zarzadzajaca aplikacja.
 */
public class makieta {
	
	/**
	 * Konstruktor bezparametrowy inicjujacy okno startowe.
	 */
	makieta()
	{
		MainWindow window = new MainWindow();
	}

	/**
	 * Metoda main.
	 */
	public static void main(String[] args) 
	{
		Properties p=new Properties();		
		makieta app=new makieta();
	}

}
