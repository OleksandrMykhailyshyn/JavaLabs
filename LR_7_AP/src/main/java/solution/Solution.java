package solution;

import commands.*;
import menu.DoMenu;
import menu.StartMenu;
import user.User;
import virtualConsole.VirtualConsole;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    private VirtualConsole virtualConsole = new VirtualConsole();

    public VirtualConsole getVirtualConsole() {
        return virtualConsole;
    }

    public void setVirtualConsole(VirtualConsole virtualConsole) {
        this.virtualConsole = virtualConsole;
    }
    public boolean solve () throws IOException {
            ArrayList<User> userList = new ArrayList<User>();
            Menu menu = new Menu(userList);

            boolean boolCheck = true;
            int choice = 0;
            boolean cont = true;
            for (int q=0;cont;q++)
            {
                do
                {
                    System.out.println("Select the action: ");
                    System.out.println("1.Register\n2.Log in\n3.Exit");
                    if (virtualConsole.choice1[q]==-1)
                    {
                        virtualConsole.choice1[q] = scanner.nextInt();
                    }
                    choice =  virtualConsole.choice1[q];
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


                for (int t=0;boolCheck;t++) {
                    do
                    {
                        System.out.println("Select the action: ");
                        System.out.println("1.Select insurance\n2.Update insurance\n3.Delete insurance\n4.Help\n5.View my derivative\n6.Log out");
                        if (virtualConsole.choice1[t]==-1)
                        {
                            virtualConsole.choice1[t] = scanner.nextInt();
                        }
                        choice = virtualConsole.choice1[t];
                    }while (choice<1 || choice>6);

                    doMenu.getDoMenu().get(choice).execute();

                    if (choice == 6) {
                        userList.add(user);
                        boolCheck = false;
                    }
                }
            }
        return true;

        }

}

