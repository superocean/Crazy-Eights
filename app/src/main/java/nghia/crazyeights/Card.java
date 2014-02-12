package nghia.crazyeights;

import android.graphics.Bitmap;

public class Card {
    private int id;
    private Bitmap bmp;
    private int suit;
    private int rank;

    public Card(int newId) {
        id = newId;
        suit = Math.round(id/100) * 100;
        rank = id - suit;
    }
    public void setBitmap(Bitmap newBitmap) {
        bmp = newBitmap;
    }
    public Bitmap getBitmap() {
        return bmp;
    }
    public int getId() {
        return id;
    }
    public int getSuit() {
        return suit;
    }
    public int getRank() {
        return rank;
    }
}
