/**
 * represent cell in the board
 */
public class Cell {
   private int color;
   private int futureColor;



    public Cell(int color) {
        this.color = color;
        this.futureColor=color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getFutureColor() {
        return futureColor;
    }

    public void setFutureColor(int futureColor) {
        this.futureColor = futureColor;
    }

    @Override
    public String toString() {
        return String.valueOf(color);
    }
}
