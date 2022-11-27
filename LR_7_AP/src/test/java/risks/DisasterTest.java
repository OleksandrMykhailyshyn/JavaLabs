package risks;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisasterTest {
    Disaster disaster = new Disaster();
    @Test
    void getLevelOfRisk() {
        Assert.assertEquals(4,disaster.getLevelOfRisk());
    }
}