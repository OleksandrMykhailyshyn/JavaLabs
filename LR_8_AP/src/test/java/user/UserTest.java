package user;

import commands.*;
import insurance.CASCO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import risks.CarTheft;
import risks.CompleteDeathOfTheCar;
import risks.Risk;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    DataOfTheInsured dataOfTheInsured = new DataOfTheInsured("Maryan", "Pinzel","Olegovich","35008","maryan@gmail.com","+380982314563","Lviv","Stepan Bandera", 1, 304);
    LogInData logInData = new LogInData("Maryan","Pinzel","maryan@gmail.com","123456");
    Payment payment = new Payment("5555444433332222",12,22,111);
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    ArrayList list = new ArrayList<>();
    ArrayList userList = new ArrayList<>();
    Menu menu = new Menu(userList);
    Command logIn = new LogIn(menu);
    Command register = new Register(menu);
    Command logOut = new LogOut(menu);
    Command help = new Help(menu);
    Command update = new UpdateInsurance(menu);
    Command select = new SelectInsurance(menu);
    Command delete = new DeleteInsurance(menu);
    Command view = new ViewInsurance(menu);
    Command search = new SearchInsurance(menu);
    User userCom  = new User(
                    logIn,
                    register,
                    logOut,
                    help,
                    update,
                    select,
                    delete,
                    view,
                    search
            );
    User userData = new User(payment,dataOfTheInsured,logInData, list);
    @Before
    public void setUp(){
        list.add(new CASCO(date,calendar,"VUSO",new String[]{"Викрадення","Повна загибель авто (тотал)"},new Risk[]{new CarTheft(),new CompleteDeathOfTheCar()},100,15,14,"Audi","A4",2018,20000));
    }
    @Test
    void getLogInData() {
        Assert.assertEquals(logInData, userData.getLogInData());
    }

    @Test
    void setLogInData() {
        LogInData temp = new LogInData("www@gmail.com","126790");
        userData.setLogInData(temp);
        Assert.assertEquals(temp,userData.getLogInData());
    }

    @Test
    void getLogIn() {
        Assert.assertEquals(logIn, userCom.getLogIn());
    }

    @Test
    void getRegister() {
        Assert.assertEquals(register, userCom.getRegister());
    }

    @Test
    void getLogOut() {
        Assert.assertEquals(logOut, userCom.getLogOut());
    }

    @Test
    void getHelp() {
        Assert.assertEquals(help, userCom.getHelp());
    }

    @Test
    void getUpdate() {
        Assert.assertEquals(update, userCom.getUpdate());
    }

    @Test
    void getSelect() {
        Assert.assertEquals(select, userCom.getSelect());
    }

    @Test
    void getDelete() {
        Assert.assertEquals(delete, userCom.getDelete());
    }

    @Test
    void getView() {
        Assert.assertEquals(view, userCom.getView());
    }

    @Test
    void getSearch() {
        Assert.assertEquals(search, userCom.getSearch());
    }

    @Test
    void getPayment() {
        Assert.assertEquals(payment, userData.getPayment());
    }

    @Test
    void setPayment() {
        Payment temp = new Payment("5555000033332222",1,22,444);
        userData.setPayment(temp);
        Assert.assertEquals(temp, userData.getPayment());
    }

    @Test
    void getData() {
        Assert.assertEquals(dataOfTheInsured, userData.getData());
    }

    @Test
    void setData() {
        DataOfTheInsured temp = new DataOfTheInsured("Victor", "Pinko","Olegovich","35008","pinko@gmail.com","+380962314501","Lviv","Stepan Bandera", 15, 20);
        userData.setData(temp);
        Assert.assertEquals(temp, userData.getData());
    }

    @Test
    void getList() {
        Assert.assertEquals(list, userData.getList());
    }

    @Test
    void setList() {
        ArrayList temp = new ArrayList<>();
        userData.setList(temp);
        Assert.assertEquals(temp, userData.getList());
    }

    @Test
    void testToString() {
        Assert.assertEquals(userData.toString(), "User{" + "list=" + list + '}');
    }

    @Test
    void logIn() {
    }

    @Test
    void logOut() {
    }

    @Test
    void register() {
    }

    @Test
    void help() {
    }

    @Test
    void update() {
    }

    @Test
    void select() {
    }

    @Test
    void delete() {
    }
}