package risks;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IllegalActionsOfThirdPartiesTest {
    IllegalActionsOfThirdParties illegalActionsOfThirdParties = new IllegalActionsOfThirdParties();
    @Test
    void getLevelOfRisk() {
        Assert.assertEquals(7,illegalActionsOfThirdParties.getLevelOfRisk());
    }
}