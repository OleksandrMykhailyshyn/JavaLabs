package insurance;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import risks.Risk;
import risks.RoadAccident;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class GreenCardTest {
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    GreenCard greenCard = new GreenCard(date,calendar,"VUSO",new String[]{"ДТП"},new Risk[]{new RoadAccident()},100,15,9,"Germany","car",10);
    @Test
    void getN() {
        Assert.assertEquals(2,greenCard.getN());
    }

    @Test
    void getRegionOfStay() {
        Assert.assertEquals("Germany",greenCard.getRegionOfStay());
    }

    @Test
    void setRegionOfStay() {
        greenCard.setRegionOfStay("Poland");
        Assert.assertEquals("Poland",greenCard.getRegionOfStay());
    }

    @Test
    void getVehicle() {
        Assert.assertEquals("car",greenCard.getVehicle());
    }

    @Test
    void setVehicle() {
        greenCard.setVehicle("plane");
        Assert.assertEquals("plane",greenCard.getVehicle());
    }

    @Test
    void getTermOfStay() {
        Assert.assertEquals(10,greenCard.getTermOfStay());
    }

    @Test
    void setTermOfStay() {
        greenCard.setTermOfStay(15);
        Assert.assertEquals(15,greenCard.getTermOfStay());
    }

    @Test
    void testToString() {
        Assert.assertEquals(greenCard.toString(),"GreenCard{" +
                "regionOfStay='" + "Germany" + '\'' +
                ", vehicle='" + "car" + '\'' +
                ", termOfStay=" + 10 +
                ", startDate=" + date +
                ", calendar=" + greenCard.calendar.getTime() +
                ", company='" + "VUSO" + '\'' +
                ", risks=" + "[ДТП]" +
                ", cost=" + 100.0 +
                ", validity=" + 15 +
                ", levelOfRisk=" + 9 +
                '}');
    }
}