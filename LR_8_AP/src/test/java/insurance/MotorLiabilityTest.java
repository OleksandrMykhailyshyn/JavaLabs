package insurance;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import risks.Risk;
import risks.RoadAccident;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MotorLiabilityTest {
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    MotorLiability motorLiability = new MotorLiability(date,calendar,"VUSO",new String[]{"ДТП"},new Risk[]{new RoadAccident()},100,15,9,"BC2252HE","Opel","Astra",2010,"4Y1SL65848Z411439");
    @Test
    void getN() {
        Assert.assertEquals(3,motorLiability.getN());
    }

    @Test
    void getCarNumber() {
        Assert.assertEquals("BC2252HE",motorLiability.getCarNumber());
    }

    @Test
    void setCarNumber() {
        motorLiability.setCarNumber("BC2332HE");
        Assert.assertEquals("BC2332HE",motorLiability.getCarNumber());
    }

    @Test
    void getCarBrand() {
        Assert.assertEquals("Opel", motorLiability.getCarBrand());
    }

    @Test
    void setCarBrand() {
        motorLiability.setCarBrand("Audi");
        Assert.assertEquals("Audi", motorLiability.getCarBrand());
    }

    @Test
    void getCarModel() {
        Assert.assertEquals("Astra", motorLiability.getCarModel());
    }

    @Test
    void setCarModel() {
        motorLiability.setCarModel("A4");
        Assert.assertEquals("A4", motorLiability.getCarModel());
    }

    @Test
    void getYearOfManufactureOfTheCar() {
        Assert.assertEquals(2010, motorLiability.getYearOfManufactureOfTheCar());
    }

    @Test
    void setYearOfManufactureOfTheCar() {
        motorLiability.setYearOfManufactureOfTheCar(2012);
        Assert.assertEquals(2012,motorLiability.getYearOfManufactureOfTheCar());
    }

    @Test
    void getBodyNumber() {
        Assert.assertEquals("4Y1SL65848Z411439", motorLiability.getBodyNumber());
    }

    @Test
    void setBodyNumber() {
        motorLiability.setBodyNumber("5X2SL65848Z411439");
        Assert.assertEquals("5X2SL65848Z411439", motorLiability.getBodyNumber());
    }

    @Test
    void testToString() {
        Assert.assertEquals(motorLiability.toString(),"MotorLiability{" +
                "carNumber='" + "BC2252HE" + '\'' +
                ", carBrand='" + "Opel" + '\'' +
                ", carModel='" + "Astra" + '\'' +
                ", yearOfManufactureOfTheCar=" + 2010 +
                ", bodyNumber='" + "4Y1SL65848Z411439" + '\'' +
                ", startDate=" + date +
                ", calendar=" + motorLiability.calendar.getTime() +
                ", company='" + "VUSO" + '\'' +
                ", risks=" + "[ДТП]" +
                ", cost=" + 100.0 +
                ", validity=" + 15 +
                ", levelOfRisk=" + 9 +
                '}');
    }
}