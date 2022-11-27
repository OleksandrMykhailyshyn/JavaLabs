package risks;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FallingObjectsTest {
    FallingObjects fallingObjects = new FallingObjects();
    @Test
    void getLevelOfRisk() {
        Assert.assertEquals(3,fallingObjects.getLevelOfRisk());
    }
}