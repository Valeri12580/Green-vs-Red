import java.util.List;

/**
 * Holds the required numbers to get the neighbors of the currently processed cell
 */
public final class CoordinatesHolder {
    private  List<Coordinate> coordinateList;

    public CoordinatesHolder() {
        this.coordinateList = List.of(new Coordinate(-1,0),
                new Coordinate(0,-1),
        new Coordinate(0,1),
        new Coordinate(+1,0),
        new Coordinate(-1,-1),
        new Coordinate(-1,1),
                new Coordinate(1,1),
                new Coordinate(1,-1));
    }

    public List<Coordinate> getCoordinateList() {
        return coordinateList;
    }

    public void setCoordinateList(List<Coordinate> coordinateList) {
        this.coordinateList = coordinateList;
    }
}
