package user;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogInDataTest {
    LogInData logInData = new LogInData("Maryan","Pinzel","maryan@gmail.com","123456");
    LogInData tempLogInData = new LogInData();
    LogInData temp2LogInData = new LogInData("maryan@gmail.com","123456");
    @Test
    void getName() {
        Assert.assertEquals("Maryan",logInData.getName());
    }

    @Test
    void setName() {
        tempLogInData.setName("Maryan");
        Assert.assertEquals("Maryan",tempLogInData.getName());
    }

    @Test
    void getSurname() {
        Assert.assertEquals("Pinzel",logInData.getSurname());
    }

    @Test
    void setSurname() {
        tempLogInData.setSurname("Pinzel");
        Assert.assertEquals("Pinzel",tempLogInData.getSurname());
    }

    @Test
    void getEmail() {
        Assert.assertEquals("maryan@gmail.com",logInData.getEmail());
    }

    @Test
    void setEmail() {
        tempLogInData.setEmail("maryan@gmail.com");
        Assert.assertEquals("maryan@gmail.com",tempLogInData.getEmail());
    }

    @Test
    void getPassword() {
        Assert.assertEquals("123456",logInData.getPassword());
    }

    @Test
    void setPassword() {
        tempLogInData.setPassword("123456");
        Assert.assertEquals("123456",tempLogInData.getPassword());
    }
    @Test
    void testToString()
    {
        Assert.assertEquals(temp2LogInData.toString(),"LogInData{" +
                "email='" + "maryan@gmail.com" + '\'' +
                ", password='" + "123456" + '\'' +
                '}');
    }

}