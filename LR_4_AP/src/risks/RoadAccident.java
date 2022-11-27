package risks;

public class RoadAccident extends Risk {
    final int levelOfRisk = 9;

    public int getLevelOfRisk() {
        return levelOfRisk;
    }

    @Override
    public String toString() {
        return "RoadAccident{" +
                "levelOfRisk=" + levelOfRisk +
                '}';
    }
}
