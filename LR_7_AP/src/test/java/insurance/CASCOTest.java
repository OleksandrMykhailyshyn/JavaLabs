package insurance;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import risks.CarTheft;
import risks.CompleteDeathOfTheCar;
import risks.Risk;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CASCOTest {

    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    CASCO casco = new CASCO(date,calendar,"VUSO",new String[]{"Викрадення","Повна загибель авто (тотал)"},new Risk[]{new CarTheft(),new CompleteDeathOfTheCar()},100,15,14,"Audi","A4",2018,20000);
    @Test
    void getN() {
        Assert.assertEquals(1,casco.getN());
    }

    @Test
    void getCarBrand() {
        Assert.assertEquals("Audi",casco.getCarBrand());
    }

    @Test
    void setCarBrand() {
        casco.setCarBrand("BMW");
        Assert.assertEquals("BMW",casco.getCarBrand());
    }

    @Test
    void getCarModel() {
        Assert.assertEquals("A4",casco.getCarModel());
    }

    @Test
    void setCarModel() {
        casco.setCarModel("A5");
        Assert.assertEquals("A5",casco.getCarModel());
    }

    @Test
    void getYearOfManufactureOfTheCar() {
        Assert.assertEquals(2018,casco.getYearOfManufactureOfTheCar());
    }

    @Test
    void setYearOfManufactureOfTheCar() {
        casco.setYearOfManufactureOfTheCar(2019);
        Assert.assertEquals(2019,casco.getYearOfManufactureOfTheCar());
    }

    @Test
    void getCarPrice() {
        Assert.assertEquals(20000,casco.getCarPrice());

    }

    @Test
    void setCarPrice() {
        casco.setCarPrice(25000);
        Assert.assertEquals(25000,casco.getCarPrice());
    }

    @Test
    void testToString() {
        Assert.assertEquals(casco.toString(), "CASCO{" +
                "carBrand='" + "Audi"  +
                ", carModel='" + "A4"  +
                ", yearOfManufactureOfTheCar=" + 2018 +
                ", carPrice=" + 20000 +
                ", startDate=" + date +
                ", calendar=" + casco.calendar.getTime() +
                ", company='" + "VUSO"  +
                ", risks=" + "[Викрадення, Повна загибель авто (тотал)]" +
                ", cost=" + 100.0 +
                ", validity=" + 15 +
                ", levelOfRisk=" + 14 +
                '}');
    }
}