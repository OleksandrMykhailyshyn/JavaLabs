package menu;

import commands.Command;
import user.User;

import java.util.HashMap;

public class StartMenu {
    HashMap<Integer, Command> startMenu = new HashMap<>();

    public StartMenu(User user) {
        startMenu.put(1,user.getRegister());
        startMenu.put(2,user.getLogIn());
        startMenu.put(3,user.getLogOut());
    }

    public HashMap<Integer, Command> getStartMenu() {
        return startMenu;
    }
}
