package commands;

import insurance.CASCO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import risks.CarTheft;
import risks.CompleteDeathOfTheCar;
import risks.Risk;
import user.LogInData;
import user.User;
import virtualConsole.VirtualConsole;

import java.io.*;
import java.util.*;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    @Mock
    Menu menu;
    @Mock
    User user;
    @Mock
    VirtualConsole virtualConsole;
    @Mock
    ArrayList<User> userList;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    @Test
    void logIn() throws IOException {
        userList = new ArrayList<>();
        virtualConsole = new VirtualConsole();
        menu = new Menu(userList);
        user = user = new User(
                new LogIn(menu),
                new Register(menu),
                new LogOut(menu),
                new Help(menu),
                new UpdateInsurance(menu),
                new SelectInsurance(menu),
                new DeleteInsurance(menu),
                new ViewInsurance(menu),
                new SearchInsurance(menu)
        );
        user.setLogInData(new LogInData("lol@gmail.com", "123456"));
        userList.add(user);
        virtualConsole.email = "lol@gmail.com";
        virtualConsole.password = "123456";
        menu.setVirtualConsole(virtualConsole);

        Assert.assertTrue(menu.logIn());
    }

    @Test
    void register() throws IOException {
        userList = new ArrayList<>();
        virtualConsole = new VirtualConsole();
        menu = new Menu(userList);
        user = user = new User(
                new LogIn(menu),
                new Register(menu),
                new LogOut(menu),
                new Help(menu),
                new UpdateInsurance(menu),
                new SelectInsurance(menu),
                new DeleteInsurance(menu),
                new ViewInsurance(menu),
                new SearchInsurance(menu)
        );
        user.setLogInData(new LogInData("lol@gmail.com", "123456"));
        userList.add(user);
        virtualConsole.name = "Maryan";
        virtualConsole.surname = "Pinzel";
        virtualConsole.email = "lol@gmail.com";
        virtualConsole.password = "123456";
        virtualConsole.password2 = "123456";
        menu.setVirtualConsole(virtualConsole);

        Assert.assertTrue(menu.register());
    }

    @Test
    void logOut() {
        userList = new ArrayList<>();
        virtualConsole = new VirtualConsole();
        menu = new Menu(userList);
        user = user = new User(
                new LogIn(menu),
                new Register(menu),
                new LogOut(menu),
                new Help(menu),
                new UpdateInsurance(menu),
                new SelectInsurance(menu),
                new DeleteInsurance(menu),
                new ViewInsurance(menu),
                new SearchInsurance(menu)
        );
        Assert.assertTrue(menu.logOut());
    }

    @Test
    void selectInsurance() {
    }

    @Test
    void updateInsurance() {
    }

    @Test
    void viewInsurance() throws IOException {
        userList = new ArrayList<>();
        virtualConsole = new VirtualConsole();
        menu = new Menu(userList);
        user = user = new User(
                new LogIn(menu),
                new Register(menu),
                new LogOut(menu),
                new Help(menu),
                new UpdateInsurance(menu),
                new SelectInsurance(menu),
                new DeleteInsurance(menu),
                new ViewInsurance(menu),
                new SearchInsurance(menu)
        );
        virtualConsole.choice=1;
        menu.setVirtualConsole(virtualConsole);
        Assert.assertTrue(menu.viewInsurance());
        virtualConsole.choice=2;
        menu.setVirtualConsole(virtualConsole);
        Assert.assertTrue(menu.viewInsurance());
        virtualConsole.choice=3;
        menu.setVirtualConsole(virtualConsole);
        Assert.assertTrue(menu.viewInsurance());
    }

    @Test
    void searchInsurance() throws IOException {
        userList = new ArrayList<>();
        virtualConsole = new VirtualConsole();
        menu = new Menu(userList);
        user = new User(
                new LogIn(menu),
                new Register(menu),
                new LogOut(menu),
                new Help(menu),
                new UpdateInsurance(menu),
                new SelectInsurance(menu),
                new DeleteInsurance(menu),
                new ViewInsurance(menu),
                new SearchInsurance(menu)
        );
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        CASCO casco = new CASCO(date,calendar,"VUSO",new String[]{"Викрадення","Повна загибель авто (тотал)"},new Risk[]{new CarTheft(),new CompleteDeathOfTheCar()},100,15,14,"Audi","A4",2018,20000);
        user.getList().add(casco);
        userList.add(user);



        virtualConsole.tempInt[0]=1;
        virtualConsole.tempInt[1]=0;
        virtualConsole.lowerLevelOfRisk=1;
        virtualConsole.upperLevelOfRisk=10;
        menu.setVirtualConsole(virtualConsole);

        Assert.assertTrue(menu.searchInsurance());


        virtualConsole.lowerCost=1;
        virtualConsole.upperCost=10;
        menu.setVirtualConsole(virtualConsole);

        Assert.assertTrue(menu.searchInsurance());

        virtualConsole.lowerValidity=1;
        virtualConsole.upperValidity=20;
        menu.setVirtualConsole(virtualConsole);

        Assert.assertTrue(menu.searchInsurance());
    }

    @Test
    void deleteInsurance() {
    }
    @Test
    void help(){
        userList = new ArrayList<>();
        virtualConsole = new VirtualConsole();
        menu = new Menu(userList);
        user = new User(
                new LogIn(menu),
                new Register(menu),
                new LogOut(menu),
                new Help(menu),
                new UpdateInsurance(menu),
                new SelectInsurance(menu),
                new DeleteInsurance(menu),
                new ViewInsurance(menu),
                new SearchInsurance(menu)
        );

        Assert.assertTrue(menu.help());
    }
}