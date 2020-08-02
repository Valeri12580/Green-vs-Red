/**
 * Class for storing the monitored cell
 */
public class Storage {

    private Cell monitoredCell;
    private int counter;

    public Storage(Cell monitoredCell) {
        this.monitoredCell = monitoredCell;
        setCounter(0);
    }

    public void setCounter(int counter) {
        this.counter = counter;
        if(monitoredCell.getColor()==1){
            this.counter++;
        }
    }

    public void checkColor(){
        if(monitoredCell.getColor()==1){
            counter++;
        }
    }

    public int getCounter() {
        return counter;
    }
}
