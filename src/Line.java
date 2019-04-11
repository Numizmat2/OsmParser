import java.util.List;

public class Line {

    public String id;
    public List<Point> pointElements;

    public Line(String id, List<Point> pointElements) {
        this.id = id;
        this.pointElements = pointElements;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Point> getPointElements() {
        return pointElements;
    }

    public void setPointElements(List<Point> pointElements) {
        this.pointElements = pointElements;
    }
}
