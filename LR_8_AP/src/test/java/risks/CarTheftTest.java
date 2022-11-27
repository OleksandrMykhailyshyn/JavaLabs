package risks;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTheftTest {
    CarTheft carTheftTest = new CarTheft();
    @Test
    void getLevelOfRisk() {
        Assert.assertEquals(8, carTheftTest.getLevelOfRisk());
    }
}