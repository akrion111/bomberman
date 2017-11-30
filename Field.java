package makieta;

import java.security.Policy;

/**
 * Klasa abstrakcyjna, po ktorej dziedzicza obiekty znajdujace sie na mapie. Znajduje sie w niej obsluga kolizji.
 */
public abstract class Field {
protected int x;
protected int y;

/**
 * Metoda zwracajaca wsporzeldna x pola.
 */
public int getX(){return x;};

/**
 * Metoda zwracajaca wsporzeldna y pola.
 */
public int getY(){return y;};

/**
 * Metoda inicjujaca polozenie pola.
 */
public void initPosition(int a, int b){
	x=a;
	y=b;
}

/**
 * Metoda sprawdzajaca czy dochodzi do kolizji z dolu. 
 * Zwraca true albo false w zaleznosci czy doszlo do kolizji.
 */
public boolean dolnaKolizja(Field field){
    if((this.getY() +Properties.FieldHeight == field.getY()) && ((this.getX()>field.getX()-50)&&(this.getX()<field.getX()+50))) {

        return true;
    }
    else{
        return false;
    }
}

/**
 * Metoda sprawdzajaca czy dochodzi do kolizji z gory. 
 * Zwraca true albo false w zaleznosci czy doszlo do kolizji.
 */
public boolean gornaKolizja(Field field){
    if((this.getY() == field.getY() + Properties.FieldHeight) && ((this.getX()>field.getX()-50)&&(this.getX()<field.getX()+50))){
        return true;
    }
    else{
        return false;
    }

}

/**
 * Metoda sprawdzajaca czy dochodzi do kolizji z prawej strony. Zwraca true albo false w zaleznosci czy doszlo do kolizji.
 */
public boolean prawaKolizja(Field field){
	
	//System.out.println(field.x +"i"+ field.y);
    if((this.getX() + Properties.FieldWidth == field.getX()) && ((this.getY()> field.getY()-50)&&(this.getY()<field.getY()+50))){
   
        return true;
    }
    else{
        return false;
    }

}

/**
 * Metoda sprawdzajaca czy dochodzi do kolizji z lewej strony. 
 * Zwraca true albo false w zaleznosci czy doszlo do kolizji.
 */
public boolean lewaKolizja(Field field){
    if((this.getX() == field.getX() + Properties.FieldWidth) && ((this.getY()>field.getY()-50)&&(this.getY()< field.getY()+50))){
        return true;
    }
    else{
        return false;
    }

}



}
