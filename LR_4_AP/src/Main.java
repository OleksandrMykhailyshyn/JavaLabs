/*
11. Страхування. Визначити ієрархію страхових зобов’язань. Зібрати із зобов’язань
дериватив. Підрахувати вартість. Здійснити сортування зобов’язань у деривативі на
основі зменшення рівня ризику. Знайти зобов’язання у деривативі, що відповідає
заданому діапазону параметрів.
*/

import commands.*;
import insurance.CASCO;
import insurance.Insurance;
import user.LogInData;
import user.User;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {

        ArrayList<User> userList = new ArrayList<User>();
        Menu menu = new Menu(userList);

        User tempUser = new User(
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
        tempUser.setLogInData(new LogInData("2","2"));
        userList.add(tempUser);
        boolean boolCheck = true;
        int choice;
        boolean cont = true;
        while (cont)
        {
            System.out.println("Select the action: ");
            System.out.println("1.Register\n2.Log in\n3.Exit");

            choice = scanner.nextInt();
            //check
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
            HashMap<Integer, Command> startMenu = new HashMap<>();
            startMenu.put(1,user.getRegister());
            startMenu.put(2,user.getLogIn());
            startMenu.put(3,user.getLogOut());

            startMenu.get(choice).execute();

            if (choice == 3)
            {
                System.out.println("You have exited the program");
                boolCheck = false;
                cont = false;
            }
            else {
                user = menu.getUser();
            }
            //----------------------------------------------------
                /*switch (choice)
                {
                    case 1:
                        user.register();
                        user = menu.getUser();
                        break;
                    case 2:
                        user.logIn();
                        user = menu.getUser();
                        //user.getLogInData().setEmail(menu.getUser().getLogInData().getEmail());
                        //check with all users
                        break;
                    case 3:
                        System.out.println("You have exited the program");
                        boolCheck = false;
                        break;
                }*/
            //----------------------------------------------------

            HashMap<Integer, Command> doMenu = new HashMap<>();
            doMenu.put(1,user.getSelect());
            doMenu.put(2,user.getUpdate());
            doMenu.put(3,user.getDelete());
            doMenu.put(4,user.getSearch());
            doMenu.put(5,user.getHelp());
            doMenu.put(6,user.getView());
            doMenu.put(7,user.getLogOut());
            boolCheck = true;
            while(boolCheck) {
                System.out.println("Select the action: ");
                System.out.println("1.Select insurance\n2.Update insurance\n3.Delete insurance\n4.Search insurance\n5.Help\n6.View my derivative\n7.Log out");
                choice = scanner.nextInt();
                //use string scanner?
                //check
                doMenu.get(choice).execute();

                if (choice == 7) {
                    System.out.println("You have exited the program");
                    userList.add(user);
                    boolCheck = false;
                }
            }
            //----------------------------------------------------
                /*while(boolCheck)
                {
                    System.out.println("Select the action: ");
                    System.out.println("1.Select insurance\n2.Update insurance\n3.Delete insurance\n4.Help\n5.Log out\n6.View my derivative\n7.Exit");
                    choice = scanner.nextInt();
                    //use string scanner?
                    //check
                    switch(choice)
                    {
                        case 1:
                            user.select();
                            user = menu.getUser();
                            break;
                        case 2:
                            user.update();
                            break;
                        case 3:
                            user.delete();
                            break;
                        case 4:
                            user.help();
                            break;
                        case 5:
                            user.logOut();
                            break;
                        case 6:
                            System.out.println(user);
                            break;
                        case 7:
                            System.out.println("You have exited the program");
                            boolCheck = false;
                            break;
                    }
                }*/
            //----------------------------------------------------
        }

    }
}



















/* майнове */
// фізичних осіб
// юридичних осіб

/* особове */
// життя
// здоров'я

/* соціальне */
// працездатність
// працевлаштування

/* медичне */

/* відповідальності */
// на автотранспорті
// професіанальної відповідальності

/* ризиків */
// підприємницьких
// фінансових

//********//
/* форми */
// обов'язкове
// добровільне