package virtualConsole;

import java.util.Scanner;

public class VirtualConsole {
    public Scanner scanner = new Scanner(System.in);
    /************* log in ****************/
    public String email;
    public String password;
    /************* register **************/
    public String name;
    public String surname;
    public String password2;
    /************* select ****************/
    public int[] tempInt1 = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public int choice;
    public int[] choice1 = new int[20];
    public String carBrand;
    public String carModel;
    public int yearOfManufactureOfTheCar;
    public int carPrice;
    public int validity;
    public String carNumber1;
    public String carBrand1;
    public String carModel1;
    public int yearOfManufactureOfTheCar1;
    public String bodyNumber;
    public String regionOfStay;
    public String vehicle;
    public int termOfStay;
    public String middleName;
    public String TIN;
    public String phoneNumber;
    public String city;
    public String street;
    public int house;
    public int apartment;
    public String cardNumber;
    public int monthValidity;
    public int yearValidity;
    public int CVV2;


    /************* search ****************/
    public int[] tempInt = new int[]{-1,-1,-1,-1};
    public int lowerLevelOfRisk;
    public int upperLevelOfRisk;

    public double lowerCost;
    public double upperCost;

    public int lowerValidity;
    public int upperValidity;

    /************* update ****************/
    public int choiceAction;
    public int number;
    public String company;
    public String newRisk;
    public int cont;

}
