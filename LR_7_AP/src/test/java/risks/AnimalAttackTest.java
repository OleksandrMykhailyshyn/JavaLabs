package risks;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalAttackTest {
    AnimalAttack animalAttack = new AnimalAttack();
    @Test
    void getLevelOfRisk() {
        Assert.assertEquals(1,animalAttack.getLevelOfRisk());
    }
}