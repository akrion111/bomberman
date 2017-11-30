package makieta;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Klasa przechowujaca informacje o graczu.
 */
public class Player extends Field {
    
	/**
     * Zmienna przechowujaca nick gracza.
     */
    static String nick;
    
    /**
     * Zmienna przechowujaca liczbe punktow.
     */
    int points;

    /**
     * Konstruktor bezparametrowy tworzacy obiekt gracza i nadajacy mu poczatkowe wspolrzedne.
     */
    Player(){
    	x=Properties.PlayerStartPositionX;
    	y=Properties.PlayerStartPositionY;
    }
}



