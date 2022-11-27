package user;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataOfTheInsuredTest {
    DataOfTheInsured dataOfTheInsured = new DataOfTheInsured("Maryan", "Pinzel","Olegovich","35008","maryan@gmail.com","+380982314563","Lviv","Stepan Bandera", 1, 304);
    DataOfTheInsured tempDataOfTheInsured = new DataOfTheInsured();
    @Test
    void getName() {
        Assert.assertEquals("Maryan",dataOfTheInsured.getName());
    }

    @Test
    void setName() {
        tempDataOfTheInsured.setName("Maryan");
        Assert.assertEquals("Maryan",tempDataOfTheInsured.getName());
    }

    @Test
    void getSurname() {
        Assert.assertEquals("Pinzel",dataOfTheInsured.getSurname());
    }

    @Test
    void setSurname() {
        tempDataOfTheInsured.setSurname("Pinzel");
        Assert.assertEquals("Pinzel",tempDataOfTheInsured.getSurname());
    }

    @Test
    void getMiddleName() {
        Assert.assertEquals("Olegovich",dataOfTheInsured.getMiddleName());
    }

    @Test
    void setMiddleName() {
        tempDataOfTheInsured.setMiddleName("Olegovich");
        Assert.assertEquals("Olegovich",tempDataOfTheInsured.getMiddleName());
    }

    @Test
    void getTIN() {
        Assert.assertEquals("35008",dataOfTheInsured.getTIN());
    }

    @Test
    void setTIN() {
        tempDataOfTheInsured.setTIN("35008");
        Assert.assertEquals("35008",tempDataOfTheInsured.getTIN());
    }

    @Test
    void getEmail() {
        Assert.assertEquals("maryan@gmail.com",dataOfTheInsured.getEmail());
    }

    @Test
    void setEmail() {
        tempDataOfTheInsured.setEmail("maryan@gmail.com");
        Assert.assertEquals("maryan@gmail.com",tempDataOfTheInsured.getEmail());
    }

    @Test
    void getPhoneNumber() {
        Assert.assertEquals("+380982314563",dataOfTheInsured.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
        tempDataOfTheInsured.setPhoneNumber("+380982314563");
        Assert.assertEquals("+380982314563",tempDataOfTheInsured.getPhoneNumber());
    }

    @Test
    void getCity() {
        Assert.assertEquals("Lviv",dataOfTheInsured.getCity());
    }

    @Test
    void setCity() {
        tempDataOfTheInsured.setCity("Lviv");
        Assert.assertEquals("Lviv",tempDataOfTheInsured.getCity());
    }

    @Test
    void getStreet() {
        Assert.assertEquals("Stepan Bandera",dataOfTheInsured.getStreet());
    }

    @Test
    void setStreet() {
        tempDataOfTheInsured.setStreet("Stepan Bandera");
        Assert.assertEquals("Stepan Bandera",tempDataOfTheInsured.getStreet());
    }

    @Test
    void getHouse() {
        Assert.assertEquals(1,dataOfTheInsured.getHouse());
    }

    @Test
    void setHouse() {
        tempDataOfTheInsured.setHouse(1);
        Assert.assertEquals(1,tempDataOfTheInsured.getHouse());
    }

    @Test
    void getApartment() {
        Assert.assertEquals(304,dataOfTheInsured.getApartment());
    }

    @Test
    void setApartment() {
        tempDataOfTheInsured.setApartment(304);
        Assert.assertEquals(304,tempDataOfTheInsured.getApartment());
    }
    @Test
    void testToString() {
        Assert.assertEquals(dataOfTheInsured.toString(),"DataOfTheInsured{" +
                "name='" + "Maryan" + '\'' +
                ", surname='" + "Pinzel" + '\'' +
                ", middleName='" + "Olegovich" + '\'' +
                ", TIN='" + "35008" + '\'' +
                ", email='" + "maryan@gmail.com" + '\'' +
                ", phoneNumber='" + "+380982314563" + '\'' +
                ", city='" + "Lviv" + '\'' +
                ", street='" + "Stepan Bandera" + '\'' +
                ", house=" + 1 +
                ", apartment=" + 304 +
                '}');
    }

}