package makieta;
import java.awt.*;
abstract class Pole extends Rectangle {

    private int bok;

    /**
     * Konstruktor z parametrem
     * @param b d�ugo�� boku pola
     */
    public Pole(int b){
        bok = b;
    }
    public Pole(){};

    /**
     * Metoda s�u�y do sprawdzania czy dochodzi do dolnej kolizji z kt�rym� z obiekt�w dziedzicz�cym o polu.
     * Polega na sprawdzeniu odpowiednich wsp�rz�dnych dw�ch obiekt�w.
     * @param pole Obiekt dla kt�rego sprawdzamy kolizje
     * @return Zwraca true albo false w zale�no�ci czy dosz�o do kolizji czy nie .
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
     * Metoda s�u�y do sprawdzania czy dochodzi do kolizji z g�ry.
     * Polega na sprawdzeniu odpowiednich wsp�rz�dnych dw�ch obiekt�w.
     * @param pole Obiekt dla kt�rego sprawdzamy kolizje
     * @return Zwraca true albo false w zale�no�ci czy dosz�o do kolizji czy nie .
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
     * Metoda s�u�y do sprawdzania czy dochodzi do kolizji z prawej.
     * Polega na sprawdzeniu odpowiednich wsp�rz�dnych dw�ch obiekt�w.
     * @param pole Obiekt dla kt�rego sprawdzamy kolizje
     * @return Zwraca true albo false w zale�no�ci czy dosz�o do kolizji czy nie .
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
     * Metoda s�u�y do sprawdzania czy dochodzi do kolizji z lewej strony.
     * Polega na sprawdzeniu odpowiednich wsp�rz�dnych dw�ch obiekt�w.
     * @param pole Obiekt dla kt�rego sprawdzamy kolizje
     * @return Zwraca true albo false w zale�no�ci czy dosz�o do kolizji czy nie
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
