package exercise;

// BEGIN
public class Cottage implements Home {
    private final double area;
    private final int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public String toString() {
        return floorCount
                + " этажный коттедж площадью "
                + area
                + " метров";
    }

    @Override
    public double getArea() {
        return area;
    }
    @Override
    public int compareTo(Home another) {
        return Double.compare(area, another.getArea());
    }
}
// END
