package risks;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompleteDeathOfTheCarTest {
    CompleteDeathOfTheCar completeDeathOfTheCar = new CompleteDeathOfTheCar();
    @Test
    void getLevelOfRisk() {
        Assert.assertEquals(6,completeDeathOfTheCar.getLevelOfRisk());
    }
}