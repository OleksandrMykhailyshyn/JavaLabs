package risks;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MilitaryRisksTest {
    MilitaryRisks militaryRisks = new MilitaryRisks();
    @Test
    void getLevelOfRisk() {
        Assert.assertEquals(5,militaryRisks.getLevelOfRisk());
    }
}