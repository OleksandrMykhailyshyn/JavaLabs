package risks;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireExplosionTest {
    FireExplosion fireExplosion = new FireExplosion();
    @Test
    void getLevelOfRisk() {
        Assert.assertEquals(2,fireExplosion.getLevelOfRisk());
    }
}