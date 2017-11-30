package makieta;
import java.awt.*;
abstract class Pole extends Rectangle {

    private int bok;

    /**
     * Konstruktor z parametrem
     * @param b d³ugoœæ boku pola
     */
    public Pole(int b){
        bok = b;
    }
    public Pole(){};

    /**
     * Metoda s³u¿y do sprawdzania czy dochodzi do dolnej kolizji z którymœ z obiektów dziedzicz¹cym o polu.
     * Polega na sprawdzeniu odpowiednich wspó³rzêdnych dwóch obiektów.
     * @param pole Obiekt dla którego sprawdzamy kolizje
     * @return Zwraca true albo false w zale¿noœci czy dosz³o do kolizji czy nie .
     */
    public boolean dolnaKolizja(Pole pole){
        if(((this.getY() +this.getHeight()) == pole.getY()) && (this.getX() == pole.getX())) {

            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Metoda s³u¿y do sprawdzania czy dochodzi do kolizji z góry.
     * Polega na sprawdzeniu odpowiednich wspó³rzêdnych dwóch obiektów.
     * @param pole Obiekt dla którego sprawdzamy kolizje
     * @return Zwraca true albo false w zale¿noœci czy dosz³o do kolizji czy nie .
     */
    public boolean gornaKolizja(Pole pole){
        if((this.getY() == pole.getY() + pole.getHeight()) && (this.getX() == pole.getX())){
            return true;
        }
        else{
            return false;
        }

    }
    /**
     * Metoda s³u¿y do sprawdzania czy dochodzi do kolizji z prawej.
     * Polega na sprawdzeniu odpowiednich wspó³rzêdnych dwóch obiektów.
     * @param pole Obiekt dla którego sprawdzamy kolizje
     * @return Zwraca true albo false w zale¿noœci czy dosz³o do kolizji czy nie .
     */
    public boolean prawaKolizja(Pole pole){
        if((this.getX() + getWidth() == pole.getX()) && (this.getY() == pole.getY())){
            return true;
        }
        else{
            return false;
        }

    }
    /**
     * Metoda s³u¿y do sprawdzania czy dochodzi do kolizji z lewej strony.
     * Polega na sprawdzeniu odpowiednich wspó³rzêdnych dwóch obiektów.
     * @param pole Obiekt dla którego sprawdzamy kolizje
     * @return Zwraca true albo false w zale¿noœci czy dosz³o do kolizji czy nie
     */
    public boolean lewaKolizja(Pole pole){
        if((this.getX() == pole.getX() + pole.getWidth()) && (this.getY() == pole.getY())){
            return true;
        }
        else{
            return false;
        }

    }


}
