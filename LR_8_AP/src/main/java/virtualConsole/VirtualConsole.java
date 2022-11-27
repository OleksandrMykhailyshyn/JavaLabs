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
    public int choice;
    /************* search ****************/
    public int[] tempInt = new int[]{-1,-1,-1,-1};;
    public int lowerLevelOfRisk;
    public int upperLevelOfRisk;

    public double lowerCost;
    public double upperCost;

    public int lowerValidity;
    public int upperValidity;

}
