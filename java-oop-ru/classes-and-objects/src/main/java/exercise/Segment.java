package exercise;

// BEGIN
public class Segment {
    private final Point point1;
    private final Point point2;

    public Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Point getBeginPoint() {
        return point1;
    }

    public Point getEndPoint() {
        return point2;
    }

    public Point getMidPoint() {
        var midX = (point1.getX() + point2.getX()) / 2;
        var midY = (point1.getY() + point2.getY()) / 2;

        return new Point(midX, midY);
    }
}
// END
