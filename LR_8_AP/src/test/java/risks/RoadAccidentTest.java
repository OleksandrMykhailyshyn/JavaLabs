package risks;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoadAccidentTest {
    RoadAccident roadAccident = new RoadAccident();
    @Test
    void getLevelOfRisk() {
        Assert.assertEquals(9,roadAccident.getLevelOfRisk());
    }
}