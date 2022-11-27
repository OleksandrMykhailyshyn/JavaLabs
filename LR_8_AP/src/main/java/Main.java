/*
11. Страхування. Визначити ієрархію страхових зобов’язань. Зібрати із зобов’язань
дериватив. Підрахувати вартість. Здійснити сортування зобов’язань у деривативі на
основі зменшення рівня ризику. Знайти зобов’язання у деривативі, що відповідає
заданому діапазону параметрів.
*/

import commands.*;
import menu.DoMenu;
import menu.StartMenu;
import user.User;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static FileWriter writer = new Menu(null).getWriter();


    public static FileWriter getWriter() {
        return writer;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<User> userList = new ArrayList<User>();
        Menu menu = new Menu(userList);

        boolean boolCheck = true;
        int choice = 0;
        boolean cont = true;
        while (cont)
        {
            do
            {
                System.out.println("Select the action: ");
                System.out.println("1.Register\n2.Log in\n3.Exit");
                choice = scanner.nextInt();
                if(choice<1 || choice>3)
                {
                    logger.log(Level.WARNING, "Out of range");
                    String text = "Out of range @1\n";
                    writer.write(text);
                }
            }while (choice<1 || choice>3);


            User user = new User(
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
            StartMenu startMenu = new StartMenu(user);
            startMenu.getStartMenu().get(choice).execute();

            if (choice == 3)
            {
                System.out.println("You have exited the program");
                boolCheck = false;
                cont = false;
            }
            else {
                user = menu.getUser();
                boolCheck = true;
            }

            DoMenu doMenu = new DoMenu(user);


            while(boolCheck) {
                do
                {
                    System.out.println("Select the action: ");
                    System.out.println("1.Select insurance\n2.Update insurance\n3.Delete insurance\n4.Help\n5.View my derivative\n6.Log out");
                    choice = scanner.nextInt();
                    if (choice<1 || choice>6)
                    {
                        logger.log(Level.WARNING, "Out of range");
                        String text = "Out of range @2\n";
                        writer.write(text);

                    }
                }while (choice<1 || choice>6);

                doMenu.getDoMenu().get(choice).execute();

                if (choice == 6) {
                    userList.add(user);
                    boolCheck = false;
                }
            }
        }
        SendEmail sendEmail = new SendEmail();
        sendEmail.send();
        writer.close();

    }
}
